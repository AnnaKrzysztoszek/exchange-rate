package pl.com.bottega.exchangerate.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Calculation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String from;
	private String to;
	private BigDecimal calculatedAmount;
	private LocalDate date;

	public Calculation(String from, String to, BigDecimal calculatedAmount, LocalDate date) {
		this.from = from;
		this.to = to;
		this.calculatedAmount = calculatedAmount;
		this.date = date;
	}

	Calculation calculateFromTo(String from, String to, BigDecimal amount, ExchangeRate exchangeRate) {
		if (from.equals("PLN"))
			calculatedAmount = amount.divide(exchangeRate.getRate());
		if (to.equals("PLN"))
			calculatedAmount = amount.multiply(exchangeRate.getRate());
		if (from == to)
			throw new IllegalStateException("can not calculate to equals currency");

		return new Calculation(from, to, calculatedAmount, date);
	}
}
