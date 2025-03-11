package in.cdac.crypto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.crypto.data.CryptoPara;
import in.cdac.crypto.service.CryptoService;

@RestController()
@RequestMapping(value = "crypto")
public class CryptoController {
	private static final Logger logger = LoggerFactory.getLogger(CryptoController.class);
	@Autowired
	public CryptoService service;
	@Autowired
	private CryptoPara para;

	@PostMapping("/sign")
	public String sign(@RequestBody String plainxml) {
		String signedxml = service.signing(plainxml);
		logger.info(signedxml);
		return signedxml;
	}

	@GetMapping("/test")
	public CryptoPara getparameters() {
		return para;
	}
	@PostMapping("/signlocal")
	public String sign2(@RequestBody String plainxml) {
//		String signedxml = service.signing(plainxml);
		
//		logger.info(signedxml);
		return plainxml+"<signed/>";
	}
}
