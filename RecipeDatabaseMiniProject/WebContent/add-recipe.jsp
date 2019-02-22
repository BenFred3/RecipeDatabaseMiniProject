<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<!-- Create a form with all three instance variables from PetList to allow the user to add to the database. -->
	<form action = "addRecipeServlet" method="post">
		Recipe Name: <input type ="text" name = "recipeName">
		Recipe Type: <input type = "text" name = "recipeType">
		Date Added: <input type = "text" name = "dateAdded">
		Calories: <input type = "text" name = "calories">
		Prep Time: <input type = "text" name = "prepTime">
		<br />
		<input type = "submit" value="Add Pet">
	</form> <br />
	<!-- Link to view the pet's database and the vet's database. -->
	<p><a href = "viewAllRecipesServlet">Return Back to the List of Recipes</a></p>
</body>
</html>