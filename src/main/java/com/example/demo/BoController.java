package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/backoffice")

public class BoController {

	@GetMapping("/status")
	public String status() {
		return "Backoffice Service is up and running!";
	}

	@GetMapping("/user-status")
	public String getCustomerServiceStatus() {
		// String customerServiceUrl = "http://localhost:8081/api/status";
		String customerServiceUrl = "http://USERSERVICE/user/status";
		return restTemplate.getForObject(customerServiceUrl, String.class);
		// return "Status service call success";
	}

	@Autowired
	private RestTemplate restTemplate;

	private Map<String, String> dataStore = new HashMap<>();

	@PostMapping("/data-save")
	public ResponseEntity<String> createData(@RequestParam String key, @RequestParam String value) {
		dataStore.put(key, value);
		return new ResponseEntity<>("Data created", HttpStatus.CREATED);
	}

	@Autowired
	private RFRepository rfRepository;

	@PostMapping("/bo-save")
	public Rfid createData(@RequestBody Rfid rfid) {
		return rfRepository.save(rfid);
	}
}
