package myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //nazwa przeglądu
    private String name;

    //status (otwarte/anulowane/wykonane/zakończone)
    private String statusInspection;

    //do jakiej podgrupy/systemu należy
//    @ManyToOne
//    private InstallationType installationTypeInspection;

    //do jakiej szczegółowej podgrupy/systemu należy
//    @ManyToOne
//    private Installation installationInspection;

    // data dodania przeglądu
    private LocalDateTime dateAdd;

    //data przeglądu, ustawiana przez ownerPerson
    private LocalDateTime startInspection;

    //data do kiedy mają zostać wygenerowane przeglądy
    private LocalDateTime endInspection;

    //interwał wygenerowania przeglądów (tydzień, miesiąc, kwartał, półrocze, rok)
    private Integer intervalOfInspection;

    //ilość dni przypominających o wykonaniu przeglądu- wyświetli dashboard
    private Duration reminder;

    //firma/lokalizacja wykonania przeglądu urządzenia
    @ManyToOne
    private Company companyInspection;

    //użytkownik dodający przegląd
    @ManyToOne
    private Person ownerPerson;

    //odpowiedzialny użytkownik
    @ManyToOne
    private Person responsibleInspectionPerson;

    @PrePersist
    public void prePersist() {
        dateAdd = LocalDateTime.now();
    }

}
