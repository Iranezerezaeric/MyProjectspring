package Test.Myprojectspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Test.Myprojectspring.model.Profil;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {

    
}
