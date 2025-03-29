package in.cadac.auth.auth.domainobject;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JacksonXmlRootElement(localName = "Uses")
public class Uses implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message = "pi is mandatory")
	@Pattern(regexp = "^[yn]$", message = "Value must be 'y' or 'n'")
	private String pi;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message = "pa is mandatory")
	@Pattern(regexp = "^[yn]$", message = "Value must be 'y' or 'n'")
	private String pa;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message = "pfa should not be empty")
	@Pattern(regexp = "^[yn]$", message = "Value must be 'y' or 'n'")
	private String pfa;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message = "bio is mandatory")
	@Pattern(regexp = "^[yn]$", message = "Value must be 'y' or 'n'")
	private String bio;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotNull(message = "bt is mandatory")
	@Pattern(regexp = "^$|^(FMR|FIR|IIR|FMR,FIR)$", message = "Value must be '' or 'FMR,FIR' or 'FMR' or 'FIR' or 'IIR'")
	private String bt;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message="pin is mandatory")
	@Pattern(regexp = "^[yn]$", message = "Value must be 'y' or 'n'")
	private String pin;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message = "otp is mandatory")
	@Pattern(regexp = "^[yn]$", message = "Value must be 'y' or 'n'")
	private String otp;
	
	
	public String getPi() {
		return pi;
	}
	public void setPi(String pi) {
		this.pi = pi;
	}
	public String getPa() {
		return pa;
	}
	public void setPa(String pa) {
		this.pa = pa;
	}
	public String getPfa() {
		return pfa;
	}
	public void setPfa(String pfa) {
		this.pfa = pfa;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	@Override
	public String toString() {
		return "Uses [pi=" + pi + ", pa=" + pa + ", pfa=" + pfa + ", bio=" + bio + ", bt=" + bt + ", pin=" + pin
				+ ", otp=" + otp + "]";
	}
	
	

}
