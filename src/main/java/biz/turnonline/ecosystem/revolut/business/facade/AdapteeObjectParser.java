package biz.turnonline.ecosystem.revolut.business.facade;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.ObjectParser;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The object parser that wraps {@link ObjectMapper} from jackson databind library.
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

    @Inject
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
}
