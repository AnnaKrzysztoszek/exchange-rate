package pl.com.bottega.exchangerate.ui;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.exchangerate.api.AdminPanel;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateCommand;

import java.time.LocalDate;

@RestController
public class ExchangeRateController {

	private AdminPanel adminPanel;

	public ExchangeRateController(AdminPanel adminPanel) {
		this.adminPanel = adminPanel;
	}

	@PutMapping("/exchange-rate")
	void exchangeRate(@RequestBody ExchangeRateCommand command) {
		adminPanel.exchangeRate(command);
	}

	@GetMapping("/calculation")
	void getCalculation(@RequestParam @DateTimeFormat(pattern = "YYYY-MM-DD") LocalDate date) {

	}

}
