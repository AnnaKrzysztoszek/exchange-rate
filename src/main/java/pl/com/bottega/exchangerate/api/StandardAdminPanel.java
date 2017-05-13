package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRateRepository;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateCommand;

public class StandardAdminPanel implements AdminPanel {

	private ExchangeRateRepository exchangeRateRepository;

	public StandardAdminPanel(ExchangeRateRepository exchangeRateRepository) {
		this.exchangeRateRepository = exchangeRateRepository;
	}

	@Override
	public void exchangeRate(ExchangeRateCommand command) {
		ExchangeRate exchangeRate = new ExchangeRate(command.getDate(), command.getCurrency(), command.getRate());
		exchangeRateRepository.put(exchangeRate);
	}

}
