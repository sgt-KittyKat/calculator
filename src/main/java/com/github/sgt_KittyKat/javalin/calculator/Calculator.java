package com.github.sgt_KittyKat.javalin.calculator;

import io.javalin.Javalin;

public class Calculator {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        app.start(8080);
        app.get("/calculator/:operation/:first/:second" , context -> {
            String operation = context.pathParam("operation");
            int first = Integer.parseInt(context.pathParam("first"));
            int second = Integer.parseInt(context.pathParam("second"));
            switch (operation) {
                case ("add"):
                    first += second;
                    break;
                case ("sub"):
                    first -= second;
                    break;
                case ("mpy"):
                    first *= second;
                    break;
                case ("div"):
                    first /= second;
                    break;
                case ("power"):
                    first = (int) Math.pow(first, second);
                    break;
            }
            context.result(String.valueOf(first));
        });
    }
}
