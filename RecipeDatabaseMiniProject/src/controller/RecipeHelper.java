package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.RecipeInfo;

public class RecipeHelper 
{
	// Relate this class to the persistence.xml file.
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Recipes");
		
	// This method inserts a recipe into the database.
	public void insertRecipe(RecipeInfo ri) 
	{
		// Create a EntityManager, start a transaction, send the new recipe information, commit it to the database, close the transaction.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ri);
		em.getTransaction().commit();
		em.close();
	}
		
	// This method shows all the items from the recipe database.
	public List<RecipeInfo> showAllRecipes() 
	{
		// Create a EntityManager, pass a SQL command and get the results, return the results.
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked") // Make the warning disappear from the line below.
		List<RecipeInfo> allRecipes = em.createQuery("SELECT i FROM RecipeInfo i").getResultList();
		return allRecipes;
	}
		
	// This method deletes an item from the recipe database.
	public void deleteRecipe(RecipeInfo toDelete) 
	{
		// Create a EntityManager, start a transaction, pass a SQL command.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RecipeInfo> typedQuery = em.createQuery("select li from RecipeInfo li where li.recipeID = :selectedRecipeID and li.recipeName = :selectedRecipeName"
		+ " and li.recipeType = :selectedRecipeType and li.dateAdded = :selectedDateAdded and li.calories = :selectedCalories and li.prepTime = "
		+ ":selectedPrepTime", RecipeInfo.class);
				
		// Substitute parameter with actual data from the toDelete item.
		typedQuery.setParameter("selectedRecipeID", toDelete.getRecipeID());
		typedQuery.setParameter("selectedRecipeName", toDelete.getRecipeName());
		typedQuery.setParameter("selectedRecipeType", toDelete.getRecipeType());
		typedQuery.setParameter("selectedDateAdded", toDelete.getDateAdded());
		typedQuery.setParameter("selectedCalories", toDelete.getCalories());
		typedQuery.setParameter("selectedPrepTime", toDelete.getPrepTime());
		
		// Make sure there is only one result.
		typedQuery.setMaxResults(1);

		// This try-catch statement is to avoid a exception caused by me trying to fix the delete function.
		try 
		{
			// Get the result and save it into a new list item.
			RecipeInfo result = typedQuery.getSingleResult();
			// Remove it, commit it, and close the transaction.
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}
		catch (Exception e)
		{
			// If there is an exception do nothing.
		}
	}

	// This method searches the recipe database using a id.
	public RecipeInfo searchForRecipeByID(int iDToFind) 
	{
		// Create a EntityManager, start a transaction, find a ID from the int given, close the transaction, return the found information.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		RecipeInfo found = em.find(RecipeInfo.class, iDToFind);
		em.close();
		return found;
	}
		
	// This method updates an item in the recipe database.
	public void updateRecipe(RecipeInfo recipeToUpdate) 
	{
		// Create a EntityManager, start a transaction, merge the existing information with the new recipe information given, commit it, and close the transaction.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(recipeToUpdate);
		em.getTransaction().commit();
		em.close();
	}
}
