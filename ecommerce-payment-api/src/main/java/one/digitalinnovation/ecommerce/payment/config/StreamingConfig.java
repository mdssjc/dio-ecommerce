package one.digitalinnovation.ecommerce.payment.config;

import one.digitalinnovation.ecommerce.payment.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @author Marcelo dos Santos
 */
@Configuration
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {

}
