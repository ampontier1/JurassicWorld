import java.util.List;

import controller.ParkHelper;
import model.Park;


/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Oct 7, 2021
 */

public class ParkTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Park owen = new Park("Owen");
		
		ParkHelper ph = new ParkHelper();
		
		ph.insertPark(owen);
		
		Park clair = new Park("Clair");
		ph.insertPark(clair);
		
		List<Park> allParks = ph.showAllParks();
		
		for(Park a: allParks) {
			System.out.println(a.toString());
		}
	}

}
