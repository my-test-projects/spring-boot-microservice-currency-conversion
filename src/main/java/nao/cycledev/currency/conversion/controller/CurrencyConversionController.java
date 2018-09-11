package nao.cycledev.currency.conversion.controller;

import nao.cycledev.currency.conversion.modal.CurrencyConversionValue;
import nao.cycledev.currency.conversion.service.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy exchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionValue convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
                                                        @PathVariable BigDecimal quantity) {

        CurrencyConversionValue response = exchangeServiceProxy.retrieveExchangeValue(from, to);

        return new CurrencyConversionValue(
                response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}
