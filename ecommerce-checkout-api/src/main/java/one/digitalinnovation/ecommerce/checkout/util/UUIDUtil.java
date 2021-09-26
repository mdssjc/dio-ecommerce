package one.digitalinnovation.ecommerce.checkout.util;

import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * @author Marcelo dos Santos
 */
@Component
public class UUIDUtil {

  public UUID createUUID() {
    return UUID.randomUUID();
  }
}
