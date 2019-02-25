//A helper class that handles any functions needed with the Ingredients entity.
package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Ingredients;
import model.RecipeInfo;

public class IngredientsHelper 
{
	// Relate this class to the persistence.xml file.
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Recipes");
		
	// This method inserts an Ingredient into the database.
	public void insertIngredients(Ingredients i) 
	{
		// Create a EntityManager, start a transaction, send the new Ingredient information, commit it to the database, close the transaction.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		em.close();
	}
		
	// This method shows all the ingredients from the recipe database.
	public List<Ingredients> showAllIngredients() 
	{
		// Create a EntityManager, pass a SQL command and get the results, return the results.
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked") // Make the warning disappear from the line below.
		List<Ingredients> allIngredients = em.createQuery("SELECT i FROM Ingredients i").getResultList();
		return allIngredients;
	}
		
	// This method deletes an ingredient from the recipe database.
	public void deleteIngredients(Ingredients toDelete) 
	{
		// Create a EntityManager, start a transaction, pass a SQL command.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Ingredients> typedQuery = em.createQuery("SELECT li from Ingredients li where li.ingredientID = :selectedIngredientID " , Ingredients.class); 
		//TypedQuery<Ingredients> typedQuery = em.createQuery("SELECT li from Ingredients li where li.recipeID = :selectedRecipeID and li.ingredientID = :selectedIngrdientID " 
//		+ " and li.ingredientName = :selectedIngredientName" and li.recipeType = :selectedRecipeType and li.dateAdded = :selectedDateAdded and li.calories = :selectedCalories and li.prepTime = "
//		+ ":selectedPrepTime"

				
		// Substitute parameter with actual data from the toDelete item.
		//typedQuery.setParameter("selectedRecipeID", toDelete.getRecipeID());
		typedQuery.setParameter("selectedIngredientID", toDelete.getIngredientID());
		//typedQuery.setParameter("selectedRecipeName", toDelete.getRecipeName());
		//typedQuery.setParameter("selectedRecipeType", toDelete.getRecipeType());
		//typedQuery.setParameter("selectedDateAdded", toDelete.getDateAdded());
		//typedQuery.setParameter("selectedCalories", toDelete.getCalories());
		//typedQuery.setParameter("selectedPrepTime", toDelete.getPrepTime());
		
		// Make sure there is only one result.
		typedQuery.setMaxResults(1);
		
		// Get the result and save it into a new list item.
		Ingredients result = typedQuery.getSingleResult();
		// Remove it, commit it, and close the transaction.
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	// This method searches for ingredients in the recipe database using an ingredient id.
	public Ingredients searchForIngredientsByID(int iDToFind) 
	{
		// Create an EntityManager, start a transaction, find an ID from the int given, close the transaction, return the found information.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Ingredients found = em.find(Ingredients.class, iDToFind);
		em.close();
		return found;
	}
		
	// This method searches for ingredients in the recipe database using a recipe id.
	public List<Ingredients> searchForIngredientsByRecipeID(int recipeID) 
	{
		
		RecipeHelper rh = new RecipeHelper(); 
		RecipeInfo ri = rh.searchForRecipeByID(recipeID); 
		
		// Create an EntityManager, start a transaction, find an ID from the int given, close the transaction, return the found information.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Ingredients> typedQuery = em.createQuery("SELECT li FROM Ingredients li where li.recipeID = :selectedRecipeID ", Ingredients.class);

		// Substitute parameter with actual data from the toDelete item.
		typedQuery.setParameter("selectedRecipeID", ri);
		
		List<Ingredients> allIngredients = typedQuery.getResultList(); 
		em.close();
		return allIngredients;
		
	}

	// This method updates an ingredient in the recipe database.
	public void updateIngredients(Ingredients ingredientToUpdate) 
	{
		// Create an EntityManager, start a transaction, merge the existing information with the new ingredient information given, commit it, and close the transaction.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(ingredientToUpdate);
		em.getTransaction().commit();
		em.close();
	}
}
