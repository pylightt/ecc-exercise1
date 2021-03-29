import java.util.Random;

public class Generator {	
	public static String threeCharGenerator() {
		Random random = new Random();
		String cell = new String(random.ints(3, 41, 126).toArray(), 0, 3);
		return cell;
	}
}