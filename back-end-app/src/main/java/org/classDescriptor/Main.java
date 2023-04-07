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
        }

        outputFormatter(
                new ClassesModel(className, scope, constructor, getFields(lines)));
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
        return inputLine.split(" ")[2];
    }
    private static String getVariable(String inputLine) {
        return inputLine.split(" ")[2].contains("(") ? "M" : "A";
    }
    private static String getFieldScope(String inputLine) {
        if (inputLine.contains("public")) {
            return "public";
        } else if (inputLine.contains("private")) {
            return "private";
        }
        return "";
    }
    private static String getFieldType(String inputLine) {
        return inputLine.split(" ")[1];
    }

    private static ArrayList<Attributes> getFields(String[] inputLines) {
        // List the class's fields
        List<String> fields = new ArrayList<>();
        ArrayList<Attributes> attributes = new ArrayList<>();
        for (String line : inputLines) {
            if (line.contains(";")) {
                attributes.add(new Attributes(getFieldName(line), getVariable(line),
                        getFieldScope(line), getFieldType(line)));
                fields.add(line.trim());
            }
        }
        return attributes;
    }

    private static void outputFormatter(ClassesModel classToFormat) {
        ArrayList<Attributes> attributes = classToFormat.getAttributes();

        System.out.println("class name: " + classToFormat.getName());
        System.out.println("scope: " + classToFormat.getScope());
        System.out.println("constructor: " + classToFormat.getConstructor());

        String headerFormat = "┏%1$-10s┳%2$-10s┳%3$-10s┳%3$-10s┓\n";
        String format = "|%1$-10s|%2$-10s|%3$-10s|%4$-10s|\n";
        String footerFormat = "┗%1$-10s┻%2$-10s┻%3$-10s┻%3$-10s┛\n";

        System.out.format(headerFormat,"----------", "----------","----------", "----------");
        for (Attributes attribute : attributes) {
            System.out.format(format, attribute.getName(), attribute.getVariable(),
                    attribute.getScope(), attribute.getSignature());
        }
        System.out.format(footerFormat,"----------", "----------","----------", "----------");
    }
}