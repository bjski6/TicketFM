package myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.swing.text.DateFormatter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person personNews;

    private LocalDateTime dateAdd;

    private String dateString;

    @NotBlank(message = "Podaj temat")
    @Size(min = 2, max = 30)
    private String subject;

    @Size (max=500)
    private String content;

    @PrePersist
    public void prePersist(){
        dateAdd=LocalDateTime.now();
       }

       @Transient
       public void setFormatDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        dateString = dtf.format(dateAdd);
       }



}
