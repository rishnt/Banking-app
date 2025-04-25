package net.application.Banking.Service.impl;

import net.application.Banking.Configuration.AccountMapper;
import net.application.Banking.DTO.AccountDTO;
import net.application.Banking.Entity.Account;
import net.application.Banking.Exception.AccountException;
import net.application.Banking.Repository.AccountRepository;
import net.application.Banking.Service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper){
        this.accountRepository=accountRepository;
        this.accountMapper=accountMapper;
            }
    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
      Account account=  accountMapper.toEntity(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
       Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Account Does Not Exist"));
       return accountMapper.toDto(account);
    }

    @Override
    public AccountDTO deposit(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Account Does Not Exist"));
        double total= account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount =accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    @Override
    public AccountDTO withDraw(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Account Does Not Exist"));
         if(account.getBalance()<amount){
             throw new RuntimeException("Isufficient Balance");
         }

         double total =account.getBalance() - amount;
         account.setBalance(total);
         Account savedAccount =accountRepository.save(account);
         return accountMapper.toDto(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
       List<Account> account = accountRepository.findAll();
      return account.stream().map(account1 -> accountMapper.toDto(account1)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Account Does Not Exist"));
           accountRepository.deleteById(id);
    }


}
