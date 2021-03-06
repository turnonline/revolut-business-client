package biz.turnonline.ecosystem.revolut.business.facade;

import biz.turnonline.ecosystem.revolut.business.account.model.Account;
import biz.turnonline.ecosystem.revolut.business.account.model.AccountBankDetailsItem;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.Counterparty;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.CreateCounterpartyRequest;
import biz.turnonline.ecosystem.revolut.business.draft.model.CreatePaymentDraftRequest;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentDraftResponse;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentOrderInfo;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRateResponse;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRequest;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.AccountAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.AccountBankDetailsAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.CounterpartyAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.ExchangeAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.PaymentAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.PaymentDraftAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.TransferAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.adaptee.WebhookAdaptee;
import biz.turnonline.ecosystem.revolut.business.transaction.model.PaymentRequest;
import biz.turnonline.ecosystem.revolut.business.transaction.model.Transaction;
import biz.turnonline.ecosystem.revolut.business.transaction.model.TransferRequest;
import biz.turnonline.ecosystem.revolut.business.webhook.model.Webhook;
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

        bind( new TypeLiteral<ListExecutorAdaptee<AccountBankDetailsItem>>()
        {
        } ).to( AccountBankDetailsAdaptee.class );

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

        // Exchange endpoint
        bind( new TypeLiteral<InsertExecutorAdaptee<ExchangeRequest>>()
        {
        } ).to( ExchangeAdaptee.class );

        bind( new TypeLiteral<GetExecutorAdaptee<ExchangeRateResponse>>()
        {
        } ).to( ExchangeAdaptee.class );

        // Payment endpoint
        bind( new TypeLiteral<InsertExecutorAdaptee<PaymentRequest>>()
        {
        } ).to( PaymentAdaptee.class );

        bind( new TypeLiteral<GetExecutorAdaptee<Transaction>>()
        {
        } ).to( PaymentAdaptee.class );

        bind( new TypeLiteral<ListExecutorAdaptee<Transaction>>()
        {
        } ).to( PaymentAdaptee.class );

        bind( new TypeLiteral<DeleteExecutorAdaptee<Transaction>>()
        {
        } ).to( PaymentAdaptee.class );

        // Transfer endpoint
        bind( new TypeLiteral<InsertExecutorAdaptee<TransferRequest>>()
        {
        } ).to( TransferAdaptee.class );

        // Webhook endpoints
        bind( new TypeLiteral<InsertExecutorAdaptee<Webhook>>()
        {
        } ).to( WebhookAdaptee.class );

        bind( new TypeLiteral<GetExecutorAdaptee<Webhook>>()
        {
        } ).to( WebhookAdaptee.class );

        bind( new TypeLiteral<DeleteExecutorAdaptee<Webhook>>()
        {
        } ).to( WebhookAdaptee.class );
    }
}
