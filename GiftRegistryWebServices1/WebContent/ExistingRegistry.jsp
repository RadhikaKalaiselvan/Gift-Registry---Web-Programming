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
 <fieldset>
 <div class="row">
		<div class="col">
		<h2 class="form-signin-heading">Existing Registry</h2>
		</div>
		<div class="col" align=right>
		<a href="success.jsp" class="btn btn-primary btn-lg">HOME</a><br>
		</div>
	</div>
	<hr>
 
${message} <br><br>

         <div class="control-group">
            <!-- Button -->
            <div class="controls">
	            <form action="myRegistryServlet" method="get" >
				<input class="btn btn-primary btn-lg" type="submit"  value="My Registry">
				</form><br>
          
	          	<form action="SharedRegistry" method="get" >
				<input class="btn btn-primary btn-lg" type="submit"  value="Shared Registry">
				</form>
            </div>
        </div>
        
</fieldset>
</div>	

</body>
</html>