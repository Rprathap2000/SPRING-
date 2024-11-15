package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="ARTIST_INFO")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen1", sequenceName = "artist_seq", initialValue = 1000, allocationSize = 1)
    @Column(name="AID")
    private Integer aid;

    @NonNull
    @Column(name="ANAME", length = 40)
    private String aname;

    @NonNull
    @Column(length = 30)
    private String category;

    @NonNull
    private Double fee;

    public Artist() {
        System.out.println("Artist:: 0-arg constructor");
    }    
}
