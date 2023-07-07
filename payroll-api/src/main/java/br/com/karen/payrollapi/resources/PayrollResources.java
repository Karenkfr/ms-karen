package br.com.karen.payrollapi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.karen.payrollapi.domain.Payroll;
import br.com.karen.payrollapi.domain.User;
import br.com.karen.payrollapi.feignClients.UserFeign;
import br.com.karen.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/payments")

@RequiredArgsConstructor
public class PayrollResources {
	

	private final UserFeign userFeign;
	private final PayrollService payrollService;
	
	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
		
		User user = userFeign.findById(workerId).getBody();
		return ResponseEntity.ok().body(payrollService.getPayment(workerId, payment));
	}

}
