package br.com.fiap.domain.model;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Wallet extends PanacheMongoEntity {
    public String cpf;
    public String balance;
    public List<Store> stores;
    // public List<Transaction> transactions;

    public static Wallet findByCPF(String cpf) {
        return find("cpf", cpf).firstResult();
    }
}