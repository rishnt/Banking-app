package net.application.Banking.Service;

import net.application.Banking.DTO.AccountDTO;

import java.util.List;


public interface AccountService {

    AccountDTO createAccount(AccountDTO accountDTO);

    AccountDTO getAccountById(Long id);
    AccountDTO deposit(Long id,double amount);
    AccountDTO withDraw(Long id,double amount);

    List<AccountDTO> getAllAccounts();

    void deleteAccount(Long id);
}
