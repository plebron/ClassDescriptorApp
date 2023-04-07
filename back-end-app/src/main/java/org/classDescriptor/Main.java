package org.

classDescriptor;

import org.classDescriptor.models.Attributes;
import org.classDescriptor.models.ClassesModel;

import javax.smartcardio.ATR;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Attributes> attributes;

        // Replace this string with the text of the Java class you want to describe
        String classText = "// Person.txt\n" +
                "\n" +
                "public class Person {\n" +
                "\n" +
                " \n" +
                "\n" +
                "    private int year = 0;\n" +
                "\n" +
                " \n" +
                "\n" +
                "    public void getOlder(int year) {\n" +
                "\n" +
                "        if(year <= 0) {\n" +
                "\n" +
                "            return;\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "        this.year += year;\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    public String eat() {\n" +
                "\n" +
                "        return eat(\"chicken\");\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    public String eat(String food) {\n" +
                "\n" +
                "        if(year <= 1) {\n" +
                "\n" +
                "            return \"eating milk...\";\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "        return \"eating \" + food + \"...\";\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "}";

        String className, scope, constructor;
        className = scope = constructor = "";

        ArrayList<Attributes> fields = new ArrayList<>();

        // Split the class text into lines
        String[] lines = classText.split("\n");
        for (String line : lines) {
            className = getClassName(line, className);
            scope = getScope(line, scope);
            constructor = getConstructor(line, className, constructor);

            if(getFields(line) != null) {
                fields.add(getFields(line));
            }
        }

        outputFormatter(
                new ClassesModel(className, scope, constructor, fields));
    }

    private static String getClassName(String inputLine, String className) {
        if (inputLine.contains("class")) {
            return inputLine.split(" ")[2];
        }
        return className;
    }

    // Determine the class's access level
    private static String getScope(String inputLine, String scope) {
        if (inputLine.contains("public")) {
            return "public";
        } else if (inputLine.contains("private")) {
            return "private";
        }
        return scope;
    }

    private static String getConstructor(String inputLine, String className, String constructor) {
        if(inputLine.contains(className) && inputLine.contains("(")){
            return inputLine;
        }
        return constructor.isEmpty() ? className : constructor;
    }

    private static String getFieldName(String inputLine) {
        String result = inputLine.trim().split(" ")[2];
        if(result.contains("(")) {
            return result.substring(0, result.indexOf('('));
        }
        return result;
    }

    private static Character getVariable(String inputLine) {
        return inputLine.trim().split(" ")[2].contains("(") ? 'M' : 'A';
    }

    private static String getFieldType(String inputLine) {
        return inputLine.split(" ")[1];
    }

    private static String getSignature(String inputLine, Character variable) {
        String result = inputLine.trim();

        switch (variable) {
            case 'A':
                return "TYPE: " + inputLine.trim().split(" ")[1];

            case 'M':
                if(result.contains("(") && result.contains(")")){
                    String params = result.substring(result.indexOf('(') +1, result.indexOf(')'));
                    String formattedParams = params.isEmpty() ? "" : ", PARAMS: " + params;

                    return "RTYPE: " + inputLine.trim().split(" ")[1] + formattedParams;
                }

            default:
                return "";
        }
    }

    private static Attributes getFields(String inputLines) {
        // List the class's fields
        if ((inputLines.contains(";") || inputLines.contains("{"))
                && !getScope(inputLines, "").isEmpty() && getClassName(inputLines, "").isEmpty()
        ) {
            Character variable = getVariable(inputLines);
            return new Attributes(getFieldName(inputLines), variable,
                    getScope(inputLines, ""), getSignature(inputLines, variable));
        }
        return null;
    }

    private static void outputFormatter(ClassesModel classToFormat) {
        ArrayList<Attributes> attributes = classToFormat.getAttributes();

        System.out.println("class name: " + classToFormat.getName());
        System.out.println("scope: " + classToFormat.getScope());
        System.out.println("constructor: " + classToFormat.getConstructor());

        String headerFormat = "┏%1$-10s┳%1$-10s┳%1$-10s┳%2$-35s┓\n";
        String format = "┃%1$-10s┃%2$-10s┃%3$-10s┃%4$-35s┃\n";
        String footerFormat = "┗%1$-10s┻%1$-10s┻%1$-10s┻%2$-35s┛\n";

        System.out.format(headerFormat,"----------", "-----------------------------------");
        System.out.format(format, "NAME", "VARI", "SCOPE", "SIGNATURE");
        System.out.format(format,"----------", "----------","----------", "-----------------------------------");
        for (Attributes attribute : attributes) {
            System.out.format(format, attribute.getName(), attribute.getVariable(),
                    attribute.getScope(), attribute.getSignature());
        }
        System.out.format(footerFormat,"----------", "-----------------------------------");
        System.out.println("VARI: variación, RTYPE: return type, PARAMS: parámetros");
        System.out.println("A: atributo, M: método");
    }
}