package acme.features.administrator.systemConfg;




import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.components.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdminSystemConfgRepository extends AbstractRepository{

	@Query(value="SELECT c FROM SystemConfiguration c WHERE c.id = :id", nativeQuery=true)
	SystemConfiguration findOneSystemConfiguration(int id);
	
}
