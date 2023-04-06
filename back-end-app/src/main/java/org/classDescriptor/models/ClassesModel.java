package org.classDescriptor.models;

import java.util.ArrayList;
import java.util.List;

public class ClassesModel {
    String Name;

    String Scope;

    String Constructor;

    ArrayList<Attributes> Attributes;

    public ClassesModel(String name, String scope, String constructor) {
        Name = name;
        Scope = scope;
        Constructor = constructor;
    }

    public ClassesModel(String name, String scope, String constructor, ArrayList<org.classDescriptor.models.Attributes> attributes) {
        Name = name;
        Scope = scope;
        Constructor = constructor;
        Attributes = attributes;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getScope() {
        return Scope;
    }

    public void setScope(String scope) {
        Scope = scope;
    }

    public String getConstructor() {
        return Constructor;
    }

    public void setConstructor(String constructor) {
        Constructor = constructor;
    }

    public ArrayList<org.classDescriptor.models.Attributes> getAttributes() {
        return Attributes;
    }

    public void setAttributes(ArrayList<org.classDescriptor.models.Attributes> attributes) {
        Attributes = attributes;
    }
}
