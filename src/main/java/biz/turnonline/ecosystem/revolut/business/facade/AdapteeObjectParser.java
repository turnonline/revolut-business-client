package biz.turnonline.ecosystem.revolut.business.facade;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.api.client.util.ObjectParser;
import org.openapitools.jackson.nullable.JsonNullableModule;

import javax.annotation.Nonnull;
import javax.inject.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.text.FieldPosition;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The object parser that wraps {@link ObjectMapper} from jackson databind library.
 * {@link java.text.DateFormat} is based on the {@link ISO8601DateFormat} but serializing milliseconds.
 *
 * <p>
 * The implementation is fully thread-safe.
 * </p>
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@Singleton
public class AdapteeObjectParser
        implements ObjectParser
{
    private final ObjectMapper mapper;

    public AdapteeObjectParser()
    {
        this( new ObjectMapper()
                .disable( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES )
                .disable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS )
                .setDateFormat( new RFC3339() )
                .registerModule( new JavaTimeModule() )
                .registerModule( new JsonNullableModule() ) );
    }

    public AdapteeObjectParser( @Nonnull ObjectMapper mapper )
    {
        this.mapper = checkNotNull( mapper, "Object mapper can't be null" );
    }

    @Override
    public <T> T parseAndClose( InputStream in, Charset charset, Class<T> dataClass ) throws IOException
    {
        return mapper.readValue( in, dataClass );
    }

    @Override
    public Object parseAndClose( InputStream in, Charset charset, Type dataType ) throws IOException
    {
        JavaType jacksonType = mapper.getTypeFactory().constructType( dataType );
        return mapper.readValue( in, jacksonType );
    }

    @Override
    public <T> T parseAndClose( Reader reader, Class<T> dataClass ) throws IOException
    {
        return mapper.readValue( reader, dataClass );
    }

    @Override
    public Object parseAndClose( Reader reader, Type dataType ) throws IOException
    {
        JavaType jacksonType = mapper.getTypeFactory().constructType( dataType );
        return mapper.readValue( reader, jacksonType );
    }

    private static class RFC3339
            extends ISO8601DateFormat
    {
        @Override
        public StringBuffer format( Date date, StringBuffer toAppendTo, FieldPosition fieldPosition )
        {
            String value = ISO8601Utils.format( date, true );
            toAppendTo.append( value );
            return toAppendTo;
        }
    }
}
