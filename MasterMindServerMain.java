
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;
import java.rmi.*;
import java.rmi.server.*;

public class MasterMindServerMain   {
	public static void main(String[] args) throws RemoteException {
if(System.getSecurityManager() == null) System.setSecurityManager(new RMISecurityManager());
		
		try {

       Registry registry = LocateRegistry.createRegistry(1099); 
Properties p= System.getProperties();
String url=p.getProperty("java.rmi.server.codebase");
Class ClasseServeur = RMIClassLoader.loadClass(url,"MasterMindServerImp");
			registry.rebind("MasterMind",(Remote)ClasseServeur.newInstance());
		} 
		catch (Exception e) {
	             System.out.println("Erreur de liaison de l'objet MasterMind");
                     System.out.println(e.toString());
                     }
	}
}
