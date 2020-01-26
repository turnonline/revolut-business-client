package biz.turnonline.ecosystem.revolut.business.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.json.Json;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.OutputStream;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Serializes JSON HTTP content data by {@link ObjectMapper}.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class ObjectMapperHttpContent
        extends AbstractHttpContent
{
    /**
     * To be serialized to JSON
     */
    private final Object payload;

    private final ObjectMapper mapper;

    protected ObjectMapperHttpContent( @Nonnull Object payload, @Nonnull ObjectMapper mapper )
    {
        super( Json.MEDIA_TYPE );
        this.payload = checkNotNull( payload, "Payload to be serialized to JSON can't be null" );
        this.mapper = checkNotNull( mapper, "Object mapper can't be null" );
    }

    @Override
    public void writeTo( OutputStream out ) throws IOException
    {
        mapper.writeValue( out, payload );
    }
}
