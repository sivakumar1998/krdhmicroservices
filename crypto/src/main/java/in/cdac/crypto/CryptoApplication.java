package in.cdac.crypto;

import java.security.Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safenetinc.luna.provider.LunaProvider;

@SpringBootApplication
public class CryptoApplication {
static {
	Security.addProvider(new LunaProvider());
}
	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);
	}

}
