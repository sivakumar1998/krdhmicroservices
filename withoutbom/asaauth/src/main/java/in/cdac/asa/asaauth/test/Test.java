package in.cdac.asa.asaauth.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test {
	@Value("${uidai_auth_url}")
	private String url;
	@Value("${asa_lk}")
	private String asalk;
	@Value("${ac}")
	private String ac;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAsalk() {
		return asalk;
	}
	public void setAsalk(String asalk) {
		this.asalk = asalk;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	@Override
	public String toString() {
		return "Test [url=" + url + ", asalk=" + asalk + ", ac=" + ac + "]";
	}
	
	
}
