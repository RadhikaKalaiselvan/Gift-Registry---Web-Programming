<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    <%@ page import="blueleaf.giftregistry.model.Product"%>
<!DOCTYPE html>
<html>
<head>
	<title>Blue leaf</title>
	<!-- Required meta tags -->
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="blueleaf.png">
	<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
</head>
<body>

<% List<Product> pro = (List<Product>) request.getAttribute("sharedRegistryProduct");%><br>
<% String SharedRegistryID = (String) request.getAttribute("SharedRegistryID");%><br>

<div class="container">
<h2 class="form-signin-heading">Product detail</h2><br>
<div class="row">
<table>

<tr>
	<th>RegisterID: </th>
	<th>ProductName </th>
	<th>ProductID : </th>
	<th>price : </th>
	<th>certification : </th>
	<th>rating : </th>
	<th>category: </th>
	<th>assigned to </th>
	<th>Action: </th>
</tr>
	
<% for(Product rg:pro) { %>
<tr>
	<form action="SelfAssign" method="get">
		<td><input size="10" type="Text" name="RegisterID" value="<%= SharedRegistryID%>" readonly></td>
		<td><input size="10" type="Text" name="ProductName" value="<%=rg.getProductName() %>"readonly></td>
		<td><input size="10" type="Text"  name="ProductID"value="<%=rg.getProductID() %>" readonly></td>
		<td><input size="10" type="Text"  name="price"value="<%=rg.getPrice() %>" readonly></td>
		<td><input size="10" type="Text"  name="certification"value="<%=rg.getCertification() %>" readonly></td>
		<td><input size="10" type="Text"  name="rating"value="<%=rg.getRating() %>" readonly></td>
		<td><input size="10" type="Text"  name="category"value="<%=rg.getCategory() %>" readonly></td>
		<td><input size="10" type="Text"  name="category"value="<%=rg.getAssignedTo() %>" readonly></td>
		<td><input type="submit" value="SelfAssign" class="btn btn-primary"></td>
		<td><a href="success.jsp" class="btn btn-primary">Home</a><br></td>
	</form>
</tr>
<% } %>

</table>
</div>
</div>

</body>
</html>