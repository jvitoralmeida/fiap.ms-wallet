package br.com.fiap.domain.model;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;


public class Store {
    public String id;
    public String name;
    public String cnpj;
    public Long percent;
    public String urlLogo;
}
