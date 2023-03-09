package com.example.domains;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "shows") // se si specifica solo @Entity con name vale anche per table in db
@Data
@Table(name ="shows")
@AllArgsConstructor
@NoArgsConstructor
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="titolo",nullable = false) //,unique = true)
    String titolo;
    @Column(name="cover")
    String cover;
    @Column(name="link")
    String link;
    @Column(name="trailer")
    String trailer;
    @Column(name="genere")
    String  genere;
    @Column(name="descrizione", length = 100000)
    String descrizione;
    @Column(name="cast")
    String cast;
}
