package nao.cycledev.currency.conversion.service;

import nao.cycledev.currency.conversion.modal.CurrencyConversionValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name="forex-service", url="localhost:8000")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
