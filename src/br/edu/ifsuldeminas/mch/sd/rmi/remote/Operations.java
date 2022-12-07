package br.edu.ifsuldeminas.mch.sd.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Operations extends Remote {
	Number sum(Number x, Number y) throws RemoteException;
	Number sub(Number x, Number y) throws RemoteException;
	Number mul(Number x, Number y) throws RemoteException;
	Number div(Number x, Number y) throws RemoteException;
	Number raiz(Number x, Number y) throws RemoteException;
	Number pot(Number x, Number y) throws RemoteException;
	Number por(Number x, Number y) throws RemoteException;
	Number mod(Number x, Number y) throws RemoteException;
	Number fat(Number x) throws RemoteException;
	String dec(Number x) throws RemoteException;
	String com(Number x) throws RemoteException;
	List<String> lastOperations(int howMany) throws RemoteException;
	List<String> lastOperations() throws RemoteException;
}
