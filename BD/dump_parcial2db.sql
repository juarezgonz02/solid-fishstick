

CREATE TABLE public.song (
	code uuid NOT NULL DEFAULT gen_random_uuid(),
	title varchar NOT NULL,
	duration int4 NOT NULL,
	CONSTRAINT song_pk PRIMARY KEY (code)
);


-- public."user" definition

-- Drop table

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	code uuid NOT NULL DEFAULT gen_random_uuid(),
	username varchar NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (code),
	CONSTRAINT user_un UNIQUE (username, email)
);


-- public.playlist definition

-- Drop table

-- DROP TABLE public.playlist;

CREATE TABLE public.playlist (
	code uuid NOT NULL DEFAULT gen_random_uuid(),
	title varchar NOT NULL,
	description varchar NOT NULL,
	usercode uuid NULL,
	CONSTRAINT playlist_pk PRIMARY KEY (code),
	CONSTRAINT playlist_fk FOREIGN KEY (usercode) REFERENCES public."user"(code) ON DELETE SET NULL ON UPDATE CASCADE
);


-- public.songxplaylist definition

-- Drop table

-- DROP TABLE public.songxplaylist;

CREATE TABLE public.songxplaylist (
	code uuid NOT NULL DEFAULT gen_random_uuid(),
	song_code uuid NULL,
	playlist_code uuid NULL,
	date_added timestamp NOT NULL,
	CONSTRAINT songxplaylist_pk PRIMARY KEY (code),
	CONSTRAINT songxplaylist_fk FOREIGN KEY (song_code) REFERENCES public.song(code) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT songxplaylist_fk_1 FOREIGN KEY (playlist_code) REFERENCES public.playlist(code) ON DELETE SET NULL ON UPDATE CASCADE
);
