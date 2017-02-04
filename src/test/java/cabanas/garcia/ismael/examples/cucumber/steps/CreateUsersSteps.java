package cabanas.garcia.ismael.examples.cucumber.steps;

import cabanas.garcia.ismael.examples.UserManagementApplication;
import cabanas.garcia.ismael.examples.cucumber.common.Attribute;
import cabanas.garcia.ismael.examples.rest.request.UserRequest;
import cabanas.garcia.ismael.examples.rest.response.UserResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
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

    private HttpStatus httpStatus;

    private UserResponse userResponse;

    private UserResponse tempUserRespose;

    @When("^the client requests for creating (.*) user$")
    public void theClientRequestsForCreatingUser(String userName) throws Throwable {
        UserRequest userRequest = new UserRequest();
        userRequest.setName(userName);

        ResponseEntity<UserResponse> response = restTemplate.postForEntity("/users", userRequest, UserResponse.class);

        httpStatus = response.getStatusCode();
        userResponse = response.getBody();
    }

    @Then("^the user is created$")
    public void theUserIsCreated() throws Throwable {
        assertHttpStatus(HttpStatus.CREATED);
    }

    @And("^the user has the following attributes:$")
    public void theUserHasTheFollowingAttributes(List<Attribute> attributes) throws Throwable {
        assertThat(userResponse.getName(), is(equalTo(attributes.get(0).getValue())));
    }

    @Given("^the system knows about (.*) user$")
    public void theSystemKnowsAboutUser(String userName) throws Throwable {
        theClientRequestsForCreatingUser(userName);
        this.tempUserRespose = userResponse;
    }

    @When("^the client requests for getting his information$")
    public void theClientRequestsForGettingHisInformation() throws Throwable {
        String url = "/users/{id}";

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        final HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<UserResponse> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, UserResponse.class, tempUserRespose.getId());

        httpStatus = response.getStatusCode();
        userResponse = response.getBody();
    }

    @Then("^the user is got$")
    public void theUserIsGot() throws Throwable {
        assertHttpStatus(HttpStatus.OK);
    }

    @When("^the client request for updating his name to (.*)")
    public void theClientRequestForUpdatingHisNameTo(String newName) throws Throwable {
        String url = "/users/{id}";

        UserRequest userRequestBody = new UserRequest();
        userRequestBody.setId(tempUserRespose.getId());
        userRequestBody.setName(newName);

        HttpEntity<UserRequest> requestEntity = new HttpEntity<>(userRequestBody);

        ResponseEntity<UserResponse> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, UserResponse.class, tempUserRespose.getId());

        httpStatus = response.getStatusCode();
        userResponse = response.getBody();
    }

    @Then("^the user is updated$")
    public void theUserIsUpdated() throws Throwable {
        assertHttpStatus(HttpStatus.OK);
    }

    @When("^the client request for deleting her$")
    public void theClientRequestForDeletingHer() throws Throwable {
        String url = "/users/{id}";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, tempUserRespose.getId());

        httpStatus = response.getStatusCode();
    }

    @Then("^the user is deleted$")
    public void theUserIsDeleted() throws Throwable {
        assertHttpStatus(HttpStatus.NO_CONTENT);
    }

    private void assertHttpStatus(HttpStatus httpStatus){
        assertThat(this.httpStatus, is(equalTo(httpStatus)));
    }

}
