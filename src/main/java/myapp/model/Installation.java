package myapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Installation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Override
    public String toString() {
        return  name;
    }


}
