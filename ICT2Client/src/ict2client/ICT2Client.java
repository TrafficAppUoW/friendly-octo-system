/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict2client;

import server.Exception_Exception;

/**
 *
 * @author umut2
 */
public class ICT2Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ICT2Client client = new ICT2Client();
        client.execute();
    }
    
        private void execute() {
        System.out.println("[CLIENT] - Starting test...");
        if (testConnection().equals(1.0)) {
            System.out.println("[CLIENT] - Server is connected, continuing test...");
            
            String s1 = "Umut";
            String s2 = "Saber";
            
            String s3 = longestString(s1,s2);
            System.out.println("[CLIENT] - " + s1 + " < " + s2 );
            
            String s4 = "Assassin";
            String s5 = "Umut";
            
            String s6 = longestString(s4,s5);
            System.out.println("[CLIENT] - " + s4 + " > " + s5 );
            //
            //
            //
            
            String b1 = "Umut";
            String b2 = null;
            
            try{
            String b3 = safeLongestString(b1,b2);
            System.out.println("[CLIENT] - " + b1 + " > " + b2 );
           } catch (Exception_Exception ex) {
                System.out.println("[CLIENT] - EXCEPTION");
//                Logger.getLogger(ICT2Client.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            String b3 = null;
            String b4 = null;
            
            try{
            String b5 = safeLongestString(b3,b4);
            System.out.println("[CLIENT] - " + b3 + " < " + b4 );
           } catch (Exception_Exception ex) {
                System.out.println("[CLIENT] - EXCEPTION");
//                Logger.getLogger(ICT2Client.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            String b6 = null;
            String b7 = "Assassin";
            
            try{
            String b8 = safeLongestString(b6,b7);
            System.out.println("[CLIENT] - " + b6 + " < " + b7 );
           } catch (Exception_Exception ex) {
                System.out.println("[CLIENT] - EXCEPTION");
//                Logger.getLogger(ICT2Client.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            String b9 = "Umut";
            String b10 = "Assassin";
            
            try{
            String b11 = safeLongestString(b9,b10);
            System.out.println("[CLIENT] - " + b9 + " < " + b10 );
           } catch (Exception_Exception ex) {
                System.out.println("[CLIENT] - EXCEPTION");
//                Logger.getLogger(ICT2Client.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            addDoubleOnServer(true);
            System.out.println("[CLIENT] - Greatest values " + getLargestDouble());
            addDoubleOnServer(false);
            System.out.println("[CLIENT] - Greatest  values " + getLargestDouble());
            addDoubleOnServer(true);
            System.out.println("[CLIENT] - Greatest values " + getLargestDouble());
            addDoubleOnServer(true);
            System.out.println("[CLIENT] - Greatest values " + getLargestDouble());
            

        } else {
            System.out.println("[CLIENT] - Server is NOT connected, test failed !");

        }
        System.out.println("[CLIENT] - Test Completed !");
    }

    private static Double testConnection() {
        server.ICT2WebService_Service service = new server.ICT2WebService_Service();
        server.ICT2WebService port = service.getICT2WebServicePort();
        return port.testConnection();
    }

    private static String longestString(java.lang.String s1, java.lang.String s2) {
        server.ICT2WebService_Service service = new server.ICT2WebService_Service();
        server.ICT2WebService port = service.getICT2WebServicePort();
        return port.longestString(s1, s2);
    }

    private static String safeLongestString(java.lang.String s1, java.lang.String s2) throws Exception_Exception {
        server.ICT2WebService_Service service = new server.ICT2WebService_Service();
        server.ICT2WebService port = service.getICT2WebServicePort();
        return port.safeLongestString(s1, s2);
    }

    private static Boolean addDoubleOnServer(java.lang.Boolean b) throws Exception_Exception {
        server.ICT2WebService_Service service = new server.ICT2WebService_Service();
        server.ICT2WebService port = service.getICT2WebServicePort();
        return port.addDoubleOnServer(b);
    }

    private static Double getLargestDouble() throws Exception_Exception {
        server.ICT2WebService_Service service = new server.ICT2WebService_Service();
        server.ICT2WebService port = service.getICT2WebServicePort();
        return port.getLargestDouble();
    }
    
}
