package br.com.fiap.domain.repository;

import br.com.fiap.domain.model.Wallet;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WalletRepository implements PanacheMongoRepository<Wallet> {

    public Wallet findByCPF(String cpf) {
        return list("cpf = ?1",cpf).get(0);
    }
}
