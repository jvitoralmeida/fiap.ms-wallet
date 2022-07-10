package br.com.fiap.application.controller;

import java.net.URI;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.domain.repository.WalletRepository;
import org.bson.types.ObjectId;

import br.com.fiap.domain.model.Wallet;

@Path("/wallet")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WalletController {

    @Inject
    WalletRepository repository;

    @GET
    @Path("/{cpf}")
    @RolesAllowed({"user", "admin"})
    public Wallet findWalletByCPF(String cpf) {
        return repository.findByCPF(cpf);
    }

    @GET
    @RolesAllowed({"admin"})
    public List<Wallet> findAll() {
        return repository.listAll();
    }

    @POST
    public Response create(Wallet wallet) {
        repository.persist(wallet);

        return Response.created(URI.create("/wallet/" + wallet.id)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"user", "admin"})
    public Wallet findById(String id) {
        return repository.findById(new ObjectId(id));
    }


    @PUT
    @RolesAllowed({"user", "admin"})
    public Response updateWallet(Wallet wallet) {

        repository.update(wallet);

        return Response.noContent().build();
    }
}
