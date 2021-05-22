package com.jankowski.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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
    private String name;

    // model
    private String model;

    //numer seryjny
    private String serialNo;

    //producent, w przyszłości dodawany do listy rozwijanej,
    private String manufacturer;

    //do jakiej podgrupy/systemu należy  relacje jednokierunkowe
    @ManyToOne
    private InstallationType installationTypeEquipment;

    @ManyToOne
    private Installation installationEquipment;

    // w użyciu/zdemontowane  running / dismounted
    private String status;

}
