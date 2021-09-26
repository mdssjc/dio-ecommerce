package one.digitalinnovation.ecommerce.checkout.steps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import one.digitalinnovation.ecommerce.checkout.SpringIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * @author Marcelo dos Santos
 */
public class StepDefinitions extends SpringIntegrationTest {

  @Autowired
  protected TestRestTemplate template;
  private String responseBody;
  private HttpStatus statusCode;

  private static String getBody(ResponseEntity<?> response) {
    final StringBuilder body = new StringBuilder();
    if (response.getBody() != null) {
      body.append(response.getBody().toString());
    }
    return body.toString();
  }

  @When("the client calls {string}")
  public void theClientCalls(String path) {
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      final String body = "{\n" +
          "    \"firstName\": \"Marcelo\",\n" +
          "    \"lastName\": \"dos Santos\",\n" +
          "    \"email\": \"mds@sjc.com.br\",\n" +
          "    \"address\": \"rua ABC\",\n" +
          "    \"complement\": \"---\",\n" +
          "    \"country\": \"Brasil\",\n" +
          "    \"state\": \"São Paulo\",\n" +
          "    \"cep\": \"12200000\",\n" +
          "    \"saveAddress\": true,\n" +
          "    \"saveInfo\": true,\n" +
          "    \"paymentMethod\": \"CardCredit\",\n" +
          "    \"cardName\": \"Marcelo dos Santos\",\n" +
          "    \"cardNumber\": \"123412341234\",\n" +
          "    \"cardDate\": \"102030\",\n" +
          "    \"cardCvv\": \"123\",\n" +
          "    \"products\": [\n" +
          "        \"Caderno\",\n" +
          "        \"Caneta\",\n" +
          "        \"PostIt\"\n" +
          "    ]\n" +
          "}";

      HttpEntity<String> entity = new HttpEntity<>(body, headers);
      final ResponseEntity<?> response = template.postForEntity(path, entity, String.class);
      responseBody = getBody(response);
      statusCode = response.getStatusCode();
    } catch (HttpStatusCodeException ex) {
      statusCode = ex.getStatusCode();
      assertEquals("", ex.getResponseBodyAsString());
    }
  }

  @Then("the client receives status code of {int}")
  public void theClientReceivesStatusCodeOf(int expectedStatusCode) {
    assertEquals(expectedStatusCode, statusCode.value());
  }

  @And("response contains {string}")
  public void responseContains(String expectedResponse) {
    Assertions.assertTrue(responseBody.contains(expectedResponse));
  }
}
