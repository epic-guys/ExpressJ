package org.EpicGuys.ExpressJ;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class ServerSocketRunnable implements Runnable {

    private ServerSocket serverSocket;
    private boolean active;
    private Consumer<Socket> connectionHandler;

    public ServerSocketRunnable(ServerSocket socket, Consumer<Socket> connectionHandler) {
        this.serverSocket = socket;
        this.connectionHandler = connectionHandler;
        active = true;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    @Override
    public void run() {
        try {
            while (active) {
                // waring: since this is a blocking call, the server will not be able to stop IMMEDIATELY
                // but only after a new connection is accepted
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> connectionHandler.accept(clientSocket)).start();
            }
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        active = false;
    }

}
