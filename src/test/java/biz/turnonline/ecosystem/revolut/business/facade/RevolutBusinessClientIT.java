package biz.turnonline.ecosystem.revolut.business.facade;

import biz.turnonline.ecosystem.revolut.business.account.model.Account;
import org.ctoolkit.restapi.client.RestFacade;
import org.ctoolkit.restapi.client.appengine.CtoolkitRestFacadeAppEngineModule;
import org.ctoolkit.restapi.client.appengine.CtoolkitRestFacadeDefaultOrikaModule;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.List;

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
}