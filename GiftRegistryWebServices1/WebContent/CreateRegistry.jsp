<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="blueleaf.png">
	<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
<title>Create Registry</title>
</head>
<body>
 <div class="container">
 <h2 class="form-signin-heading">Create Registry</h2>
 <form action="RegisterCreate" method="post">
 ${message} <br>
  <div class="form-group row">
    <label for="UserID" class="col-sm-2 col-form-label">User ID</label>
    <div class="col-sm-10">
      <input type="text" name="userID" value="${sessionScope.SuserID}" readonly class="form-control" id="UserID" >
    </div>
  </div>
  <div class="form-group row">
    <label for="RegistryName" class="col-sm-2 col-form-label">Registry Name</label>
    <div class="col-sm-10">
      <input type="text" name="registryName" focus class="form-control" id="RegistryName" placeholder="Registry Name">
    </div>
  </div>
  <fieldset class="form-group">
    <div class="row">
    <legend class="col-form-legend col-sm-2"></legend>
      <div class="col-sm-10">
        <div class="form-check">
          <label class="form-check-label">
            <input class="form-check-input" type="radio" name="Private" id="gridRadios1" value=0 />
            Private<br>
            <input class="form-check-input" type="radio" name="Private" id="gridRadios2" value=1 />
            Public
          </label>
        </div>
        
      </div>
    </div>
  </fieldset>
  
  <div class="form-group row">
    <div class="col-sm-10">
      <input type="submit" name="submit" value="Submit" class="btn btn-primary">
      <a href="success.jsp" class="btn btn-primary">Home</a>
    </div>
  
  </div>
  
</form>
 </div>
</body>
</html>