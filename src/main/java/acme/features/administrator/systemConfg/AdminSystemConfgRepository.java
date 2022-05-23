package acme.features.administrator.systemConfg;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.components.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdminSystemConfgRepository extends AbstractRepository{

	@Query("SELECT sc from SystemConfiguration sc")
	SystemConfiguration findSystemConfiguration();
	
	@Query("SELECT s from Spam s WHERE s.strong = true")
	List<String> findStrongSpamWords();
	
	@Query("SELECT s from Spam s WHERE s.strong = false")
	List<String> findWeakSpamWords();
	
	@Query("SELECT s from Spam s WHERE s.threshold = 10")
	List<String> findStrongSpamThreshold();
	
	@Query("SELECT s from Spam s WHERE s.threshold = 25")
	List<String> findWeakSpamThreshold();	

}
