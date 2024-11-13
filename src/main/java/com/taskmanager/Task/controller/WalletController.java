package com.taskmanager.Task.controller;

import com.taskmanager.Task.model.BankAccount;
import com.taskmanager.Task.model.Wallet;
import com.taskmanager.Task.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteira")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/cadastrarConta/{userId}")
    public ResponseEntity<?> addAccount(@PathVariable Long userId, @RequestBody BankAccount newAccount){
        try{
            Wallet wallet = walletService.getOrCreateWallet(userId);
            wallet.addAccount(newAccount);
            return ResponseEntity.ok(wallet);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/trasferir/{userId}")
    public ResponseEntity<String> trasnfer(@PathVariable Long userId, @RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam double amount){
        try{
            boolean sucess = walletService.transfer(userId, fromAccountId, toAccountId, amount);
            if(sucess){
                return ResponseEntity.ok("Transferência realizada com sucesso!");
            }
            return ResponseEntity.status(400).body("Erro ao realizar a tranferência!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
