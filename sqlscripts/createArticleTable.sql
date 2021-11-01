-- Table: public.articles

-- DROP TABLE public.articles;

CREATE TABLE IF NOT EXISTS public.articles
(
    title character varying COLLATE pg_catalog."default" NOT NULL,
    quantity integer,
    price double precision NOT NULL,
    id integer NOT NULL DEFAULT nextval('articles_id_seq'::regclass),
    CONSTRAINT articles_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.articles
    OWNER to postgres;