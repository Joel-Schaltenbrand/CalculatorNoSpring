/*
 * MIT License
 *
 * Copyright (c) 2023 Joel Schaltenbrand.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
