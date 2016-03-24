

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;



public interface MasterMindServer extends Remote, Serializable {
	public int obtenirPartie() throws RemoteException;
	public Resultat evaluateMove(int numPartie, Comb c) throws RemoteException;
}
