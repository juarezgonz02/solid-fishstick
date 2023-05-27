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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SongXPlaylist")
public class SongXPlaylist{
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;

    @OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "playlist_code", nullable = true)
	private PlayList play_listcode;

    @OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "song_code", nullable = true)
	private Song song_code;
    
    
}