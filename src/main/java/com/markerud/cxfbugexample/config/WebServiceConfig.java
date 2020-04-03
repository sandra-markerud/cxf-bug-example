package com.markerud.cxfbugexample.config;

import static org.apache.cxf.message.Message.SCHEMA_VALIDATION_ENABLED;

import com.markerud.cxfbugexample.exceptionhandling.UnhandledExceptionInterceptor;
import com.markerud.cxfbugexample.webservice.IDemoLogWebService;
import javax.annotation.PostConstruct;
import javax.xml.ws.Endpoint;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebServiceConfig {

  private final Bus bus;

  @PostConstruct
  public void init() {
    bus.getProperties().put(SCHEMA_VALIDATION_ENABLED, true);
    bus.getOutFaultInterceptors().add(new UnhandledExceptionInterceptor());
  }

  @Bean
  public Endpoint demoLogEndpoint(IDemoLogWebService service) {
    EndpointImpl endpoint = new EndpointImpl(bus, service);
    endpoint.publish("/I_Demo_Log");
    return endpoint;
  }

}
