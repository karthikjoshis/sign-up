CREATE TABLE public.user_registration
(
    id serial NOT NULL,
    first_name character varying,
    last_name character varying,
    email_id character varying,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.user_registration
    OWNER to postgres;