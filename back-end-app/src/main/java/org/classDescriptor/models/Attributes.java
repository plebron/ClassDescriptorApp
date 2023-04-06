package org.classDescriptor.models;

public class Attributes {
    String Name;
    String Variable;
    String Scope;
    String Signature;

    public Attributes(String name, String variable, String scope, String signature) {
        Name = name;
        Variable = variable;
        Scope = scope;
        Signature = signature;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVariable() {
        return Variable;
    }

    public void setVariable(String variable) {
        Variable = variable;
    }

    public String getScope() {
        return Scope;
    }

    public void setScope(String scope) {
        Scope = scope;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
