<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    <%@ page import="blueleaf.giftregistry.model.Product"%>
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
<style type="text/css">
li {
  list-style-type: none;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<% List<Product> pro = (List<Product>) request.getAttribute("myProduct");%>

<div class="container" id="filters">
	<div class="row">
		<div class="col">
		<h2 class="form-signin-heading">List of Products</h2><br>
		</div>
		<div class="col" align=right>
		<a href="success.jsp" class="btn btn-primary btn-lg">HOME</a><br>
		</div>
	</div>

  
<h4 class="form-signin-heading">Filters</h4>
<div class="row">
		<!--div class="col">
	    <section id="price">
	        <p id="fHeader">Price</p>
	        <input type="checkbox" name="price" value="p1" id="p1" />$10 - $50
	        <br/>
	        <input type="checkbox" name="price" value="p2" id="p2" />$50 - $100
	        <br/>
	        <input type="checkbox" name="price" value="p3" id="p3" />$100 - $500
	        <br/>
	        <input type="checkbox" name="price" value="p4" id="p4" />$500 +
	        <br/>
	    </section>
	    </div  -->
    <div class="col">
    <section id="category">
        <p id="fHeader">Category</p>
        <%@ page import = "java.util.HashSet" %>
        <%
        HashSet<String> set1 = new HashSet<>();
        String 	category;
        for(Product rg:pro) { 
        	category = rg.getCategory();
    		if(set1.contains(category)){
    			continue;
    		}else{
    			set1.add(category);
        %>
        <input type="checkbox" name="category" value="<%=rg.getCategory() %>"/><%=rg.getCategory() %>
        <br/>
        <% } }%>
    </section>
    </div>
   
    <div class="col">
    <section id="rating">
        <p id="fHeader">Rating</p>
        <input type="checkbox" name="rating" value="1" id="1" />1
        <br/>
        <input type="checkbox" name="rating" value="2" id="2" />2
        <br/>
        <input type="checkbox" name="rating" value="3" id="3" />3
        <br/>
        <input type="checkbox" name="rating" value="4" id="4" />4
        <br/>
        <input type="checkbox" name="rating" value="5" id="5" />5
    </section>
    </div>
    <div class="col">
    <section id="brand">
        <p id="fHeader">Brand</p>
        
        <%
        HashSet<String> set = new HashSet<>();
        String 	brand;
        for(Product rg:pro) { 
        	brand = rg.getBrandName();
    		if(set.contains(brand)){
    			continue;
    		}else{
    			set.add(brand);
        %>
        <input type="checkbox" name="brand" value="<%=rg.getBrandName() %>"/><%=rg.getBrandName() %>
        <br/>
        <% } }%>
    </section>
    </div>
     <div class="col">
    <section id="rating">
        <p id="fHeader">Certification</p>
        <input type="checkbox" name="certification" value="1" id="1" />1 YES
        <br/>
        <input type="checkbox" name="certification" value="0" id="0" />0 NO

    </section>
    </div>
    </div>
    </div>
<hr>

<div class="container">
<div class="row">


<table class="table table-striped">
  <thead>
	  <tr>
		<th></th>
		<th></th>
		<th>RegisterID</th>
		<th>ProductName</th>
		<th>BrandName</th>
		<th>ProductID</th>
		<th>Price</th>
		<th>Certification</th>
		<th>Rating</th>
		<th>Category</th>
	</tr>
  </thead>
  
  <tbody>
  
    <% for(Product rg:pro) { %>
    
<tr>
<form action="AddProductServlet" method="get">
	${message} <br><br>	
	<td scope="row"  data-rating="<%=rg.getRating() %>"
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" ><p>*</p>
			
	</td>
	
	<td data-rating="<%=rg.getRating() %>"
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" >
			
				<div class="control-group">
		            <div class="controls">
		                <img src="<%= rg.getImageURL() %>" name="imageURL" id="imageURL" width="80px">
		                <p id="err"></p>
		            </div>
		        </div>
	</td>
		<td data-rating="<%=rg.getRating() %>"
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" ><input type="Text" name="RegisterID" size=10 placeholder="Enter RegID" required></li></td>
		<td data-rating="<%=rg.getRating() %>" 
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" type="Text" name="ProductName"><%=rg.getProductName() %></td>
		<td data-rating="<%=rg.getRating() %>" 
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" type="Text" name="brand"><%=rg.getBrandName() %></td>
		<td data-rating="<%=rg.getRating() %>" 
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>"><input type="Text"  name="ProductID" value=<%=rg.getProductID() %> readonly></td>
		<td data-rating="<%=rg.getRating() %>" 
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" type="Text"  name="price"><%=rg.getPrice() %></td>
		<td data-rating="<%=rg.getRating() %>" 
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" type="Text"  name="certification"><%=rg.getCertification() %></td>
		<td data-rating="<%=rg.getRating() %>"
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" type="Text"  name="rating"><%=rg.getRating() %></td>
		<td data-rating="<%=rg.getRating() %>"
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" type="Text"  name="category"><%=rg.getCategory() %></td>
		<td data-rating="<%=rg.getRating() %>"
			data-category="<%=rg.getCategory() %>"
			data-certification="<%=rg.getCertification() %>"
			data-price="<%=rg.getPrice() %>"
			data-brand="<%=rg.getBrandName() %>" > <input type="submit" class="btn btn-success" value="AddToRegistry"></td>
	</form>
</tr>
<% } %>
    
  </tbody>
</table>
</div>
</div>

<script>
        $(document).ready(function () {
        $('#filters input:checkbox').click(function () {
            if ($('input:checkbox:checked').length) {
                var arrSelected = []; // Create Array of checked Values
                var arrTypes = []; // Create Array of Types
                $('input:checkbox:checked').each(function () {
                    if (arrSelected[$(this).prop('name')] == undefined) {
                        arrSelected[$(this).prop('name')] = [];
                    }
                    arrSelected[$(this).prop('name')].push($(this).val());
                    if ($.inArray($(this).prop('name'), arrTypes) < 0) {
                        arrTypes.push($(this).prop('name'));
                    }
                });
                $('td').each(function() {
                    $(this).hide();   
                    var intKeyCount = 0;
                    for (key in arrTypes) { // AND (check count of matching types)
                        var blnFound = false;
                        for (val in arrSelected[arrTypes[key]]) { // OR (check one of values matches type)
                            if ($(this).attr('data-' + arrTypes[key]).indexOf(arrSelected[arrTypes[key]][val]) > -1) {                       
                                blnFound = true;
                                break;
                            }
                        }
                        if (blnFound) {
                            intKeyCount++;
                        }
                    }
                    if ( intKeyCount == arrTypes.length) {
                        $(this).show();   
                    }
                });
            } else {
                $("td").show();
            }
        });
        });
</script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>