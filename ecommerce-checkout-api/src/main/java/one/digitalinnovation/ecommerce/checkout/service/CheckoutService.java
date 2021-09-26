package one.digitalinnovation.ecommerce.checkout.service;

import java.util.Optional;
import one.digitalinnovation.ecommerce.checkout.entity.CheckoutEntity;
import one.digitalinnovation.ecommerce.checkout.resource.checkout.CheckoutRequest;

/**
 * @author Marcelo dos Santos
 */
public interface CheckoutService {

  Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

  Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
