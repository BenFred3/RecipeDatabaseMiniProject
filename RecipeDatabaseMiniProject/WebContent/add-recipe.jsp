<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Adding Recipe to Database</title>
</head>
<body>
	<!-- Create a form with all three instance variables from PetList to allow the user to add to the database. -->
	<form action = "addRecipeServlet" method="post">
		Recipe Name: <input type ="text" name = "recipeName">
		<br>
		Recipe Type: <input type = "text" name = "recipeType">
		<br>
		Date Added: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
		<br>
		Calories: <input type = "text" name = "calories">
		<br>
		Prep Time: <input type = "text" name = "prepTime">
		<br />
		<input type = "submit" value="Add Recipe">
	</form> <br />
	<!-- Link to view the pet's database and the vet's database. -->
	<p><a href = "viewAllRecipesServlet">Return Back to the List of Recipes</a></p>
</body>
</html>