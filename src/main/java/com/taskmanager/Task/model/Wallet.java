package com.taskmanager.Task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String owner;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id")
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    public BankAccount getAccount(Long accountId){
        return accounts.stream()
                .filter(account -> account.getId().equals(accountId))
                .findFirst()
                .orElse(null);
    }
}
