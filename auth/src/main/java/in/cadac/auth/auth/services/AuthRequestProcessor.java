package in.cadac.auth.auth.services;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import feign.RetryableException;
import in.cadac.auth.auth.domainobject.AuthRequest;
import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.entity.AuthTransactionRecord;
import in.cadac.auth.auth.error.DuplicateKeyException;
import in.cadac.auth.auth.repositories.AuthTransactionRepository;
import jakarta.validation.Valid;

@Service()
public class AuthRequestProcessor {
	private static final Logger logger = LoggerFactory.getLogger(AuthRequestProcessor.class);
	@Autowired
	private AuthTransactionRepository authrepository;
	@Autowired
	private CryptoCaller cryptocaller;
	@Autowired
	private Environment environment;

	public AuthResponse processRequest(@Valid AuthRequest auth, String clientIP)
			throws RetryableException, DuplicateKeyException {
		// TODO Auto-generated method stub
		if (authrepository.existsByTxn(auth.getTxn())) {
			throw new DuplicateKeyException("Duplicate Transaction Id");
		} else {
			AuthTransactionRecord recordBeforeTransfer = persistBeforeTransfer(auth, clientIP);
			authrepository.save(recordBeforeTransfer);
			try {
				logger.info(auth.getTxn());
				XmlMapper xml = new XmlMapper();
				String requestXml = xml.writeValueAsString(auth);
				String signedxml = cryptocaller.cryptoCaller(requestXml);
				System.err.println(signedxml);

			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return null;
	}

	private AuthTransactionRecord persistBeforeTransfer(AuthRequest auth, String clientIP) {
		AuthTransactionRecord record = new AuthTransactionRecord();
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
		record.setType(getUIDType(auth.getUid()));
		return record;
	}

	protected char getUIDType(String uid) {

		if (uid.length() == Integer.parseInt(environment.getProperty("uidlength"))) {
			return 'A';
		} else if (uid.length() == Integer.parseInt(environment.getProperty("virtualidlength"))) {
			return 'V';
		} else if (uid.length() == Integer.parseInt(environment.getProperty("uidtokenlength"))) {
			return 'T';
		} else {
			// invalid uid type
			return 'I';
		}
	}
}
