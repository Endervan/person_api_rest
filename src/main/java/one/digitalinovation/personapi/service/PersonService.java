package one.digitalinovation.personapi.service;


import one.digitalinovation.personapi.dto.MessageResponseDTO;
import one.digitalinovation.personapi.dto.mapper.response.PersonMapper;
import one.digitalinovation.personapi.dto.request.PersonDTO;
import one.digitalinovation.personapi.entities.Person;
import one.digitalinovation.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // gerencia a classe tipo servico para toda regra de negocio da aplicação
public class PersonService {

    private PersonRepository personRepository;

    private  final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // create person
    public MessageResponseDTO create(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Create person with id" + savedPerson.getId())
                .build();
    }


}
