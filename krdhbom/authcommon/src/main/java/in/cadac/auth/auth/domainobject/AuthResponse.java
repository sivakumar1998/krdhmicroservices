package in.cadac.auth.auth.domainobject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import in.cadac.auth.auth.domainobject.signature.Signature;

@JacksonXmlRootElement(localName = "AuthRes")
public class AuthResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JacksonXmlProperty(isAttribute = true, localName = "ret")
	private String ret;
	@JacksonXmlProperty(isAttribute = true, localName = "code")
	private String code;
	@JacksonXmlProperty(isAttribute = true, localName = "txn")
	private String txn;
	@JacksonXmlProperty(isAttribute = true, localName = "err")
	private String err;
	@JacksonXmlProperty(isAttribute = true, localName = "ts")
	private String ts;
	@JacksonXmlProperty(isAttribute = true, localName = "actn")
	private String actn;
	@JacksonXmlProperty(isAttribute = true, localName = "info")
	private String info;
	@JacksonXmlProperty(localName = "BfdRanks",isAttribute = false)
	private BfdRanks bfdRanks;
	@JacksonXmlProperty(localName = "Signature",isAttribute = false)
	private Signature signature;

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTxn() {
		return txn;
	}

	public void setTxn(String txn) {
		this.txn = txn;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getActn() {
		return actn;
	}

	public void setActn(String actn) {
		this.actn = actn;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public BfdRanks getBfdRanks() {
		return bfdRanks;
	}

	public void setBfdRanks(BfdRanks bfdRanks) {
		this.bfdRanks = bfdRanks;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

}
