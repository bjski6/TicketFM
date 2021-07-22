package myapp.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.Duration;
import java.time.LocalDate;
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
    @NotBlank(message = "Podaj nazwę")
    private String subject;

    //status (otwarte/anulowane/wykonane/zakończone)
    @ManyToOne
    private Status status;

    //    do jakiej szczegółowej podgrupy/systemu należy
    @ManyToOne
    private Installation installationInspection;

    // data dodania przeglądu
    private LocalDate dateAdd;

    // private String dateAddString;

    //data rozpoczęcia cyklu


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startInspection;

//    @NotBlank (message = "Podaj datę rozpoczęcia cyklu")
//    private String startInspectionString;


    private Long inspectionDuration;

    //data zakończenia przeglądu
    private LocalDate endInspection;

//    @NotBlank(message = "Podaj datę zakończenia cyklu")
//    private String endInspectionString;

//    //interwał wygenerowania przeglądów (tydzień, miesiąc, kwartał, półrocze, rok)
    @ManyToOne
    private InspectionCycle inspectionCycle;

    //ilość dni przypominających o wykonaniu przeglądu- wyświetli dashboard
//    @ManyToOne
//    private InspectionType inspectionType;

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
        dateAdd = LocalDate.now();
    }

    @Transient
    public void endInspection() {
        endInspection = startInspection.plusDays(inspectionDuration);
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
