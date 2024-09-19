package com.bankingApp.banking.Service;

import com.bankingApp.banking.Dto.AccountDto;

public interface AccountServiceInterface {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto depositAmount(Long AccountId,double deposit);
    AccountDto debitAmount(Long AccountId,double debitAmount);

    AccountDto getAccount(Long AccountId);

}
