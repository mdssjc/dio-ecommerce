package one.digitalinnovation.ecommerce.checkout.repository;

import java.util.Optional;
import one.digitalinnovation.ecommerce.checkout.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Marcelo dos Santos
 */
@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {

  Optional<CheckoutEntity> findByCode(String code);
}
