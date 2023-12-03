package br.com.pameladilly;


import br.com.pameladilly.DTO.PreferencesDTO;
import br.com.pameladilly.service.MenuService;
import br.com.pameladilly.service.PreferencesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public class MenuController {

    @Inject
    MenuService service;

    @Inject
    PreferencesService preferencesService;

    @GET
    @Path("/menu/{idMenu}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenu(@PathParam("idMenu") String idMenu , @QueryParam("idPessoa") String idPessoa){
        return Response.ok(service.getMenu(idMenu, idPessoa)).build();
    }

    @POST
    @Path("/menu")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePreferences(PreferencesDTO preferencesDTO,
                                    @QueryParam("idMenu") String idMenu, @QueryParam("idPessoa") String idPessoa){

        preferencesDTO.setIdMenu(Long.parseLong(idMenu));
        preferencesDTO.setIdPessoa(Long.parseLong(idPessoa));
        if (preferencesService.savePreferences(preferencesDTO ))
            return Response.status(Response.Status.CREATED).build();
        else
            return Response.serverError().build();
    }
}
