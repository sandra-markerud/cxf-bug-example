package com.markerud.cxfbugexample.exceptionhandling;

import javax.xml.ws.WebFault;

@WebFault(name = "Error", targetNamespace = "http://ws.markerud.com/error/v1.0")
public class MyBusinessException extends Exception {

  private Error error;

  public MyBusinessException() {
  }

  public MyBusinessException(String message) {
    super(message);
  }

  public MyBusinessException(String message, Throwable cause) {
    super(message, cause);
  }

  public MyBusinessException(String message, Error error) {
    super(message);
    this.error = error;
  }

  public MyBusinessException(String message, Error error, Throwable cause) {
    super(message, cause);
    this.error = error;
  }

  public Error getFaultInfo() {
    return this.error;
  }

}
