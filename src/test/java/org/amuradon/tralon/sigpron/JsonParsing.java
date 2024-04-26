package org.amuradon.tralon.sigpron;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.amuradon.tralon.sigpron.exchange.Symbol;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParsing {

//	@Test
	public void parse() throws IOException {
		double quantity = 900;
		ObjectMapper mapper = new ObjectMapper();
		Symbol[] symbols = mapper.readValue(
				mapper.readTree(this.getClass().getClassLoader().getResourceAsStream("file.json"))
					.get("symbols").traverse(), mapper.getTypeFactory().constructArrayType(Symbol.class));
		Map<String, Symbol> mapping = Arrays.stream(symbols)
				.filter(s -> s.contractType.equalsIgnoreCase("PERPETUAL"))
				.collect(Collectors.<Symbol, String, Symbol>toMap(s -> s.symbol, s -> s));
		
		Symbol btc = mapping.get("BTCUSDT");
		
		if (btc.orderTypes.contains("MARKET")) {
			Map<String, Object> marketLotSize = btc.filterMapping.get("MARKET_LOT_SIZE");
			Map<String, Object> lotSize = btc.filterMapping.get("LOT_SIZE");
			double maxQty = Double.min(Double.parseDouble(marketLotSize.get("maxQty").toString()), Double.parseDouble(lotSize.get("maxQty").toString()));
			double minQty = Double.max(Double.parseDouble(marketLotSize.get("minQty").toString()), Double.parseDouble(lotSize.get("minQty").toString()));
			
			if (quantity < minQty) {
				// TODO log error
				return;
			}
			
			double resolvedQuantity = Double.min(maxQty, quantity);
			// TODO log quantities
			System.out.println(String.format("Requested %f, resolved %f", quantity, resolvedQuantity));
		}
	}
}
