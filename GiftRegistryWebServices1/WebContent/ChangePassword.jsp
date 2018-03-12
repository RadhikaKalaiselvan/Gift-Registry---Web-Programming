<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link href="https://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="changepass.css" rel="stylesheet">
</head>
<body style="background-color:#7bceeb">
<div class="container" >
<form class="form" action="ChangePassword" method="post">
<h2 class="form-heading">Enter your email</h2>
<label for="inputEmail" class="sr-only">Email address</label>
<input type="email" name="emailID" id="inputEmail" class="form-control" placeholder="Email address" onkeypress="email_validate(this.value)" required >
        <div id="status"></div>
<button class="btn btn-lg btn-primary btn-block" type="submit">Confirm</button>


</form>
</body>
</html>