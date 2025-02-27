package Test.Myprojectspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Test.Myprojectspring.model.Profil;
import Test.Myprojectspring.service.ProfilService;



@RestController
@RequestMapping(path="/api/profil")
public class ProfilController {
    

    @Autowired
    private ProfilService profilService;
     
    @GetMapping
    public List<Profil> getAllProfils(){

        return profilService.getAllProffils();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profil> getProfilById(@PathVariable Long id){
        Optional<Profil> profil = profilService.getProfilById(id);

        if(profil.isPresent()){
            return ResponseEntity.ok(profil.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Profil> saveProfil(@RequestBody Profil profil){
        Profil savedProfil = profilService.saveProfil(profil);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProfil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfil(@PathVariable Long id){
        profilService.deleteProfil(id);
        return ResponseEntity.noContent().build();
    }

    
}
