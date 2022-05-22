package acme.features.administrator.systemConfg;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.components.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdminSystemConfgRepository extends AbstractRepository{

	@Query("SELECT sc from SystemConfiguration sc")
	SystemConfiguration findSystemConfiguration();
	
}
