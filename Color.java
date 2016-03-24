
import java.util.Random;

public enum Color {
	Red, Green, White,Orange , Blue, Violet, Fuchsia ,Yellow;
	static Random r = new Random();
	
	public static Color colorAlea() {
		int n = r.nextInt(7);
		switch (n) {
		case 0: return Red;
		case 1: return Green;
		case 2: return White;
		case 3: return Orange;
		case 4: return Blue;
                case 5: return Violet;
                case 6: return Fuchsia;
                
		default: return Yellow;
		}
	}
	
	public static Color convertCharToColor (char c) {
		switch (c) {
		case 'R': return Red;
		case 'G': return Green;
		case 'W': return White;
		case 'O': return Orange;
		case 'B': return Blue;
		case 'V': return Violet;
                case 'F': return Fuchsia;
                case 'Y': return Yellow;
		default: return null;
		}
	}
};
