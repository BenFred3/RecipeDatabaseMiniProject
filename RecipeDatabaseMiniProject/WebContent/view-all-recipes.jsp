<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Recipe Database Contents</title>
</head>
<body>
	<!-- Create a form and table to allow the user to edit the information in the database. -->
	<form method = "post" action = "navigationServlet">
		<table>
			<!-- List out the database for the user and allow them to select an item. -->
			<c:forEach items="${requestScope.allRecipes}" var="currentRecipe">
				<tr><td><input type="radio" name="recipeID" value="${currentRecipe.recipeID}">Recipe ID: ${currentRecipe.recipeID}</td></tr>
			 	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Recipe Name: ${currentRecipe.recipeName}</td></tr>
			 	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Recipe Type: ${currentRecipe.recipeType}</td></tr>
			 	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Date Added: ${currentRecipe.dateAdded}</td></tr>
				<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Calories: ${currentRecipe.calories}</td></tr>
			 	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; Prep Time: ${currentRecipe.prepTime}</td></tr>
			</c:forEach>
			<!-- Create buttons to allow the user to edit, delete, or go back and add. -->
		</table>
		<br />
		<input type = "submit" value = "edit" name = "doThisToRecipe">
		<input type = "submit" value = "delete" name = "doThisToRecipe">
		<input type = "submit" value = "add" name = "doThisToRecipe">
	</form>
	<br />
	<p><a href = "viewAllIngredientsServlet">View the Ingredients</a></p>
	<p><a href ="index.html">Go back to the home-page</a></p>
</body>
</html>