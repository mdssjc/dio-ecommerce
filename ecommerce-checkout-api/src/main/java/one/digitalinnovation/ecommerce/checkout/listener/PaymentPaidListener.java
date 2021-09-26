package one.digitalinnovation.ecommerce.checkout.listener;

import one.digitalinnovation.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import one.digitalinnovation.ecommerce.checkout.entity.CheckoutEntity;
import one.digitalinnovation.ecommerce.checkout.service.CheckoutService;
import one.digitalinnovation.ecommerce.checkout.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author Marcelo dos Santos
 */
@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

  private final CheckoutService checkoutService;

  @StreamListener(PaymentPaidSink.INPUT)
  public void handler(PaymentCreatedEvent paymentCreatedEvent) {
    checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(),
                                 CheckoutEntity.Status.APPROVED);
  }
}
