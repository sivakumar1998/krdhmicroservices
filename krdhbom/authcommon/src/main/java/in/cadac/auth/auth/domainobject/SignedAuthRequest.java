package in.cadac.auth.auth.domainobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import in.cadac.auth.auth.domainobject.signature.Signature;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


public class SignedAuthRequest extends AuthRequest {
	@JacksonXmlElementWrapper(useWrapping = true)
	@NotNull(message = "signature is must for signed xml")
	@JsonProperty("Signature")
	private Signature signature;

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

	public void setAuthreqdata(@Valid AuthRequest auth) {
		this.setAc(auth.getAc());
		this.setData(auth.getData());
		this.setHmac(auth.getHmac());
		this.setLk(auth.getLk());
		this.setMeta(auth.getMeta());
		this.setRc(auth.getRc());
		this.setSa(auth.getSa());
		this.setSkey(auth.getSkey());
		this.setTid(auth.getTid());
		this.setTxn(auth.getTxn());
		this.setUid(auth.getUid());
		this.setUses(auth.getUses());
		this.setVer(auth.getVer());
	}

	@Override
	public String toString() {
		return "SignedRequest [signature=" + signature + "]";
	}

	

	
	
}
