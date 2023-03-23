package org.EpicGuys.ExpressJ;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class HTTPResponse implements HTTPPacket {
    
    private final Map<String, String> headers;
    private ByteBuffer body;

    public HTTPResponse()
    {
        body = ByteBuffer.allocate(1024);
        headers = new HashMap<>();
    }

    public int getStatusCode()
    {
        // Just for debugging
        return 200;
    }

    @Override
    public String getHTTPVersion() {
        //hardcoded to HTTP/1.1 since we are not implementing HTTP/2.0 and we don't want to deal with frames :)
        return "HTTP/1.1";
    }

    @Override
    public String getHeader(String key) {
       return this.headers.get(key);
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void write(String b) {
        //allcoate more space if needed
        byte[] bytes = b.getBytes();
        if (this.body.remaining() < bytes.length) {
            //create a new buffer with the size of the old one + the new body
            ByteBuffer newBuffer = ByteBuffer.allocate(this.body.capacity() + bytes.length);
            //copy the old buffer into the new one
            newBuffer.put(this.body);
            //set the new buffer as the body
            this.body = newBuffer;
        }
        this.body.put(bytes);
    }
}