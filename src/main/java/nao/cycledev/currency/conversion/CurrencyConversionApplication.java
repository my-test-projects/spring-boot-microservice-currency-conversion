package nao.cycledev.currency.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("nao.cycledev.currency.conversion.service")
@SpringBootApplication
public class CurrencyConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionApplication.class, args);
    }
}
