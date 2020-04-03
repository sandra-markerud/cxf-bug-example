# Demo project
This project demonstrates the occurrence of a NullPointerException in `org.apache.cxf.jaxws.interceptors.WebFaultOutInterceptor` under certain circumstances.
This topic is addressed in the following issue:

[NPE in WebFaultOutInterceptor handleMessage method](https://issues.apache.org/jira/browse/CXF-8254)

## Getting started
* Clone this repository with `git clone https://github.com/sandra-markerud/cxf-bug-example.git`
* Start the service with `mvn spring-boot:run`
* In SoapUI import and use the following project `demo-soapui-project.xml` found under `src/main/resources`
    * The SOAP request `Failure with NPE hides business error object` reproduces the NullPointerException
    * This request targets a non existing endpoint due to a typo and additionally does not contain the soap action information in the `Content-Type` header
