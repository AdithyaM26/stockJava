package com.stock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StockAnalyzerTest {

	private StockAnalyzer stocks = null;

	@Before
	public void before() {
		stocks = new StockAnalyzer();
	}

	@Test
	public void validStockAAPLAndYear() {
		try {
			String response = stocks.stockInput("AAPL", 2024);
			assertTrue(response != null);
			assertEquals("Successfully caluclated stock prices", response);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void validStockMSFTAndYear() {
		try {
			String response = stocks.stockInput("MSFT", 2023);
			assertTrue(response != null);
			assertEquals("Successfully caluclated stock prices", response);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void validStockNFLXAndYear() {
		try {
			String response = stocks.stockInput("NFLX", 2022);
			assertTrue(response != null);
			assertEquals("Successfully caluclated stock prices", response);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void validStockTSLAAndYear() {
		try {
			String response = stocks.stockInput("TSLA", 2021);
			assertTrue(response != null);
			assertEquals("Successfully caluclated stock prices", response);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void invalidStock() {
		try {
			stocks.stockInput("XYZ", 2024);
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void invalidYear() {
		try {
			stocks.stockInput("AAPL", 2035);
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

}