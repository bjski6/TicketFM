package myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //temat zgłoszenia
    private String subject;

    //opis zgłoszenia
    private String description;

    //status zgłoszenia open/close/suspended
    private String status;

    //do jakiej podgrupy/systemu należy
//    @ManyToOne
//    private InstallationType installationTypeTickets;

    //do jakiej szczegółowej podgrupy/systemu należy
//    @ManyToOne
//    private InstallationType installationTickets;

    //data dodania zgłoszenia
    private LocalDateTime dateAdd;

    //planowana data wykonania
    private LocalDateTime plannedFinish;

    //firma, lokalizacja, kto zgłasza usterkę
    @ManyToOne
    private Company companyTickets;

    //użytkownik dodający zgłoszenie
    @ManyToOne
    private Person personTicket;

    //odpowiedzialny użytkownik
    @ManyToOne
    private Person responsibleTicketPerson;

    @PrePersist
    public void prePersist(){
        dateAdd = LocalDateTime.now();
    }
}
