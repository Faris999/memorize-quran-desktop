package com.faris.memorizequran;

import java.util.HashMap;
import java.util.Scanner;

public class Command {

    //TODO Save
    //TODO Load

    public void exit(String... args) {
        if (args.length > 0) {
            System.exit(Integer.valueOf(args[0]));
        }
        System.exit(0);
    }

    public void status(String... args) {
        //TODO Status
        System.out.println("Status");
    }

    public void test(String... args) {
        if (args.length != 3) {
            System.out.println("Usage: test <level> <type> <name>");
            return;
        }
        Scanner sc = new Scanner(System.in);
        Level level;
        try {
            level = Level.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            System.out.printf("No such level: %s\n", args[0]);
            return;
        }
        Type type;
        try {
            type = Type.valueOf(args[1]);
        } catch (IllegalArgumentException e) {
            System.out.printf("No such type: %s\n", args[1]);
            return;
        }
        String name = args[2]; //TODO Name
        HashMap<String, Option> questions = generateQuestions(level, type, name);
        int correct = 0;
        for (String question : questions.keySet()) {
            boolean invalidArgument;
            do {
                invalidArgument = false;
                System.out.println(question);
                System.out.print(">");
                String answer = sc.nextLine();
                try {
                    Option.valueOf(answer.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Valid options: A, B, C, D");
                    invalidArgument = true;
                    continue;
                }
                if (Option.valueOf(answer.toUpperCase()) == questions.get(question)) {
                    System.out.println("Correct!");
                    correct++;
                } else {
                    System.out.println("Correct answer: " + questions.get(question));
                }
            } while (invalidArgument);
        }
        System.out.printf("Correct: %d, Wrong: %d\n", correct, questions.size() - correct);
    }

    private HashMap<String, Option> generateQuestions(Level level, Type type, String name) {
        //TODO Generate Questions
        HashMap<String, Option> questions = new HashMap<>();
        questions.put("Qul a'udzubirobbinnaas\nWhat is the number of this verse above?\nA. 1\nB. 5\nC. 8\nD. 4", Option.A);
        return questions;
    }

}
