package pl.com.bottega.exchangerate.domain.commands;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;

public class ExchangeRateCommand implements Validatable {

	private static final String REQUIRED_FIELD = "is a required field and cannot be blank";
	private static final String WRONG_CURRENCY = "has invalid format";
	private static final String NEGATIVE_RATE = "must be > than 0.0";

	private LocalDate date;
	private String currency;
	private BigDecimal rate;

	public ExchangeRateCommand() {
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public void validate(ValidationErrors errors) {
		validateDate(errors);
		validateCurrency(errors);
		validateRate(errors);
	}

	private void validateRate(ValidationErrors errors) {
		if (isNull(rate))
			errors.add("rate", REQUIRED_FIELD);

		if (!isNull(rate) && rate.compareTo(BigDecimal.ZERO) < 0)
			errors.add("rate", NEGATIVE_RATE);
	}

	private void validateDate(ValidationErrors errors) {
		if (date == null)
			errors.add("date", REQUIRED_FIELD);
	}

	private void validateCurrency(ValidationErrors errors) {
		if (currency == null || currency.isEmpty() || currency.trim().equals(""))
			errors.add("currency", REQUIRED_FIELD);

		if (currency.length() != 3)
			errors.add("currency", WRONG_CURRENCY);
	}
}
