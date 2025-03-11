package in.cadac.auth.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cadac.auth.auth.restconsumers.CryptoClient;

@Service
public class CryptoCaller {
	@Autowired
CryptoClient cryptoclient;
	public String cryptoCaller(String authxml) {
		return cryptoclient.sign2(authxml);
	}
}
