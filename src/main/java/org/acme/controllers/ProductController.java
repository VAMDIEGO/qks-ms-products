package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entities.Product;
import org.acme.repositories.ProductRepository;
import org.acme.repositories.ProductRepositoryJPA;

import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductRepositoryJPA pr;

    @GET
    public List<Product> list() {
        return pr.findAll();
    }

    @GET
    @Path("/{Id}")
    public Product getById(@PathParam("Id") Long Id) {
        return pr.findById(Id).get();
    }

    @POST
    public Response add(Product p) {
        pr.save(p);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{Id}")
    public Response delete(@PathParam("Id") Long Id) {
        pr.delete(pr.findById(Id).get());
        return Response.ok().build();
    }

    @PUT
    public Response update(Product p) {
        Product product = pr.findById(p.getId()).get();
        product.setCode(p.getCode());
        product.setName(p.getName());
        product.setDescription(p.getDescription());
        pr.save(product);
        return Response.ok().build();
    }
}
