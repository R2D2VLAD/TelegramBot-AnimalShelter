package com.telegram_bot_animal_shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Entity for person who wants to give a cat.
 * @author: Kucherenko V.V.
 * @version 0.0.1
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class PersonCat extends Person {

    /**
     * Autogenerated primary key id for PersonCat
     * @param id
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    public PersonCat(String name, int yearOfBirth, String phone, String address, Long chatId, Status status, Cat cat) {
        super(name, yearOfBirth, phone, address, chatId, status);
        this.cat = cat;
    }

    public PersonCat(String name, int yearOfBirth, String phone, String address, Long chatId, Status status) {
        super(name, yearOfBirth, phone, address, chatId, status);
    }

    public PersonCat(String name, String phone, Long chatId) {
        super(name, phone, chatId);
    }

    /**
     * Connect to entity cat, One person can have One cat
     * @param cat
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    private Cat cat;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Report> reports;

}
