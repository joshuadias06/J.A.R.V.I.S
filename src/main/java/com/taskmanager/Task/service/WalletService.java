package com.taskmanager.Task.service;

import com.taskmanager.Task.model.BankAccount;
import com.taskmanager.Task.model.Wallet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WalletService {

    private final Map<Long, Wallet> userWallets = new HashMap<>();

    public Wallet getOrCreateWallet(Long userId){
        return userWallets.computeIfAbsent(userId, id->{
            Wallet wallet =new Wallet();
            wallet.setUserId(id);

            BankAccount nubankAccount = new BankAccount("Nubank", "0111-2003", 1000.00);
            wallet.addAccount(nubankAccount);

            return wallet;
        });
    }

    public boolean tranfer(Long userId, Long fromAccountId, Long toAccountId, double amount){

        if(amount <= 0){
            throw new IllegalArgumentException("O valor da tranferencia deve ser positivo.");
        }

        Wallet wallet = userWallets.get(userId);
        if(wallet == null){
            throw new IllegalArgumentException("Carteira do usuário não encontrada.");
        }

        BankAccount fromAccount = wallet.getAccount(fromAccountId);
        BankAccount toAccount = wallet.getAccount(toAccountId);

        if(fromAccount == null || toAccount == null){
            throw new IllegalArgumentException("Conta de origem ou detino não encontrada.");
        }

        if(fromAccount.getBalance() < amount){
            throw new IllegalArgumentException("Saldo insuficiente na conta de origem!");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        return true;

    }



}
