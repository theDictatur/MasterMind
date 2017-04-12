
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//import java.io.Serializable;



public class MasterMindServerImp extends UnicastRemoteObject implements MasterMindServer {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	int numpartie = 0;
	Comb combSecret;
	Lock l;
	Random r;
	
	public MasterMindServerImp() throws RemoteException {
		l = new ReentrantLock();
		r = new Random();
		combSecret = new Comb();
	}
	
	
	
	public Resultat evaluateMove(int numpartieClient,Comb combCliente) throws RemoteException {
		Resultat r = new Resultat();
		System.out.println("combinaison received:"+combCliente);
		l.lock();
		try {
			if (numpartieClient == numpartie) {
				r = combSecret.comparaison(combCliente);
				if (r.etat == EtatJeu.GANGNANT) {
					numpartie++;
					combSecret = new Comb();
				}
			} else {
				r.etat = EtatJeu.CHANGEMENT_PARTIE;
			}
			return r;
		} finally {
			l.unlock();
		}
	}
	
	
	@Override
	public int obtenirPartie() throws RemoteException {
		l.lock();
		try {
			return numpartie;
		} finally {
			l.unlock();
		}
	}

}

