package one.digitalinovation.personapi.controllers;


import one.digitalinovation.personapi.dto.MessageResponseDTO;
import one.digitalinovation.personapi.entities.Person;
import one.digitalinovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // instruir code 201
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.create(person);
    }


}
