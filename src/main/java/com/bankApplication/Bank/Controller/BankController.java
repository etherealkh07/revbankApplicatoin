package com.bankApplication.Bank.Controller;


import com.bankApplication.Bank.Model.BankUser;
import com.bankApplication.Bank.Services.BankServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bank")
public class BankController {
    @Autowired
    private BankServices bankServices;

    @GetMapping("/all")
    public List<BankUser> getAllBankUser()
    {
        return bankServices.getAllBankUsers();
    }

    @GetMapping("/{AccountNumber}")
    public BankUser getBankUserById(@PathVariable Long AccountNumber)
    {
        return bankServices.getBankUserById(AccountNumber);
    }

    @PostMapping("/save")
    public BankUser saveBank(@Valid @RequestBody BankUser bankUser) {
        return bankServices.saveBankUser(bankUser);
    }



    @DeleteMapping("/delete/{AccountNumber}")
    public void deleteBankUser(@PathVariable Long AccountNumber)
    {
        bankServices.deleteBankUSer(AccountNumber);
    }
}

