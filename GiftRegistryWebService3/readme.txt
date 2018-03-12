
APIs and their usage 

BaseUrl+/THE following

/registeruser
To add a new user to gift registry.
POST 
INPUT: JSON
{
        "email": "john@gmail.com",
        "password": "test213",
        "phoneNum": 1233333339,
        "userType": 1,
        "username": "John"
    }
    
OUTPUT: JSON
{
    "email": "john@gmail.com",
    "password": "test213",
    "phoneNum": 1233333339,
    "userID": 133,
    "userType": 1,
    "username": "John"
}

/customerdetails

To get all users with all user info.
GET
INPUT: -
OUTPUT:
[
    {
        "email": "test1@gmail.com",
        "password": "test213",
        "phoneNum": 123456789,
        "userID": 124,
        "userType": 1,
        "username": "User123RAD1"
    },
    {
        "email": "test@gmail.com",
        "password": "test",
        "phoneNum": 123456789,
        "userID": 125,
        "userType": 2,
        "username": "Radhika"
    },
    {
        "email": "test2@gmail.com",
        "password": "test2",
        "phoneNum": 123456789,
        "userID": 126,
        "userType": 1,
        "username": "User1"
    }
]

/customerdetails/{emailID}

To get a particular user information.
GET
Eg: http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/test1@gmail.com

OUTPUT: JSON
{
    "email": "test1@gmail.com",
    "password": "test1",
    "userID": 124,
    "userType": 1,
    "username": "Radhika1"
}

/registeruser/newuser/{emailId}


To check if the user already exists.
GET
OUTPUT: TXT

False – new user
True –old user

/customerdetails/updateInfo

To update user information like username and password.
POST
INPUT: JSON (Must have userID in the JSON)
{
        "email": "test23@gmail.com",
        "password": "test213",
        "userType": 1,
        "username": "User123RAD1",
        "userID": 124
    }

OUTPUT:
JSON
{
        "email": "test23@gmail.com",
        "password": "test213",
        "userType": 1,
        "username": "User123RAD1",
        "userID": 124
    }

/productmanagement/getbrands

To get all brands
GET
INPUT: -
OUTPUT: JSON
[
    {
        "brandID": 1,
        "brandName": "Nike"
    },
    {
        "brandID": 2,
        "brandName": "Wildcraft"
    }
]
/productmanagement/getcategories

To get all categories.
GET
INPUT: -
OUTPUT:JSON
[
    {
        "categoryID": 1,
        "categoryName": "Electronics"
    },
    {
        "categoryID": 2,
        "categoryName": "Kitchen"
    },
    {
        "categoryID": 3,
        "categoryName": "Fashion"
    }
]


/productmanagement/allproducts

To get all products
GET
INPUT: -
OUTPUT:
JSON
[
    {
        "brandID": 1,
        "brandname": "PEN",
        "category": "Electronics",
        "categoryID": 1,
        "certification": 1,
        "imageURL": "",
        "price": 40,
        "productID": 900,
        "productName": "PEN",
        "rating": 4
    }
]
/productmanagement/addproduct

To add a product.
POST
INPUT: JSON
{
        "productID" : 0,
	    "productName" : "IPHONE",
		"price" : 1400,
		"imageURL" : "",
		"rating" : 5,
		"certification" : 1,
	     "brandID" : 1,
		"categoryID" : 1,
		"brandName" : "",
		"categoryName" : ""
    }

productID,brandName,categoryName are updated after inserting into DB.
OUTPUT:JSON
{
    "code": 100,
    "message": "Success"
}
productmanagement/deleteproduct/{product-ID}

Eg:
http://localhost:8085/GiftRegistryDBWeb/rest/productmanagement/deleteproduct/903
 
To delete a product.
GET
Input: -
OUTPUT:
{
    "code": 100,
    "message": "Success"
}

registrymanagement/getallregistry/{user-ID}

eg :
registrymanagement/getallregistry/124


To get all registries of a user
GET
INPUT: -
OUTPUT:
[
    {
        "registryID": 900,
        "registryName": "MyPublicRegistry",
        "registryType": 1,
        "userID": 124
    },
    {
        "registryID": 901,
        "registryName": "MyPrivateRegistry",
        "registryType": 0,
        "userID": 124
    }
]
/registrymanagement/add

To add a registry.
POST
INPUT: JSON
{
        "registryID": 0,
        "registryName": "My_NEW_PublicRegistry",
        "registryType": 1,
        "userID": 124
    }

OUTPUT:
JSON
{
    "registryID": 902,
    "registryName": "My_NEW_PublicRegistry",
    "registryType": 1,
    "userID": 124
}

/registrymanagement/delete/{registry-ID}

Eg:
/registrymanagement/delete/902

To delete a registry
GET
INPUT: -
OUTPUT:
JSON
{
    "code": 100,
    "message": "Success"
}
registryproductmapper/addproduct/{registry-ID}

Eg:
registryproductmapper/addproduct/900


To add product to a registry
POST
INPUT: JSON of product to be added to the registry.
{
        "brandID": 1,
        "brandname": "IPHONE",
        "category": "Electronics",
        "categoryID": 1,
        "certification": 1,
        "imageURL": "",
        "price": 1400,
        "productID": 902,
        "productName": "IPHONE",
        "rating": 5
    }

OUTPUT:
{
    "code": 200,
    "message": "SUCCESS"
}

registryproductmapper/deleteproduct/{registry_ID}

eg:
registryproductmapper/deleteproduct/900


To delete a product from the registry.
POST
INPUT: JSON of product to be deleted.
{
        "brandID": 1,
        "brandname": "IPHONE",
        "category": "Electronics",
        "categoryID": 1,
        "certification": 1,
        "imageURL": "",
        "price": 1400,
        "productID": 902,
        "productName": "IPHONE",
        "rating": 5
    }

OUTPUT:
{
    "code": 100,
    "message": "SUCCESS"
}
registryproductmapper/allproducts/{registry-Id}

Eg:
registryproductmapper/allproducts/903




To get all the products of a registry.
GET
INPUT: -
OUTPUT:JSON of all products in the registry
[
    {
        "brandID": 1,
        "brandname": "PEN",
        "category": "Electronics",
        "categoryID": 1,
        "certification": 1,
        "imageURL": "",
        "price": 40,
        "productID": 900,
        "productName": "PEN",
        "rating": 4
    },
    {
        "brandID": 1,
        "brandname": "IPHONE",
        "category": "Electronics",
        "categoryID": 1,
        "certification": 1,
        "imageURL": "",
        "price": 1400,
        "productID": 902,
        "productName": "IPHONE",
        "rating": 5
    }
]
/registryproductmapper/shareprivateregistry/{buyeruserID}

eg:
/registryproductmapper/shareprivateregistry/127


To a share a private registry to user.
POST
INPUT: JSON of registry
{
        "registryID": 900,
        "registryName": "MyPublicRegistry",
        "registryType": 1,
        "userID": 124
    }

OUTPUT: Status JSON
{
    "code": 100,
    "message": "SUCCESS"
}
/registryproductmapper/markregistrypublic/{registryID}

eg:
/registryproductmapper/markregistrypublic/901

To make a registry public.
GET
INPUT: -
OUTPUT: Status JSON
{
    "code": 100,
    "message": "SUCCESS"
}
registryproductmapper/deleteallprivateregistrymapping/{registry-ID}

Eg:
registryproductmapper/deleteallprivateregistrymapping/903


To delete all entries of private user registry mapping.
GET
INPUT: -
OUTPUT: Status JSON
{
    "code": 100,
    "message": "SUCCESS"
}


To get the list of registries shared with you.
GET
INPUT: -
OUTPUT: JSON
[
    {
        "registryID": 900,
        "registryName": "MyPublicRegistry",
        "registryType": 0,
        "userID": 124
    },
    {
        "registryID": 901,
        "registryName": "MyPrivateRegistry",
        "registryType": 1,
        "userID": 124
    },
    {
        "registryID": 903,
        "registryName": "My_NEW_PublicRegistry",
        "registryType": 1,
        "userID": 124
    }
]


 

