package com.jankowski.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //osoba dodająca aktualność relacja jednokierunkowa
    @ManyToOne
    private Person personNews;

    //data dodania aktualności
    private LocalDateTime dateAdd;

    //tytuł aktualności
    private String subject;

    //zawartość aktualności
    private String content;

    @PrePersist
    public void prePersist(){
        dateAdd=LocalDateTime.now();
    }
}
