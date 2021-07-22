package myapp.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Wpisz temat zgłoszenia")
    private String subject;

    private String description;

    @ManyToOne
    private Status status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAdd;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate plannedFinishDate;

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
    public void prePersist() {
        dateAdd = LocalDate.now();
    }

    @Transient
    public void setFormatDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    }

    @Transient
    public void setLocalDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    }


}
