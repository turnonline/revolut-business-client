package biz.turnonline.ecosystem.revolut.business.facade;

import biz.turnonline.ecosystem.revolut.business.account.model.Account;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.Counterparty;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.CreateCounterpartyRequest;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.ProfileType;
import org.ctoolkit.restapi.client.RestFacade;
import org.ctoolkit.restapi.client.appengine.CtoolkitRestFacadeAppEngineModule;
import org.ctoolkit.restapi.client.appengine.CtoolkitRestFacadeDefaultOrikaModule;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.List;
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

    private UUID counterpartyId;

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
    }

    @Test
    public void getAccount()
    {
        String identifier = "";
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
                .hasSize( 2 );
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
                .that( counterparty.getId().toString() )
                .isEqualTo( counterpartyId.toString() );
    }

    @Test( dependsOnMethods = "getCounterparty" )
    public void deleteCounterparty()
    {
        facade.delete( Counterparty.class )
                .identifiedBy( counterpartyId.toString() )
                .authBy( TOKEN )
                .bearer()
                .finish();
    }
}