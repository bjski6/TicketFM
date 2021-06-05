package myapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 12)
    private String name;

    @Size(max = 16)
    private String surname;

    @Email
    private String email;

    @NotBlank
    private String password;

    @Size(max = 11)
    private String phoneNumber;

    //firma
    @ManyToOne
    private Company companyPerson;

    // uprawnienia admin/user/superUser/guest
    @ManyToOne
    private PersonPermissions personPermissions;

    //lista zgłoszeń/ticketów użytkownika
    @OneToMany(mappedBy = "personTicket")
    private List<Ticket> ticketList;

    // lista przeglądów dodanych przez użytkownika
    @OneToMany(mappedBy = "ownerPerson")
    private List<Inspection> ownerPersonList;

    //lista przeglądów za które odpowiedzialny jest użytkownik
    @OneToMany(mappedBy = "inspectionResponsiblePerson")
    private List<Inspection> responsibleInspectionPersonList;

    //lista zgłoszeń za które odpowiedzialny jest użytkownik
    @OneToMany(mappedBy = "personResponsibleTicket")
    private List<Ticket> responsibleTicketPersonList;

    @Override
    public String toString() {
        return name + ' ' + surname;
    }

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getNameAndSurname() {
        return name + " " + surname;

    }
}
