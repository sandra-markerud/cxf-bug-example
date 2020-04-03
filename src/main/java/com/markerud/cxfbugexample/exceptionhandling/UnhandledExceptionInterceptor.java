package com.markerud.cxfbugexample.exceptionhandling;

import java.time.LocalDateTime;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

public class UnhandledExceptionInterceptor extends AbstractSoapInterceptor {

  public UnhandledExceptionInterceptor() {
    super(Phase.USER_LOGICAL);
  }

  @Override
  public void handleMessage(SoapMessage message) throws Fault {
    Exception exception = message.getContent(Exception.class);
    if (!(exception instanceof Fault)) {
      return;
    }

    if (exception.getCause() instanceof MyBusinessException) {
      // do some business stuff here
      return;
    }

    Fault fault = (Fault) exception;
    MyBusinessException businessFault = createBusinessException(fault);
    Fault newFault = new Fault(businessFault, fault.getFaultCode());
    message.setContent(Exception.class, newFault);
  }

  private MyBusinessException createBusinessException(Fault fault) {
    // Message id and other omitted error fields depend on received fault.
    Error error = new Error();
    error.setMessageID("42");
    error.setTimestamp(LocalDateTime.now());
    return new MyBusinessException("Some business exception", error);
  }
}
