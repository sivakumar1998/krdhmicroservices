package in.cadac.auth.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auth")
public class Config {

	public String getCryptoUrl() {
		return cryptoUrl;
	}

	public void setCryptoUrl(String cryptoUrl) {
		this.cryptoUrl = cryptoUrl;
	}

	private String cryptoUrl;

}
