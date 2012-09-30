package RMIServerPackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.*;

public interface HesapMakinesi extends Remote {
    public long topla(long a, long b) throws RemoteException;
    public long cikart(long a, long b) throws RemoteException;
    public long carp(long a, long b) throws RemoteException;
    public long bol(long a, long b) throws RemoteException;
}
