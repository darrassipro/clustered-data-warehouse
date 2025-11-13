package com.example.fxdeals;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class DealService {

    @Autowired
    private DealRepository repository;

    @Autowired
    private FxDealsLogger fxDealsLogger;

    public boolean saveIfNotExists(Deal deal) {
        Optional<Deal> existing = repository.findById(deal.getDealUniqueId());
        if (existing.isPresent()) {
            fxDealsLogger.logInfo("⚠️ Duplicate deal skipped | ID: " + deal.getDealUniqueId());
            return false;
        }
        repository.save(deal);
        fxDealsLogger.logDeal(deal.getDealUniqueId(), deal.getOrderingCurrency(),
                deal.getDeliveryCurrency(), deal.getAmount());
        return true;
    }
}
