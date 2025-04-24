package net.application.Banking.Service.impl;

import net.application.Banking.Configuration.AccountMapper;
import net.application.Banking.DTO.AccountDTO;
import net.application.Banking.Entity.Account;
import net.application.Banking.Repository.AccountRepository;
import net.application.Banking.Service.AccountService;
import org.springframework.stereotype.Service;

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
}
