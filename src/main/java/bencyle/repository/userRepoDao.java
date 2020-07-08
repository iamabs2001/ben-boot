package bencyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import bencyle.Entity.user;

public interface userRepoDao extends JpaRepository<user, Integer> {
	

}
