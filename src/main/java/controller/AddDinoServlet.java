package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dinosaur;

/**
 * Servlet implementation class AddDinoServlet
 */
@WebServlet("/addDinoServlet")
public class AddDinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDinoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String species = request.getParameter("species");
		String color = request.getParameter("color");
		if (species.isEmpty() || color.isEmpty() || species == null || color == null) {
			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			
		} else {
			
			Dinosaur di = new Dinosaur(species, color);
			DinosaurHelper dino = new DinosaurHelper();
			dino.insertDino(di);
			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
