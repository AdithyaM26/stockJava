package com.stock;

import java.io.BufferedReader;
import java.io.FileReader;

public class StockAnalyzer {

	public ResuorceObject maxProfit(String stockName, int year) throws Exception {
		String csvFile = stockName.toUpperCase() + ".csv";
		double minPrice = Double.MAX_VALUE;
		double maxProfit = 0.0;
		ResuorceObject ro = new ResuorceObject();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if(data.length!=7) {
					throw new Exception("Invalid stock data");
				}
				String date = data[0];
				int dataYear = Integer.parseInt(date.split("-")[0]);
				if (dataYear == year) {
					double currentPrice = Double.parseDouble(data[4]); // Closing price
					if (currentPrice < minPrice) {
						minPrice = currentPrice;
						ro.setBuyDate(date);
						ro.setBuyPrice(currentPrice);
					} else {
						double profit = currentPrice - minPrice;
						if (profit > maxProfit) {
							maxProfit = profit;
							ro.setSellDate(date);
							ro.setSellPrice(currentPrice);
						}
					}
				}
			}
		}

		if (ro.getBuyDate()==null) {
			throw new Exception("No data found for the specified year.");
		}
		ro.setProfit(maxProfit);
		return ro;
	}

	public String stockInput(String stockName, int year) throws Exception {
		try {
			ResuorceObject ro = maxProfit(stockName, year);
			if (ro != null) {
				System.out.println("Max Profit Information:");
				if (ro.getBuyDate() != null) {
					System.out.println("Buy date: " + ro.getBuyDate());
				}
				if (ro.getBuyPrice() != 0.0) {
					System.out.println("Buy price: " + ro.getBuyPrice());
				}
				if (ro.getSellDate() != null) {
					System.out.println("Sell date: " + ro.getSellDate());
				}
				if (ro.getSellPrice() != 0.0) {
					System.out.println("Sell price: " + ro.getSellPrice());
				}
				if (ro.getProfit() != 0.0) {
					System.out.println("Profit:  " + ro.getProfit());
				}

			}
		} catch (Exception e) {
			throw new Exception("Error reading stock data: " + e.getMessage());
		}
		return "Successfully caluclated stock prices";
	}

	public static void main(String[] args) throws Exception {
		StockAnalyzer stocks = new StockAnalyzer();
		stocks.stockInput("AAPL", 2024);// Replace with the desired stock code and year
	}

}
