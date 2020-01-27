package biz.turnonline.ecosystem.revolut.business.facade;

import biz.turnonline.ecosystem.revolut.business.account.model.Account;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.Counterparty;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.CreateCounterpartyRequest;
import biz.turnonline.ecosystem.revolut.business.draft.model.CreatePaymentDraftRequest;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentDraftResponse;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentOrderInfo;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRateResponse;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRequest;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.AccountAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.CounterpartyAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.ExchangeAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.PaymentDraftAdaptee;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import org.ctoolkit.restapi.client.adaptee.DeleteExecutorAdaptee;
import org.ctoolkit.restapi.client.adaptee.GetExecutorAdaptee;
import org.ctoolkit.restapi.client.adaptee.InsertExecutorAdaptee;
import org.ctoolkit.restapi.client.adaptee.ListExecutorAdaptee;

/**
 * The Revolut for Business guice default adaptee configuration.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class RevolutBusinessAdapterModule
        extends AbstractModule
{
    @Override
    protected void configure()
    {
        // Accounts endpoint
        bind( new TypeLiteral<GetExecutorAdaptee<Account>>()
        {
        } ).to( AccountAdaptee.class );

        bind( new TypeLiteral<ListExecutorAdaptee<Account>>()
        {
        } ).to( AccountAdaptee.class );

        // Counterparties endpoint
        bind( new TypeLiteral<InsertExecutorAdaptee<CreateCounterpartyRequest>>()
        {
        } ).to( CounterpartyAdaptee.class );

        bind( new TypeLiteral<GetExecutorAdaptee<Counterparty>>()
        {
        } ).to( CounterpartyAdaptee.class );

        bind( new TypeLiteral<ListExecutorAdaptee<Counterparty>>()
        {
        } ).to( CounterpartyAdaptee.class );

        bind( new TypeLiteral<DeleteExecutorAdaptee<Counterparty>>()
        {
        } ).to( CounterpartyAdaptee.class );

        // Payment drafts endpoint
        bind( new TypeLiteral<InsertExecutorAdaptee<CreatePaymentDraftRequest>>()
        {
        } ).to( PaymentDraftAdaptee.class );

        bind( new TypeLiteral<GetExecutorAdaptee<PaymentDraftResponse>>()
        {
        } ).to( PaymentDraftAdaptee.class );

        bind( new TypeLiteral<ListExecutorAdaptee<PaymentOrderInfo>>()
        {
        } ).to( PaymentDraftAdaptee.class );

        bind( new TypeLiteral<DeleteExecutorAdaptee<PaymentDraftResponse>>()
        {
        } ).to( PaymentDraftAdaptee.class );

        // Payment drafts endpoint
        bind( new TypeLiteral<InsertExecutorAdaptee<ExchangeRequest>>()
        {
        } ).to( ExchangeAdaptee.class );

        bind( new TypeLiteral<GetExecutorAdaptee<ExchangeRateResponse>>()
        {
        } ).to( ExchangeAdaptee.class );
    }
}
