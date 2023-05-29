package com.escruadronlobo.devs.parcial2.models.entities;

import java.util.Date;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "playlist")

public class PlayList{
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;

    @Column(name = "title")
	private String title;

    @Column(name = "description")
	private String description;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usercode", nullable = true)
	private User usercode;

    public PlayList(String title, String description, User usercode) {
        this.title = title;
        this.description = description;
        this.usercode = usercode;
    }
}