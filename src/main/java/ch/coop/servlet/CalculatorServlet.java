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

package ch.coop.servlet;

import ch.coop.service.CalculatorService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

public class CalculatorServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		setupResponse(resp);
		String result;
		try {
			result = setupCalculation(req);
		} catch (Exception e) {
			writeError(resp, e);
			return;
		}
		resp.getWriter().write(result);
		resp.setStatus(HttpServletResponse.SC_OK);
	}

	private void setupResponse(HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
	}

	private String setupCalculation(HttpServletRequest req) throws IOException {
		JSONObject jsonBody = new JSONObject(req.getReader().lines().collect(Collectors.joining()));
		return calculate(jsonBody.getDouble("number1"), jsonBody.getDouble("number2"), jsonBody.getString("operator").charAt(0));
	}

	private String calculate(double number1, double number2, char operator) {
		Double result = CalculatorService.calc(number1, number2, operator);
		DecimalFormat df = new DecimalFormat("#.##########");
		df.setRoundingMode(RoundingMode.CEILING);
		return df.format(result);
	}

	private void writeError(HttpServletResponse resp, Exception e) throws IOException {
		resp.getWriter().write("Invalid JSON");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		System.out.printf("Invalid JSON: %s", e.getMessage());
	}

}
