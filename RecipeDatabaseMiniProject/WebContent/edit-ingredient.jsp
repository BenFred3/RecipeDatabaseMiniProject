<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Edit page to allow the user to change the contents of a recipe. -->
<!DOCTYPE html>
<html>
<head>
	<!-- Added CSS to make the web page look pretty. -->
	<style>
	body 
	{
  		background-color: lightgrey;
	}
	a 
	{
   		background-color: grey;
  		box-shadow: 0 5px 0 darkgrey;
  		color: white;
  		padding: .25em .5em;
  		position: relative;
  		text-decoration: none;
	}
	a:hover 
	{
  		background-color: grey;
	}
	a:active 
	{
  		box-shadow: none;
  		top: 5px;
	}
	</style>
	<meta charset="ISO-8859-1">
	<title>Editing Ingredient</title>
</head>
<body>
	<!-- Create a form to allow the user to edit the values of the current recipe. -->
	<form action = "editIngredientServlet" method="post">
		Ingredient Quantity: <input type = "text" name = "ingredientQuantity" value="${ingredientToEdit.ingredientQuantity}">
		<br>
		Ingredient Name: <input type ="text" name = "IngredientName" size= "40" value="${ingredientToEdit.ingredientName}">
		<br>
		Ingredient Sort Order: <input type = "text" name = "ingredientSortNumber" value="${ingredientToEdit.ingredientSortNumber}" >
		<br>
		<input type = "hidden" name = "ingredientID" value="${ingredientToEdit.ingredientID}">
		<br>
		<input type = "submit" value="Save Edited Ingredient">
	</form>
	<!-- Link to return to the recipe's database. -->
	<p><a href = "viewAllRecipesServlet">Return Back to the List of Recipes</a></p>
</body>
</html>