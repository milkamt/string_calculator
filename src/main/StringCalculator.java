package main;

public class StringCalculator {

    final private String DELIMITER = "[,\s\n]";

    public int getSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int[] numbers = getNumbers(input);
        int sum = 0;
        for (int i : numbers) {
            if (validate(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private int[] getNumbers(String input) {
        String[] splitInput = input.split(DELIMITER);
        int[] numbers = new int[splitInput.length];
        int index = 0;
        for (String s : splitInput) {
            numbers[index] = Integer.parseInt(s);
            index++;
        }
        return numbers;
    }

    private boolean validate(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Not supporting negative numbers.");
        }
        return n <= 100;
    }
}