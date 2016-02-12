/**
 * MyFirstWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap.schemas._class.MyFirstWebService;

public interface MyFirstWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getMyFirstWebServiceAddress();

    public com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServicePortType getMyFirstWebService() throws javax.xml.rpc.ServiceException;

    public com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServicePortType getMyFirstWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
