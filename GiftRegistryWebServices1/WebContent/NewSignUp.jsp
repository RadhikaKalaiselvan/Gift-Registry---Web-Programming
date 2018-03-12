<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User account </title>

<link href="https://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="newsignup.css" rel="stylesheet">
</head>
<body style="background-color:#7bceeb">
<div class="container">
	<form class="form-horizontal" action="SignUp" method="post">
		${message} <br>
		<fieldset>
		
        <div id="legend">
            <legend class="">Register</legend>
        </div>
        <div class="control-group">
            <!-- Username -->
            <label class="control-label"  for="username">Username</label>
            <div class="controls">
                <input type="text" id="username" name="username" class="input-xlarge"  placeholder="Name" required autofocus>
                <p id="err"></p>
            </div>
        </div>
        <div class="control-group">
            <!-- E-mail -->
            <label class="control-label" for="email">E-mail</label>
            <div class="controls">
                <input type="email" id="email" name="userEmail"  placeholder="Emailid@Gmail.com" class="input-xlarge" required>
                <p id="status"></p>
            </div>
        </div>
        <div class="control-group">
            <!-- phonenumber -->
            <label class="control-label"  for="phonenumber">phonenumber</label>
            <div class="controls">
                <input type="text" id="username" name="phonenumber" class="input-xlarge"  placeholder="phonenumber" >
                <p id="err"></p>
            </div>
        </div>
        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input type="password" id="pass1" name="password" placeholder="Password" class="input-xlarge" required>
                <p class="help-block"></p>
            </div>
        </div>
        <div class="control-group">
            <!-- Password -->
            <label class="control-label"  for="password_confirm">Confirm Password</label>
            <div class="controls">
                <input type="password" id="pass2" name="repassword" placeholder="Password" class="input-xlarge" required>
                <p id="confirmMessage"></p>
            </div>
        </div>
         <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success" type="submit">Register</button>
                </div>
        </div>
    </fieldset>
</form>
</div>

</body>
</html>