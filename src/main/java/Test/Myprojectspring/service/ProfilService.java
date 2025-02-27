package Test.Myprojectspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Test.Myprojectspring.model.Profil;
import Test.Myprojectspring.repository.ProfilRepository;

@Service
public class ProfilService {

    @Autowired
    private ProfilRepository ProfilRepository;

    public List<Profil> getAllProffils()
    {
        return ProfilRepository.findAll();
    }

    public Optional<Profil> getProfilById(Long id){
        return ProfilRepository.findById(id);
    }

    public Profil saveProfil(Profil profil){
        return ProfilRepository.save(profil);

    }

    public void deleteProfil(Long id){

         ProfilRepository.deleteById(id);
    }
   
}
