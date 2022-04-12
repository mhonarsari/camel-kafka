package ir.openbyte.camel.service;

import lombok.SneakyThrows;
import org.apache.camel.CamelContext;
import org.springframework.stereotype.Service;

@Service
public class CamelRouteManager {

    private final CamelContext camelContext;

    public CamelRouteManager(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

//    @Autowired
//    public CamelRouteManager(CamelContext camelContext) {
//        this.camelContext = camelContext;
//    }

    @SneakyThrows
    public void stop(String routeId) {
        camelContext.getRouteController().stopRoute(routeId);
    }

    @SneakyThrows
    public void start(String routeId) {
        camelContext.getRouteController().startRoute(routeId);
    }
}