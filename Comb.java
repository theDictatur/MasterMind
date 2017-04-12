
import java.io.Serializable;

//@SuppressWarnings("serial")
public class Comb implements Serializable {
	public static int N = 4;
	private Color[] comb;
	
	public Comb() {
	 comb = new Color[N];
		System.out.println("Nouvelle combinaison secrete");
		for (int i = 0 ; i < N ; i++) {
		 comb[i] = Color.colorAlea();
		}
		System.out.println(this);
	}
	
	public Comb(String s) {
	 comb = new Color[N];
		for (int i = 0 ; i < N; i++) {
		 comb[i] = Color.convertCharToColor(s.charAt(i));
		}
	}
	
	public String toString() {
		return toString(comb);
	}
	
	public String toString(Color [] comb) {
		String str = "" + comb[0];
		for (int i = 1 ; i < N; i++) {
			str = str + "," + comb[i];
		}
		return str;
	}
	
	public Resultat comparaison (Comb jeu) {
		Resultat r  = new Resultat(); 
		Color[] keyCopie = comb.clone();
		System.out.println(toString (keyCopie));
		Color[] CopieMove = jeu.comb.clone();
		System.out.println(toString(CopieMove));
		int n = keyCopie.length;
		for (int i = 0; i < n; i++) {
			if  (keyCopie[i] == CopieMove[i]) {
				r.m++;
			 keyCopie[i] = null;
				CopieMove[i] = null;
			}
		}
		for ( int i  = 0 ; i < n; i++) {
			int j = 0;
			boolean found = false;
			while ( (j < n) && !found) {
				found = (( keyCopie[i] == CopieMove[j]) &&  (keyCopie[i]!=null));
				j++;
			}
			if (found) {
			 keyCopie[i] = null;
				CopieMove[j-1] = null;
				r.h++;
			}
		}
		if (r.m == 4) {
			r.etat = EtatJeu.GANGNANT;
		} else {
			r.etat = EtatJeu.RESULTAT_PARTIEL;
		}
		return r;
	}
	
}

