package com.example.account.enumeration;


public enum RouteEnumeration {

    REGISTRATION("direct:postRegistration");

    private String  id;

    RouteEnumeration(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
