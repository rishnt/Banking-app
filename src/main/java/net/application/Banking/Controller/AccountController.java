package net.application.Banking.Controller;
import net.application.Banking.DTO.AccountDTO;
import net.application.Banking.Service.impl.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/bank/accounts")
public class AccountController {
    private final AccountServiceImpl accountServiceImpl;
    AccountController(AccountServiceImpl accountServiceImpl){
        this.accountServiceImpl=accountServiceImpl;
    }
    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody  AccountDTO accountDTO){
        return new ResponseEntity<>(accountServiceImpl.createAccount(accountDTO), HttpStatus.CREATED);

    }
    @GetMapping(path ="/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        AccountDTO accountDTO = accountServiceImpl.getAccountById(id);
        return ResponseEntity.ok(accountDTO);
    }

    @PutMapping(path = "/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount =request.get("amount");
       AccountDTO accountDto = accountServiceImpl.deposit(id,amount);
return ResponseEntity.ok(accountDto);
    }

    @PutMapping(path = "/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount =request.get("amount");
        AccountDTO accountDto = accountServiceImpl.withDraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        List<AccountDTO> accounts = accountServiceImpl.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountServiceImpl.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully!");
    }
}
