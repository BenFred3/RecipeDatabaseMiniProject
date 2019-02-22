package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllRecipesServlet
 */
@WebServlet("/viewAllRecipesServlet")
public class viewAllRecipesServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllRecipesServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create a PetListHelper Object.
		RecipeHelper rh = new RecipeHelper();
		
		// Get the attribute from the previous servlet.
		request.setAttribute("allRecipes", rh.showAllRecipes());
		
		// If the attribute is empty then set a blank attribute to avoid errors.
		if(rh.showAllRecipes().isEmpty())
		{
			request.setAttribute("allRecipes", " ");
		}
		
		// Pass the request and responses to the jsp.
		getServletContext().getRequestDispatcher("/view-all-recipes.jsp").forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
