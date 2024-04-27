package com.spangler.springfreecodecamp;

public class FirstBeanClass {

    private final String fieldValue;

    public FirstBeanClass(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public static void printStatic() {
        System.out.println("Static Method inside Bean Class");
    }

    public String printFieldValue() {
        return "Field Value -> " + fieldValue;
    }
}
