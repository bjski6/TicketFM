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
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String phoneNumber;

    //firma
    @ManyToOne
    private Company companyPerson;

    // uprawnienia admin/user/superUser/guest
    private String permission;

    //lista zgłoszeń/ticketów użytkownika
    @OneToMany(mappedBy = "personTicket")
    private List <Tickets> ticketsList;

    // lista przeglądów dodanych przez użytkownika
    @OneToMany(mappedBy = "ownerPerson")
    private List <Inspection> ownerPersonList;

    //lista przeglądów za które odpowiedzialny jest użytkownik
    @OneToMany(mappedBy = "responsibleInspectionPerson")
    private List <Inspection> responsibleInspectionPersonList;

    //lista zgłoszeń za które odpowiedzialny jest użytkownik
    @OneToMany(mappedBy = "responsibleTicketPerson")
    private List <Tickets> responsibleTicketPersonList;

}
