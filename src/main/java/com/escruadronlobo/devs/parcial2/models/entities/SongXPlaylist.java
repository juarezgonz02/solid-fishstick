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
@Table(name = "songXPlaylist")
public class SongXPlaylist{
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "playlist_code", nullable = true)
	private PlayList play_listcode;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "song_code", nullable = true)
	private Song song_code;

	@Column(name = "date_added")
	private Date date_added;

	public SongXPlaylist(PlayList play_listcode, Song song_code, Date date_added) {
		this.play_listcode = play_listcode;
		this.song_code = song_code;
		this.date_added = date_added;
	}
}