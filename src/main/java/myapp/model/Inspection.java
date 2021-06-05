package myapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Duration;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //nazwa przeglądu
    @NotBlank (message = "Podaj nazwę")
    private String subject;

    //status (otwarte/anulowane/wykonane/zakończone)
    @ManyToOne
    private Status status;

    //    do jakiej szczegółowej podgrupy/systemu należy
    @ManyToOne
    private Installation installationInspection;

    // data dodania przeglądu
    private LocalDateTime dateAdd;
    private String dateAddString;

    //data rozpoczęcia cyklu

    private LocalDateTime startInspection;

    @NotBlank (message = "Podaj datę rozpoczęcia cyklu")
    private String startInspectionString;


    private String inspectionDuration;

    //data zakończenia cyklu
    private LocalDateTime endInspection;

    @NotBlank (message = "Podaj datę zakończenia cyklu")
    private String endInspectionString;

    //interwał wygenerowania przeglądów (tydzień, miesiąc, kwartał, półrocze, rok)
    @ManyToOne
    private InspectionCycle inspectionCycle;

    //ilość dni przypominających o wykonaniu przeglądu- wyświetli dashboard
    @ManyToOne
    private InspectionType inspectionType;

    //firma/lokalizacja wykonania przeglądu urządzenia
    @ManyToOne
    private Company inspectionCompany;

    //użytkownik dodający przegląd
    @ManyToOne
    private Person ownerPerson;

    //odpowiedzialny użytkownik
    @ManyToOne
    private Person inspectionResponsiblePerson;

    @PrePersist
    public void prePersist() {
        dateAdd = LocalDateTime.now();
    }

//    @Transient
//    public void setEndInspection() {
//        endInspection = startInspection.plusDays(Integer.parseInt(inspectionDuration));
//    }

//    @Transient startInspection.plusDays(1);
//    public void getCycleTime() {
//        if (inspectionCycle.getCycle()==("D")) {
//            startInspection.plusDays(1);
//        } else if (inspectionCycle.getCycle()==("M")) {
//            startInspection.plusMonths(1);
//        } else if (inspectionCycle.getCycle()==("Q")) {
//            startInspection.plusMonths(3);
//        } else if (inspectionCycle.getCycle()==("H")) {
//            startInspection.plusMonths(6);
//        } else if (inspectionCycle.getCycle()==("Y")) {
//            startInspection.plusYears(1);
//        }
//    }


}
