package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.commands.ExchangeRateCommand;

public interface AdminPanel {

	void exchangeRate(ExchangeRateCommand command);
}
