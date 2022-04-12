package ir.openbyte.camel.component;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class GreaterProcess implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("with jpa insert into Greater");
        exchange.getIn().setBody("INSERT into t_amount(inputdata) values ('"+exchange.getIn().getBody()+"')");

    }
}