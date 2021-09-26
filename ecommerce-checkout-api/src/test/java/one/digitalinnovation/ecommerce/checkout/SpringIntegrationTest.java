package one.digitalinnovation.ecommerce.checkout;

import io.cucumber.spring.CucumberContextConfiguration;
import one.digitalinnovation.ecommerce.checkout.setup.PostgreSQLSetup;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Marcelo dos Santos
 */
@ActiveProfiles("test")
@CucumberContextConfiguration
@SpringBootTest(
    classes = {CheckoutApplication.class, PostgreSQLSetup.class},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 8888)
public class SpringIntegrationTest {

}
