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
		JSONObject jsonBody = new JSONObject(req.getReader().lines().collect(Collectors.joining()));
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.setStatus(HttpServletResponse.SC_OK);
		Double result = CalculatorService.calc(jsonBody.getDouble("number1"), jsonBody.getDouble("number2"), jsonBody.getString("operator").charAt(0));
		DecimalFormat df = new DecimalFormat("#.##########");
		df.setRoundingMode(RoundingMode.CEILING);
		resp.getWriter().write(df.format(result));
	}
}
