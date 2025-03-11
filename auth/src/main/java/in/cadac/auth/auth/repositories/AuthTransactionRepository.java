package in.cadac.auth.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cadac.auth.auth.entity.AuthTransactionRecord;

public interface AuthTransactionRepository extends JpaRepository<AuthTransactionRecord, Long>{
	
	public AuthTransactionRecord findByTxn(String txn);
	boolean existsByTxn(String transactionId);

}
