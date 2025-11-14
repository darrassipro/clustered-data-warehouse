package com.example.fxdeals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FxDealsLogger {

    private static final Logger logger = LoggerFactory.getLogger(FxDealsLogger.class);

    public void logDeal(String dealId, String fromCurrency, String toCurrency, double amount) {
        logger.info("🟢 Deal Imported | ID: {} | From: {} | To: {} | Amount: {}",
                dealId, fromCurrency, toCurrency, amount);
    }

    public void logInfo(String message) {
        logger.info("ℹ️ {}", message);
    }

    public void logError(String message, Exception e) {
        logger.error("❌ {} | Exception: {}", message, e.getMessage());
    }
}
