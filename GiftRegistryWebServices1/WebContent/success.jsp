<%@page import="blueleaf.giftregistry.model.AllUserinfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="blueleaf.png">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="success.css">

    <style>
    	#logout {
		  background:none;
		  border:none;
		}
    </style>   
<title>Blue leaf</title>
</head>
<body>
${message}
<nav class="navbar navbar-expand-md navbar-toggleable-md navbar-light bg-faded sticky-top ">
    
<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" 
		aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    
    <a class="navbar-brand" href="#" style="font-size:25px">
    <img src="blueleaf.png" width="50px" style="border-radius: 50%"> Blue Leaf
    </a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="EditProfile.jsp">Profile<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="CreateRegistry.jsp">Create Registry</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ExistingRegistry.jsp">Registries</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="AddUsertoPrivateRegistry.jsp">Share Registry To Buyer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="makeRegistryPublic.jsp">Make Registry Public</a>
            </li>
           
        </ul>
        	<div style="float: right;">
                 <!--  form action="Logout" method="get">
					<input class="btn btn-outline-success my-2 my-sm-0" id="logout" type="submit" value="Logout">
				</form>-->
				<a class="btn btn-outline-success my-2 my-sm-0" href="logout.jsp">Log out</a>
           </div>
	</div>
	
</nav>
<div id="jumbotron" class="jumbotron jumbotron-fluid container-fluid">
    <br class="my-5">
	<br class="my-5">
	<br class="my-5">
	<br class="my-5">
	<br class="my-5">
	<br class="my-5">
	<br class="my-5">
	<br class="my-5">
	<br class="my-5">
	<br class="my-5">
	<br class="my-5">
	<div class="container">
	
	    <br class="my-4">
	
	    <p class="lead">
	        <form action="AddProducttoRegistry" method="get">
				${message}
				<input class="btn btn-primary btn-lg" type="submit" value="Add Product">
			</form>
	    </p>
    </div>
    <br class="my-4">
    <br class="my-4">
    <br class="my-4">
    <br class="my-4">
    <br class="my-4">
    <br class="my-4">
    <div align="right" class="container">
		User Name : ${sessionScope.SUname}<br>
		User ID : ${sessionScope.SuserID}<br>
		Phone Number : ${sessionScope.Sphonenum}<br>
		Email ID : ${sessionScope.Semail}<br>
	</div>
</div>  

<!-- jQuery first, then Tether, then Bootstrap JS. -->
		<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>


</body>
</html>