package com.bankingApp.banking.Mapper;

import com.bankingApp.banking.Dto.AccountDto;
import com.bankingApp.banking.Entity.Account;

public class AccountMapper {
    public static AccountDto accountToAccountDTo(Account account) {

        AccountDto accDto = new AccountDto(
                account.getId(), account.getAccountHolderName(), account.getBalance()
        );

        return accDto;
    }

    public static Account accountDtoToAccount(AccountDto accountDto) {

        Account acc = new Account(
                accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance()
        );

        return acc;
    }

}
