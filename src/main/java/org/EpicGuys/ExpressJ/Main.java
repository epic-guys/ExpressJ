package org.EpicGuys.ExpressJ;

public class Main {
   public static void main(String[] args) throws Exception {
        BasicHTTPServer srv = new BasicHTTPServer();

        srv.listen(6969);
        System.out.println("Server non bloccante");
   } 
}
