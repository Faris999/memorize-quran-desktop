package com.faris.memorizequran;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        System.out.println("Memorize Quran v0.0.1a build 12");
        executeCommand();
    }

    private void executeCommand() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(">");
            String s = sc.nextLine();
            String[] args = Arrays.copyOfRange(s.split(" "), 1, s.split(" ").length);
            s = s.split(" ")[0];
            Command command = new Command();
            Method method;
            try {
                method = Command.class.getMethod(s, String[].class);
            } catch (NoSuchMethodException e) {
                System.out.printf("Unknown Command: %s\n", s);
                return;
            }
            try {
                method.invoke(command, new Object[]{args});
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
