package app.controller;

import app.entity.Credit;
import app.entity.Customer;
import app.service.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }


    @PostMapping("/get-customer")
    public ResponseEntity<List<Customer>> handlePost(@Valid @RequestBody Credit credit) {
        List<Customer> properCustomer = workerService.findProperCustomer(credit.getAmount(),
                credit.getPeriod());
        return ResponseEntity.ok(properCustomer);
    }

}
