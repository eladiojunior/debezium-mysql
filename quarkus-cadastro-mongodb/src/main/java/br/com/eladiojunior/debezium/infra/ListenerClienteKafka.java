package br.com.eladiojunior.debezium.infra;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ListenerClienteKafka {

    @Incoming("clientes")
    public void receberClienteFila(String jsonCliente) {

        System.out.println("-----------------------------------------------------------------");
        System.out.println("[Cliente Recebido]: " + jsonCliente);
        System.out.println("-----------------------------------------------------------------");

    }

}
