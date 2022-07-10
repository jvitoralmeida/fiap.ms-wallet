package br.com.fiap.application.controller;

import java.net.URI;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import br.com.fiap.domain.model.Wallet;

@Path("/wallet")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WalletController {

    @GET
    @Path("/{cpf}")
    @RolesAllowed({"user", "admin"})
    public Wallet findWalletByCPF(String cpf) {
        return Wallet.findByCPF(cpf);
    }

    @GET
    @RolesAllowed({"admin"})
    public List<Wallet> findAll() {
        return Wallet.listAll();
    }

    @POST
    @RolesAllowed({"user","admin"})
    public Response create(Wallet wallet) {
        wallet.persist();
        return Response.created(URI.create("/wallet/" + wallet.id)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"user", "admin"})
    public Wallet findById(String id) {
        return Wallet.findById(new ObjectId(id));
    }


    @PUT
    @Path("/{cpf}")
    @RolesAllowed({"user", "admin"})
    public Wallet updateWalletStores(String id) {
        return Wallet.findById(new ObjectId(id));
    }
}
