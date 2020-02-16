package biz.turnonline.ecosystem.revolut.business.oauth;

import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.assertWithMessage;

/**
 * {@link RevolutCredential} unit testing.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@SuppressWarnings( {"ConstantConditions", "ResultOfMethodCallIgnored"} )
public class RevolutCredentialTest
{
    public static final String REFRESH_TOKEN = "oa_sand_ScxB..";

    private static final String ISSUER = "payment.my.com";

    private static final String CLIENT_ID = "cyx_clientX123";

    @Tested
    private RevolutCredential tested;

    @SuppressWarnings( "FieldCanBeLocal" )
    @Injectable
    private RevolutCredential.Builder builder;

    @Mocked
    private RevolutCredential.Certificate certificate;

    @Mocked
    private RevolutCredential.Storage storage;

    @Mocked
    private RevolutCredential.JwtTokenFactory factory;

    @Mocked
    private HttpTransport transport;

    @Mocked
    private JsonFactory jsonFactory;

    @Mocked
    private HttpResponse httpResponse;

    @BeforeMethod
    public void before()
    {
        builder = new RevolutCredential.Builder()
                .setTransport( transport )
                .setJsonFactory( jsonFactory )
                .setTokenServerUrl( new GenericUrl( "https://my.business.com/auth/token" ) )
                .setCertificate( certificate )
                .setStorage( storage )
                .setJwtTokenFactory( factory );
    }

    @Test
    public void executeRefreshToken_ClientIdNull() throws IOException
    {
        new Expectations()
        {
            {
                certificate.clientId();
                result = null;

                certificate.issuer();
                result = ISSUER;
            }
        };

        assertWithMessage( "Token response" )
                .that( tested.executeRefreshToken() )
                .isNull();

        verificationStorageNotCalled();
    }

    @Test
    public void executeRefreshToken_IssuerNull() throws IOException
    {
        new Expectations()
        {
            {
                certificate.clientId();
                result = CLIENT_ID;

                certificate.issuer();
                result = null;
            }
        };

        assertWithMessage( "Token response" )
                .that( tested.executeRefreshToken() )
                .isNull();

        verificationStorageNotCalled();
    }

    @Test
    public void executeRefreshToken_SecretKey_Null() throws IOException
    {
        new Expectations()
        {
            {
                certificate.clientId();
                result = CLIENT_ID;

                certificate.issuer();
                result = ISSUER;

                storage.getSecretKey( anyString );
                result = null;
            }
        };

        assertWithMessage( "Token response" )
                .that( tested.executeRefreshToken() )
                .isNull();

        verificationStorageNotCalled();
    }

    @Test
    public void executeRefreshToken_SecretKey_Failure() throws IOException
    {
        new Expectations()
        {
            {
                certificate.clientId();
                result = CLIENT_ID;

                certificate.issuer();
                result = ISSUER;

                storage.getSecretKey( anyString );
                result = new RuntimeException( "Something went wrong" );
            }
        };

        assertWithMessage( "Token response" )
                .that( tested.executeRefreshToken() )
                .isNull();

        verificationStorageNotCalled();
    }

    @Test
    public void executeRefreshToken_RefreshToken_Failure() throws IOException
    {
        expectationsJwtToken();
        new Expectations()
        {
            {
                storage.getRefreshToken( anyString );
                result = new RuntimeException( "Something went wrong" );
            }
        };

        assertWithMessage( "Token response" )
                .that( tested.executeRefreshToken() )
                .isNull();

        verificationStorageNotCalled();
    }

    @Test
    public void executeRefreshToken_AuthorizationCodeNull()
            throws IOException
    {
        expectationsJwtToken();
        new Expectations()
        {
            {
                storage.getRefreshToken( anyString );
                result = null;

                storage.getCode( anyString );
                result = null;
            }
        };

        assertWithMessage( "Token response" )
                .that( tested.executeRefreshToken() )
                .isNull();

        verificationStorageNotCalled();
    }

    @Test
    public <T extends TokenRequest> void executeRefreshToken_ExchangeAuthorizationCode()
            throws IOException
    {
        expectationsJwtToken();
        new Expectations()
        {
            {
                storage.getRefreshToken( anyString );
                result = null;

                storage.getCode( anyString );
                result = "oa_sand_qmJf..";
            }
        };

        new MockUp<T>()
        {
            @Mock
            public TokenResponse execute()
            {
                return new TokenResponse().setRefreshToken( REFRESH_TOKEN );
            }
        };

        assertWithMessage( "Token response" )
                .that( tested.executeRefreshToken() )
                .isNotNull();

        new Verifications()
        {
            {
                storage.store( CLIENT_ID, REFRESH_TOKEN );
                times = 1;
            }
        };
    }

    @Test
    public <T extends TokenRequest> void executeRefreshToken_ExchangeAuthorizationCode_StorageFailure()
            throws IOException
    {
        expectationsJwtToken();
        new Expectations()
        {
            {
                storage.getRefreshToken( anyString );
                result = null;

                storage.getCode( anyString );
                result = "oa_sand_qmJf..";

                storage.store( CLIENT_ID, REFRESH_TOKEN );
                result = new RuntimeException( "Something went wrong" );
            }
        };

        new MockUp<T>()
        {
            @Mock
            public TokenResponse execute()
            {
                return new TokenResponse().setRefreshToken( REFRESH_TOKEN );
            }
        };

        assertWithMessage( "Token response" )
                .that( tested.executeRefreshToken() )
                .isNotNull();
    }

    @Test( expectedExceptions = TokenResponseException.class )
    public <T extends TokenRequest> void executeRefreshToken_ExchangeAuthorizationCode_Unauthorized()
            throws IOException
    {
        expectationsJwtToken();
        new Expectations()
        {
            {
                storage.getRefreshToken( anyString );
                result = null;

                storage.getCode( anyString );
                result = "oa_sand_qmJf..";

                httpResponse.getHeaders();
                result = new HttpHeaders();

                storage.store( anyString, anyString );
                times = 0;
            }
        };

        new MockUp<T>()
        {
            @Mock
            public TokenResponse execute() throws IOException
            {
                throw TokenResponseException.from( jsonFactory, httpResponse );
            }
        };

        tested.executeRefreshToken();
    }

    @Test
    public <T extends TokenRequest> void executeRefreshToken_AccessToken() throws IOException
    {
        expectationsJwtToken();
        new Expectations()
        {
            {
                storage.getRefreshToken( anyString );
                result = REFRESH_TOKEN;
            }
        };

        new MockUp<T>()
        {
            @Mock
            public TokenResponse execute()
            {
                return new TokenResponse().setAccessToken( "oa_sand_Xdfg68j.." ).setRefreshToken( REFRESH_TOKEN );
            }
        };

        assertWithMessage( "Token response" )
                .that( tested.executeRefreshToken() )
                .isNotNull();

        verificationStorageNotCalled();
    }

    private void expectationsJwtToken()
    {
        new Expectations()
        {
            {
                certificate.clientId();
                result = CLIENT_ID;

                certificate.issuer();
                result = ISSUER;

                storage.getSecretKey( anyString );
                result = new byte[0];

                factory.create( anyString, anyString, ( byte[] ) any );
                result = "ya29.c.Km..";
            }
        };
    }

    private void verificationStorageNotCalled()
    {
        new Verifications()
        {
            {
                storage.store( anyString, anyString );
                times = 0;
            }
        };
    }
}