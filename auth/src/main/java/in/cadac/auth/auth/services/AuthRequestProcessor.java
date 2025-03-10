package in.cadac.auth.auth.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import in.cadac.auth.auth.domainobject.AuthRequest;
import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.entity.AuthTransactionRecord;
import jakarta.validation.Valid;

@Service()
public class AuthRequestProcessor {

	public AuthResponse processRequest(@Valid AuthRequest auth, String clientIP) {
		// TODO Auto-generated method stub
		AuthTransactionRecord recordBeforeTransfer=	persistBeforeTransfer(auth, clientIP);
		return null;
	}

	private AuthTransactionRecord persistBeforeTransfer(AuthRequest auth, String clientIP) {
		AuthTransactionRecord record=new AuthTransactionRecord();
		record.setTxn(auth.getTxn());
		record.setTid(auth.getTid());
		record.setAc(auth.getAc());
		record.setVer(auth.getVer());
		record.setPi(auth.getUses().getPi());
		record.setPa(auth.getUses().getPa());
		record.setPfa(auth.getUses().getPfa());
		record.setBio(auth.getUses().getBio());
		record.setBt(auth.getUses().getBt());
		record.setPin(auth.getUses().getPin());
		record.setOtp(auth.getUses().getOtp());
		record.setUdc("");
		record.setRdsid(auth.getMeta().getRdsId());
		record.setRdsver(auth.getMeta().getRdsVer());
		record.setDpid(auth.getMeta().getDpId());
		record.setDc(auth.getMeta().getDc());
		record.setMi(auth.getMeta().getMi());
		record.setMc(auth.getMeta().getMc());
		record.setSa(auth.getSa());
		record.setRc(auth.getRc());
		record.setRequest_receipt_time(LocalDateTime.now());
		record.setClient_ip(clientIP);
		record.setLk("");
		record.setClient_lk(auth.getLk());
		record.setCi(auth.getSkey().getCi());
		record.setMacid(auth.getMeta().getUdc());
		return record;
	}

}
