package ir.openbyte.camel.component;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AmountRoute extends RouteBuilder {

    public final String ROUTE_ID = "TEST";

    private final MyProcess myProcess;
    private final GreaterProcess greaterProcess;
    private final OtherwiseProcess otherwiseProcess;

    public AmountRoute(MyProcess myProcess, GreaterProcess greaterProcess, OtherwiseProcess otherwiseProcess) {
        this.myProcess = myProcess;
        this.greaterProcess = greaterProcess;
        this.otherwiseProcess = otherwiseProcess;
    }

    @Override
    public void configure() throws Exception {
        from("{{camel.kafka.from.card-content}}")
                .routeId(ROUTE_ID)
                .process(myProcess)
                .choice()
                    .when(header("amount").convertTo(Integer.class).isGreaterThanOrEqualTo(1))
                        .process(greaterProcess)
                        .to("{{camel.jdbc.to.tamount}}")
                .otherwise()
                        .process(otherwiseProcess);

    }
}