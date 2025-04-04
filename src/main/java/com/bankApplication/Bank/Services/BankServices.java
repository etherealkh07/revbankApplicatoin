package com.bankApplication.Bank.Services;

import com.bankApplication.Bank.Exception.UserNotFoundException;
import com.bankApplication.Bank.Model.BankUser;
import com.bankApplication.Bank.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServices {
    @Autowired
    private BankRepository bankRepository;

    // try

    public List<BankUser>getAllBankUsers()
    {
        return bankRepository.findAll();
    }
    public BankUser getBankUserById(Long AccountNumber)
    {
        return bankRepository.findById(AccountNumber).orElseThrow(()-> new UserNotFoundException("User is not found with this AccountNumber"+ AccountNumber));
    }
    public BankUser saveBankUser(BankUser bankUser)
    {

        return bankRepository.save(bankUser);
    }

    public void deleteBankUSer(Long AccountNumber)
    {
        BankUser user = bankRepository.findById(AccountNumber).orElseThrow(()->new UserNotFoundException("Cannot delete, no user with this account Number"+AccountNumber));
        bankRepository.delete(user);

    }



}
