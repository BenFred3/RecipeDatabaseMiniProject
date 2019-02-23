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
 * Servlet implementation class editRecipeServlet
 */
@WebServlet("/editRecipeServlet")
public class editRecipeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editRecipeServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create a RecipeHelper object.
		RecipeHelper rh = new RecipeHelper();
		
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
		
		// Create a integer to hold the recipeID.
		Integer tempID = Integer.parseInt(request.getParameter("recipeID"));
		// Get the RecipeInfo object from the id.
		RecipeInfo recipeToUpdate = rh.searchForRecipeByID(tempID);
		// Pass the variables from earlier to the recipeHelper.
		recipeToUpdate.setRecipeName(recipeName);
		recipeToUpdate.setRecipeType(recipeType);
		recipeToUpdate.setDateAdded(ld);
		recipeToUpdate.setCalories(calories);
		recipeToUpdate.setPrepTime(prepTime);
		// Update the item.
		rh.updateRecipe(recipeToUpdate);
		// Return to the servlet.
		getServletContext().getRequestDispatcher("/viewAllRecipesServlet").forward(request, response);
		
	}

}
