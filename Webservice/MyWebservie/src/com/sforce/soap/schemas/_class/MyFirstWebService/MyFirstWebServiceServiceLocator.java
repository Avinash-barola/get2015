/**
 * MyFirstWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap.schemas._class.MyFirstWebService;

public class MyFirstWebServiceServiceLocator extends org.apache.axis.client.Service implements com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServiceService {

    public MyFirstWebServiceServiceLocator() {
    }


    public MyFirstWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MyFirstWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MyFirstWebService
    private java.lang.String MyFirstWebService_address = "https://ap2.salesforce.com/services/Soap/class/MyFirstWebService";

    public java.lang.String getMyFirstWebServiceAddress() {
        return MyFirstWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MyFirstWebServiceWSDDServiceName = "MyFirstWebService";

    public java.lang.String getMyFirstWebServiceWSDDServiceName() {
        return MyFirstWebServiceWSDDServiceName;
    }

    public void setMyFirstWebServiceWSDDServiceName(java.lang.String name) {
        MyFirstWebServiceWSDDServiceName = name;
    }

    public com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServicePortType getMyFirstWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MyFirstWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMyFirstWebService(endpoint);
    }

    public com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServicePortType getMyFirstWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServiceBindingStub _stub = new com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServiceBindingStub(portAddress, this);
            _stub.setPortName(getMyFirstWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMyFirstWebServiceEndpointAddress(java.lang.String address) {
        MyFirstWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServiceBindingStub _stub = new com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServiceBindingStub(new java.net.URL(MyFirstWebService_address), this);
                _stub.setPortName(getMyFirstWebServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MyFirstWebService".equals(inputPortName)) {
            return getMyFirstWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/MyFirstWebService", "MyFirstWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/MyFirstWebService", "MyFirstWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MyFirstWebService".equals(portName)) {
            setMyFirstWebServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
