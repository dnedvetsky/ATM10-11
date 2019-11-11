package stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pageobject.page.casePages.CaseSearchPage;
import pageobject.page.casePages.CaseViewPage;
import pageobject.page.LoginPage;
import pageobject.page.MainPage;
import pageobject.test.CommonConditions;
import service.UserCreator;


public class CaseSearchSteps extends CommonConditions {
    String createdCaseNumber;
   // WebDriver driver = new ChromeDriver();

    @Given("I logged in the CMS")
    public void iLoggedInCMS(){
        System.setProperty("environment","qa");
        UserModel testUser = UserCreator.withCredentialsFromProperty();
        new LoginPage().open().login(testUser);
    }

    @When("I create case")
    public void createCase(){
        new MainPage().openCreateCase().fillInCaseClassification("@@@").chooseCaseClassification("Business - N8 - Arbitration");
    }

    @And("I search for created case in Case Search page")
    public void caseSearch(){
        createdCaseNumber = new CaseViewPage().getCaseNumber();
        new CaseSearchPage().caseSearch(createdCaseNumber);
    }
     @Then("the case is found")
    public void caseFound(){
         String foundCaseNumber = new CaseViewPage().getFoundCaseNumber();
         Assert.assertEquals(createdCaseNumber,foundCaseNumber,"Fail");

     }

}
