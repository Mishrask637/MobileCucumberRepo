package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import driverfactoryutility.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {

	LoginPage login = new LoginPage(DriverFactory.getdriver());
	
	@Given("User is on amazon landing page")
	public void user_is_on_amazon_landing_page() {
		DriverFactory.getdriver().get("https://www.amazon.in/");
	}

	@Given("user clicks on signin tab")
	public void user_clicks_on_signin_tab() {
		login.signInTab();
	}
	
	@When("user enters username")
	public void user_enters_username(DataTable userlist) {
		
		List<String> users = userlist.asList();
		String username = users.get(0);
		login.enterUserName(username);
	}

	@When("user clicks on signin button")
	public void user_clicks_on_signin1_button() {
		login.clicksubmit();
	}
	
	@When("user enters password")
	public void user_enters_password(DataTable userlist) {
		List<String> users = userlist.asList();
		String password = users.get(0);
		try {
			login.enterPassword(password);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("user clicks on signinsubmit button")
	public void user_clicks_on_signinsubmit_button() {
		login.clicksigninsubmit();
	}
	
	/*
	 * @Then("user navigates to home page") public void
	 * user_navigates_to_home_page() { String title =
	 * "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
	 * ; assertEquals(login.getTitle(), title); }
	 */
	 
	
}
