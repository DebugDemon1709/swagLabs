package swagLabs;

public class Steps {

}
/*
Swag labs 

Login page 

	Enter username (standard_user) 

	Enter password (secret_sauce) 

	Return product catalogue object 

Product Catalogue (refer EndToEnd.java) 

	Get all the product names in ‘Product’ List<WebElement> (line 31) 

	Search for specific product name in ‘Product’ using Java Streams, save it in prod<WebElement> (32, 33) 

	Click on ‘add to cart’ in prod <WebElement> using streams (34) 

	Click on the Cart button, right top (38) 

	Get all the items in the cart list, save it in cartProducts List<WebElement>(39) 

	Matching all the elements in the cartProducts with required productName, if required item is present then match is true or else false (40, 41) 

	Click on checkout, enter firstName, lastName and zipCode. 

	Scroll to view ‘continue’ button and perform click operation (42, 43) 

	In checkoutPage, do assertion for required productName is present or not, click ‘finish’ 

	Then do assertion for ‘thank you’ message (48, 49) 

 
*/