package net.application.Banking.Controller;
import net.application.Banking.DTO.AccountDTO;
import net.application.Banking.Service.impl.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bank/account")
public class AccountController {
    private final AccountServiceImpl accountServiceImpl;
    AccountController(AccountServiceImpl accountServiceImpl){
        this.accountServiceImpl=accountServiceImpl;
    }
    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody  AccountDTO accountDTO){
        return new ResponseEntity<>(accountServiceImpl.createAccount(accountDTO), HttpStatus.CREATED);

    }
}
