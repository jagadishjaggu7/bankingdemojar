package com.bankingApp.banking.Exception;

public class NotEnoughAmountException extends  RuntimeException{
    public NotEnoughAmountException(String message){
        super(message);
    }
}
