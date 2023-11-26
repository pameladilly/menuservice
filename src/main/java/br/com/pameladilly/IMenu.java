package br.com.pameladilly;

import br.com.pameladilly.DTO.MenuDTOResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@RegisterRestClient(baseUri = "http://localhost:8081/api")
public interface IMenu {

    @GET
    @Path("/getmenu/{idMenu}")
    @Produces(MediaType.APPLICATION_JSON)
    public MenuDTOResponse getMenu(@PathParam("idMenu") String idMenu);
}
