import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ParkSurveyHelper;
import controller.ParkHelper;
import model.ParkSurvey;
import model.Dinosaur;
import model.Park;

/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Oct 7, 2021
 */

public class ParkSurveyTester {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Park malcolm = new Park("Malcolm");
		
		ParkSurveyHelper psh = new ParkSurveyHelper();
		
		Dinosaur trik = new Dinosaur("triceritops", "green");
		Dinosaur trex = new Dinosaur("t-rex", "red");
		
		List<Dinosaur> malcolmDinos = new ArrayList<Dinosaur>();
		
		malcolmDinos.add(trik);
		malcolmDinos.add(trex);
		
		ParkSurvey malcolmSurvey = new ParkSurvey("Malcolm's Survey", LocalDate.now(), malcolm);
		
		malcolmSurvey.setSurveyOfPark(malcolmDinos);
		
		psh.insertNewParkSurvey(malcolmSurvey);
		
		ParkHelper ph = new ParkHelper();
		
		ph.insertPark(malcolm);

		List<ParkSurvey> allSurveys = psh.getSurvey();
		
		for(ParkSurvey a : allSurveys) {
			System.out.println(a.toString());
		}

	}

}
