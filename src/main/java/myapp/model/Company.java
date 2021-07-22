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

    @NotBlank(message = "Wprowadź nazwę firmy")
    private String name;

    @ManyToOne
    private CompanyType companyType;

    @OneToMany(mappedBy = "companyPerson")
    private List<Person> companyPersonList;

    @Override
    public String toString() {
        return name;
    }
}
