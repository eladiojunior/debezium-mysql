package br.com.eladiojunior.debezium;

import br.com.eladiojunior.debezium.entites.Cliente;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cadastro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CadastroResource {

    @GET
    public List<Cliente> listarClientes() {
        return Cliente.listAll();
    }

}