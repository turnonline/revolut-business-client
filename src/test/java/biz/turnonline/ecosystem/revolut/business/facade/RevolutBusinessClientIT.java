package biz.turnonline.ecosystem.revolut.business.facade;

import biz.turnonline.ecosystem.revolut.business.account.model.Account;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.Counterparty;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.CreateCounterpartyRequest;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.ProfileType;
import biz.turnonline.ecosystem.revolut.business.draft.model.CreatePaymentDraftRequest;
import biz.turnonline.ecosystem.revolut.business.draft.model.CreatePaymentDraftResponse;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentDraftResponse;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentOrderInfo;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentReceiver;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentRequest;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangePart;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRateResponse;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRequest;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeResponse;
import org.ctoolkit.restapi.client.RestFacade;
import org.ctoolkit.restapi.client.appengine.CtoolkitRestFacadeAppEngineModule;
import org.ctoolkit.restapi.client.appengine.CtoolkitRestFacadeDefaultOrikaModule;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.google.common.truth.Truth.assertWithMessage;

/**
 * Revolut Business API testing.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@Guice( modules = {
        RevolutBusinessClientModule.class,
        RevolutBusinessAdapterModule.class,
        CtoolkitRestFacadeAppEngineModule.class,
        CtoolkitRestFacadeDefaultOrikaModule.class
} )
public class RevolutBusinessClientIT
{
    private static final String TOKEN = "";

    private static Logger LOGGER = Logger.getLogger( "com.google.api.client.http" );

    static
    {
        LOGGER.setLevel( Level.ALL );

        // Log handler which prints all log events to the console.
        ConsoleHandler logHandler = new ConsoleHandler();
        logHandler.setLevel( Level.ALL );
        LOGGER.addHandler( logHandler );

    }

    private UUID mainAccountId;

    private UUID counterpartyId;

    private UUID paymentDraft;

    @Inject
    private RestFacade facade;

    @Test
    public void accounts()
    {
        List<Account> list = facade.list( Account.class )
                .authBy( TOKEN )
                .bearer()
                .finish();

        assertWithMessage( "Revolut list of accounts" )
                .that( list )
                .isNotNull();

        assertWithMessage( "Revolut list of accounts" )
                .that( list )
                .hasSize( 3 );

        mainAccountId = list.get( 0 ).getId();
    }

    @Test( dependsOnMethods = "accounts" )
    public void getAccount()
    {
        String identifier = mainAccountId.toString();
        Account account = facade.get( Account.class )
                .identifiedBy( identifier )
                .authBy( TOKEN )
                .bearer()
                .finish();

        assertWithMessage( "Revolut single account" )
                .that( account )
                .isNotNull();

        assertWithMessage( "Revolut single account id" )
                .that( account.getId() )
                .isNotNull();

        assertWithMessage( "Revolut single account id" )
                .that( account.getId().toString() )
                .isEqualTo( identifier );
    }

    @Test
    public void createCounterparty()
    {
        CreateCounterpartyRequest request = new CreateCounterpartyRequest();
        request.profileType( ProfileType.BUSINESS )
                .companyName( "Best, Ltd." )
                .email( "account@ctoolkit.org" )
                .bankCountry( "SK" )
                .currency( "EUR" )
                .bic( "TATRSKBX" )
                .iban( "SK9111000000002628813761" );

        Counterparty counterparty = facade.insert( request )
                .answerBy( Counterparty.class )
                .authBy( TOKEN )
                .bearer()
                .finish();

        assertWithMessage( "Revolut counterparty" )
                .that( counterparty )
                .isNotNull();

        counterpartyId = counterparty.getId();
    }

    @Test( dependsOnMethods = "createCounterparty" )
    public void counterparties()
    {
        List<Counterparty> list = facade.list( Counterparty.class )
                .authBy( TOKEN )
                .bearer()
                .finish();

        assertWithMessage( "Revolut list of counterparties" )
                .that( list )
                .isNotNull();

        assertWithMessage( "Revolut list of counterparties" )
                .that( list )
                .isNotEmpty();
    }

    @Test( dependsOnMethods = "counterparties" )
    public void getCounterparty()
    {
        Counterparty counterparty = facade.get( Counterparty.class )
                .identifiedBy( counterpartyId.toString() )
                .authBy( TOKEN )
                .bearer()
                .finish();

        assertWithMessage( "Revolut single counterparty" )
                .that( counterparty )
                .isNotNull();

        assertWithMessage( "Revolut single counterparty id" )
                .that( counterparty.getId() )
                .isNotNull();

        assertWithMessage( "Revolut single counterparty id" )
                .that( counterparty.getId() )
                .isEqualTo( counterpartyId );
    }

    @Test( dependsOnMethods = "deletePaymentDraft" )
    public void deleteCounterparty()
    {
        facade.delete( Counterparty.class )
                .identifiedBy( counterpartyId.toString() )
                .authBy( TOKEN )
                .bearer()
                .finish();
    }

    @Test
    public void createPaymentDraft()
    {
        PaymentRequest payment = new PaymentRequest();
        // Revolut Main account
        payment.amount( 1.0 )
                .accountId( mainAccountId.toString() )
                .currency( "EUR" )
                .reference( "Payment for tests" );

        PaymentReceiver receiver = new PaymentReceiver();
        receiver.counterpartyId( UUID.fromString( counterpartyId.toString() ) );
        payment.setReceiver( receiver );

        CreatePaymentDraftRequest request = new CreatePaymentDraftRequest()
                .title( "Test Payment" )
                .scheduleFor( LocalDate.now().plusDays( 7 ) )
                .addPaymentsItem( payment );

        CreatePaymentDraftResponse response = facade.insert( request )
                .answerBy( CreatePaymentDraftResponse.class )
                .authBy( TOKEN )
                .bearer()
                .finish();

        assertWithMessage( "Revolut payment draft" )
                .that( response )
                .isNotNull();

        paymentDraft = response.getId();
    }

    @Test( dependsOnMethods = "createPaymentDraft" )
    public void getPaymentDraft()
    {
        PaymentDraftResponse draft = facade.get( PaymentDraftResponse.class )
                .identifiedBy( paymentDraft.toString() )
                .authBy( TOKEN )
                .bearer()
                .finish();

        assertWithMessage( "Revolut single payment draft" )
                .that( draft )
                .isNotNull();

        assertWithMessage( "Revolut single payment draft's payments" )
                .that( draft.getPayments() )
                .isNotNull();

        assertWithMessage( "Revolut single payment draft's payments" )
                .that( draft.getPayments() )
                .isNotEmpty();
    }

    @Test( dependsOnMethods = "getPaymentDraft" )
    public void paymentDrafts()
    {
        List<PaymentOrderInfo> list = facade.list( PaymentOrderInfo.class )
                .authBy( TOKEN )
                .bearer()
                .finish();

        assertWithMessage( "Revolut list of payment drafts" )
                .that( list )
                .isNotNull();

        assertWithMessage( "Revolut list of payment drafts" )
                .that( list )
                .hasSize( 1 );
    }

    @Test( dependsOnMethods = "paymentDrafts" )
    public void deletePaymentDraft()
    {
        facade.delete( PaymentDraftResponse.class )
                .identifiedBy( paymentDraft.toString() )
                .authBy( TOKEN )
                .bearer()
                .finish();
    }

    @Test
    public void exchangeRate()
    {
        Map<String, Object> query = new HashMap<>();
        query.put( "from", "EUR" );
        query.put( "to", "USD" );
        query.put( "amount", 10.0 );

        ExchangeRateResponse response = facade.get( ExchangeRateResponse.class )
                .identifiedBy( 1L )
                .authBy( TOKEN )
                .bearer()
                .finish( query );

        assertWithMessage( "Revolut exchange rate" )
                .that( response )
                .isNotNull();
    }

    @Test
    public void exchange()
    {
        ExchangePart from = new ExchangePart();
        from.accountId( UUID.fromString( "sandbox-acc1" ) );
        from.amount( 10.0 );
        from.currency( "GBP" );

        ExchangePart to = new ExchangePart();
        to.accountId( UUID.fromString( "sandbox-acc2" ) );
        to.currency( "EUR" );

        ExchangeRequest exchange = new ExchangeRequest();
        exchange.from( from );
        exchange.to( to );
        exchange.setRequestId( "b91b0454-413c-11ea-b77f-2e728ce88125" );

        ExchangeResponse response = facade.insert( exchange )
                .answerBy( ExchangeResponse.class )
                .authBy( TOKEN )
                .bearer()
                .finish();

        assertWithMessage( "Revolut exchange response" )
                .that( response )
                .isNotNull();
    }
}