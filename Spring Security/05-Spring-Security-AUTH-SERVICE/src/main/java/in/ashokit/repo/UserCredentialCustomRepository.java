package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.UserCredential;

public interface UserCredentialCustomRepository extends JpaRepository<UserCredential, Integer> {

	
	public UserCredential findByName(String name);
}
