package in.cadac.auth.auth.restconsumers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cryptoservice", url = "http://localhost:8081")
public interface CryptoClient {

	@PostMapping(value = "crypto/signlocal")
	public String sign2(String dataTobeSigned);
}
