package com.jankowski.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //nazwa firmy
    private String name;

    // typ firmy najemca/obsługa techniczna/ serwis sprzątający/ właściciel
    private String type;


    @OneToMany(mappedBy = "companyPerson")
    private List <Person> companyPersonList;

    @OneToMany (mappedBy = "companyTickets")
    private List <Tickets> companyTicketsList;

    @OneToMany(mappedBy = "companyInspection")
    private List <Inspection> companyInspectionList;

}
