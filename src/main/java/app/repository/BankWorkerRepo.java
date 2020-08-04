package app.repository;

import app.entity.BankWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankWorkerRepo  extends JpaRepository<BankWorker,Integer> {
    BankWorker findAllByUserName(String userName);

}
