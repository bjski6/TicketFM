package myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Wprowadź nazwę")
    private String name;

    // typ firmy najemca/obsługa techniczna/ serwis sprzątający/ właściciel

    @ManyToOne
    private CompanyType companyType;

    @OneToMany(mappedBy = "companyPerson")
    private List<Person> companyPersonList;

//    @OneToMany (mappedBy = "companyTicket")
//    private List <Ticket> companyTicketList;

//    @OneToMany(mappedBy = "companyInspection")
//    private List <Inspection> companyInspectionList;

    @Override
    public String toString() {
        return name;
    }
}
