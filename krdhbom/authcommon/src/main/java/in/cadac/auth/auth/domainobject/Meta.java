package in.cadac.auth.auth.domainobject;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JacksonXmlRootElement(localName = "Meta")
public class Meta {
	@JacksonXmlProperty(isAttribute = true)
//	@NotEmpty(message = "udc is mandatory")
	 @Pattern(regexp = "^([0-9A-Fa-f]{2}-){5}[0-9A-Fa-f]{2}$", message = "Invalid udc format. Expected format: XX-XX-XX-XX-XX-XX")
	private String udc;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotNull(message = "dpId should be blank for non-bio metric tranactions")
	private String dpId;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotNull(message = "rdsId should be blank for non-bio metric tranactions")
	private String rdsId;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotNull(message = "rdsVer should be blank for non-bio metric tranactions")
	@NotNull
	private String rdsVer;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotNull(message = "dc should be blank for non-bio metric tranactions")
	private String dc;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotNull(message = "mi should be blank for non-bio metric tranactions")
	private String mi;
	
	@JacksonXmlProperty(isAttribute = true)
	@NotNull(message = "mc should be blank for non-bio metric tranactions")
	private String mc;
	
	public String getUdc() {
		return udc;
	}
	public void setUdc(String udc) {
		this.udc = udc;
	}
	public String getDpId() {
		return dpId;
	}
	public void setDpId(String dpId) {
		this.dpId = dpId;
	}
	public String getRdsId() {
		return rdsId;
	}
	public void setRdsId(String rdsId) {
		this.rdsId = rdsId;
	}
	public String getRdsVer() {
		return rdsVer;
	}
	public void setRdsVer(String rdsVer) {
		this.rdsVer = rdsVer;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public String getMi() {
		return mi;
	}
	public void setMi(String mi) {
		this.mi = mi;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	@Override
	public String toString() {
		return "Meta [udc=" + udc + ", dpId=" + dpId + ", rdsId=" + rdsId + ", rdsVer=" + rdsVer + ", dc=" + dc
				+ ", mi=" + mi + ", mc=" + mc + "]";
	}
	
	
}
