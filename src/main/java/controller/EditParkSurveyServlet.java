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
 * Servlet implementation class EditParkSurveyServlet
 */
@WebServlet("/editParkSurveyServlet")
public class EditParkSurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditParkSurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ParkSurveyHelper psh = new ParkSurveyHelper();
		DinosaurHelper dh = new DinosaurHelper();
		ParkHelper ph = new ParkHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ParkSurvey surveyToUpdate = psh.searchForParkSurveyById(tempId);
		
		String newParkName = request.getParameter("parkName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String parkName = request.getParameter("parkName");
		//find out add the new park
		Park newPark = ph.findPark(parkName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		try {
			//dinos are selected in list to add
			String[] selectedDinos = request.getParameterValues("allDinosToAdd");
			List<Dinosaur> selectedDinosInList = new ArrayList<Dinosaur>();
			
			for (int i = 0; i < selectedDinos.length; i++) {
				System.out.println(selectedDinos[i]);
				Dinosaur c = dh.searchForDinoById(Integer.parseInt(selectedDinos[i]));
				selectedDinosInList.add(c);
			}
			surveyToUpdate.setSurveyOfPark(selectedDinosInList);
		} catch (NullPointerException ex) {
			//no items selected in list - set to an empty list
			List<Dinosaur> selectedDinosInList = new ArrayList<Dinosaur>();
			surveyToUpdate.setSurveyOfPark(selectedDinosInList);
		}
		
		surveyToUpdate.setParkName(newParkName);
		surveyToUpdate.setSurveyDate(ld);
		surveyToUpdate.setPark(newPark);
		
		psh.updateList(surveyToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllSurveysServlet").forward(request, response);
	}

}
