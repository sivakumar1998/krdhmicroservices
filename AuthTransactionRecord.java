package in.cadac.auth.auth.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "auth_log")
@Table(name = "auth_log",schema = "public")
public class AuthTransactionRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authid")
	private int authid;

	@Column(name = "txn")
	private String txn;

	@Column(name = "tid")
	private String tid;

	@Column(name = "ac")
	private String ac;

	@Column(name = "ver")
	private String ver;

	@Column(name = "pi")
	private String pi;

	@Column(name = "pa")
	private String pa;

	@Column(name = "pfa")
	private String pfa;

	@Column(name = "bio")
	private String bio;

	@Column(name = "bt")
	private String bt;

	@Column(name = "pin")
	private String pin;

	@Column(name = "otp")
	private String otp;

	@Column(name = "res_code")
	private String res_code;

	@Column(name = "udc")
	private String udc;

	@Column(name = "rdsid")
	private String rdsid;

	@Column(name = "rdsver")
	private String rdsver;

	@Column(name = "dpid")
	private String dpid;

	@Column(name = "dc")
	private String dc;

	@Column(name = "mi")
	private String mi;

	@Column(name = "mc")
	private String mc;

	@Column(name = "sa")
	private String sa;

	@Column(name = "rc")
	private String rc;

	@Column(name = "actn")
	private String actn;

	@Column(name = "ret")
	private String ret;

	@Column(name = "err")
	private String err;

	@Column(name = "request_receipt_time")
	private LocalDateTime request_receipt_time;

	@Column(name = "request_forward_time")
	private LocalDateTime request_forward_time;

	@Column(name = "response_receipt_time")
	private LocalDateTime response_receipt_time;

	@Column(name = "response_forward_time")
	private LocalDateTime response_forward_time;

	@Column(name = "packet_response_time")
	private LocalDateTime packet_response_time;

	@Column(name = "client_ip")
	private String client_ip;

	@Column(name = "type")
	private char type;

	@Column(name = "lk")
	private String lk;

	@Column(name = "uid_token")
	private String uid_token;

	@Column(name = "info")
	private String info;

	@Column(name = "server_ip")
	private String server_ip;

	@Column(name = "client_lk")
	private String client_lk;

	@Column(name = "ci")
	private String ci;

	@Column(name = "macid")
	private String macid;

	@Column(name = "reference_no")
	private String reference_no;

	public int getAuthid() {
		return authid;
	}

	public void setAuthid(int authid) {
		this.authid = authid;
	}

	public String getTxn() {
		return txn;
	}

	public void setTxn(String txn) {
		this.txn = txn;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

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

	public String getBt() {
		return bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
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

	public String getRes_code() {
		return res_code;
	}

	public void setRes_code(String res_code) {
		this.res_code = res_code;
	}

	public String getUdc() {
		return udc;
	}

	public void setUdc(String udc) {
		this.udc = udc;
	}

	public String getRdsid() {
		return rdsid;
	}

	public void setRdsid(String rdsid) {
		this.rdsid = rdsid;
	}

	public String getRdsver() {
		return rdsver;
	}

	public void setRdsver(String rdsver) {
		this.rdsver = rdsver;
	}

	public String getDpid() {
		return dpid;
	}

	public void setDpid(String dpid) {
		this.dpid = dpid;
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

	public String getSa() {
		return sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getActn() {
		return actn;
	}

	public void setActn(String actn) {
		this.actn = actn;
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public LocalDateTime getRequest_receipt_time() {
		return request_receipt_time;
	}

	public void setRequest_receipt_time(LocalDateTime request_receipt_time) {
		this.request_receipt_time = request_receipt_time;
	}

	public LocalDateTime getRequest_forward_time() {
		return request_forward_time;
	}

	public void setRequest_forward_time(LocalDateTime request_forward_time) {
		this.request_forward_time = request_forward_time;
	}

	public LocalDateTime getResponse_receipt_time() {
		return response_receipt_time;
	}

	public void setResponse_receipt_time(LocalDateTime response_receipt_time) {
		this.response_receipt_time = response_receipt_time;
	}

	public LocalDateTime getResponse_forward_time() {
		return response_forward_time;
	}

	public void setResponse_forward_time(LocalDateTime response_forward_time) {
		this.response_forward_time = response_forward_time;
	}

	public LocalDateTime getPacket_response_time() {
		return packet_response_time;
	}

	public void setPacket_response_time(LocalDateTime packet_response_time) {
		this.packet_response_time = packet_response_time;
	}

	public String getClient_ip() {
		return client_ip;
	}

	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getLk() {
		return lk;
	}

	public void setLk(String lk) {
		this.lk = lk;
	}

	public String getUid_token() {
		return uid_token;
	}

	public void setUid_token(String uid_token) {
		this.uid_token = uid_token;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getServer_ip() {
		return server_ip;
	}

	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}

	public String getClient_lk() {
		return client_lk;
	}

	public void setClient_lk(String client_lk) {
		this.client_lk = client_lk;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getMacid() {
		return macid;
	}

	public void setMacid(String macid) {
		this.macid = macid;
	}

	public String getReference_no() {
		return reference_no;
	}

	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}

}
