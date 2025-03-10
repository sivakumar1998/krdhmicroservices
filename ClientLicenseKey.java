package in.cadac.auth.auth.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "client_license_keys", schema = "public")
public class ClientLicenseKey {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private int dept_id;

	@Column(name = "ac")
	private String ac;

	@Column(name = "client_lk")
	private String client_lk;

	@Column(name = "is_active")
	private boolean is_active;

	@Column(name = "valid_till")
	private LocalDate valid_till;

	@Column(name = "license_type")
	private String license_type;

	@Column(name = "description")
	private String description;

	@Column(name = "creation_timestamp")
	private LocalDateTime creation_timestamp;

	@Column(name = "deptis_otp_allowed_id")
	private boolean is_otp_allowed;

	@Column(name = "is_auth_allowed")
	private boolean is_auth_allowed;

	@Column(name = "is_kyc_allowed")
	private boolean is_kyc_allowed;

	@Column(name = "is_bfd_allowed")
	private boolean is_bfd_allowed;

	@Column(name = "username")
	private String username;

	@Column(name = "sa")
	private String sa;

	@Column(name = "update_by")
	private String update_by;

	@Column(name = "update_timestamp")
	private LocalDateTime update_timestamp;

	@Column(name = "is_token_allowed")
	private boolean is_token_allowed;

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getClient_lk() {
		return client_lk;
	}

	public void setClient_lk(String client_lk) {
		this.client_lk = client_lk;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public LocalDate getValid_till() {
		return valid_till;
	}

	public void setValid_till(LocalDate valid_till) {
		this.valid_till = valid_till;
	}

	public String getLicense_type() {
		return license_type;
	}

	public void setLicense_type(String license_type) {
		this.license_type = license_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreation_timestamp() {
		return creation_timestamp;
	}

	public void setCreation_timestamp(LocalDateTime creation_timestamp) {
		this.creation_timestamp = creation_timestamp;
	}

	public boolean isIs_otp_allowed() {
		return is_otp_allowed;
	}

	public void setIs_otp_allowed(boolean is_otp_allowed) {
		this.is_otp_allowed = is_otp_allowed;
	}

	public boolean isIs_auth_allowed() {
		return is_auth_allowed;
	}

	public void setIs_auth_allowed(boolean is_auth_allowed) {
		this.is_auth_allowed = is_auth_allowed;
	}

	public boolean isIs_kyc_allowed() {
		return is_kyc_allowed;
	}

	public void setIs_kyc_allowed(boolean is_kyc_allowed) {
		this.is_kyc_allowed = is_kyc_allowed;
	}

	public boolean isIs_bfd_allowed() {
		return is_bfd_allowed;
	}

	public void setIs_bfd_allowed(boolean is_bfd_allowed) {
		this.is_bfd_allowed = is_bfd_allowed;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSa() {
		return sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public LocalDateTime getUpdate_timestamp() {
		return update_timestamp;
	}

	public void setUpdate_timestamp(LocalDateTime update_timestamp) {
		this.update_timestamp = update_timestamp;
	}

	public boolean isIs_token_allowed() {
		return is_token_allowed;
	}

	public void setIs_token_allowed(boolean is_token_allowed) {
		this.is_token_allowed = is_token_allowed;
	}

}
