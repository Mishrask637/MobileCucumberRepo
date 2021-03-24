package stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import driverfactoryutility.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SearchPage;

public class SearchPageSteps {

	LoginPage login = new LoginPage(DriverFactory.getdriver());
	SearchPage search;
	
	@Given("user is already logged in")
	public void user_is_already_logged_in(DataTable datatable) {
	  
		List<Map<String,String>> userlist = datatable.asMaps();
		String username = userlist.get(0).get("username");
		String password = userlist.get(0).get("password");
		DriverFactory.getdriver().get("https://www.amazon.in/");
		login.signInTab();
		search = login.doLogin(username, password);
		
	}

	@Given("user can navigate to signout button")
	public void user_can_navigate_to_signout_button() {
			assertTrue(search.verifyLogin());
	}

	@When("user enters {string} in search field")
	public void user_enters_in_search_field(String product) {
	   search.searchProduct(product);
	}

	@When("user clicks on Go button")
	public void user_clicks_on_go_button() {
		search.clickGoButton();
	}

	@Then("user clicks on first available product")
	public void user_clicks_on_first_available_product() {
	   search.clickFirstProduct();
	}

	@Then("user navigates back to home page")
	public void user_navigates_back_to_home_page() {
	  search.navigateBack();
	  search.navigateBack();
	}

	@Then("user clicks on logout")
	public void user_clicks_on_logout() {
	  search.doLogout();
	}
	
}
