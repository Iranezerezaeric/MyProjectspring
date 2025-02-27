package Test.Myprojectspring.controller;

import Test.Myprojectspring.model.Person;  // Importation de la classe Person, le modèle représentant une personne.
import Test.Myprojectspring.service.PersonService;  // Importation du service qui gère la logique métier pour les personnes.
import org.springframework.beans.factory.annotation.Autowired;  // Annotation pour l'injection de dépendances automatique par Spring.
import org.springframework.http.HttpStatus;  // Importation des statuts HTTP pour les réponses.
import org.springframework.http.ResponseEntity;  // Importation de la classe qui représente une réponse HTTP.
import org.springframework.web.bind.annotation.*;  // Importation des annotations nécessaires pour définir des contrôleurs REST.

import java.util.List;  // Importation de la classe List pour manipuler des listes d'objets.
import java.util.Optional;  // Importation de la classe Optional, utilisée pour gérer les valeurs qui peuvent être nulles.

@RestController  // Annotation pour indiquer que cette classe est un contrôleur REST (gère des requêtes HTTP).
@RequestMapping("/api/persons")  // Définit la route de base pour ce contrôleur. Ici, toutes les routes commencent par /api/persons.
public class PersonController {

    @Autowired  // L'annotation permet d'injecter automatiquement une instance de PersonService dans cette classe.
    private PersonService personService;  // Déclaration de l'instance de PersonService, qui contient la logique métier.

    // Endpoint pour récupérer toutes les personnes
    @GetMapping  // Cette annotation permet de lier cette méthode à une requête HTTP GET sur l'URL "/api/persons".
    public List<Person> getAllPersons() {
        return personService.getAllPersons();  // Appelle la méthode du service pour récupérer toutes les personnes.
    }

    // Endpoint pour récupérer une personne par ID
    @GetMapping("/{id}")  // Cette annotation permet de lier cette méthode à une requête HTTP GET sur l'URL "/api/persons/{id}", où {id} est un paramètre de chemin.
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {  // @PathVariable lie l'ID du chemin à la variable 'id'.
        Optional<Person> person = personService.getPersonById(id);  // Récupère la personne à l'ID spécifié, sous forme d'Optional.
        if (person.isPresent()) {  // Si la personne est présente dans la base de données...
            return ResponseEntity.ok(person.get());  // Retourne la personne avec un statut HTTP 200 (OK).
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Sinon, retourne une réponse avec un statut HTTP 404 (Not Found).
        }
    }

    // Endpoint pour créer ou mettre à jour une personne
    @PostMapping  // Cette annotation permet de lier cette méthode à une requête HTTP POST sur l'URL "/api/persons".
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {  // @RequestBody indique que la personne envoyée dans le corps de la requête sera mappée sur l'objet Person.
        Person savedPerson = personService.savePerson(person);  // Appelle la méthode du service pour créer ou mettre à jour la personne.
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);  // Retourne une réponse avec un statut HTTP 201 (Created) et l'objet de la personne créée.
    }

    // Endpoint pour supprimer une personne
    @DeleteMapping("/{id}")  // Cette annotation permet de lier cette méthode à une requête HTTP DELETE sur l'URL "/api/persons/{id}".
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {  // @PathVariable lie l'ID du chemin à la variable 'id'.
        personService.deletePerson(id);  // Appelle la méthode du service pour supprimer la personne par ID.
        return ResponseEntity.noContent().build();  // Retourne une réponse avec un statut HTTP 204 (No Content), car la suppression ne nécessite pas de contenu dans la réponse.
    }
}
