package one.digitalinovation.personapi.entities;
import java.time.LocalDate;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data // inserir getter e setters
@Builder // builder projeto
@AllArgsConstructor // inserir construtores
@NoArgsConstructor // inserir construtores
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera id incremental automatico
    private Long id;

    @Column(nullable = true) // obrigatório
    private  String fistName;

    @Column(nullable = true) // obrigatório
    private  String lastName;

    @Column(nullable = true,unique = true) // obrigatório e unico
    private  String cpf;

    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Phone> phones;
}
