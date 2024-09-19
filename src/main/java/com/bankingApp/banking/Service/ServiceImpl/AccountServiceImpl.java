package com.bankingApp.banking.Service.ServiceImpl;

import com.bankingApp.banking.Dto.AccountDto;
import com.bankingApp.banking.Entity.Account;
import com.bankingApp.banking.Exception.NotEnoughAmountException;
import com.bankingApp.banking.Exception.ResourceNotFoundException;
import com.bankingApp.banking.Mapper.AccountMapper;
import com.bankingApp.banking.Repository.AccountRepo;
import com.bankingApp.banking.Service.AccountServiceInterface;
import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountServiceInterface {

    private AccountRepo accountRepo;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account acc=AccountMapper.accountDtoToAccount(accountDto);
        Account accSave=accountRepo.save(acc);
        return AccountMapper.accountToAccountDTo(accSave);
    }

    @Override
    public AccountDto depositAmount(Long AccountId, double deposit) {
        Account acc=accountRepo.findById(AccountId).orElseThrow(()-> new ResourceNotFoundException("Account is not found with specific Id "+AccountId));

        double balance = acc.getBalance()+deposit;
        acc.setBalance(balance);
       Account account= accountRepo.save(acc);
        return AccountMapper.accountToAccountDTo(account);
    }

    @Override
    public AccountDto debitAmount(Long AccountId, double debitAmount) {
        Account acc=accountRepo.findById(AccountId).orElseThrow(()-> new ResourceNotFoundException("Account is not found with specific Id "+AccountId));
        if (debitAmount > acc.getBalance()){
            throw new NotEnoughAmountException("Not Enough Amount  and Your Balance is "+acc.getBalance());
        }
        double balance = acc.getBalance()-debitAmount;
        acc.setBalance(balance);
        Account account= accountRepo.save(acc);
        return AccountMapper.accountToAccountDTo(account);
    }

    @Override
    public AccountDto getAccount(Long AccountId) {

        Account acc=accountRepo.findById(AccountId).orElseThrow();
        return AccountMapper.accountToAccountDTo(acc);
    }


}
