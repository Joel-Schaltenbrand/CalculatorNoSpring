package ch.coop.service;

public final class CalculatorService {

	private CalculatorService() {
	}

	public static Double calc(double number1, double number2, char operator) {
		return switch (operator) {
			case '+' -> add(number1, number2);
			case '-' -> subtract(number1, number2);
			case '*' -> multiply(number1, number2);
			case '/' -> divide(number1, number2);
			default -> null;
		};
	}

	private static Double add(double number1, double number2) {
		return number1 + number2;
	}

	private static Double subtract(double number1, double number2) {
		return number1 - number2;
	}

	private static Double multiply(double number1, double number2) {
		return number1 * number2;
	}

	private static Double divide(double number1, double number2) {
		return number1 / number2;
	}
}
