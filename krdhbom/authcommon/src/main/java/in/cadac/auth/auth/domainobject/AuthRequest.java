package in.cadac.auth.auth.domainobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import in.cadac.auth.auth.validation.UKCFilter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JacksonXmlRootElement(localName = "Auth")
public class AuthRequest {
	@Pattern(regexp = "^(\\d{12}|\\d{16}|[0-9a-zA-Z/=+\\\\]{72})$", message = "Value must be either 12 or 16 digits, or exactly 72 characters long containing only digits, letters, and the characters /=+\\")
	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message = "uid is mandatory")
	private String uid;

	@JacksonXmlProperty(isAttribute = true)
	@Pattern(regexp = "^[Y]$", message = "Value must be 'Y' or 'N'")
	@NotEmpty(message = "rc is mandatory")
	private String rc;

	@JacksonXmlProperty(isAttribute = true)
	@Pattern(regexp = "^(registered|)$", message = "Value must be 'registered' or empty")
	private String tid;

	@JacksonXmlProperty(isAttribute = true)
	@Pattern(regexp = "^[a-zA-Z0-9]{1,10}$", message = "Value must be an alphanumeric string with a maximum length of 10")
	@NotEmpty(message = "ac is mandatory")
	private String ac;

	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message = "sa is mandatory")
	@Pattern(regexp = "^[a-zA-Z0-9]{1,10}$", message = "Value must be an alphanumeric string with a maximum length of 10")
	private String sa;

	@JacksonXmlProperty(isAttribute = true)
	@Pattern(regexp = "^2\\.5$", message = "Value must be exactly '2.5'")
	@NotEmpty(message = "ver is mandatory")
	private String ver;

	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message = "txn is mandatory")
	@Pattern(regexp = "[a-zA-Z0-9.,\\\\/\\-():]{0,50}$", message = "Value must be an alphanumeric string of maximum length 50, and can include .,\\/-(): but must not start with 'U*:'")
	@UKCFilter(message = "txn should not start with 'U*:'")
	private String txn;

	@JacksonXmlProperty(isAttribute = true)
	@NotEmpty(message = "lk is mandatory")
	@Pattern(regexp = "^[a-zA-Z0-9\\-]{1,64}$", message = "Value must be an alpha-numeric string of 1 to 64 characters.")
	private String lk;

	@JsonProperty("Uses")
	@Valid
	@NotNull(message="Uses is mandatory")
	private Uses uses;

	@JsonProperty("Meta")
	@Valid
	@NotNull(message="Meta is mandatory")
	private Meta meta;

	@JsonProperty("Skey")
	@Valid()
	@NotNull(message="skey should present")
	private Skey skey;
	
	@JsonProperty("Data")
	@Valid()
	@NotNull(message="data should present")
	private Data data;

	@JsonProperty("Hmac")
	@Valid()
	@NotNull()
	private Hmac hmac;

	
	

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getTxn() {
		return txn;
	}

	public void setTxn(String txn) {
		this.txn = txn;
	}

	public String getLk() {
		return lk;
	}

	public void setLk(String lk) {
		this.lk = lk;
	}

	public String getSa() {
		return sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
	}

	public Uses getUses() {
		return uses;
	}

	public void setUses(Uses uses) {
		this.uses = uses;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Skey getSkey() {
		return skey;
	}

	public void setSkey(Skey skey) {
		this.skey = skey;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Hmac getHmac() {
		return hmac;
	}

	public void setHmac(Hmac hmac) {
		this.hmac = hmac;
	}

	@Override
	public String toString() {
		return "AuthRequest [uid=" + uid + ", rc=" + rc + ", tid=" + tid + ", ac=" + ac + ", sa=" + sa + ", ver=" + ver
				+ ", txn=" + txn + ", lk=" + lk + ", uses=" + uses + ", meta=" + meta + ", skey=" + skey + ", data="
				+ data + ", hmac=" + hmac + "]";
	}

	

	
	

	
}
