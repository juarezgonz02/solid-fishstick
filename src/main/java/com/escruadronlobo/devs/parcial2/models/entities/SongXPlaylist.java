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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "songXPlaylist")
public class SongXPlaylist{
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "playlist_code", nullable = true)
	private PlayList playListCode;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "song_code", nullable = true)
	private Song songCode;

	@Column(name = "date_added")
	private Date dateAdded;

	public SongXPlaylist(PlayList playListCode, Song songCode, Date dateAdded) {
		this.playListCode = playListCode;
		this.songCode = songCode;
		this.dateAdded = dateAdded;
	}
}