package org.EpicGuys.ExpressJ;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Consumer;

public class HTTPConnectionHandler implements Consumer<Socket> {
    @Override
    public void accept(Socket connection) {
        try
        {
            Scanner inp = new Scanner(connection.getInputStream());
            
            //inp.close();
            //while (inp.hasNextLine())
            //{
            //    System.out.println(inp.nextLine());
            //}

            PrintStream stream = new PrintStream(connection.getOutputStream());
            //.println("<body>LMAO</body>");
            //print the header
            stream.println("HTTP/1.1 200 OK");
            stream.println("Content-Type: text/html");
            stream.println("Content-Length: 13");
            stream.println();
            //print the body
            stream.println("<body>LMAO</body>");
            //close the connection
            stream.close();
            connection.close();
        }
        catch (IOException e)
        {
            //bad things happened
            throw new RuntimeException(e);
        }

    }
    
}
