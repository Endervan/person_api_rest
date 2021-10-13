package one.digitalinovation.personapi.service;


import one.digitalinovation.personapi.dto.MessageResponseDTO;
import one.digitalinovation.personapi.entities.Person;
import one.digitalinovation.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service // gerencia a classe tipo servico para toda regra de negocio da aplicação
public class PersonService {

    private PersonRepository  personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // create person
    public MessageResponseDTO create(Person person) {
        Person savedPerson =  personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Create person with id"+ savedPerson.getId())
                .build();
    }


}
