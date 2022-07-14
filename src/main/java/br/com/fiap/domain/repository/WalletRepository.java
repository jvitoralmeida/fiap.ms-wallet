package br.com.fiap.domain.repository;

import br.com.fiap.domain.model.Wallet;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WalletRepository implements PanacheMongoRepository<Wallet> {

    public Wallet findByCPF(String cpf) {
        return find("cpf = ?1",cpf).firstResult();
    }
}
