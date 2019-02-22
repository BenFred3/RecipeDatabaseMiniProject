// First entity.
// Package and import statements.
package model;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recipe_info")

public class RecipeInfo 
{
	// Initial values.
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RECIPE_ID")
	private int recipeID;
	@Column(name="RECIPE_NAME")
	private String recipeName;
	@Column(name="RECIPE_TYPE")
	private String recipeType;
	@Column(name="DATE_ADDED")
	private LocalDate dateAdded;
	@Column(name="CALORIES")
	private int calories;
	@Column(name="PREP_TIME")
	private String prepTime;
	
	// Default constructor.
	public RecipeInfo()
	{
		super();
	}
	// Constructor with all the arguments.
	public RecipeInfo(int recipeID, String recipeName, String recipeType, LocalDate dateAdded, int calories, String prepTime)
	{
		super();
		this.recipeID = recipeID;
		this.recipeName = recipeName;
		this.recipeType = recipeType;
		this.dateAdded = dateAdded;
		this.calories = calories;
		this.prepTime = prepTime;
	}
	// Constructor with all the arguments, but recipeID.
	public RecipeInfo(String recipeName, String recipeType, LocalDate dateAdded, int calories, String prepTime)
	{
		super();
		this.recipeName = recipeName;
		this.recipeType = recipeType;
		this.dateAdded = dateAdded;
		this.calories = calories;
		this.prepTime = prepTime;
	}

	// Getters and setters.
	public int getRecipeID() 
	{
		return recipeID;
	}
	public void setRecipeID(int recipeID) 
	{
		this.recipeID = recipeID;
	}

	public String getRecipeName() 
	{
		return recipeName;
	}
	public void setRecipeName(String recipeName) 
	{
		this.recipeName = recipeName;
	}

	public String getRecipeType() 
	{
		return recipeType;
	}
	public void setRecipeType(String recipeType) 
	{
		this.recipeType = recipeType;
	}

	public LocalDate getDateAdded() 
	{
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) 
	{
		this.dateAdded = dateAdded;
	}

	public int getCalories() 
	{
		return calories;
	}
	public void setCalories(int calories) 
	{
		this.calories = calories;
	}

	public String getPrepTime() 
	{
		return prepTime;
	}
	public void setPrepTime(String prepTime) 
	{
		this.prepTime = prepTime;
	}
	
	// Helper methods.
	@Override
	public String toString() 
	{
		return "RecipeInfo: Recipe ID = " + recipeID + "| Recipe Name = " + recipeName + "| Recipe Type = " + recipeType
				+ "| Date Added = " + dateAdded + "| Calories = " + calories + "| Prep Time = " + prepTime;
	}
}
