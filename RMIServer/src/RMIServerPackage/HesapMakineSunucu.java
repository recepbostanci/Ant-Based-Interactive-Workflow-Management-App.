package RMIServerPackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.RMISecurityManager;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HesapMakineSunucu {

    public static void main(String[] args) throws InterruptedException {
       
        try {

            Registry reg = LocateRegistry.createRegistry(1099);
            reg = LocateRegistry.getRegistry();
            reg.rebind("HesapMakinesiServisi", new HesapMakinesiGerceklestir());
            
            //reg.unbind("HesapMakinesiServisi");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
    }
}
