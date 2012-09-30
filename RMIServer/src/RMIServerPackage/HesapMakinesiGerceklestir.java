package RMIServerPackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HesapMakinesiGerceklestir extends UnicastRemoteObject implements HesapMakinesi{

    private static final long serialVersionUID=1L;
    
    public HesapMakinesiGerceklestir() throws RemoteException {
    super();
    }
    
    @Override
    public long topla(long a, long b) throws RemoteException{
        return a+b;
    }

    @Override
    public long cikart(long a, long b) throws RemoteException {
        return a-b;
    }

    @Override
    public long carp(long a, long b) throws RemoteException {
        return a*b;
    }

    @Override
    public long bol(long a, long b) throws RemoteException {
        return a/b;
    }
}
