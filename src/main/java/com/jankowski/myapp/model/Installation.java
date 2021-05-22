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
public class Installation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //instalacje przypisane do typu na podstawie installationType_id
    @ManyToOne
    private InstallationType installationType;

    @OneToMany (mappedBy = "installationTickets")
    private List<Tickets> installationTicketsList;

    @OneToMany (mappedBy = "installationInspection")
    private List <Inspection> installationInspectionList;
}
