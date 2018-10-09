-- Table: public.invoice

-- DROP TABLE public.invoice;

CREATE TABLE public.invoice
(
    record_id integer NOT NULL DEFAULT nextval('invoice_record_id_seq'::regclass),
    invoice_number character varying(200) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    amount double precision,
    invoice_description character varying(200) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    vendor_name character varying(200) COLLATE pg_catalog."default" DEFAULT NULL::character varying
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.invoice
    OWNER to himthawa;
