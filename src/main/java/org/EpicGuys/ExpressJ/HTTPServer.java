package org.EpicGuys.ExpressJ;

import java.io.IOException;

public interface HTTPServer {
    static final int HTTP_PORT = 80;
    static final int HTTPS_PORT = 443;

    void listen() throws IOException;
    void listen(int port) throws IOException;
    
    void stop() throws IOException;
}
