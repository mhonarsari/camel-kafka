package ir.openbyte.camel.component;


import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.component.kafka.KafkaManualCommit;
import org.springframework.stereotype.Component;

@Component
public class MyProcess implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String messageBody = exchange.getMessage().getBody(String.class);
        exchange.getMessage().setHeader("amount", Integer.parseInt(messageBody.split("@")[0]));
        exchange.getMessage().setBody(messageBody + "@mame from jpa");
    }
}