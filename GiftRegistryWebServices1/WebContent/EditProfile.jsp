<%@page import="blueleaf.giftregistry.model.AllUserinfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div class="container">
<% AllUserinfo user = (AllUserinfo) request.getAttribute("userinfo");%><br>

<form action="EditProfile" method="post" class="form-horizontal" >
${message} <br>
 <fieldset>
 <h2 class="form-signin-heading">My Profile</h2>
       
        <div class="control-group">
            <!-- User name -->
            <label class="control-label"  for="username">User name</label>
            <div class="controls">
                <input type="text" name="username" value=${sessionScope.SUname} id="username" class="input-xlarge" placeholder="">
                <p id="err"></p>
            </div>
        </div>
        <div class="control-group">
            <!-- password -->
            <label class="control-label"  for="password">Password</label>
            <div class="controls">
                <input type="password" name="password" value='${sessionScope.Spassword}' id="password" class="input-xlarge" placeholder="">
                <p id="err"></p>
            </div>
        </div>
          <div class="control-group">
            <!-- phone number -->
            <label class="control-label"  for="password_confirm">Phone number</label>
            <div class="controls">
                <input type="text" name="phonenum" value=${sessionScope.Sphonenum} id="phone" placeholder="" class="input-xlarge">
                <p id="confirmMessage"></p>
            </div>
        </div>

        <div class="control-group">
            <!-- E-mail -->
            <label class="control-label" for="email">E-mail</label>
            <div class="controls">
                <input type="text"  name="email" value=${sessionScope.Semail} readonly id="email" onkeypress="email_validate(this.value)" placeholder="" class="input-xlarge">
                <p id="status"></p>
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
            	<button class="btn btn-primary" type="submit" name="submit">Save</button>
                <a class="btn btn-primary" href="success.jsp">Home</a>
            </div>
        </div>
    </fieldset>
    </form>
</div>
 
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</body>
</html>