package one.digitalinnovation.ecommerce.checkout;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Marcelo dos Santos
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "json:build/cucumber-api-report.json"},
    features = "classpath:feature")
public class CheckoutApplicationTest {

}
