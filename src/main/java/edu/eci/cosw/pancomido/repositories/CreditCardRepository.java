package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
}
