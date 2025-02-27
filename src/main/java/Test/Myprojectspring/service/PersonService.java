package Test.Myprojectspring.service;

import Test.Myprojectspring.model.Person;  // Importation du modèle Person, représentant une personne.
import Test.Myprojectspring.repository.PersonRepository;  // Importation de l'interface repository qui permet de communiquer avec la base de données.
import org.springframework.beans.factory.annotation.Autowired;  // Annotation pour l'injection automatique des dépendances.
import org.springframework.stereotype.Service;  // Annotation pour indiquer que cette classe est un service dans Spring.

import java.util.List;  // Importation de la classe List, utilisée pour manipuler des collections de personnes.
import java.util.Optional;  // Importation de la classe Optional, pour gérer des résultats qui peuvent être nulls.

@Service  // L'annotation @Service indique que cette classe est un service Spring. C'est un composant qui contient la logique métier de l'application.
public class PersonService {

    @Autowired  // L'annotation @Autowired permet l'injection automatique de l'instance de PersonRepository.
    private PersonRepository personRepository;  // Déclaration de l'instance de PersonRepository qui sera utilisée pour accéder aux données dans la base.

    // Méthode pour récupérer toutes les personnes
    public List<Person> getAllPersons() {
        return personRepository.findAll();  // Appelle la méthode findAll() du repository pour récupérer toutes les personnes de la base de données.
    }

    // Méthode pour récupérer une personne par son ID
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);  // Appelle la méthode findById() du repository pour récupérer une personne par son ID.
        // Le résultat est renvoyé sous la forme d'un Optional pour gérer les cas où la personne n'existe pas.
    }

    // Méthode pour ajouter ou mettre à jour une personne
    public Person savePerson(Person person) {
        return personRepository.save(person);  // Appelle la méthode save() du repository pour enregistrer la personne dans la base de données.
        // Si la personne existe déjà, elle sera mise à jour, sinon une nouvelle personne sera créée.
    }

    // Méthode pour supprimer une personne par son ID
    public void deletePerson(Long id) {
        personRepository.deleteById(id);  // Appelle la méthode deleteById() du repository pour supprimer la personne de la base de données par son ID.
    }
}
