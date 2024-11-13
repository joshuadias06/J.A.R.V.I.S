package com.taskmanager.Task.service;

import com.taskmanager.Task.model.BankAccount;
import com.taskmanager.Task.model.Wallet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WalletService {

    // Um Map que armazena as carteiras dos usuários. A chave é o 'userId' e o valor é a 'Wallet'.
    private final Map<Long, Wallet> userWallets = new HashMap<>();

    // Método para obter ou criar uma carteira para o usuário
    public Wallet getOrCreateWallet(Long userId){
        // Usamos 'computeIfAbsent' para verificar se já existe uma carteira para o 'userId'.
        // Caso não exista, a função cria uma nova.
        return userWallets.computeIfAbsent(userId, id -> {
            Wallet wallet = new Wallet();  // Cria uma nova instância de Wallet
            wallet.setUserId(id);  // Associa o 'userId' à carteira

            // Cria uma conta bancária predefinida para o usuário (exemplo de conta do Nubank).
            BankAccount nubankAccount = new BankAccount("Nubank", "0111-2003", 1000.00);
            wallet.addAccount(nubankAccount);  // Adiciona a conta à carteira

            return wallet;  // Retorna a carteira criada (com a conta do Nubank)
        });
    }

    // Método para transferir dinheiro de uma conta para outra
    public boolean transfer(Long userId, Long fromAccountId, Long toAccountId, double amount){

        // Valida se o valor da transferência é positivo.
        if(amount <= 0){
            throw new IllegalArgumentException("O valor da tranferencia deve ser positivo.");
        }

        // Recupera a carteira do usuário pelo 'userId'.
        Wallet wallet = userWallets.get(userId);
        if(wallet == null){
            throw new IllegalArgumentException("Carteira do usuário não encontrada.");
        }

        // Recupera as contas de origem e destino.
        BankAccount fromAccount = wallet.getAccount(fromAccountId);
        BankAccount toAccount = wallet.getAccount(toAccountId);

        // Verifica se as contas de origem ou destino não existem.
        if(fromAccount == null || toAccount == null){
            throw new IllegalArgumentException("Conta de origem ou destino não encontrada.");
        }

        // Verifica se a conta de origem tem saldo suficiente para a transferência.
        if(fromAccount.getBalance() < amount){
            throw new IllegalArgumentException("Saldo insuficiente na conta de origem!");
        }

        // Realiza a transferência: debita o valor da conta de origem e credita na conta de destino.
        fromAccount.setBalance(fromAccount.getBalance() - amount);  // Debita da conta de origem
        toAccount.setBalance(toAccount.getBalance() + amount);  // Credita na conta de destino

        return true;  // Retorna true para indicar que a transferência foi realizada com sucesso
    }
}
