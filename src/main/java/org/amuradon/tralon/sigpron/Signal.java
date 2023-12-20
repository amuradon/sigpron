package org.amuradon.tralon.sigpron;

public record Signal(String symbol,
		String base,
		String quote,
		Side side,
		double entry1,
		double entry2,
		double takeProfit1,
		double takeProfit2,
		double takeProfit3,
		double stopLoss,
		int leverage) {

}
