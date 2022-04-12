package ir.openbyte.camel.component;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataPool {

    @Bean
    public DataSource myDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("pass");
        ds.setUrl("jdbc:mysql://localhost:3306/mcishop?characterEncoding=latin1&useConfigs=maxPerformance");
        return ds;
    }
}
