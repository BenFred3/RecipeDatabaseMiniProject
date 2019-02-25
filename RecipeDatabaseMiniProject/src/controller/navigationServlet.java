// Servlet that allows the user to navigate through different pages and servlets.
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RecipeInfo;
import model.Ingredients;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public navigationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Create a RecipeHelper object.
		RecipeHelper rh = new RecipeHelper();
		IngredientsHelper ih = new IngredientsHelper();
		// Get user's response parameter and set it to a string.
		String act = request.getParameter("doThisToRecipe");

		// If no button has been selected do this.
		if (act == null) {
			// Return to the viewAllRecipesServlet to redisplay the page.
			getServletContext().getRequestDispatcher("/viewAllRecipesServlet").forward(request, response);
		}
		
		// If the string act equals delete ingredient do this.
				else if (act.equals("Delete Ingredient")) {
					// Try and catch statement to avoid errors.
					try {
						// Get the ingredientID and pass it to the search function.
						Integer ingredientID = Integer.parseInt(request.getParameter("ingredientID"));
						System.out.println("~~~~~navigationServlet:DeleteIngredient:  ingredientId = " + ingredientID);
						Ingredients ingredientToDelete = ih.searchForIngredientsByID(ingredientID);

						
						// Create an ingredientHelper and delete any ingredients associated with the
						// recipe being deleted. (Potential functionality)
						// GOES HERE
						// <---------------------------------------------------------------------------------------------------

						// then send the results to the delete function.
						ih.deleteIngredients(ingredientToDelete);
					} catch (NumberFormatException exception) {
						// If the user didn't select anything print this to console.
						System.out.println("Forgot to click a button.");
					} finally {
						// After the try-catch pass back the request and response to the servlet.
						getServletContext().getRequestDispatcher("/viewAllRecipesServlet").forward(request, response);
					}
				}
		
		// If the string act equals delete do this.
		else if (act.equals("Delete")) {
			// Try and catch statement to avoid errors.
			try {
				// Get the petId and pass it to the search function.
				Integer tempID = Integer.parseInt(request.getParameter("recipeID"));
				RecipeInfo itemToDelete = rh.searchForRecipeByID(tempID);

				// Create a ingredientHelper and delete any ingredients associated with the
				// recipe being deleted. (Potential functionality)
				// GOES HERE
				// <---------------------------------------------------------------------------------------------------

				// then send the results to the delete function.
				rh.deleteRecipe(itemToDelete);
			} catch (NumberFormatException exception) {
				// If the user didn't select anything print this to console.
				System.out.println("Forgot to click a button.");
			} finally {
				// After the try-catch pass back the request and response to the servlet.
				getServletContext().getRequestDispatcher("/viewAllRecipesServlet").forward(request, response);
			}
		}
		
		// If the string act equals edit do this.
		else if (act.equals("Edit Ingredient")) {
			try {
				// Get the recipeid; create RecipeInfo object; populate RecipeInfo object
				//Integer recipeIDToEdit = Integer.parseInt(request.getParameter("recipeIDToView"));
				//RecipeInfo recipeToEdit = rh.searchForRecipeByID(recipeIDToEdit);
				
				//Get the IngredientID; create Ingredient Object; populate Ingredient object
				Integer ingredientID = Integer.parseInt(request.getParameter("ingredientID")); 
				Ingredients i = ih.searchForIngredientsByID(ingredientID); 
				
				request.setAttribute("ingredientToEdit", i);
				getServletContext().getRequestDispatcher("/edit-ingredient.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				// If the user didn't select anything return to the servlet.
				getServletContext().getRequestDispatcher("/viewAllRecipesServlet").forward(request, response);
			}
		}

		
		// If the string act equals edit do this.
		else if (act.equals("Edit")) {
			try {
				// Get the id, pass it to the search function, then send the results to
				// edit-recipe.jsp in the form of a attribute.
				Integer tempID = Integer.parseInt(request.getParameter("recipeID"));
				RecipeInfo recipeToEdit = rh.searchForRecipeByID(tempID);
				request.setAttribute("recipeToEdit", recipeToEdit);
				getServletContext().getRequestDispatcher("/edit-recipe.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				// If the user didn't select anything return to the servlet.
				getServletContext().getRequestDispatcher("/viewAllRecipesServlet").forward(request, response);
			}
		}

		else if (act.equals("View Ingredients")) {

			try {
				System.out.println("~~~~~NavigationServlet:ViewIngredients");
				// Get the id, pass it to the search function, then send the results to
				// view-ingredients.jsp in the form of an attribute.
				Integer recipeID = Integer.parseInt(request.getParameter("recipeID"));
				System.out.println("~~~~~NavigationServlet:ViewIngredient: recipeID = " + recipeID);
				
				List<Ingredients> ingredientsToView = ih.searchForIngredientsByRecipeID(recipeID);
				request.setAttribute("allIngredients", ingredientsToView);
				request.setAttribute("recipeIDToView",  recipeID);
				getServletContext().getRequestDispatcher("/view-ingredients.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				// If the user didn't select anything return to the servlet.
				getServletContext().getRequestDispatcher("/viewAllRecipesServlet").forward(request, response);
			}
		} else if (act.equals("Add Ingredient")) {
			try {
				System.out.println("~~~~~NavigationServlet:AddIngredient");
				// Get the recipeId
				Integer recipeIDToView = Integer.parseInt(request.getParameter("recipeIDToView"));
				System.out.println("~~~~~NavigationServlet:AddIngredient: recipeID = " + recipeIDToView);
				
				request.setAttribute("recipeToEdit", recipeIDToView);
				getServletContext().getRequestDispatcher("/add-ingredient.jsp").forward(request, response);
			} catch (NumberFormatException e) {

				// Go to the add-ingredient.jsp and pass the request and respone to the jsp.
				getServletContext().getRequestDispatcher("/add-ingredient.jsp").forward(request, response);
			}
		}
		// If the string act equals add do this.
		else if (act.equals("Add")) {
			// Go to the add-recipe.jsp and pass the request and respone to the jsp.
			getServletContext().getRequestDispatcher("/add-recipe.jsp").forward(request, response);
		}

	}
}
