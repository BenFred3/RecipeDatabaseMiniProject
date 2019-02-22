// Second entity.
// Package and import statements.
package model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ingredients")
public class Ingredients 
{
	// Initial values.
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="RECIPE_ID")
	private int recipeID;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INGREDIENT_ID")
	private int ingredientID;
	@Column(name="INGREDIENT_NAME")
	private String ingredientName;
	@Column(name="INGREDIENTQUANTITY")
	private String ingredientQuantity;
	@Column(name="INGREDIENT_SORT_NUMBER")
	private int ingredientSortNumber;
	
	// Default Constructor
	public Ingredients()
	{
		super();
	}
	// Constructor with all values.
	public Ingredients(int recipeID, int ingredientID, String ingredientName, String ingredientQuantity, int ingredientSortNumber)
	{
		super();
		this.recipeID = recipeID;
		this.ingredientID = ingredientID;
		this.ingredientName = ingredientName;
		this.ingredientQuantity = ingredientQuantity;
		this.ingredientSortNumber = ingredientSortNumber;
	}
	// Constructor without recipeID and ingredientID.
		public Ingredients(String ingredientName, String ingredientQuantity, int ingredientSortNumber)
		{
			super();
			this.ingredientName = ingredientName;
			this.ingredientQuantity = ingredientQuantity;
			this.ingredientSortNumber = ingredientSortNumber;
		}
	// Constructor without ingredient ID.
	public Ingredients(int recipeID, String ingredientName, String ingredientQuantity, int ingredientSortNumber)
	{
		super();
		this.recipeID = recipeID;
		this.ingredientName = ingredientName;
		this.ingredientQuantity = ingredientQuantity;
		this.ingredientSortNumber = ingredientSortNumber;
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
	
	public int getIngredientID() 
	{
		return ingredientID;
	}
	public void setIngredientID(int ingredientID) 
	{
		this.ingredientID = ingredientID;
	}
	
	public String getIngredientName() 
	{
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) 
	{
		this.ingredientName = ingredientName;
	}
	
	public String getIngredientQuantity() 
	{
		return ingredientQuantity;
	}
	public void setIngredientQuantity(String ingredientQuantity) 
	{
		this.ingredientQuantity = ingredientQuantity;
	}
	
	public int getIngredientSortNumber() 
	{
		return ingredientSortNumber;
	}
	public void setIngredientSortNumber(int ingredientSortNumber) 
	{
		this.ingredientSortNumber = ingredientSortNumber;
	}
	
	// Helper methods.
	@Override
	public String toString() 
	{
		return "Ingredients- Recipe ID = " + recipeID + "| Ingredient ID = " + ingredientID + "| Ingredient Name = " + ingredientName + "| Ingredient Quantity = " 
				+ ingredientQuantity + "| Ingredient Sort Number = " + ingredientSortNumber;
	}
}
