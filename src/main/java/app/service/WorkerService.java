package app.service;


import app.entity.Customer;
import app.entity.Payment;
import app.repository.CustomerRepo;
import app.repository.PaymentsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    private Customer customer;
    private final CustomerRepo customerRepo;
    private final PaymentsRepo paymentsRepo;

    public WorkerService(CustomerRepo customerRepo, PaymentsRepo paymentsRepo) {
        this.customerRepo = customerRepo;
        this.paymentsRepo = paymentsRepo;
    }

    public String getCustomers() {
        return String.valueOf(customerRepo.getAllById(1).toString());
    }

    public List<Customer> findProperCustomer(double amount, int period) {
        double monthly = amount/period;
        List<Payment> allByDelayLessThan = paymentsRepo.getAllByDelayLessThan(monthly);
        List<Customer> customerList = allByDelayLessThan.stream()
                .filter(payment -> monthly < payment.getMaxAmountToPay())
                .map(Payment::getCustomer)
                .collect(Collectors.toList());
        return customerList;
    }

}
