<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
 <link href="newlogin.css" rel="stylesheet">
 <link rel="icon" href="blueleaf.png">
<title>User Login Page</title>
</head>
  <body style="background-color:#7bceeb">

  <div class="container" style="background-color:#7bceeb">

      <form action="login" method="post" class="form-signin">
      ${message} 
          <h2 class="form-signin-heading">Please sign in</h2>
          <label for="inputEmail" class="sr-only">Email address</label>
          <input type="email" name="email" id="inputEmail" class="form-control" placeholder=" Email ID" required autofocus>
          <label for="inputPassword" class="sr-only">Password</label>
          <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
          <div class="checkbox">
                  <label>
                  <input type="checkbox" value="remember-me"/> Remember me
                  </label>
              <small><a href="ChangePassword.jsp"> forget password?</a></small>
              <p>New here? <a href="NewSignUp.jsp">Sign Up</a>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit">Log in</button>
      </form>


  </div>

		<footer>
			<p>&copy All right reserved</p>
		</footer>
		
    
    </body>
</html>