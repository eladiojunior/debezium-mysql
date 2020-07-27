package br.com.eladiojunior.debezium.infra;

import br.com.eladiojunior.debezium.dtos.ClienteDTO;
import br.com.eladiojunior.debezium.dtos.RegistrarClienteDTO;
import br.com.eladiojunior.debezium.entites.Cliente;

public class ClienteMapper {
    public static ClienteDTO toDTO(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setDataNascimento(entity.getDataNascimento());
        return dto;
    }

    public static Cliente toCliente(RegistrarClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setDataNascimento(Util.toDate(dto.getDataNascimento()));
        return cliente;
    }

}
