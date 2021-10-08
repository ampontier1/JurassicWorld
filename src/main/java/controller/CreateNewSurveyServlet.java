package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dinosaur;
import model.Park;
import model.ParkSurvey;

/**
 * Servlet implementation class CreateNewSurveyServlet
 */
@WebServlet("/createNewSurveyServlet")
public class CreateNewSurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewSurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DinosaurHelper dh = new DinosaurHelper();
		String surveyName = request.getParameter("surveyName");
		System.out.println("Survey Name: "+ surveyName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String parkName = request.getParameter("parkName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedItems = request.getParameterValues("allDinosToAdd");
		List<Dinosaur> selectedItemsInList = new ArrayList<Dinosaur>();
		//make sure something was selected = otherwise we get a null pointer exception
		if(selectedItems != null && selectedItems.length > 0) {
			
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Dinosaur c = dh.searchForDinoById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		
		Park park = new Park(parkName);
		ParkSurvey slp = new ParkSurvey(surveyName, ld, park);
		slp.setSurveyOfPark(selectedItemsInList);
		ParkSurveyHelper psh = new ParkSurveyHelper();
		psh.insertNewParkSurvey(slp);
		
		System.out.println("Success!");
		System.out.println(slp.toString());
		
		getServletContext().getRequestDispatcher("/viewAllSurveysServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
