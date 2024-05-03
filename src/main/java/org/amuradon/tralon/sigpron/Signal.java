package org.amuradon.tralon.sigpron;

public record Signal(String symbol,
		String base,
		String quote,
		Side side,
		double stopPrice,
		double price,
		double takeProfit1,
		double takeProfit2,
		double takeProfit3,
		double takeProfit4,
		double takeProfit5,
		double takeProfit6,
		double stopLoss,
		MarginType marginType,
		int leverage) {
}
