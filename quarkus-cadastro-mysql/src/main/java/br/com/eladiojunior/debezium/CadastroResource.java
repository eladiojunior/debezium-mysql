package br.com.eladiojunior.debezium;

import br.com.eladiojunior.debezium.dtos.ClienteDTO;
import br.com.eladiojunior.debezium.dtos.AtualizarClienteDTO;
import br.com.eladiojunior.debezium.dtos.RegistrarClienteDTO;
import br.com.eladiojunior.debezium.entites.Cliente;
import br.com.eladiojunior.debezium.infra.ClienteMapper;
import br.com.eladiojunior.debezium.infra.Util;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/cadastro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CadastroResource {

    @GET
    public List<ClienteDTO> listarClientes() {
        Stream<Cliente> stream = Cliente.streamAll();
        return stream.map(c -> ClienteMapper.toDTO(c)).collect(Collectors.toList());
    }

    @POST
    @Transactional
    public Response registraCliente(RegistrarClienteDTO dto) {

        Cliente cliente = ClienteMapper.toCliente(dto);
        cliente.persist();

        return Response.status(Response.Status.CREATED).build();

    }

    @PUT
    @Path("{id}")
    @Transactional
    public void atualizarCliente(@PathParam("id") Long id, AtualizarClienteDTO dto) {

        Optional<Cliente> entityCliente = Cliente.findByIdOptional(id);
        if (!entityCliente.isPresent()) {
            throw new NotFoundException("Cliente não encontrado.");
        }

        Cliente cliente = entityCliente.get();
        cliente.setNome(dto.getNome());
        cliente.setDataNascimento(Util.toDate(dto.getDataNascimento()));
        cliente.persist();

    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletarCliente(@PathParam("id") Long id) {
        Optional<Cliente> entityCliente = Cliente.findByIdOptional(id);
        if (!entityCliente.isPresent()) {
            throw new NotFoundException("Cliente não encontrado.");
        }
        entityCliente.get().delete();
    }

}