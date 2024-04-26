package org.amuradon.tralon.sigpron.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Position(String symbol, String marginType, int leverage) {

}
