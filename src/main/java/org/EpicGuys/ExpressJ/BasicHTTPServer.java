package org.EpicGuys.ExpressJ;

import java.io.IOException;
import java.net.ServerSocket;

public class BasicHTTPServer implements HTTPServer {
    /*
     * Server
     * |-> ServerHandler. Thread which waits for connections
     *     |-> ConnectionHandler. Thread that manages connection individually
     * 
     * 
     */
    
    private Thread serverThread;
    private ServerSocketRunnable serverSocketRunnable;
    
    @Override
    public void listen() throws IOException {
        listen(HTTP_PORT);
        
    }

    @Override
    public void listen(int port) throws IOException {
        ServerSocket socket = new ServerSocket(port);
        serverSocketRunnable = new ServerSocketRunnable(socket, new HTTPConnectionHandler());
        serverThread = new Thread(serverSocketRunnable);
        serverThread.start();
    }

    @Override
    public void stop() throws IOException {
        serverSocketRunnable.stop();
    }
}