<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
   <%@ page import="blueleaf.giftregistry.model.Registry"%>
   
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
<div class="row">
		<div class="col">
		<h2 class="form-signin-heading">My Registry</h2>
		</div>
		<div class="col" align=right>
		<a href="success.jsp" class="btn btn-primary btn-lg">HOME</a><br>
		</div>
	</div>
	</div>
	<SCRIPT LANGUAGE="JavaScript">
 
     function SubmitA()
      {
         document.forms[0].action = "DeleteRegistry";
         document.forms[0].submit();
      }
 	function SubmitB()
 	{
     document.forms[0].action = "userProductlist";
     document.forms[0].submit();
 	}

</SCRIPT>
	
<% List<Registry> reg = (List<Registry>) request.getAttribute("myregistries");%><br>

<% for(Registry rg:reg) { %>
<div class="container">
<div class="control-group">

<form action="DeleteRegistry" method="get">
<label class="control-label"  for="username">Registry Name :</label>
<div class="controls">
<input type="Text" name="Rname" value="<%=rg.getRegistryName() %>"readonly><br>
</div>
<label class="control-label"  for="username">Registry ID :</label>
<div class="controls">
<input type="Text"  name="Rid"value="<%=rg.getRegistryID() %>" readonly><br>
</div>
	<input style="margin-top:8px" class="btn btn-primary" type="submit" value="delete" ONCLICK="SubmitA();">
	<input style="margin-top:8px" class="btn btn-primary" type="submit" ONCLICK="SubmitB();" value="OPEN">
</form>
</div>
</div>
<% } %>

 ${message}

</body>
</html>