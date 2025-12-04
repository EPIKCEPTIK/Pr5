package org.example;
public class TestRecognizer {

    public enum State {
        S, ONE, TWO, THREE, F
    }

    public State process(String input) {
        var currentState = State.S;

        if (input == null) return State.S;

        for (char c : input.toCharArray()) {
            currentState = switch (currentState) {
                case S -> (c == 'T') ? State.ONE : State.S;

                case ONE -> (c == 'E') ? State.TWO
                        : (c == 'T') ? State.ONE : State.S;

                case TWO -> (c == 'S') ? State.THREE
                        : (c == 'T') ? State.ONE : State.S;

                case THREE -> (c == 'T') ? State.F : State.S;

                case F -> State.F;
            };
        }
        return currentState;
    }
}