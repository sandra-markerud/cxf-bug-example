package com.markerud.cxfbugexample.webservice;

import static com.markerud.cxfbugexample.webservice.LogServiceImpl.NAMESPACE;

import com.markerud.cxfbugexample.exceptionhandling.MyBusinessException;
import com.markerud.cxfbugexample.webservice.model.LogMessageRequest;
import com.markerud.cxfbugexample.webservice.model.LogMessageResponse;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(targetNamespace = NAMESPACE, name = "I_Demo_Log")
@SOAPBinding(parameterStyle = ParameterStyle.BARE)
public interface IDemoLogWebService {

  @WebMethod(operationName = "LogMessage", action = NAMESPACE + "#LogMessage")
  @WebResult(name = "LogMessageResponse", targetNamespace = NAMESPACE, partName = "parameter")
  LogMessageResponse logMessage(
      @WebParam(partName = "parameter", name = "LogMessage") LogMessageRequest parameter)
      throws MyBusinessException;
}
