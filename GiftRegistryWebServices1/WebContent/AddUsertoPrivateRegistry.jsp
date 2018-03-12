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
</head>
<body>
<div class="container">
<h2 class="form-signin-heading">Add Buyer to Registry</h2>
<form action="AddBuyertoregServlet" method="get">
  ${message}<br>
  <div class="form-group">
    <label for="UserID">UserID</label>
    <input type="text" name="OwneruserID" class="form-control" id="UserID" value="${sessionScope.SuserID}">
  </div>
  <div class="form-group">
    <label for="RegID">RegID</label>
    <input type="text" name="RegID" class="form-control" id="RegID" placeholder="RegistryID" required>
  </div>
  <div class="form-group">
    <label for="buyeremailID">buyeremailID</label>
    <input type="email" name="buyeremailID" class="form-control" id="buyeremailID" placeholder="buyeremailID" required>
  </div>
  <div>
  <input type="submit" value="submit" class="btn btn-primary">
  <a href="success.jsp" class="btn btn-primary">Home</a><br>
  </div>
</form>
</div>
</body>
</html>