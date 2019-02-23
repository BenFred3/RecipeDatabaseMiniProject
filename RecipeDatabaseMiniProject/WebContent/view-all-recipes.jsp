<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page that allows the user to view all the database's entries and choose to do things with them.. -->
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
	<title>Recipe Database Contents</title>
</head>
<body>
	<!-- Create a form and table to allow the user to edit the information in the database. -->
	<form method = "post" action = "navigationServlet">
		<table>
			<!-- List out the database's items for the user and allow them to select an item. -->
			<c:forEach items="${requestScope.allRecipes}" var="currentRecipe">
				<tr><td><input type="radio" name="recipeID" value="${currentRecipe.recipeID}">Recipe ID: ${currentRecipe.recipeID}</td></tr>
			 	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Recipe Name: ${currentRecipe.recipeName}</td></tr>
			 	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Recipe Type: ${currentRecipe.recipeType}</td></tr>
			 	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Date Added: ${currentRecipe.dateAdded}</td></tr>
				<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Calories: ${currentRecipe.calories}</td></tr>
			 	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Prep Time: ${currentRecipe.prepTime}</td></tr>
			</c:forEach>
		</table>
		<br />
		<!-- Create buttons to allow the user to edit, delete, or add. -->
		<input type = "submit" value = "Edit" name = "doThisToRecipe">
		<input type = "submit" value = "Delete" name = "doThisToRecipe">
		<input type = "submit" value = "Add" name = "doThisToRecipe">
	</form>
	<br />
	<!-- Links to go to the ingredients or back to the homepage -->
	<p><a href = "viewAllIngredientsServlet">View the Ingredients</a></p> <!-- THIS COULD BE CHANGED INTO A INPUT TYPE IN ORDER TO PASS THE RECIPE ID TO INGREDIENTS -->
	<p><a href ="index.html">Go back to the Homepage</a></p>
</body>
</html>