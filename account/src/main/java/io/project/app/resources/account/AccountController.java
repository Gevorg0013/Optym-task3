package io.project.app.resources.account;

import io.project.app.services.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import io.project.app.domain.Account;
import org.springframework.http.MediaType;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author root
 */
@RestController
@RequestMapping("/api/v2/accounts")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(
            @RequestBody(required = true) Account registerRequest
    ) throws Exception {

        Optional<Account> doRegister = accountService.registerAccount(registerRequest);
        if (doRegister.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(doRegister.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(("Could not register user"));
    }
    
    
    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addAccount(
            @RequestBody(required = true) Account registerRequest
    ) throws Exception {

        Optional<Account> doRegister = accountService.registerAccount(registerRequest);
        if (doRegister.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(doRegister.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(("Could not register user"));
    }
    
    
    @GetMapping(path="/findByEmail", produces = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<?>findByEmail(String email) {
        if(email==null) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could find without mail");
        }
        return ResponseEntity.ok(this.accountService.findByMail(email));
    }
    
  @GetMapping(path="/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?>getAllAccounts() {
        return ResponseEntity.ok(this.accountService.getAccounts());
    }
   
    @DeleteMapping(path="/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>deleteAccountById(final String id) {
        return ResponseEntity.ok(this.accountService.deleteById(id));
    }
 

}
