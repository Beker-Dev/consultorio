--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

-- Started on 2022-02-22 19:44:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 49824)
-- Name: abstract_entity; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.abstract_entity (
    id bigint NOT NULL,
    nome character varying(50) NOT NULL,
    atualizado timestamp without time zone,
    excluido timestamp without time zone
);


--
-- TOC entry 200 (class 1259 OID 49822)
-- Name: abstract_entity_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.abstract_entity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 200
-- Name: abstract_entity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.abstract_entity_id_seq OWNED BY public.abstract_entity.id;


--
-- TOC entry 206 (class 1259 OID 49854)
-- Name: agendamento; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.agendamento (
    paciente_id integer NOT NULL,
    medico_id integer NOT NULL,
    secretaria_id integer NOT NULL,
    status_agendamento character varying(10) NOT NULL,
    data_agendamento timestamp without time zone NOT NULL,
    data_cancelamento timestamp without time zone NOT NULL,
    data_avaliacao timestamp without time zone NOT NULL,
    observacao character varying(150) NOT NULL,
    encaixe boolean
)
INHERITS (public.abstract_entity);


--
-- TOC entry 202 (class 1259 OID 49830)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.pessoa (
    telefone character varying(15),
    email character varying(50),
    login character varying(20),
    senha character varying(20),
    nacionalidade character varying(2),
    sexo character varying(10)
)
INHERITS (public.abstract_entity);


--
-- TOC entry 203 (class 1259 OID 49836)
-- Name: medico; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.medico (
    crm character varying(15) NOT NULL,
    porcentagem_participacao numeric,
    consultorio character varying(50),
    especialidade character varying(50)
)
INHERITS (public.pessoa);


--
-- TOC entry 204 (class 1259 OID 49843)
-- Name: paciente; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.paciente (
    convenio character varying(50),
    numero_cartao_convenio character varying(50),
    data_vencimento timestamp without time zone,
    rg character varying(50)
)
INHERITS (public.pessoa);


--
-- TOC entry 205 (class 1259 OID 49847)
-- Name: secretaria; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.secretaria (
    salario numeric,
    datacontratacao timestamp without time zone,
    pis character varying(50)
)
INHERITS (public.pessoa);


--
-- TOC entry 2872 (class 2604 OID 49827)
-- Name: abstract_entity id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.abstract_entity ALTER COLUMN id SET DEFAULT nextval('public.abstract_entity_id_seq'::regclass);


--
-- TOC entry 2877 (class 2604 OID 49857)
-- Name: agendamento id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.agendamento ALTER COLUMN id SET DEFAULT nextval('public.abstract_entity_id_seq'::regclass);


--
-- TOC entry 2874 (class 2604 OID 49839)
-- Name: medico id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.medico ALTER COLUMN id SET DEFAULT nextval('public.abstract_entity_id_seq'::regclass);


--
-- TOC entry 2875 (class 2604 OID 49846)
-- Name: paciente id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.paciente ALTER COLUMN id SET DEFAULT nextval('public.abstract_entity_id_seq'::regclass);


--
-- TOC entry 2873 (class 2604 OID 49833)
-- Name: pessoa id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.pessoa ALTER COLUMN id SET DEFAULT nextval('public.abstract_entity_id_seq'::regclass);


--
-- TOC entry 2876 (class 2604 OID 49850)
-- Name: secretaria id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.secretaria ALTER COLUMN id SET DEFAULT nextval('public.abstract_entity_id_seq'::regclass);


--
-- TOC entry 3013 (class 0 OID 49824)
-- Dependencies: 201
-- Data for Name: abstract_entity; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3018 (class 0 OID 49854)
-- Dependencies: 206
-- Data for Name: agendamento; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3015 (class 0 OID 49836)
-- Dependencies: 203
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3016 (class 0 OID 49843)
-- Dependencies: 204
-- Data for Name: paciente; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3014 (class 0 OID 49830)
-- Dependencies: 202
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3017 (class 0 OID 49847)
-- Dependencies: 205
-- Data for Name: secretaria; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 200
-- Name: abstract_entity_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.abstract_entity_id_seq', 1, false);


--
-- TOC entry 2879 (class 2606 OID 49829)
-- Name: abstract_entity abstract_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.abstract_entity
    ADD CONSTRAINT abstract_entity_pkey PRIMARY KEY (id);


--
-- TOC entry 2881 (class 2606 OID 49835)
-- Name: pessoa pessoa_email_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_email_key UNIQUE (email);


-- Completed on 2022-02-22 19:44:32

--
-- PostgreSQL database dump complete
--

