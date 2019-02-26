package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredients;

/**
 * Servlet implementation class editIngredient
 */
@WebServlet("/editIngredientServlet")
public class editIngredientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editIngredientServlet() {
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
		
		// Create an IngredientsHelper object.
		IngredientsHelper ih = new IngredientsHelper();
		
		// Get values from jsp
		//Create a integer to hold the recipeID.
		Integer ingredientID = Integer.parseInt(request.getParameter("ingredientID"));
		String ingredientQuantity = request.getParameter("ingredientQuantity");
		String ingredientName = request.getParameter("IngredientName");
		Integer ingredientSortNumber = Integer.parseInt(request.getParameter("ingredientSortNumber"));
		
		//Create and populate an Ingredients object
		Ingredients ingredientToUpdate = ih.searchForIngredientsByID(ingredientID); 

		// Pass the variables from earlier and update the ingredient.  
		ingredientToUpdate.setIngredientName(ingredientName);
		ingredientToUpdate.setIngredientQuantity(ingredientQuantity);
		ingredientToUpdate.setIngredientSortNumber(ingredientSortNumber);

		// Update the recipe in the database.
		ih.updateIngredients(ingredientToUpdate);

		// Return to the servlet.
		getServletContext().getRequestDispatcher("/viewAllRecipesServlet").forward(request, response);

	}

}
