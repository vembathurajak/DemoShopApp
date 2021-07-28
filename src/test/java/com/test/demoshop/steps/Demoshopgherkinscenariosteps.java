package com.test.demoshop.steps;

import org.openqa.selenium.WebDriver;

import com.test.DemoShop.pages.Productpage;
import com.tests.utils.WebdriverManager;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demoshopgherkinscenariosteps {
	
	 WebdriverManager driverManager;
	 Productpage product;
	 
	    public String orderID;
	    
	    public Demoshopgherkinscenariosteps(WebdriverManager driverManager){
	        this.driverManager = driverManager;
	        product = new Productpage(driverManager);
	        
	    }
	
	 @Given("Verify the user is on the demo shop home page")
	public void verify_the_user_is_on_the_demo_shop_home_page() {
		 driverManager.getDriver().get("https://testscriptdemo.com");
	}
	 
	 @Given("I add {string} different products to my wishlist")
	 public void i_add_four_different_products_to_my_wishlist(String productCount) {
		 product.addProductToWishList(productCount);
	 }
	 
	 @When("I view my wishlist table")
	 public void i_view_my_wishlist_table() {
		 product.clickOnWishlist();
	 }
	 
	 @Then("I find total four selected items in my wishlist")
	 public void i_find_total_four_selected_items_in_my_wishlist() {
		 product.getwishListTable();
	 }
	 
	 @When("I search for lowest price product")
	 public void i_search_for_lowest_price_product() {
		 product.getLowestPriceProduct();
	 }
	 
	 @When("I am able to add the lowest price item to my cart")
	 public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
		 product.addLowestPriceProductTomyCard();
	 }
	 
	 @Then("I am able to verify the item in my cart")
	 public void i_am_able_to_verify_the_item_in_my_cart() {
		 product.verifyItemInmyCart();
	 }
	 
	 @After
	 public void quitsession(){
		 driverManager.getDriver().quit();
	 }

}
