package myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //nazwa urządzenia
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    // model
    @Size(min = 2, max = 30)
    private String model;

    //numer seryjny
    @Size (max = 20)
    private String serialNo;

    //producent, w przyszłości dodawany do listy rozwijanej,
    @Size(min = 2, max = 30)
    private String manufacturer;


    @ManyToOne
    private Installation installation;

    //do jakiej podgrupy/systemu należy  relacje jednokierunkowe
//    @ManyToOne
//    private InstallationType installationTypeEquipment;

//    @ManyToOne
//    private Installation installationEquipment;

    // w użyciu/zdemontowane  running / dismounted
    @ManyToOne
    private StatusEq statusEq;

}
