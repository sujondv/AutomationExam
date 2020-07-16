package page;

import java.util.Random;

public class BasePage {

	public static int randomNumGenerator() {
		
		Random rnd = new Random();
		int randomNUm = rnd.nextInt(999);
		
		return randomNUm;
		
		
	}
	
	
}
