package com.example.fxdeals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.CSVReader;
import java.io.InputStreamReader;
import java.util.*;

@RestController
@RequestMapping("/api/import")
public class CsvImportController {

    @Autowired
    private DealService service;

    @PostMapping("/csv")
    public Map<String, Object> importCsv(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        List<String> errors = new ArrayList<>();
        int processed = 0, saved = 0;

        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] line;
            reader.readNext(); // skip header
            while ((line = reader.readNext()) != null) {
                processed++;
                if (line.length != 5) {
                    errors.add("Row " + processed + ": invalid column count");
                    continue;
                }
                try {
                    Deal deal = new Deal();
                    deal.setDealUniqueId(line[0]);
                    deal.setOrderingCurrency(line[1]);
                    deal.setDeliveryCurrency(line[2]);
                    deal.setDealTimestamp(line[3]);
                    deal.setAmount(Double.parseDouble(line[4]));
                    boolean savedOk = service.saveIfNotExists(deal);
                    if (savedOk) saved++;
                    else errors.add("Duplicate deal: " + line[0]);
                } catch (Exception e) {
                    errors.add("Row " + processed + " error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            result.put("error", e.getMessage());
            return result;
        }

        result.put("processedRows", processed);
        result.put("savedRows", saved);
        result.put("errors", errors);
        return result;
    }
}
