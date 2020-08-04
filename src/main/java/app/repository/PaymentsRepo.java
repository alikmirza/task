package app.repository;

import app.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentsRepo extends JpaRepository<Payment, Integer> {
    List<Payment> getAllByDelayLessThan(double delay);
}
