<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<style type="text/css">
li {
  list-style-type: none;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
<form action="AddProductServlet" method="post" class="form-horizontal">
${message}<br>
<fieldset>
<h2 class="form-signin-heading">Add Product</h2>

		<div class="col" align=right>
		<a href="adminHomePage.jsp" class="btn btn-primary btn-lg">HOME</a><br>
		</div>
		<div class="control-group">
            <label class="control-label"  for="productName">Product Name :</label>
            <div class="controls">
                <input type="text" name="productName" id="productName" class="input-xlarge" placeholder="productName">
                <p id="err"></p>
            </div>
        </div>
        
        <div class="control-group">
            <label class="control-label"  for="brandname">Brand Name :</label>
            <div class="controls">
                <input type="text" name="brandname" id="brandname" class="input-xlarge" placeholder="brandname">
                <p id="err"></p>
            </div>
        </div>
        
        <div class="control-group">
            <label class="control-label"  for="category">Category :</label>
            <div class="controls">
                <input type="text" name="category" id="category" class="input-xlarge" placeholder="category">
                <p id="err"></p>
            </div>
        </div>
        
        <div class="control-group">
            <label class="control-label"  for="certification">Certification :</label>
            <div class="controls">
                <input type="text" name="certification" id="certification" placeholder="certification" class="input-xlarge" >
                <p id="err"></p>
            </div>
        </div>
        
        
         <div class="control-group">
            <label class="control-label"  for="price">Price :</label>
            <div class="controls">
                <input type="text" name="price" id="price" placeholder="price" class="input-xlarge" >
                <p id="err"></p>
            </div>
        </div>
        
         <div class="control-group">
            <label class="control-label"  for="rating">Rating :</label>
            <div class="controls">
                <input type="text" name="rating" id="rating" placeholder="rating" class="input-xlarge" >
                <p id="err"></p>
            </div>
        </div>
        
        <div class="control-group">
            <label class="control-label"  for="imageURL">Image URL :</label>
            <div class="controls">
                <input type="text" name="imageURL" id="imageURL" placeholder="imageURL" class="input-xlarge" >
                <p id="err"></p>
            </div>
        </div>
        
         <div class="control-group">
            <div class="controls">
                <input type="submit" value="submit" class="btn btn-primary">
            </div>
        </div>
        
	</form>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</body>
</html>