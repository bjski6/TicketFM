package myapp.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InspectionCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cycle;

    @Override
    public String toString(){
        return cycle;
    }


}
