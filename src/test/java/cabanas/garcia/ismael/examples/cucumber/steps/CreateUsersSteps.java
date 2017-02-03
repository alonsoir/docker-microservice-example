package cabanas.garcia.ismael.examples.cucumber.steps;

import cabanas.garcia.ismael.examples.UserManagementApplication;
import cabanas.garcia.ismael.examples.cucumber.common.Attribute;
import cabanas.garcia.ismael.examples.rest.request.UserRequest;
import cabanas.garcia.ismael.examples.rest.response.UserResponse;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by XI317311 on 03/02/2017.
 */
@SpringBootTest(classes = UserManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CreateUsersSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<UserResponse> response;

    @When("^the client requests for creating (.*) user$")
    public void theClientRequestsForCreatingUser(String userName) throws Throwable {
        UserRequest userRequest = new UserRequest();
        userRequest.setName(userName);

        response = restTemplate.postForEntity("/users", userRequest, UserResponse.class);
    }

    @Then("^the response is OK$")
    public void theResponseIsOK() throws Throwable {
        assertThat(response.getStatusCode(), is(equalTo(HttpStatus.CREATED)));
    }

    @And("^the user has the following attributes:$")
    public void theUserHasTheFollowingAttributes(List<Attribute> attributes) throws Throwable {
        UserResponse userResponse = response.getBody();
        assertThat(userResponse.getName(), is(equalTo(attributes.get(0).getValue())));
    }
}
