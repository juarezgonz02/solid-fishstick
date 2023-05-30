-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;

COMMENT ON SCHEMA public IS 'standard public schema';
-- public.song definition

-- Drop table

-- DROP TABLE song;

CREATE TABLE song (
	code uuid NOT NULL DEFAULT gen_random_uuid(),
	title varchar NOT NULL,
	duration int4 NOT NULL,
	CONSTRAINT song_pk PRIMARY KEY (code)
);


-- public.user_table definition

-- Drop table

-- DROP TABLE user_table;

CREATE TABLE user_table (
	code uuid NOT NULL DEFAULT gen_random_uuid(),
	username varchar NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (code),
	CONSTRAINT user_un UNIQUE (username, email)
);


-- public.playlist definition

-- Drop table

-- DROP TABLE playlist;

CREATE TABLE playlist (
	code uuid NOT NULL DEFAULT gen_random_uuid(),
	title varchar NOT NULL,
	description varchar NOT NULL,
	usercode uuid NULL,
	CONSTRAINT playlist_pk PRIMARY KEY (code),
	CONSTRAINT playlist_fk FOREIGN KEY (usercode) REFERENCES user_table(code) ON DELETE SET NULL ON UPDATE CASCADE
);


-- public.songxplaylist definition

-- Drop table

-- DROP TABLE songxplaylist;

CREATE TABLE songxplaylist (
	code uuid NOT NULL DEFAULT gen_random_uuid(),
	song_code uuid NULL,
	playlist_code uuid NULL,
	date_added timestamp NOT NULL,
	CONSTRAINT songxplaylist_pk PRIMARY KEY (code),
	CONSTRAINT songxplaylist_fk FOREIGN KEY (song_code) REFERENCES song(code) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT songxplaylist_fk_1 FOREIGN KEY (playlist_code) REFERENCES playlist(code) ON DELETE SET NULL ON UPDATE CASCADE
);
