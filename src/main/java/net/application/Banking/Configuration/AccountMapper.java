package net.application.Banking.Configuration;


import net.application.Banking.DTO.AccountDTO;
import net.application.Banking.Entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
AccountDTO toDto(Account account);
Account toEntity(AccountDTO accountDTO);
}
