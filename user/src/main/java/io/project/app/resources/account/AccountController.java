package io.project.app.resources.account;

import io.project.app.services.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import io.project.app.domain.Account;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(
            @RequestBody(required = true) Account registerRequest
    ) {

        Optional<Account> doRegister = accountService.registerAccount(registerRequest);
        if (doRegister.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(doRegister.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(("Could not register user"));
    }

    @GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllAccounts() {
        return ResponseEntity.ok(this.accountService.getAccounts());
    }
    
 

}
