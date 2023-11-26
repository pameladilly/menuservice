package br.com.pameladilly;


import br.com.pameladilly.service.MenuService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public class MenuController {

    @Inject
    MenuService service;

    @GET
    @Path("/menu/{idMenu}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenu(@PathParam("idMenu") String idMenu){
        return Response.ok(service.getMenu(idMenu)).build();
    }
}
