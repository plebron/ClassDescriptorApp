package org.classDescriptor.models;

public class Attributes {
    String Name;
    Character Variable;
    String Scope;
    String Signature;

    public Attributes(String name, Character variable, String scope, String signature) {
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

    public Character getVariable() {
        return Variable;
    }

    public void setVariable(Character variable) {
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
