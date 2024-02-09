package org.amuradon.tralon.sigpron;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.amuradon.tralon.sigpron.exchange.Symbol;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParsing {

private String json =
"""
{
	"timezone": "UTC",
	"serverTime": 1707358695651,
	"futuresType": "U_MARGINED",
	"rateLimits": [
		{
			"rateLimitType": "REQUEST_WEIGHT",
			"interval": "MINUTE",
			"intervalNum": 1,
			"limit": 6000
		},
		{
			"rateLimitType": "ORDERS",
			"interval": "MINUTE",
			"intervalNum": 1,
			"limit": 1200
		},
		{
			"rateLimitType": "ORDERS",
			"interval": "SECOND",
			"intervalNum": 10,
			"limit": 300
		}
	],
	"exchangeFilters": [],
	"assets": [
		{
			"asset": "USDT",
			"marginAvailable": true,
			"autoAssetExchange": "-100"
		},
		{
			"asset": "BTC",
			"marginAvailable": true,
			"autoAssetExchange": "-0.00100000"
		},
		{
			"asset": "BNB",
			"marginAvailable": true,
			"autoAssetExchange": "-0.00100000"
		},
		{
			"asset": "ETH",
			"marginAvailable": true,
			"autoAssetExchange": "-0.00100000"
		},
		{
			"asset": "FIL",
			"marginAvailable": true,
			"autoAssetExchange": "-200"
		},
		{
			"asset": "BUSD",
			"marginAvailable": true,
			"autoAssetExchange": "-200"
		},
		{
			"asset": "USDC",
			"marginAvailable": true,
			"autoAssetExchange": "-0.10000000"
		}
	],
	"symbols": [
		{
			"symbol": "BTCUSDT",
			"pair": "BTCUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404802000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BTC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.30",
			"maxMoveOrderLimit": 1000,
			"filters": [
				{
					"tickSize": "0.10",
					"minPrice": "261.10",
					"maxPrice": "809484",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "0.001",
					"filterType": "LOT_SIZE",
					"maxQty": "1000",
					"minQty": "0.001"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.001",
					"stepSize": "0.001",
					"maxQty": "1000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "100"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.5000",
					"multiplierUp": "1.5000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ETHUSDT",
			"pair": "ETHUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ETH",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "95264.25",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.01",
					"minPrice": "18.67"
				},
				{
					"minQty": "0.001",
					"stepSize": "0.001",
					"maxQty": "10000",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.001",
					"minQty": "0.001",
					"maxQty": "10000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "20"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BCHUSDT",
			"pair": "BCHUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BCH",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.01",
					"maxPrice": "9521",
					"filterType": "PRICE_FILTER",
					"minPrice": "5.71"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000",
					"minQty": "0.001",
					"stepSize": "0.001"
				},
				{
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.001",
					"stepSize": "0.001"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "XRPUSDT",
			"pair": "XRPUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "XRP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0117",
					"maxPrice": "19.6050",
					"tickSize": "0.0001",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"maxQty": "1000000",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "EOSUSDT",
			"pair": "EOSUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "EOS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.001",
					"maxPrice": "36.061",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.021"
				},
				{
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LTCUSDT",
			"pair": "LTCUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LTC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "2.80",
					"maxPrice": "4672.32",
					"tickSize": "0.01",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "10000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.001",
					"minQty": "0.001"
				},
				{
					"stepSize": "0.001",
					"maxQty": "10000",
					"minQty": "0.001",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "TRXUSDT",
			"pair": "TRXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "TRX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.025000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 0,
			"filters": [
				{
					"tickSize": "0.00001",
					"maxPrice": "3.53444",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.00212"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ETCUSDT",
			"pair": "ETCUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ETC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0800",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.001",
					"minPrice": "0.567",
					"maxPrice": "946.547",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.01",
					"stepSize": "0.01",
					"maxQty": "100000"
				},
				{
					"maxQty": "100000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.01",
					"minQty": "0.01"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LINKUSDT",
			"pair": "LINKUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LINK",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI",
				"HOT"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001",
					"maxPrice": "389.118",
					"minPrice": "0.233"
				},
				{
					"minQty": "0.01",
					"maxQty": "100000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.01"
				},
				{
					"maxQty": "100000",
					"stepSize": "0.01",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.01"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "XLMUSDT",
			"pair": "XLMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "XLM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "4.74450",
					"minPrice": "0.00284",
					"tickSize": "0.00001"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ADAUSDT",
			"pair": "ADAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ADA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"HOT"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.01680",
					"maxPrice": "28.13500",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.00010"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DASHUSDT",
			"pair": "DASHUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DASH",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.007000",
			"marketTakeBound": "0.35",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.74",
					"maxPrice": "1238.47",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.01"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.001",
					"maxQty": "10000",
					"stepSize": "0.001"
				},
				{
					"minQty": "0.001",
					"maxQty": "850000",
					"stepSize": "0.001",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.5000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.5000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ZECUSDT",
			"pair": "ZECUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ZEC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.5",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "2445.24",
					"minPrice": "1.46",
					"tickSize": "0.01"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "0.001",
					"maxQty": "10000",
					"minQty": "0.001"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000",
					"stepSize": "0.001",
					"minQty": "0.001"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "XTZUSDT",
			"pair": "XTZUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "XTZ",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "62.150",
					"tickSize": "0.001",
					"minPrice": "0.037",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "10000",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BNBUSDT",
			"pair": "BNBUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BNB",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"BSC",
				"HOT"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001",
					"maxPrice": "10822.994",
					"minPrice": "6.493"
				},
				{
					"minQty": "0.01",
					"maxQty": "10000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.01"
				},
				{
					"stepSize": "0.01",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.01",
					"maxQty": "100000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ATOMUSDT",
			"pair": "ATOMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ATOM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.20",
			"maxMoveOrderLimit": 3000,
			"filters": [
				{
					"tickSize": "0.001",
					"filterType": "PRICE_FILTER",
					"maxPrice": "363.214",
					"minPrice": "0.217"
				},
				{
					"stepSize": "0.01",
					"filterType": "LOT_SIZE",
					"maxQty": "10000",
					"minQty": "0.01"
				},
				{
					"stepSize": "0.01",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.01",
					"maxQty": "100000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ONTUSDT",
			"pair": "ONTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ONT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"BSC"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0083",
					"maxPrice": "13.8978",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "IOTAUSDT",
			"pair": "IOTAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "IOTA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"maxPrice": "12.8692",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0077"
				},
				{
					"maxQty": "1000000",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BATUSDT",
			"pair": "BATUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BAT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "8.6100",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001",
					"minPrice": "0.0051"
				},
				{
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "VETUSDT",
			"pair": "VETUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "VET",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "1.538720",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000010",
					"minPrice": "0.000920"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "NEOUSDT",
			"pair": "NEOUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "NEO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.732",
					"filterType": "PRICE_FILTER",
					"maxPrice": "1220.435",
					"tickSize": "0.001"
				},
				{
					"stepSize": "0.01",
					"filterType": "LOT_SIZE",
					"minQty": "0.01",
					"maxQty": "100000"
				},
				{
					"minQty": "0.01",
					"stepSize": "0.01",
					"maxQty": "100000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "QTUMUSDT",
			"pair": "QTUMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "QTUM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "189.594",
					"tickSize": "0.001",
					"minPrice": "0.113",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1"
				},
				{
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "IOSTUSDT",
			"pair": "IOSTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "IOST",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.000396",
					"maxPrice": "0.661400",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000001"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "THETAUSDT",
			"pair": "THETAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "THETA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0010",
					"minPrice": "0.0370",
					"maxPrice": "62.0150"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ALGOUSDT",
			"pair": "ALGOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ALGO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001",
					"minPrice": "0.0067",
					"maxPrice": "11.1700"
				},
				{
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ZILUSDT",
			"pair": "ZILUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ZIL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00001",
					"maxPrice": "1.63450",
					"minPrice": "0.00098",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "KNCUSDT",
			"pair": "KNCUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "KNC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.02620",
					"tickSize": "0.00010",
					"filterType": "PRICE_FILTER",
					"maxPrice": "43.68750"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ZRXUSDT",
			"pair": "ZRXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ZRX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"minPrice": "0.0079",
					"filterType": "PRICE_FILTER",
					"maxPrice": "13.2541"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "COMPUSDT",
			"pair": "COMPUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "COMP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "1.26",
					"maxPrice": "2108",
					"tickSize": "0.01"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "0.001",
					"minQty": "0.001",
					"maxQty": "10000"
				},
				{
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.001",
					"minQty": "0.001"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "OMGUSDT",
			"pair": "OMGUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "OMG",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0010",
					"minPrice": "0.0550",
					"filterType": "PRICE_FILTER",
					"maxPrice": "92.5910"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DOGEUSDT",
			"pair": "DOGEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DOGE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"HOT"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.002170",
					"tickSize": "0.000010",
					"maxPrice": "3.623930",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SXPUSDT",
			"pair": "SXPUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SXP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI",
				"BSC"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"minPrice": "0.0104",
					"filterType": "PRICE_FILTER",
					"maxPrice": "17.4211"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "KAVAUSDT",
			"pair": "KAVAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "KAVA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "49.5250",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0297",
					"tickSize": "0.0001"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BANDUSDT",
			"pair": "BANDUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BAND",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001",
					"maxPrice": "50.0510",
					"minPrice": "0.0300"
				},
				{
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RLCUSDT",
			"pair": "RLCUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "RLC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"maxPrice": "106.7243",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0640"
				},
				{
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "WAVESUSDT",
			"pair": "WAVESUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "WAVES",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "143.1650",
					"tickSize": "0.0010",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0850"
				},
				{
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MKRUSDT",
			"pair": "MKRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MKR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "23",
					"tickSize": "0.10",
					"maxPrice": "38385",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "0.001",
					"maxQty": "10000",
					"filterType": "LOT_SIZE",
					"minQty": "0.001"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.001",
					"stepSize": "0.001",
					"maxQty": "10000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SNXUSDT",
			"pair": "SNXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SNX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.079",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001",
					"maxPrice": "132.131"
				},
				{
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1"
				},
				{
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DOTUSDT",
			"pair": "DOTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DOT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"HOT"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "271.718",
					"minPrice": "0.163",
					"tickSize": "0.001",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DEFIUSDT",
			"pair": "DEFIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DEFI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 1,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "INDEX",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "21250",
					"minPrice": "12.7",
					"tickSize": "0.1",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "0.001",
					"filterType": "LOT_SIZE",
					"maxQty": "10000",
					"stepSize": "0.001"
				},
				{
					"minQty": "0.001",
					"stepSize": "0.001",
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "YFIUSDT",
			"pair": "YFIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "YFI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 1,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.1",
					"filterType": "PRICE_FILTER",
					"maxPrice": "371600",
					"minPrice": "222.9"
				},
				{
					"maxQty": "500",
					"stepSize": "0.001",
					"minQty": "0.001",
					"filterType": "LOT_SIZE"
				},
				{
					"maxQty": "500",
					"stepSize": "0.001",
					"minQty": "0.001",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BALUSDT",
			"pair": "BALUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BAL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.103",
					"maxPrice": "172.190",
					"tickSize": "0.001"
				},
				{
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CRVUSDT",
			"pair": "CRVUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CRV",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.013",
					"tickSize": "0.001",
					"maxPrice": "22.181"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "TRBUSDT",
			"pair": "TRBUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "TRB",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.890",
					"maxPrice": "1488.050",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.010"
				},
				{
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RUNEUSDT",
			"pair": "RUNEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "RUNE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "89.5000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0010",
					"minPrice": "0.0530"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SUSHIUSDT",
			"pair": "SUSHIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SUSHI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI",
				"HOT"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0430",
					"filterType": "PRICE_FILTER",
					"maxPrice": "72.3500",
					"tickSize": "0.0010"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SRMUSDT",
			"pair": "SRMUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SRM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "153.5750",
					"tickSize": "0.0010",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0920"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "EGLDUSDT",
			"pair": "EGLDUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "EGLD",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "1685.580",
					"tickSize": "0.010",
					"filterType": "PRICE_FILTER",
					"minPrice": "1.010"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SOLUSDT",
			"pair": "SOLUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SOL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0100",
					"maxPrice": "1261.3700",
					"minPrice": "0.7500"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ICXUSDT",
			"pair": "ICXUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ICX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "50.8000",
					"minPrice": "0.0304",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "STORJUSDT",
			"pair": "STORJUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "STORJ",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0137",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001",
					"maxPrice": "22.8581"
				},
				{
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "UNIUSDT",
			"pair": "UNIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "UNI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI",
				"HOT"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "355.4590",
					"tickSize": "0.0010",
					"minPrice": "0.2130"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AVAXUSDT",
			"pair": "AVAXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AVAX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "498.8600",
					"tickSize": "0.0100",
					"minPrice": "0.2900"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "FTMUSDT",
			"pair": "FTMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "FTM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.016200",
					"maxPrice": "27.126700",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000100"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ENJUSDT",
			"pair": "ENJUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ENJ",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.00860",
					"maxPrice": "14.34500",
					"tickSize": "0.00010",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "FLMUSDT",
			"pair": "FLMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "FLM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0019",
					"maxPrice": "3.2200",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "TOMOUSDT",
			"pair": "TOMOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 1700816400000,
			"onboardDate": 1569398400000,
			"status": "SETTLING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "TOMO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0158",
					"filterType": "PRICE_FILTER",
					"maxPrice": "26.4244",
					"tickSize": "0.0001"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RENUSDT",
			"pair": "RENUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "REN",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.00001",
					"maxPrice": "4.88045",
					"minPrice": "0.00292"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "KSMUSDT",
			"pair": "KSMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "KSM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0005",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.010",
					"minPrice": "1.320",
					"filterType": "PRICE_FILTER",
					"maxPrice": "2216"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "0.1",
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "NEARUSDT",
			"pair": "NEARUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "NEAR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.025000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "128.6410",
					"tickSize": "0.0010",
					"minPrice": "0.0770",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AAVEUSDT",
			"pair": "AAVEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AAVE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "3.060",
					"maxPrice": "5109.090",
					"tickSize": "0.010"
				},
				{
					"stepSize": "0.1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "FILUSDT",
			"pair": "FILUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "FIL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "217.998",
					"tickSize": "0.001",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.130"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RSRUSDT",
			"pair": "RSRUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "RSR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.000774",
					"tickSize": "0.000001",
					"maxPrice": "1.290556"
				},
				{
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LRCUSDT",
			"pair": "LRCUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LRC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.01270",
					"tickSize": "0.00010",
					"filterType": "PRICE_FILTER",
					"maxPrice": "21.26090"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MATICUSDT",
			"pair": "MATICUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MATIC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "70.91500",
					"tickSize": "0.00010",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.04250"
				},
				{
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "OCEANUSDT",
			"pair": "OCEANUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "OCEAN",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "24.42565",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.00001",
					"minPrice": "0.01465"
				},
				{
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BELUSDT",
			"pair": "BELUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BEL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI",
				"BSC"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "64.44270",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.03860",
					"tickSize": "0.00010"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CTKUSDT",
			"pair": "CTKUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CTK",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"BSC"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00010",
					"maxPrice": "72.19700",
					"minPrice": "0.04300",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AXSUSDT",
			"pair": "AXSUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AXS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.1430",
					"tickSize": "0.0010",
					"maxPrice": "239.4000"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "100000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ALPHAUSDT",
			"pair": "ALPHAUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ALPHA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.01680",
					"maxPrice": "28",
					"tickSize": "0.00001",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ZENUSDT",
			"pair": "ZENUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1569398400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ZEN",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.001",
					"maxPrice": "700.400",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.420"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "100000",
					"stepSize": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SKLUSDT",
			"pair": "SKLUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1598252400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SKL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "2.84912",
					"minPrice": "0.00170",
					"tickSize": "0.00001",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "GRTUSDT",
			"pair": "GRTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1598252400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "GRT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00001",
					"maxPrice": "8.72000",
					"minPrice": "0.00523",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BNTUSDT",
			"pair": "BNTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1608534000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BNT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "20.5265",
					"tickSize": "0.0001",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0122"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "1INCHUSDT",
			"pair": "1INCHUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1608879600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "1INCH",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI",
				"HOT"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "23.3563",
					"minPrice": "0.0140",
					"tickSize": "0.0001"
				},
				{
					"maxQty": "1000000",
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "UNFIUSDT",
			"pair": "UNFIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1609138800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "UNFI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI",
				"BSC"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001",
					"maxPrice": "354.100",
					"minPrice": "0.212"
				},
				{
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "100000",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CHZUSDT",
			"pair": "CHZUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1611212400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CHZ",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "3.09496",
					"minPrice": "0.00185",
					"tickSize": "0.00001"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SANDUSDT",
			"pair": "SANDUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1610953200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SAND",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.02380",
					"tickSize": "0.00010",
					"maxPrice": "39.68930"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ANKRUSDT",
			"pair": "ANKRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1611558000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ANKR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.000910",
					"tickSize": "0.000010",
					"maxPrice": "1.527170",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LITUSDT",
			"pair": "LITUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1613545200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LIT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "75.569",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001",
					"minPrice": "0.045"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000",
					"stepSize": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "REEFUSDT",
			"pair": "REEFUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1611558000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "REEF",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.000109",
					"maxPrice": "0.182942",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000001"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RVNUSDT",
			"pair": "RVNUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1614063600000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "RVN",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00001",
					"minPrice": "0.00280",
					"filterType": "PRICE_FILTER",
					"maxPrice": "4.67471"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SFPUSDT",
			"pair": "SFPUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1614150000000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SFP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"maxPrice": "53.3950",
					"minPrice": "0.0320",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "XEMUSDT",
			"pair": "XEMUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1614668400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "XEM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "5.8462",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0035",
					"tickSize": "0.0001"
				},
				{
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BTCSTUSDT",
			"pair": "BTCSTUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1614754800000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BTCST",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.040000",
			"marketTakeBound": "0.30",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.668",
					"maxPrice": "1000000",
					"tickSize": "0.001"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "COTIUSDT",
			"pair": "COTIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1615273200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "COTI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.00115",
					"tickSize": "0.00001",
					"maxPrice": "1.93326",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CHRUSDT",
			"pair": "CHRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1615532400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CHR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0024",
					"maxPrice": "4.1565"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MANAUSDT",
			"pair": "MANAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1615705200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MANA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0214",
					"maxPrice": "35.7100",
					"tickSize": "0.0001"
				},
				{
					"maxQty": "1000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ALICEUSDT",
			"pair": "ALICEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1615791600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ALICE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.042",
					"maxPrice": "70.900",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001"
				},
				{
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "HBARUSDT",
			"pair": "HBARUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1615964400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "HBAR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "14.02950",
					"tickSize": "0.00001",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.00841"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ONEUSDT",
			"pair": "ONEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1615964400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ONE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.00001",
					"maxPrice": "1.33000",
					"minPrice": "0.00079"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LINAUSDT",
			"pair": "LINAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1615964400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LINA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.00043",
					"tickSize": "0.00001",
					"maxPrice": "0.72800"
				},
				{
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "STMXUSDT",
			"pair": "STMXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1615964400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "STMX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00001",
					"maxPrice": "0.35400",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.00021"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DENTUSDT",
			"pair": "DENTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1616482800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DENT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000001",
					"minPrice": "0.000018",
					"maxPrice": "0.030282"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CELRUSDT",
			"pair": "CELRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1617001200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CELR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.00033",
					"maxPrice": "0.55926",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.00001"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "HOTUSDT",
			"pair": "HOTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1617087600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "HOT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.000068",
					"maxPrice": "0.113450",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000001"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MTLUSDT",
			"pair": "MTLUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1617174000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MTL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"minPrice": "0.0436",
					"maxPrice": "72.7546",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "OGNUSDT",
			"pair": "OGNUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1617174000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "OGN",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "7.6100",
					"minPrice": "0.0045",
					"tickSize": "0.0001",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "1000000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "NKNUSDT",
			"pair": "NKNUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1617865200000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "NKN",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.00860",
					"maxPrice": "14.34653",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.00001"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DGBUSDT",
			"pair": "DGBUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1618815600000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DGB",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00001",
					"minPrice": "0.00087",
					"filterType": "PRICE_FILTER",
					"maxPrice": "1.45450"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "1000SHIBUSDT",
			"pair": "1000SHIBUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1620630000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "1000SHIB",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.000286",
					"maxPrice": "0.478100",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000001"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BAKEUSDT",
			"pair": "BAKEUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1621321200000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BAKE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "47.3794",
					"minPrice": "0.0001",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "GTCUSDT",
			"pair": "GTCUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1615791600000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "GTC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.346",
					"tickSize": "0.001",
					"maxPrice": "577.250"
				},
				{
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BTCDOMUSDT",
			"pair": "BTCDOMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1623913200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BTCDOM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 1,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "INDEX",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "52.1",
					"filterType": "PRICE_FILTER",
					"maxPrice": "86841.4",
					"tickSize": "0.1"
				},
				{
					"stepSize": "0.001",
					"filterType": "LOT_SIZE",
					"minQty": "0.001",
					"maxQty": "10000"
				},
				{
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.001",
					"stepSize": "0.001"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MASKUSDT",
			"pair": "MASKUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1626418800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MASK",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.45",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "202.5500",
					"minPrice": "0.1210",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0010"
				},
				{
					"maxQty": "1000000",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.3000",
					"multiplierDecimal": "4",
					"multiplierDown": "0.7000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "IOTXUSDT",
			"pair": "IOTXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1628665200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "IOTX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "1.63550",
					"tickSize": "0.00001",
					"minPrice": "0.00098",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.0500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AUDIOUSDT",
			"pair": "AUDIOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1629270000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AUDIO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "7.4938",
					"minPrice": "0.0044",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001"
				},
				{
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "C98USDT",
			"pair": "C98USDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1629702000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "C98",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0038",
					"maxPrice": "6.4762",
					"tickSize": "0.0001"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ATAUSDT",
			"pair": "ATAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1630306800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ATA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"maxPrice": "3.3899",
					"minPrice": "0.0020",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000"
				},
				{
					"minQty": "1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DYDXUSDT",
			"pair": "DYDXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1631170800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DYDX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "108.435",
					"minPrice": "0.065",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"minQty": "0.1"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.0500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "1000XECUSDT",
			"pair": "1000XECUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1631775600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "1000XEC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.00102",
					"maxPrice": "1.71642",
					"tickSize": "0.00001"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500",
					"multiplierUp": "1.0500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "GALAUSDT",
			"pair": "GALAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1631862000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "GALA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00001",
					"maxPrice": "2.34380",
					"minPrice": "0.00140",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9500",
					"multiplierUp": "1.0500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CELOUSDT",
			"pair": "CELOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1632639600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CELO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "20.994",
					"tickSize": "0.001",
					"minPrice": "0.012"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.0500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ARUSDT",
			"pair": "ARUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1632639600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.001",
					"minPrice": "0.123",
					"maxPrice": "205.758",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000",
					"stepSize": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "KLAYUSDT",
			"pair": "KLAYUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1633935600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "KLAY",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0090",
					"tickSize": "0.0001",
					"maxPrice": "15.0200"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ARPAUSDT",
			"pair": "ARPAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1634540400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ARPA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00001",
					"maxPrice": "2.06106",
					"minPrice": "0.00123",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CTSIUSDT",
			"pair": "CTSIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1635145200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CTSI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0189",
					"maxPrice": "31.5954",
					"tickSize": "0.0001"
				},
				{
					"maxQty": "1000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9500",
					"multiplierUp": "1.0500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LPTUSDT",
			"pair": "LPTUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1636527600000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LPT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001",
					"maxPrice": "1765.155",
					"minPrice": "1.059"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "0.1",
					"maxQty": "1000000",
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ENSUSDT",
			"pair": "ENSUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1638169200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ENS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.01",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.277",
					"maxPrice": "463.118",
					"tickSize": "0.001"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "PEOPLEUSDT",
			"pair": "PEOPLEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1640242800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "PEOPLE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00001",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.00086",
					"maxPrice": "2000"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ANTUSDT",
			"pair": "ANTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1640329200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ANT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.001",
					"minPrice": "0.181",
					"maxPrice": "302.273",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000",
					"stepSize": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ROSEUSDT",
			"pair": "ROSEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1640934000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ROSE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "3.93400",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.00001",
					"minPrice": "0.00236"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DUSKUSDT",
			"pair": "DUSKUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1641452400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DUSK",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "6.74733",
					"tickSize": "0.00001",
					"minPrice": "0.00404",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.0500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "FLOWUSDT",
			"pair": "FLOWUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1644390000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "FLOW",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.018",
					"filterType": "PRICE_FILTER",
					"maxPrice": "30.304",
					"tickSize": "0.001"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "IMXUSDT",
			"pair": "IMXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1644476400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "IMX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0303",
					"maxPrice": "50.5451"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500",
					"multiplierUp": "1.0500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "API3USDT",
			"pair": "API3USDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1645426800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "API3",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "96.1320",
					"minPrice": "0.0570",
					"tickSize": "0.0010",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "GMTUSDT",
			"pair": "GMTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1647241200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "GMT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.01310",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.00010",
					"maxPrice": "21.98470"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "100000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "APEUSDT",
			"pair": "APEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1647500400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "APE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"NFT"
			],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "87.2330",
					"minPrice": "0.0520",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001"
				},
				{
					"minQty": "1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "WOOUSDT",
			"pair": "WOOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1649314800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "WOO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00001",
					"minPrice": "0.00749",
					"filterType": "PRICE_FILTER",
					"maxPrice": "12.48550"
				},
				{
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.0500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "JASMYUSDT",
			"pair": "JASMYUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1650351600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "JASMY",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "100",
					"tickSize": "0.000010",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.000210"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500",
					"multiplierUp": "1.0500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DARUSDT",
			"pair": "DARUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1651129200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DAR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0024",
					"maxPrice": "4.0022"
				},
				{
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.0500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "GALUSDT",
			"pair": "GALUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1651734000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "GAL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.07020",
					"tickSize": "0.00010",
					"filterType": "PRICE_FILTER",
					"maxPrice": "117.14000"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500",
					"multiplierUp": "1.0500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "OPUSDT",
			"pair": "OPUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1654066800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "OP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.005000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0748000",
					"maxPrice": "200",
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.0500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "XMRUSDT",
			"pair": "XMRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1627628400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "XMR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 3,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.003500",
			"marketTakeBound": "0.30",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "4.836",
					"tickSize": "0.001",
					"filterType": "PRICE_FILTER",
					"maxPrice": "8060.080"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.001",
					"maxQty": "100000000",
					"stepSize": "0.001"
				},
				{
					"minQty": "0.001",
					"stepSize": "0.001",
					"maxQty": "100000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 0,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "INJUSDT",
			"pair": "INJUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1660633200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "INJ",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0010000",
					"minPrice": "0.1280000",
					"maxPrice": "2000"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.0500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "STGUSDT",
			"pair": "STGUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1661324400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "STG",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0330000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000",
					"maxPrice": "200"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SPELLUSDT",
			"pair": "SPELLUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1662361200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SPELL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [
				"DEFI"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0000001",
					"minPrice": "0.0000274",
					"filterType": "PRICE_FILTER",
					"maxPrice": "100"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "80000000",
					"minQty": "100",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"maxQty": "80000000",
					"minQty": "100",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "1000LUNCUSDT",
			"pair": "1000LUNCUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1662620400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "1000LUNC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0035000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "5.8476400",
					"tickSize": "0.0000100"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LUNA2USDT",
			"pair": "LUNA2USDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1662706800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LUNA2",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"minPrice": "0.0548000",
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "1000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LDOUSDT",
			"pair": "LDOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1662757200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LDO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000100",
					"maxPrice": "2000",
					"minPrice": "0.083300"
				},
				{
					"minQty": "1",
					"maxQty": "100000",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"maxQty": "100000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CVXUSDT",
			"pair": "CVXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1662757200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CVX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.001000",
					"maxPrice": "138.286000",
					"minPrice": "0.082000",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "100000",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "100000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ICP2USDT",
			"pair": "ICP2USDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1627628400000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ICP2",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 4,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.30",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "100000",
					"tickSize": "0.0001",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0001"
				},
				{
					"stepSize": "0.01",
					"filterType": "LOT_SIZE",
					"maxQty": "100000",
					"minQty": "0"
				},
				{
					"minQty": "0",
					"maxQty": "100000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.01"
				},
				{
					"limit": 0,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "FOOTBALLUSDT",
			"pair": "FOOTBALLUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1627628400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "FOOTBALL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.30",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "20000",
					"filterType": "PRICE_FILTER",
					"minPrice": "18.77000",
					"tickSize": "0.01000"
				},
				{
					"minQty": "0.01",
					"maxQty": "10000",
					"stepSize": "0.01",
					"filterType": "LOT_SIZE"
				},
				{
					"maxQty": "10000",
					"stepSize": "0.01",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.01"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "APTUSDT",
			"pair": "APTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1666076400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "APT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00100",
					"minPrice": "0.29900",
					"filterType": "PRICE_FILTER",
					"maxPrice": "498.51300"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9000",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "QNTUSDT",
			"pair": "QNTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1666076400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "QNT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "2000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.010000",
					"minPrice": "4.140000"
				},
				{
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1"
				},
				{
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BLUEBIRDUSDT",
			"pair": "BLUEBIRDUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1667286000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BLUEBIRD",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "INDEX",
			"underlyingSubType": [
				"Index"
			],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.00100",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.19500",
					"maxPrice": "326.42200"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000",
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "FXSUSDT",
			"pair": "FXSUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1674111600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "FXS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001000",
					"minPrice": "0.315000",
					"maxPrice": "2000"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "HOOKUSDT",
			"pair": "HOOKUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1674111600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "HOOK",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.076000",
					"maxPrice": "2000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.001000"
				},
				{
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MAGICUSDT",
			"pair": "MAGICUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1674457200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MAGIC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "2000",
					"minPrice": "0.057400",
					"tickSize": "0.000100"
				},
				{
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "TUSDT",
			"pair": "TUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1675148400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "T",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"tickSize": "0.0000100",
					"minPrice": "0.0012500"
				},
				{
					"maxQty": "10000000",
					"minQty": "0",
					"stepSize": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "0",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RNDRUSDT",
			"pair": "RNDRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1675321200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "RNDR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.000100",
					"minPrice": "0.052600",
					"maxPrice": "2000",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "HIGHUSDT",
			"pair": "HIGHUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1675407600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "HIGH",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.000100",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.116000",
					"maxPrice": "2000"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MINAUSDT",
			"pair": "MINAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1675407600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MINA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.30",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0300000",
					"maxPrice": "200"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ASTRUSDT",
			"pair": "ASTRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1676271600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ASTR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "3.1605000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0018900",
					"tickSize": "0.0000100"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "PHBUSDT",
			"pair": "PHBUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1676444400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "PHB",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0438000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000",
					"maxPrice": "200"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AGIXUSDT",
			"pair": "AGIXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1676444400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AGIX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0087000",
					"maxPrice": "14.6374000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "FETUSDT",
			"pair": "FETUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1676530800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "FET",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0065000",
					"maxPrice": "10.9750000"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "GMXUSDT",
			"pair": "GMXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1676530800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "GMX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "2000",
					"tickSize": "0.010000",
					"filterType": "PRICE_FILTER",
					"minPrice": "2.310000"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "0.01",
					"minQty": "0.01",
					"maxQty": "100000"
				},
				{
					"maxQty": "100000",
					"stepSize": "0.01",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.01"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CFXUSDT",
			"pair": "CFXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1676790000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CFX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"minPrice": "0.0036000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "6.0263000"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "STXUSDT",
			"pair": "STXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1676876400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "STX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"minPrice": "0.0196000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "200"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BNXUSDT",
			"pair": "BNXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1677049200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BNX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "9.553000",
					"minPrice": "0.005000",
					"tickSize": "0.001000"
				},
				{
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ACHUSDT",
			"pair": "ACHUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1676962800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ACH",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0000010",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0006000",
					"maxPrice": "1.0055100"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SSVUSDT",
			"pair": "SSVUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1677135600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SSV",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.010000",
					"tickSize": "0.010000",
					"maxPrice": "2000",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "0.01",
					"minQty": "0.01",
					"maxQty": "100000"
				},
				{
					"minQty": "0.01",
					"stepSize": "0.01",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "100000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CKBUSDT",
			"pair": "CKBUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1677456000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CKB",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0000010",
					"minPrice": "0.0000810",
					"filterType": "PRICE_FILTER",
					"maxPrice": "0.1358030"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "PERPUSDT",
			"pair": "PERPUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1677801600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "PERP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0300",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.000100",
					"tickSize": "0.000100",
					"maxPrice": "2000",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LQTYUSDT",
			"pair": "LQTYUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1678345200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LQTY",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000100",
					"minPrice": "0.000100",
					"maxPrice": "2000"
				},
				{
					"maxQty": "1000000",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "USDCUSDT",
			"pair": "USDCUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1678579200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "USDC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.020000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0000100",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0000100"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1000",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9000",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ARBUSDT",
			"pair": "ARBUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1679270400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ARB",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.047000",
					"tickSize": "0.000100",
					"maxPrice": "78.463600",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "IDUSDT",
			"pair": "IDUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1679529600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ID",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0001000",
					"tickSize": "0.0001000"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "JOEUSDT",
			"pair": "JOEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1679961600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "JOE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"tickSize": "0.0001000",
					"minPrice": "0.0001000"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AMB",
			"pair": "AMB",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1680048000000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AMB",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "2000",
					"tickSize": "0.0000100",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0000100"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AMBUSDT",
			"pair": "AMBUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1680048000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AMB",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "0.4259800",
					"tickSize": "0.0000100",
					"minPrice": "0.0002500"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LEVERUSDT",
			"pair": "LEVERUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1680048000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LEVER",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0000010",
					"maxPrice": "100",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0000001"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "TRUUSDT",
			"pair": "TRUUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1680048000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "TRU",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0000100",
					"minPrice": "0.0000100"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RDNTUSDT",
			"pair": "RDNTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1680566400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "RDNT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"minPrice": "0.0001000",
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ETHBTC",
			"pair": "ETHBTC",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1680566400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ETH",
			"quoteAsset": "BTC",
			"marginAsset": "BTC",
			"pricePrecision": 6,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1000",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.10",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.001850",
					"tickSize": "0.000010",
					"filterType": "PRICE_FILTER",
					"maxPrice": "3.085000"
				},
				{
					"maxQty": "10000",
					"minQty": "0.01",
					"filterType": "LOT_SIZE",
					"stepSize": "0.01"
				},
				{
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.01",
					"stepSize": "0.01"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "0.001"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1000",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9000"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "HFTUSDT",
			"pair": "HFTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1680652800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "HFT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"tickSize": "0.0001000",
					"minPrice": "0.0001000",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "XVSUSDT",
			"pair": "XVSUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1681257600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "XVS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 0,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "2000",
					"tickSize": "0.001000",
					"minPrice": "0.001000"
				},
				{
					"maxQty": "1000000",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BLURUSDT",
			"pair": "BLURUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1682553600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BLUR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"minPrice": "0.0060000",
					"maxPrice": "10.0950000",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.9700",
					"multiplierDecimal": "4",
					"multiplierUp": "1.0300",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "EDUUSDT",
			"pair": "EDUUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1682640000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "EDU",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0181000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000",
					"maxPrice": "30.3212000"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "IDEXUSDT",
			"pair": "IDEXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1682985600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "IDEX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"minPrice": "0.0000100",
					"tickSize": "0.0000100",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "1000PEPEUSDT",
			"pair": "1000PEPEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1683158400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "1000PEPE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0000366",
					"filterType": "PRICE_FILTER",
					"maxPrice": "0.0610535",
					"tickSize": "0.0000001"
				},
				{
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "1000FLOKIUSDT",
			"pair": "1000FLOKIUSDT",
			"contractType": "",
			"deliveryDate": 4133404800000,
			"onboardDate": 1683331200000,
			"status": "PENDING_TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "1000FLOKI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0000100",
					"maxPrice": "200",
					"tickSize": "0.0000100"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RADUSDT",
			"pair": "RADUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1683590400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "RAD",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "2000",
					"tickSize": "0.001000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.001000"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "UMAUSDT",
			"pair": "UMAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1683590400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "UMA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "2000",
					"tickSize": "0.001000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.001000"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "KEYUSDT",
			"pair": "KEYUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1684800000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "KEY",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"tickSize": "0.0000010",
					"minPrice": "0.0000010"
				},
				{
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "COMBOUSDT",
			"pair": "COMBOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1685707200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "COMBO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.014200",
					"tickSize": "0.000100",
					"filterType": "PRICE_FILTER",
					"maxPrice": "23.797600"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "5000000",
					"stepSize": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SUIUSDT",
			"pair": "SUIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1683072000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SUI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "2000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000100",
					"minPrice": "0.000100"
				},
				{
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "10000000"
				},
				{
					"maxQty": "10000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "NMRUSDT",
			"pair": "NMRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1687435200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "NMR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.010000",
					"maxPrice": "2000",
					"tickSize": "0.010000",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MAVUSDT",
			"pair": "MAVUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1688040000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MAV",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"tickSize": "0.0001000",
					"minPrice": "0.0001000",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "100000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MDTUSDT",
			"pair": "MDTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1688126400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MDT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0000100",
					"minPrice": "0.0000100"
				},
				{
					"maxQty": "100000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "XVGUSDT",
			"pair": "XVGUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1688558400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "XVG",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0000010",
					"maxPrice": "200",
					"tickSize": "0.0000010",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "100000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "WLDUSDT",
			"pair": "WLDUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1690200000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "WLD",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0001000",
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "200"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"stepSize": "1",
					"maxQty": "1000000",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "PENDLEUSDT",
			"pair": "PENDLEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1690511400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "PENDLE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000",
					"minPrice": "0.0001000",
					"maxPrice": "200"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "1000000",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ARKMUSDT",
			"pair": "ARKMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1690512300000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ARKM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "19.3282000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0115000",
					"tickSize": "0.0001000"
				},
				{
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AGLDUSDT",
			"pair": "AGLDUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1690597800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AGLD",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0375000",
					"maxPrice": "62.5968000"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "YGGUSDT",
			"pair": "YGGUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1691206200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "YGG",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0001000",
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "200"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DODOXUSDT",
			"pair": "DODOXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1691496000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DODOX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0001000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"tickSize": "0.0000010"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "1000000",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "OXTUSDT",
			"pair": "OXTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1691755200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "OXT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0000100",
					"maxPrice": "200",
					"minPrice": "0.0000100"
				},
				{
					"minQty": "1",
					"maxQty": "100000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SEIUSDT",
			"pair": "SEIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1692239400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SEI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0001000",
					"tickSize": "0.0001000"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CYBERUSDT",
			"pair": "CYBERUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1692619200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CYBER",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "190.188000",
					"tickSize": "0.001000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.114000"
				},
				{
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "HIFIUSDT",
			"pair": "HIFIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1694874600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "HIFI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0001000",
					"maxPrice": "200",
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ARKUSDT",
			"pair": "ARKUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1695133800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ARK",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"minPrice": "0.0001000",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ARKXUSDT",
			"pair": "ARKXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1692619200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ARKX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "2000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.001000",
					"tickSize": "0.001000"
				},
				{
					"minQty": "0.1",
					"maxQty": "10000000",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "FRONTUSDT",
			"pair": "FRONTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1695393000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "FRONT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000",
					"minPrice": "0.0001000"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BTCUSDT_240329",
			"pair": "BTCUSDT",
			"contractType": "CURRENT_QUARTER",
			"deliveryDate": 1711699200000,
			"onboardDate": 1695628800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BTC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 1,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.1",
					"minPrice": "576.3",
					"maxPrice": "1000000"
				},
				{
					"maxQty": "500",
					"filterType": "LOT_SIZE",
					"stepSize": "0.001",
					"minQty": "0.001"
				},
				{
					"stepSize": "0.001",
					"maxQty": "500",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.001"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ETHUSDT_240329",
			"pair": "ETHUSDT",
			"contractType": "CURRENT_QUARTER",
			"deliveryDate": 1711699200000,
			"onboardDate": 1695628800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ETH",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "100000",
					"minPrice": "41.10",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.01"
				},
				{
					"minQty": "0.001",
					"maxQty": "10000",
					"stepSize": "0.001",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "0.001",
					"stepSize": "0.001",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.0500",
					"multiplierDown": "0.9500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "GLMRUSDT",
			"pair": "GLMRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1695691800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "GLMR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"minPrice": "0.0001000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "200"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BICOUSDT",
			"pair": "BICOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1695933000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BICO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"minPrice": "0.0001000",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "STRAXUSDT",
			"pair": "STRAXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1696991400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "STRAX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0001000",
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "200"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LOOMUSDT",
			"pair": "LOOMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1697034600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LOOM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"tickSize": "0.0000100",
					"minPrice": "0.0001000"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BIGTIMEUSDT",
			"pair": "BIGTIMEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1697121000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BIGTIME",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"minPrice": "0.0001000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "200"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BONDUSDT",
			"pair": "BONDUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1697380200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BOND",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.001000",
					"maxPrice": "2000",
					"tickSize": "0.001000"
				},
				{
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ORBSUSDT",
			"pair": "ORBSUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1697522400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ORBS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0000100",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0000100"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "STPTUSDT",
			"pair": "STPTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1697639400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "STPT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"minPrice": "0.0000100",
					"tickSize": "0.0000100",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "1000000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "WAXPUSDT",
			"pair": "WAXPUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1697639400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "WAXP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0000100",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0000100"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BSVUSDT",
			"pair": "BSVUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1697833800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BSV",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "20000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.01000",
					"tickSize": "0.01000"
				},
				{
					"maxQty": "100000",
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RIFUSDT",
			"pair": "RIFUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1697891400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "RIF",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0000100",
					"tickSize": "0.0000100"
				},
				{
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "POLYXUSDT",
			"pair": "POLYXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1698201000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "POLYX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0000100",
					"minPrice": "0.0001000",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "GASUSDT",
			"pair": "GASUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1698201900000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "GAS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.001000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "2000",
					"minPrice": "0.001000"
				},
				{
					"stepSize": "0.1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "POWRUSDT",
			"pair": "POWRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1698373800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "POWR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0001000",
					"tickSize": "0.0001000"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SLPUSDT",
			"pair": "SLPUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1698762600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SLP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0000010",
					"maxPrice": "200",
					"tickSize": "0.0000010"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"maxQty": "10000000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "TIAUSDT",
			"pair": "TIAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1698769800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "TIA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0001000"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SNTUSDT",
			"pair": "SNTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1698928200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SNT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0000100",
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"minPrice": "0.0000100"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "1000000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "CAKEUSDT",
			"pair": "CAKEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1698929100000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "CAKE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0001000",
					"tickSize": "0.0001000"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MEMEUSDT",
			"pair": "MEMEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1699012800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MEME",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0000010",
					"minPrice": "0.0000010",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "10000000",
					"stepSize": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "100000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "TOKENUSDT",
			"pair": "TOKENUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1699023600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "TOKEN",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0000100",
					"maxPrice": "200",
					"minPrice": "0.0000100"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000000"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "100000",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ORDIUSDT",
			"pair": "ORDIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1699360200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ORDI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.001000",
					"maxPrice": "2000",
					"minPrice": "0.001000",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "100000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "5000",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "STEEMUSDT",
			"pair": "STEEMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1699453800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "STEEM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.000100",
					"maxPrice": "200",
					"minPrice": "0.000100",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "1000000",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"maxQty": "10000",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BADGERUSDT",
			"pair": "BADGERUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1699533000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BADGER",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"minPrice": "0.001000",
					"tickSize": "0.001000"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"maxQty": "10000",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ILVUSDT",
			"pair": "ILVUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1699633800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ILV",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.01000",
					"tickSize": "0.01000",
					"maxPrice": "2000"
				},
				{
					"maxQty": "10000",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "200",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "NTRNUSDT",
			"pair": "NTRNUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1699963200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "NTRN",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"minPrice": "0.000100",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.000100"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"minQty": "1",
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MBLUSDT",
			"pair": "MBLUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1699974000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MBL",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0000010",
					"minPrice": "0.0000010"
				},
				{
					"stepSize": "1",
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "100000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "KASUSDT",
			"pair": "KASUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1700186400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "KAS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0000100",
					"maxPrice": "200",
					"tickSize": "0.0000100"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BEAMXUSDT",
			"pair": "BEAMXUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1700227800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BEAMX",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0000010",
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"tickSize": "0.0000010"
				},
				{
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "100000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "1000BONKUSDT",
			"pair": "1000BONKUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1700661600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "1000BONK",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "0.6029500",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0000010",
					"minPrice": "0.0003610"
				},
				{
					"maxQty": "10000000",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"maxQty": "100000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "PYTHUSDT",
			"pair": "PYTHUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1700663400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "PYTH",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"tickSize": "0.0001000",
					"minPrice": "0.0001000",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"maxQty": "1000000",
					"minQty": "1"
				},
				{
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "100000",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SUPERUSDT",
			"pair": "SUPERUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1701003600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SUPER",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0001000",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000"
				},
				{
					"maxQty": "1000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "100000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "USTCUSDT",
			"pair": "USTCUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1701088200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "USTC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"minPrice": "0.0000100",
					"tickSize": "0.0000100",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "1000000",
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"maxQty": "100000",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ONGUSDT",
			"pair": "ONGUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1701090000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ONG",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0001000",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0001000"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000"
				},
				{
					"maxQty": "100000",
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ETHWUSDT",
			"pair": "ETHWUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1701174600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ETHW",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "2000",
					"minPrice": "0.0010000",
					"tickSize": "0.0010000",
					"filterType": "PRICE_FILTER"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "JTOUSDT",
			"pair": "JTOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1702029600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "JTO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.000100",
					"maxPrice": "200",
					"tickSize": "0.000100"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "1000000"
				},
				{
					"maxQty": "10000",
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "1000SATSUSDT",
			"pair": "1000SATSUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1702389600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "1000SATS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.0000010",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0000180",
					"maxPrice": "0.0316400"
				},
				{
					"stepSize": "1",
					"maxQty": "100000000",
					"filterType": "LOT_SIZE",
					"minQty": "1"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AUCTIONUSDT",
			"pair": "AUCTIONUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1702645200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AUCTION",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.010000",
					"maxPrice": "2000",
					"tickSize": "0.010000",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "100000",
					"filterType": "LOT_SIZE",
					"minQty": "0.01",
					"stepSize": "0.01"
				},
				{
					"minQty": "0.01",
					"stepSize": "0.01",
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "1000RATSUSDT",
			"pair": "1000RATSUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1702648800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "1000RATS",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0072800",
					"filterType": "PRICE_FILTER",
					"maxPrice": "12.1410200",
					"tickSize": "0.0000100"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"maxQty": "100000",
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ACEUSDT",
			"pair": "ACEUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1702893600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ACE",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.2520000",
					"tickSize": "0.0001000",
					"filterType": "PRICE_FILTER",
					"maxPrice": "420"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"maxQty": "100000"
				},
				{
					"minQty": "1",
					"stepSize": "1",
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BTCUSDT_240628",
			"pair": "BTCUSDT",
			"contractType": "NEXT_QUARTER",
			"deliveryDate": 1719561600000,
			"onboardDate": 1703491200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BTC",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 1,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "1000000",
					"minPrice": "576.3",
					"tickSize": "0.1"
				},
				{
					"minQty": "0.001",
					"stepSize": "0.001",
					"filterType": "LOT_SIZE",
					"maxQty": "500"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "500",
					"minQty": "0.001",
					"stepSize": "0.001"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.9500",
					"multiplierUp": "1.0500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MOVRUSDT",
			"pair": "MOVRUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1703593800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MOVR",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "5000",
					"minPrice": "0.001000",
					"tickSize": "0.001000",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.01",
					"maxQty": "100000",
					"stepSize": "0.01"
				},
				{
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.01",
					"minQty": "0.01"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "TWTUSDT",
			"pair": "TWTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1703548800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "TWT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 5,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.012500",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.00010",
					"tickSize": "0.00010",
					"filterType": "PRICE_FILTER",
					"maxPrice": "2000"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"stepSize": "0.1"
				},
				{
					"maxQty": "50000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "NFPUSDT",
			"pair": "NFPUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1703680200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "NFP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.30",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0001000",
					"maxPrice": "1000",
					"tickSize": "0.0001000"
				},
				{
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "LOT_SIZE"
				},
				{
					"maxQty": "100000",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ETHUSDT_240628",
			"pair": "ETHUSDT",
			"contractType": "NEXT_QUARTER",
			"deliveryDate": 1719561600000,
			"onboardDate": 1703750400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ETH",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.0500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.05",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "41.10",
					"maxPrice": "100000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.01"
				},
				{
					"minQty": "0.001",
					"filterType": "LOT_SIZE",
					"maxQty": "10000",
					"stepSize": "0.001"
				},
				{
					"stepSize": "0.001",
					"minQty": "0.001",
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.0500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.9500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BTCUSDC",
			"pair": "BTCUSDC",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1704285000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BTC",
			"quoteAsset": "USDC",
			"marginAsset": "USDC",
			"pricePrecision": 1,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.012500",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "500000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.1",
					"minPrice": "0.1"
				},
				{
					"stepSize": "0.001",
					"minQty": "0.001",
					"maxQty": "800",
					"filterType": "LOT_SIZE"
				},
				{
					"maxQty": "100",
					"stepSize": "0.001",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.001"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "100"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ETHUSDC",
			"pair": "ETHUSDC",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1704285300000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ETH",
			"quoteAsset": "USDC",
			"marginAsset": "USDC",
			"pricePrecision": 2,
			"quantityPrecision": 3,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.012500",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.01",
					"maxPrice": "100000",
					"minPrice": "0.01",
					"filterType": "PRICE_FILTER"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.001",
					"stepSize": "0.001",
					"maxQty": "8000"
				},
				{
					"minQty": "0.001",
					"maxQty": "1600",
					"stepSize": "0.001",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "20",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "BNBUSDC",
			"pair": "BNBUSDC",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1704285600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "BNB",
			"quoteAsset": "USDC",
			"marginAsset": "USDC",
			"pricePrecision": 3,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "100000",
					"minPrice": "0.010",
					"tickSize": "0.010",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "0.01",
					"minQty": "0.01",
					"filterType": "LOT_SIZE",
					"maxQty": "80000"
				},
				{
					"maxQty": "1600",
					"stepSize": "0.01",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.01"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "XRPUSDC",
			"pair": "XRPUSDC",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1704286200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "XRP",
			"quoteAsset": "USDC",
			"marginAsset": "USDC",
			"pricePrecision": 4,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.012500",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "100000",
					"tickSize": "0.0001",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.0001"
				},
				{
					"maxQty": "8000000",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"stepSize": "0.1",
					"maxQty": "1600000",
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SOLUSDC",
			"pair": "SOLUSDC",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1704285900000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SOL",
			"quoteAsset": "USDC",
			"marginAsset": "USDC",
			"pricePrecision": 4,
			"quantityPrecision": 2,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "100000",
					"minPrice": "0.1000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0010"
				},
				{
					"maxQty": "800000",
					"stepSize": "0.01",
					"filterType": "LOT_SIZE",
					"minQty": "0.01"
				},
				{
					"minQty": "0.01",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.01",
					"maxQty": "4000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "AIUSDT",
			"pair": "AIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1704717000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "AI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.000010",
					"maxPrice": "200",
					"tickSize": "0.000010",
					"filterType": "PRICE_FILTER"
				},
				{
					"maxQty": "1000000",
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "10000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "XAIUSDT",
			"pair": "XAIUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1704808800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "XAI",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"minPrice": "0.0001000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"stepSize": "1",
					"maxQty": "10000",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DOGEUSDC",
			"pair": "DOGEUSDC",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1705572000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DOGE",
			"quoteAsset": "USDC",
			"marginAsset": "USDC",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.010000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"tickSize": "0.000010",
					"minPrice": "0.000010"
				},
				{
					"filterType": "LOT_SIZE",
					"maxQty": "50000000",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"maxQty": "3000000",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1",
					"minQty": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "WIFUSDT",
			"pair": "WIFUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1705536000000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "WIF",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "1000",
					"tickSize": "0.0001000",
					"minPrice": "0.0001000"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"minQty": "0.1"
				},
				{
					"maxQty": "50000",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "MANTAUSDT",
			"pair": "MANTAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1705586400000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "MANTA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0001000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000",
					"maxPrice": "1000"
				},
				{
					"maxQty": "1000000",
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE"
				},
				{
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "20000",
					"minQty": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ONDOUSDT",
			"pair": "ONDOUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1705755600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ONDO",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"minPrice": "0.0001000",
					"filterType": "PRICE_FILTER",
					"tickSize": "0.0001000"
				},
				{
					"maxQty": "1000000",
					"minQty": "1",
					"stepSize": "1",
					"filterType": "LOT_SIZE"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "250000",
					"minQty": "1",
					"stepSize": "1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "LSKUSDT",
			"pair": "LSKUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1706192100000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "LSK",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"minPrice": "0.001000",
					"tickSize": "0.000100",
					"maxPrice": "2000"
				},
				{
					"minQty": "1",
					"filterType": "LOT_SIZE",
					"stepSize": "1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ALTUSDT",
			"pair": "ALTUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1706191200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ALT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.0000100",
					"tickSize": "0.0000100",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "1",
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000"
				},
				{
					"maxQty": "100000",
					"minQty": "1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ALTUSDT_240130",
			"pair": "ALTUSDT",
			"contractType": "CURRENT_QUARTER",
			"deliveryDate": 1706702400000,
			"onboardDate": 1706616000000,
			"status": "DELIVERING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ALT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.000010",
					"filterType": "PRICE_FILTER",
					"maxPrice": "2000",
					"minPrice": "0.000010"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "100000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "0.1",
					"maxQty": "1000000",
					"stepSize": "0.1"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ALTUSDT_240426",
			"pair": "ALTUSDT",
			"contractType": "NEXT_QUARTER",
			"deliveryDate": 1707357600000,
			"onboardDate": 1706616000000,
			"status": "SETTLING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ALT",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"minPrice": "0.000010",
					"tickSize": "0.000010",
					"maxPrice": "2000",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "0.1",
					"minQty": "0.1",
					"filterType": "LOT_SIZE",
					"maxQty": "100000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "1000000",
					"stepSize": "0.1",
					"minQty": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4",
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "JUPUSDT",
			"pair": "JUPUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1706725800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "JUP",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 7,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "200",
					"tickSize": "0.0001000",
					"minPrice": "0.0001000"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "1",
					"maxQty": "1000000",
					"stepSize": "1"
				},
				{
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE",
					"minQty": "1",
					"maxQty": "10000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"limit": 10,
					"filterType": "MAX_NUM_ALGO_ORDERS"
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "ZETAUSDT",
			"pair": "ZETAUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1706860800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "ZETA",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 0,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.000100",
					"minPrice": "0.000100",
					"maxPrice": "200",
					"filterType": "PRICE_FILTER"
				},
				{
					"stepSize": "1",
					"minQty": "1",
					"maxQty": "1000000",
					"filterType": "LOT_SIZE"
				},
				{
					"maxQty": "10000",
					"minQty": "1",
					"stepSize": "1",
					"filterType": "MARKET_LOT_SIZE"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"notional": "5",
					"filterType": "MIN_NOTIONAL"
				},
				{
					"multiplierUp": "1.1500",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"filterType": "PERCENT_PRICE"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "RONINUSDT",
			"pair": "RONINUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1707193800000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "RONIN",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"maxPrice": "200",
					"tickSize": "0.001000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.001000"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "1000000",
					"minQty": "0.1"
				},
				{
					"minQty": "0.1",
					"stepSize": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"filterType": "PERCENT_PRICE",
					"multiplierUp": "1.1500",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "SUIUSDC",
			"pair": "SUIUSDC",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1707375600000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "SUI",
			"quoteAsset": "USDC",
			"marginAsset": "USDC",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"filterType": "PRICE_FILTER",
					"maxPrice": "20000",
					"tickSize": "0.000100",
					"minPrice": "0.000100"
				},
				{
					"filterType": "LOT_SIZE",
					"minQty": "0.1",
					"stepSize": "0.1",
					"maxQty": "10000000"
				},
				{
					"minQty": "0.1",
					"filterType": "MARKET_LOT_SIZE",
					"stepSize": "0.1",
					"maxQty": "2000000"
				},
				{
					"limit": 200,
					"filterType": "MAX_NUM_ORDERS"
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"multiplierDown": "0.8500",
					"multiplierUp": "1.1500",
					"filterType": "PERCENT_PRICE",
					"multiplierDecimal": "4"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		},
		{
			"symbol": "DYMUSDT",
			"pair": "DYMUSDT",
			"contractType": "PERPETUAL",
			"deliveryDate": 4133404800000,
			"onboardDate": 1707280200000,
			"status": "TRADING",
			"maintMarginPercent": "2.5000",
			"requiredMarginPercent": "5.0000",
			"baseAsset": "DYM",
			"quoteAsset": "USDT",
			"marginAsset": "USDT",
			"pricePrecision": 6,
			"quantityPrecision": 1,
			"baseAssetPrecision": 8,
			"quotePrecision": 8,
			"underlyingType": "COIN",
			"underlyingSubType": [],
			"settlePlan": 0,
			"triggerProtect": "0.1500",
			"liquidationFee": "0.015000",
			"marketTakeBound": "0.15",
			"maxMoveOrderLimit": 10000,
			"filters": [
				{
					"tickSize": "0.001000",
					"maxPrice": "2000",
					"filterType": "PRICE_FILTER",
					"minPrice": "0.001000"
				},
				{
					"filterType": "LOT_SIZE",
					"stepSize": "0.1",
					"minQty": "0.1",
					"maxQty": "1000000"
				},
				{
					"filterType": "MARKET_LOT_SIZE",
					"maxQty": "10000",
					"minQty": "0.1",
					"stepSize": "0.1"
				},
				{
					"filterType": "MAX_NUM_ORDERS",
					"limit": 200
				},
				{
					"filterType": "MAX_NUM_ALGO_ORDERS",
					"limit": 10
				},
				{
					"filterType": "MIN_NOTIONAL",
					"notional": "5"
				},
				{
					"filterType": "PERCENT_PRICE",
					"multiplierDown": "0.8500",
					"multiplierDecimal": "4",
					"multiplierUp": "1.1500"
				}
			],
			"orderTypes": [
				"LIMIT",
				"MARKET",
				"STOP",
				"STOP_MARKET",
				"TAKE_PROFIT",
				"TAKE_PROFIT_MARKET",
				"TRAILING_STOP_MARKET"
			],
			"timeInForce": [
				"GTC",
				"IOC",
				"FOK",
				"GTX",
				"GTD"
			]
		}
	]
}
""";

	@Test
	public void parse() throws IOException {
		double quantity = 900;
		ObjectMapper mapper = new ObjectMapper();
		Symbol[] symbols = mapper.readValue(mapper.readTree(json).get("symbols").traverse(), mapper.getTypeFactory().constructArrayType(Symbol.class));
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
