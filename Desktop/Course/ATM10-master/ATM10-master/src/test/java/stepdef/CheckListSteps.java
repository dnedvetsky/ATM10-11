package stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import model.CaseModel;
import model.PersonModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobject.page.MainPage;
import pageobject.page.casePages.AddPartyPage;
import pageobject.page.casePages.CaseEventPage;
import pageobject.page.casePages.EditCaseViewPage;
import pageobject.test.CommonConditions;
import service.CaseCreator;
import service.PersonCreator;

import java.util.List;

public class CheckListSteps{
    //WebDriver driver = new ChromeDriver();
  //  WebDriver driver;
    EditCaseViewPage editCaseViewPage;


    @And("^I add party with type \"([^\"]*)\" and role \"([^\"]*)\"$")
    public void addParty(String partyType, String partyRole){
        PersonModel testPerson = PersonCreator.withDataFromProperties();
        new AddPartyPage().addPartyRoleType(partyType,partyRole).addPerson(testPerson).addLegalRep();
    }

    @And("I add case event")
    public void addingCaseEvent(){
        new CaseEventPage().newCaseEvent("Filing - Bundle").addCaseEvent();
    }

    @And("I add case caption and case title")
    public void addingCaptionAndTitle(){
        CaseModel newCase = CaseCreator.withDataFromProperties();
       // EditCaseViewPage editCaseViewPage = new EditCaseViewPage().addCaseCaptionAndTitle(newCase);
        editCaseViewPage = new EditCaseViewPage();
        editCaseViewPage.addCaseCaptionAndTitle(newCase);
    }


    @Then("^checklist is absent on Case View page$")
    public void checklistIsAbsentOnCaseViewPage() {
       // List checklist = driver.findElements(By.cssSelector(".cc-checklistTable"));
        //List checkList = EditCaseViewPage()
        //Assert.assertTrue(checklist.size()==0,"It is visible. Or not. Maybe wrong selector");
        editCaseViewPage.getCheckList();

    }

}
