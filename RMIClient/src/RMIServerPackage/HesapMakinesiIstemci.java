package RMIServerPackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import RMIServerPackage.HesapMakinesi;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class HesapMakinesiIstemci {
 
    public static void main(String[] args) {
      
        try{
        
            HesapMakinesi h=(HesapMakinesi)Naming.lookup("rmi://127.0.0.1:1099/HesapMakinesiServisi");
            System.out.println("Toplama Sonucu:"+h.topla(10, 1));
            
        } catch(Exception e) {
        System.out.print(e.getMessage());
        }
        
    }
}
