package cabanas.garcia.ismael.examples.cucumber.steps;

import cabanas.garcia.ismael.examples.UserManagementApplication;
import cabanas.garcia.ismael.examples.cucumber.common.Attribute;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * Created by XI317311 on 03/02/2017.
 */
@SpringBootTest(classes = UserManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CreateUsersSteps {
    @When("^the client requests for creating (.*) user$")
    public void theClientRequestsForCreatingUser(String userName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the response is OK$")
    public void theResponseIsOK() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the user has the following attributes:$")
    public void theUserHasTheFollowingAttributes(List<Attribute> attributes) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
