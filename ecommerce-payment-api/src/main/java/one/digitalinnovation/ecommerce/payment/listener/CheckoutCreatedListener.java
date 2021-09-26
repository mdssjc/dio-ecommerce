package one.digitalinnovation.ecommerce.payment.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.digitalinnovation.ecommerce.checkout.event.CheckoutCreatedEvent;
import one.digitalinnovation.ecommerce.payment.entity.PaymentEntity;
import one.digitalinnovation.ecommerce.payment.event.PaymentCreatedEvent;
import one.digitalinnovation.ecommerce.payment.service.PaymentService;
import one.digitalinnovation.ecommerce.payment.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Marcelo dos Santos
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CheckoutCreatedListener {

  private final CheckoutProcessor checkoutProcessor;

  private final PaymentService paymentService;

  @StreamListener(CheckoutProcessor.INPUT)
  public void handler(CheckoutCreatedEvent checkoutCreatedEvent) {
    log.info("checkoutCreatedEvent={}", checkoutCreatedEvent);
    final PaymentEntity paymentEntity = paymentService.create(checkoutCreatedEvent).orElseThrow();
    final PaymentCreatedEvent paymentCreatedEvent =
        PaymentCreatedEvent.newBuilder()
                           .setCheckoutCode(paymentEntity.getCheckoutCode())
                           .setPaymentCode(paymentEntity.getCode())
                           .build();
    checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
  }
}
