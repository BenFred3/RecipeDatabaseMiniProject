package controller;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RecipeInfo;

/**
 * Servlet implementation class addRecipeServlet
 */
@WebServlet("/addRecipeServlet")
public class addRecipeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRecipeServlet() 
    {
        super();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create seven variables to hold all the requests.
		String recipeName = request.getParameter("recipeName");
		String recipeType = request.getParameter("recipeType");
		Integer calories = Integer.parseInt(request.getParameter("calories"));
		String prepTime = request.getParameter("prepTime");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		// Create a LocalDate variable.
		LocalDate ld;
		// Try to create a local date out of the strings given.
		try 
		{
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		// If it fails set the date to the current date.
		catch(NumberFormatException ex) 
		{
			ld = LocalDate.now();
		}
		
		// Create a RecipeInfo object and pass the four strings, integer and LocalDate.
		RecipeInfo ri = new RecipeInfo(recipeName, recipeType, ld, calories, prepTime);
		// Create a RecipeHelper object.
		RecipeHelper rh = new RecipeHelper();
		// Pass the RecipeInfo object to the RecipeHelper to add it to the recipe database.
		rh.insertRecipe(ri);
		
		// Forward the requests and response to the add-recipe.jsp.
		getServletContext().getRequestDispatcher("/add-recipe.jsp").forward(request, response);
	}

}
