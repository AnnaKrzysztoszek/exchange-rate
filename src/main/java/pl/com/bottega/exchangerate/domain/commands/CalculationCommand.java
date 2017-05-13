package pl.com.bottega.exchangerate.domain.commands;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Objects.isNull;

public class CalculationCommand implements Validatable {

	private static final String REQUIRED_FIELD = "is a required field and cannot be blank";
	private static final String NEGATIVE_AMOUNT = "amount can not be less than zero";

	private String from;
	private String to;
	private BigDecimal calculatedAmount;
	private LocalDate date;

	public CalculationCommand() {
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public void validate(ValidationErrors errors) {
		if (from == null || from.isEmpty() || from.trim().equals(""))
			errors.add("from", REQUIRED_FIELD);
		if (to == null || to.isEmpty() || to.trim().equals(""))
			errors.add("to", REQUIRED_FIELD);
		if (isNull(calculatedAmount))
			errors.add("rate", REQUIRED_FIELD);

		if (calculatedAmount.compareTo(BigDecimal.ZERO) < 0)
			errors.add("negative amount", NEGATIVE_AMOUNT);
	}
}
