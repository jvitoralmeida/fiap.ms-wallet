package br.com.fiap.application.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public Wallet findWalletByCPF(String cpf) {
        return Wallet.findByCPF(cpf);
    }

    @GET
    public List<Wallet> findAll() {
        return Wallet.listAll();
    }

    @POST
    public Response create(Wallet wallet) {
        wallet.persist();
        return Response.created(URI.create("/wallet/" + wallet.id)).build();
    }

    @GET
    @Path("/{id}")
    public Wallet findById(String id) {
        return Wallet.findById(new ObjectId(id));
    }
}
