package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ParkSurvey;

/**
 * Servlet implementation class SurveyNavigationServlet
 */
@WebServlet("/surveyNavigationServlet")
public class SurveyNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ParkSurveyHelper psh = new ParkSurveyHelper();
		String act = request.getParameter("doThisToList");
		
		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/ViewAllSurveysServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ParkSurvey listToDelete = psh.searchForParkSurveyById(tempId);
				psh.deleteList(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllSurveysServlet").forward(request, response);
			}
		} else if (act.equals("edit")) {
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ParkSurvey listToEdit = psh.searchForParkSurveyById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				
				request.setAttribute("month", listToEdit.getSurveyDate().getMonthValue());
				request.setAttribute("date", listToEdit.getSurveyDate().getDayOfMonth());
				request.setAttribute("year", listToEdit.getSurveyDate().getYear());
				
				DinosaurHelper pshForDinos = new DinosaurHelper();
				
				request.setAttribute("allDinos", pshForDinos.showAllDinos());
				
				if(pshForDinos.showAllDinos().isEmpty()) {
					request.setAttribute("allDinos", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-survey.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllSurveysServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-survey.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
