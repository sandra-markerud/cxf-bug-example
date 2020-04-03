package com.markerud.cxfbugexample.webservice;

import static java.time.LocalDateTime.now;
import static javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING;

import com.markerud.cxfbugexample.exceptionhandling.Error;
import com.markerud.cxfbugexample.exceptionhandling.MyBusinessException;
import com.markerud.cxfbugexample.webservice.model.LogMessageRequest;
import com.markerud.cxfbugexample.webservice.model.LogMessageResponse;
import javax.xml.ws.BindingType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@BindingType(SOAP12HTTP_BINDING)
public class LogServiceImpl implements IDemoLogWebService {

  public static final String NAMESPACE = "http://ws.markerud.com/example/DemoLogService/v1.0";

  @Override
  public LogMessageResponse logMessage(LogMessageRequest parameter) throws MyBusinessException {
    if (parameter.getMessage().contains("invalid")) {
      throw new MyBusinessException("This message is not allowed", new Error("42", now()));
    }
    log.info("Logging the following message: {}", parameter.getMessage());
    return new LogMessageResponse("And also hello to you");
  }
}
