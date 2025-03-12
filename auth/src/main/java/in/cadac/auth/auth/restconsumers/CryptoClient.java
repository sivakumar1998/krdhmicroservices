package in.cadac.auth.auth.restconsumers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "crypto")
public interface CryptoClient {

	@PostMapping(value = "crypto/sign")
	public String sign2(String dataTobeSigned);
}
