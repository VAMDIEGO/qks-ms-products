package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entities.Product;
import org.acme.repositories.ProductRepository;

import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductRepository pr;

    @GET
    public List<Product> list() {
        return pr.list();
    }

    @POST
    public Response add(Product p) {
        pr.create(p);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(Product p) {
        pr.delete(p);
        return Response.ok().build();
    }
}
