package pl.com.bottega.exchangerate.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.com.bottega.exchangerate.api.AdminPanel;
import pl.com.bottega.exchangerate.api.StandardAdminPanel;
import pl.com.bottega.exchangerate.domain.ExchangeRateRepository;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	ExchangeRateRepository exchangeRateRepository() {
		return new JPAExchangeRepository();
	}

	@Bean
	public AdminPanel adminPanel(ExchangeRateRepository exchangeRateRepository) {
		return new StandardAdminPanel(exchangeRateRepository);
	}

}
