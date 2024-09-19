package com.bankingApp.banking.controller;

import com.bankingApp.banking.Dto.AccountDto;
import com.bankingApp.banking.Service.ServiceImpl.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/bank")
public class AccountController {

    private AccountServiceImpl accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        AccountDto accountDto1=accountService.createAccount(accountDto);
        return new ResponseEntity<>(accountDto1, HttpStatus.CREATED);
    }

    @PutMapping("{Id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long Id, @RequestBody Map<String,Double> depositAmount){
       AccountDto accountDto= accountService.depositAmount(Id,depositAmount.get("depositMoney"));
       return ResponseEntity.ok(accountDto);
    }

    @PutMapping("{Id}/debit")
    public ResponseEntity<AccountDto> debitAmount(@PathVariable Long Id, @RequestBody Map<String,Double> debitAmount){
        AccountDto accountDto= accountService.debitAmount(Id,debitAmount.get("debitMoney"));
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("{Id}/getAccount")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long Id){

        AccountDto response = accountService.getAccount(Id);

        return ResponseEntity.ok(response);


    }
}
