package org.amuradon.tralon.sigpron.exchange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Symbol {
	// I don't know how to parse JSON array into map directly in Jackson, therefore class instead of record

	public final String symbol;
	public final String contractType;
	public final String status;
	public final Set<String> orderTypes;
	public final Set<String> timeInForce;
	public final Map<String, Map<String, Object>> filterMapping;
	
	@JsonCreator
	public Symbol(@JsonProperty("symbol") String symbol,
		@JsonProperty("contractType") String contractType,
		@JsonProperty("status") String status,
		@JsonProperty("orderType") Set<String> orderTypes,
		@JsonProperty("timeInForce") Set<String> timeInForce,
		@JsonProperty("filters") List<Map<String, Object>> filters) {
			this.symbol = symbol;
			this.contractType = contractType;
			this.status = status;
			this.orderTypes = orderTypes;
			this.timeInForce = timeInForce;
			filterMapping = new HashMap<>();
			
			for (Map<String, Object> map : filters) {
				filterMapping.put(map.get("filterType").toString(), map);
			}
	}

}