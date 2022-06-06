package br.com.fiap.domain.model;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;


@MongoEntity(collection = "store")
public class Store extends PanacheMongoEntity {
    public String name;
    public String cnpj;
    public Long percent;
    public String urlLogo;

    public static List<Store> findByName(String name) {
        return find("name", name).list();
    }
}
