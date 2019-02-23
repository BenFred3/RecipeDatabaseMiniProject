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
	<title>Editing Recipe in Database</title>
</head>
<body>
	<!-- Create a form to allow the user to edit the values of the current recipe. -->
	<form action = "editRecipeServlet" method="post">
		Recipe Name: <input type ="text" name = "recipeName" size= "40" value="${recipeToEdit.recipeName}">
		<br>
		Recipe Type: <input type = "text" name = "recipeType" value="${recipeToEdit.recipeType}">
		<br>
		Date Added: <input type = "text" name = "dateAdded" value="${recipeToEdit.dateAdded}" readonly>
		<br>
		Calories: <input type = "text" name = "calories" value="${recipeToEdit.calories}">
		<br>
		Prep Time: <input type = "text" name = "prepTime" value="${recipeToEdit.prepTime}">
		<br>
		<input type = "hidden" name = "recipeID" value="${recipeToEdit.recipeID}">
		<br>
		<input type = "submit" value="Save Edited Recipe">
	</form>
	<!-- Link to return to the recipe's database. -->
	<p><a href = "viewAllRecipesServlet">Return Back to the List of Recipes</a></p>
</body>
</html>