package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredients;
import model.RecipeInfo;

/**
 * Servlet implementation class addIngredientServlet
 */
@WebServlet("/addIngredientServlet")
public class addIngredientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addIngredientServlet() {
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
		// Create  variables to hold all the requests.
		
		Integer recipeToAdd = Integer.parseInt(request.getParameter("recipeIDToAdd"));
		String ingredientQuantity = request.getParameter("ingredientQuantity");
		String ingredientName = request.getParameter("ingredientName");
		Integer ingredientSortOrder = Integer.parseInt(request.getParameter("ingredientSortOrder"));
		
		RecipeHelper rh = new RecipeHelper();
		RecipeInfo ri = rh.searchForRecipeByID(recipeToAdd);  

		
		// Create an Ingredient object and pass the parms pulled from the jsp
		Ingredients i = new Ingredients(ri, ingredientName, ingredientQuantity, ingredientSortOrder);

		// Create an IngredientsHelper object.
		IngredientsHelper ih = new IngredientsHelper();
		// Pass the Ingredients object to the IngredientsHelper to add it to the database.
		ih.insertIngredients(i);
		
		// Forward the requests and response to the add-recipe.jsp.
		getServletContext().getRequestDispatcher("/viewAllRecipesServlet").forward(request, response);	}

}
