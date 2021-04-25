/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author umut2
 */
@WebService(serviceName = "ICT2WebService")
public class ICT2WebService {
    ArrayList<Boolean>  values =    new ArrayList();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "testConnection")
    public Double testConnection() {
        System.out.println("[SERVER] - testConnection()");
        return 1.0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "longestString")
    public String longestString(@WebParam(name = "s1") String s1, @WebParam(name = "s2") String s2) {
        if (s1.length() > s2.length()){
            System.out.println("[SERVER] - longestString(" + s1 + " > " + s2 + ")");
            return s1;
        }
        else {
            System.out.println("[SERVER] - longestString(" + s2 + " > " + s1 + ")");
            return s2;
                    }
        }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "safeLongestString")
    public String safeLongestString(@WebParam(name = "s1") String s1, @WebParam(name = "s2") String s2) throws Exception {
        
        if (s1 == null) {
            throw new Exception();
        }

        if (s2 == null) {
            throw new Exception();
        }
        
        if (s1.length() > s2.length()){
            System.out.println("[SERVER] - longestString(" + s1 + " > " + s2 + ")");
            return s1;
        }
        else {
            System.out.println("[SERVER] - longestString(" + s2 + " > " + s1 + ")");
            return s2;
                    }
    }

  /**
     * Web service operation
     * @param b
     * @return 
     * @throws java.lang.Exception 
     */
    @WebMethod(operationName = "addDoubleOnServer")
    public Boolean addDoubleOnServer(@WebParam(name = "b") Boolean b) throws Exception {
                System.out.println("[SERVER] - LongestString(" + b + ")");

        if(b == null)
            throw new Exception();
        
        values.add(b);
        return true;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLargestDouble")
    public Double getLargestDouble() throws Exception {
       System.out.println("[SERVER] - getLargestDouble()");

        if(values.isEmpty())
            throw new Exception();
        
        Double num = 0.0;
        
        for(int i = 0; i < values.size(); i++)
            if(values.get(i))
                num++;
        
        return num;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllDoubleSamplesAbove")
    public Double getAllDoubleSamplesAbove() throws Exception {
        //TODO write your implementation code here:
        return null;
    }
    }






    
        
        
    

