package com.js.tictactoe.player;

import com.js.tictactoe.validators.InputValidator;
import com.js.tictactoe.validators.PlayerSignValidator;

import java.util.function.Supplier;

public class PlayersGenerator {

    public static String createName(Supplier<String> input) {
        String name;

        do {
            name = input.get();
        } while (name.equalsIgnoreCase(""));

        return name;
    }

    public static Sign createSign(Supplier<String> input) {
        InputValidator validator = new PlayerSignValidator();
        String sign;
        boolean correct;
        do {
            System.out.println("Choose sign (O/X)");
            sign = input.get();
            correct = validator.validate(sign);
        } while (!correct);

        return Sign.valueOf(sign.toUpperCase());
    }
}
