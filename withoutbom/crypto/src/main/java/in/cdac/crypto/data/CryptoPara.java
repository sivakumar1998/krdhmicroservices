package in.cdac.crypto.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "crypto")
public class CryptoPara {
	private String ac;
	private String certIdentifier;
	private String certPath;
	private String certAlias;
	private String certExpiryDate;
	private String certType;
	private String provider;
	private String slotPassword;

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getCertIdentifier() {
		return certIdentifier;
	}

	public void setCertIdentifier(String certIdentifier) {
		this.certIdentifier = certIdentifier;
	}

	public String getCertPath() {
		return certPath;
	}

	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}

	public String getCertAlias() {
		return certAlias;
	}

	public void setCertAlias(String certAlias) {
		this.certAlias = certAlias;
	}

	public String getCertExpiryDate() {
		return certExpiryDate;
	}

	public void setCertExpiryDate(String certExpiryDate) {
		this.certExpiryDate = certExpiryDate;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getSlotPassword() {
		return slotPassword;
	}

	public void setSlotPassword(String slotPassword) {
		this.slotPassword = slotPassword;
	}

}
