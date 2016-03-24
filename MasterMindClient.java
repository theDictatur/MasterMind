
import java.io.Console;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.*;


public class MasterMindClient {
	public static void main(String [] args) {
if(System.getSecurityManager() == null) System.setSecurityManager(new RMISecurityManager());
      MasterMindClient mmc = new MasterMindClient();
		mmc.connectGame();

	}
	
	public void connectGame() {
		try {
			MasterMindServer server = (MasterMindServer) Naming.lookup("MasterMind");
			game(server);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("URL error");
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Problem with lookup");
		} catch (NotBoundException e) {
			e.printStackTrace();
			System.out.println("Objet not found in registry");
		}
	}
public void game(MasterMindServer server) {
		Console cons = System.console();
		System.out.println("Client Mastermind.Enter the game or 'exit' to exit");
		int numP = 0;
		try {
			numP = server.obtenirPartie();
		} catch (RemoteException e) {
			System.out.println("probleme de communication dans le jeu");
			e.printStackTrace();
		}
		String cmd = cons.readLine();
		while (!cmd.equals("exit")) {
			Comb c = new Comb(cmd);
			Resultat r;
			try {
				r = server.evaluateMove(numP, c);
				if (r.etat == EtatJeu.GANGNANT) {
					System.out.println("YOU WIN THE GAME");
					numP = server.obtenirPartie();
				} else if (r.etat == EtatJeu.CHANGEMENT_PARTIE) {
					System.out.println("RESTART GAME");
					numP = server.obtenirPartie();
				} else {
					System.out.println(r.m+ " right "+r.h+" replace");
				}
			} catch (RemoteException e) {
				System.out.println("probleme de communication");
				e.printStackTrace();
			}		
			cmd = cons.readLine();
		}
	}
}

