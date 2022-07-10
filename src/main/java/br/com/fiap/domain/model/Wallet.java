package br.com.fiap.domain.model;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;


@MongoEntity(collection = "user")
public class Wallet {
    public ObjectId id;
    public String name;
    public String cpf;
    public String balance;
    public List<Store> stores;

    public Wallet(){}

    public Wallet(String name, String cpf, String balance, List<Store> stores) {
        this.name = name;
        this.cpf = cpf;
        this.balance = balance;
        this.stores = stores;
    }
}
