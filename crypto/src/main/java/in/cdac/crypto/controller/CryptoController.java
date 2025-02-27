package in.cdac.crypto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.crypto.service.CryptoService;

@RestController()
public class CryptoController {
@Autowired
public CryptoService service;
	public String sign(@RequestBody String plainxml) {
		String signedxml=service.dosign(plainxml);
		return signedxml;
	}
	
}
