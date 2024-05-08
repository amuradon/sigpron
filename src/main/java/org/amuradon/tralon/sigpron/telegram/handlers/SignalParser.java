package org.amuradon.tralon.sigpron.telegram.handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amuradon.tralon.sigpron.MarginType;
import org.amuradon.tralon.sigpron.Side;
import org.amuradon.tralon.sigpron.Signal;

import io.quarkus.qute.TemplateEnum;

@TemplateEnum
public enum SignalParser {
	WOLFX {
		@Override
		public Signal parseSignal(String messageContent) {
			Matcher matcher = WOLFX_PATTERN.matcher(messageContent);
			if (matcher.find()) {
				return new Signal(
						matcher.group(1).replace("/", ""),
						matcher.group(2),
						matcher.group(3),
						Side.valueOf(matcher.group(4).toUpperCase()),
						Double.parseDouble(matcher.group(5)),
						Double.parseDouble(matcher.group(6)),
						Double.parseDouble(matcher.group(7)),
						Double.parseDouble(matcher.group(8)),
						Double.parseDouble(matcher.group(9)),
						0,
						0,
						0,
						Double.parseDouble(matcher.group(10)),
						MarginType.ISOLATED,
						Integer.parseInt(matcher.group(11)),
						"Wolfx"
					);
			} else {
				return null;
			}
		}
	},
	MONEY_TEAM {
		@Override
		public Signal parseSignal(String messageContent) {
			Matcher matcher = MONEY_TEAM_PATTERN.matcher(messageContent);
			if (matcher.find()) {
				Side side = matcher.group(1).equalsIgnoreCase("LONG") ? Side.BUY : Side.SELL;
				return new Signal(
						matcher.group(2).replace("/", ""),
						matcher.group(3),
						matcher.group(4),
						side,
						Double.parseDouble(matcher.group(7)),
						Double.parseDouble(matcher.group(8)),
						Double.parseDouble(matcher.group(9)),
						Double.parseDouble(matcher.group(10)),
						Double.parseDouble(matcher.group(11)),
						Double.parseDouble(matcher.group(12)),
						Double.parseDouble(matcher.group(13)),
						Double.parseDouble(matcher.group(14)),
						Double.parseDouble(matcher.group(15)),
						MarginType.valueOf(matcher.group(5).toUpperCase()),
						Integer.parseInt(matcher.group(6)),
						"MoneyT"
					);
			} else {
				return null;
			}
		}
	};
	
	private static final Pattern WOLFX_PATTERN = Pattern.compile("((\\w+)\\/(\\w+)).*(BUY|SELL)\\n+.*above:\\s+(\\d+\\.\\d+).*of\\s+(\\d+\\.\\d+).*\\n+"
			+ ".*TP1\\s+(\\d+\\.\\d+)\\n+.*TP2\\s+(\\d+\\.\\d+)\\n+.*TP3\\s+(\\d+\\.\\d+)\\n+.*SL\\s+(\\d+\\.\\d+)\\n+.*Leverage\\s+(\\d+)x");
	
	private static final Pattern MONEY_TEAM_PATTERN = Pattern.compile(".*PREMIUM SIGNAL.*\\n+.*\\n.*\\n+.*(LONG|SHORT)"
			+ "\\nName:\\s*((\\w+)\\/(\\w+))\\nMargin:\\s*(\\w+)\\s+(\\d+).*\\n+.*ENTRY.*\\n(\\d+\\.\\d+)-"
			+ "(\\d+\\.\\d+)\\n+.*TARGETS.*\\n1\\)\\s*(\\d+\\.\\d+)\\n2\\)\\s*(\\d+\\.\\d+)\\n3\\)\\s*(\\d+\\.\\d+)\\n"
			+ "4\\)\\s*(\\d+\\.\\d+)\\n5\\)\\s*(\\d+\\.\\d+)\\n6\\)\\s*(\\d+\\.\\d+)\\n+.*StopLoss.*\\n(\\d+\\.\\d+)");
	
	public abstract Signal parseSignal(String messageContent);
}
