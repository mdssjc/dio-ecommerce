package one.digitalinnovation.ecommerce.payment.service;

import one.digitalinnovation.ecommerce.checkout.event.CheckoutCreatedEvent;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import one.digitalinnovation.ecommerce.payment.entity.PaymentEntity;
import one.digitalinnovation.ecommerce.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

/**
 * @author Marcelo dos Santos
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

  private final PaymentRepository paymentRepository;

  @Override
  public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
    final PaymentEntity paymentEntity =
        PaymentEntity.builder()
                     .checkoutCode(checkoutCreatedEvent.getCheckoutCode())
                     .code(UUID.randomUUID().toString())
                     .build();
    paymentRepository.save(paymentEntity);
    return Optional.of(paymentEntity);
  }
}
