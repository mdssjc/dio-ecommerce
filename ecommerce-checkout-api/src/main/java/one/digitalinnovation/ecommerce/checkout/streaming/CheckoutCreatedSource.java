package one.digitalinnovation.ecommerce.checkout.streaming;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Marcelo dos Santos
 */
public interface CheckoutCreatedSource {

  String OUTPUT = "checkout-created-output";

  @Output(OUTPUT)
  MessageChannel output();
}
