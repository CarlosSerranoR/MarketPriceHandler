# MarketPriceHandler
Assume line separator for multiple CSV line is: \n

There are two REST methods exposed:

	- price-feed/getLastFeed?instrumentName=GBP/USD : get the last instrumentName price receive 
	- price-feed/recieveFeed  : is used for supply data to system

## Usage

To run the application:

```
mvn spring-boot:run
```

To test the application with data there are two ways:

- Importing in postman

```
{
	"info": {
		"_postman_id": "6d456d51-7798-4ddf-ac50-d688907a2e87",
		"name": "PX Feed test",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "receiveFeed",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\"feed\":\"106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\\n107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002\\n108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002\\n109, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100\\n110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110\"}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/price-feed/recieveFeed",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"price-feed",
						"recieveFeed"
					]
				}
			},
			"response": []
		},
		{
			"name": "getLastFeed?instrumentName=EUR/JPY",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/price-feed/getLastFeed?instrumentName=EUR/JPY",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"price-feed",
						"getLastFeed"
					],
					"query": [
						{
							"key": "instrumentName",
							"value": "EUR/JPY"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "getLastFeed?instrumentName=GBP/USD",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/price-feed/getLastFeed?instrumentName=GBP/USD",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"price-feed",
						"getLastFeed"
					],
					"query": [
						{
							"key": "instrumentName",
							"value": "GBP/USD"
						}
					]
				}
			},
			"response": []
		}
	]
}
```

- Via cURL

```
curl --location --request POST 'http://localhost:8080/price-feed/recieveFeed' \
--header 'Content-Type: application/json' \
--data-raw '{"feed":"106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002\n108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002\n109, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100\n110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110"}'

curl --location --request GET 'http://localhost:8080/price-feed/getLastFeed?instrumentName=EUR/JPY'

curl --location --request GET 'http://localhost:8080/price-feed/getLastFeed?instrumentName=GBP/USD'
```

## Unit test

```
mvn test
```