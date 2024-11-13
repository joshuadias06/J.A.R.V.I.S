package com.taskmanager.Task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankName;
    private String accountNumber;
    private double balance;

    public BankAccount(String bankName, String accountNumber, double balance){
        this.bankName =bankName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
