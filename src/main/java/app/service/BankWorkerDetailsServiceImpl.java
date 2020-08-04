package app.service;

import app.entity.BankWorker;
import app.repository.BankWorkerRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BankWorkerDetailsServiceImpl implements UserDetailsService {

    private final BankWorkerRepo bankWorkerRepo;

    public BankWorkerDetailsServiceImpl(BankWorkerRepo bankWorkerRepo) {
        this.bankWorkerRepo = bankWorkerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        BankWorker bankWorker = bankWorkerRepo.findAllByUserName(s);
        if (bankWorker == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        return bankWorker;
    }



}
