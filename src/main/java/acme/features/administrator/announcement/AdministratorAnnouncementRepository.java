package acme.features.administrator.announcement;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;

import acme.entities.Announcement;
import acme.framework.repositories.AbstractRepository;

public interface AdministratorAnnouncementRepository extends AbstractRepository{

	@Query("SELECT a FROM Announcement a WHERE a.id = :id")
	Announcement findAnnouncementById(int id);

	@Query("SELECT a FROM Announcement a WHERE a.creationMoment > :deadline")
	Collection<Announcement> findLastAnnouncements(Date deadline);
	
	@Query("SELECT a FROM Announcement a")
	Collection<Announcement> findAllAnnouncements();
	
}