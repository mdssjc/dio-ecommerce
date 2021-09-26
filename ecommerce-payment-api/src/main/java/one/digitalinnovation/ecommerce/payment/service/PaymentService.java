package one.digitalinnovation.ecommerce.payment.service;

import one.digitalinnovation.ecommerce.checkout.event.CheckoutCreatedEvent;
import java.util.Optional;
import one.digitalinnovation.ecommerce.payment.entity.PaymentEntity;

/**
 * @author Marcelo dos Santos
 */
public interface PaymentService {

  Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}
