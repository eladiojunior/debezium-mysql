package br.com.eladiojunior.debezium.infra;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class ClienteDeserializer extends ObjectMapperDeserializer<String> {

    public ClienteDeserializer() {
        super(String.class);
    }
}
