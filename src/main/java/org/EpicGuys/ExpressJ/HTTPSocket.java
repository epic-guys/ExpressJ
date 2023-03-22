package org.EpicGuys.ExpressJ;

import java.io.*;
import java.net.*;

class HTTPSocket extends Socket {
    private static final int HTTP_PORT = 80;
    private static final String CRLF = "\r";

    public HTTPSocket(String host) throws IOException {
        super(host, HTTP_PORT);
    }

    public void sendRequest(String request) throws IOException {
        OutputStream out = getOutputStream();
        out.write(request.getBytes());
        out.flush();
    }

    public String getResponse() throws IOException {
        InputStream in = getInputStream();
        StringBuffer response = new StringBuffer();
        int c;
        while ((c = in.read()) != -1) {
            response.append((char) c);
        }
        return response.toString();
    }
}