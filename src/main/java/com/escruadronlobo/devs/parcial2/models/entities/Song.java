package com.escruadronlobo.devs.parcial2.models.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = {"songs"})
@Entity
@Table(name = "Song")
public class Song{
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "song", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Song> songs;

    @Column(name = "duration")
    private Integer duration;
}

// crear playlist
// recibir un arreglo para agregarlo a la playlist
// añadir cancion a una playlist
// eliminar una playlist
// 