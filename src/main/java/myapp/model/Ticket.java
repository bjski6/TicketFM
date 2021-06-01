package myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //temat zgłoszenia
    private String subject;

    //opis zgłoszenia
    private String description;

    //status zgłoszenia open/close/suspended
    @ManyToOne
    private TicketStatus ticketStatus;

    //data dodania zgłoszenia
    private LocalDateTime dateAdd;

    private String dateAddString;

    //planowana data wykonania
    private LocalDateTime plannedFinishDate;

    private String dateFromFormString;

    //firma, lokalizacja, kto zgłasza usterkę
    @ManyToOne
    private Company companyTicket;

    @ManyToOne
    private TicketType ticketType;


    //użytkownik dodający zgłoszenie
    @ManyToOne
    private Person personTicket;

    //odpowiedzialny użytkownik
    @ManyToOne
    private Person personResponsibleTicket;

    @ManyToOne
    private Installation installationTicket;

    @PrePersist
    public void prePersist(){
        dateAdd = LocalDateTime.now();
    }

    @Transient
    public void setFormatDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        dateAddString = dtf.format(dateAdd);
    }

    @Transient
    public void setLocalDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        plannedFinishDate = LocalDateTime.parse(dateFromFormString, dtf);
    }


}
