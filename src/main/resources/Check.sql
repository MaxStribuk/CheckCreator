--
-- PostgreSQL database dump
--

-- Dumped from database version 14.6
-- Dumped by pg_dump version 14.6

-- Started on 2022-12-21 18:11:30

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

--
-- TOC entry 3321 (class 1262 OID 16395)
-- Name: Check; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Check" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';


ALTER DATABASE "Check" OWNER TO postgres;

\connect "Check"

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
-- TOC entry 212 (class 1259 OID 16405)
-- Name: discount_card; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discount_card (
    discount_card_id integer NOT NULL,
    discount_card_active boolean NOT NULL
);


ALTER TABLE public.discount_card OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16404)
-- Name: discount_card_discount_card_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.discount_card ALTER COLUMN discount_card_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.discount_card_discount_card_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 210 (class 1259 OID 16397)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    product_id integer NOT NULL,
    product_title text NOT NULL,
    product_price numeric(10,2) NOT NULL,
    product_promotional boolean NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16396)
-- Name: product_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.product ALTER COLUMN product_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.product_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3315 (class 0 OID 16405)
-- Dependencies: 212
-- Data for Name: discount_card; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (1, true);
INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (2, true);
INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (3, true);
INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (4, true);
INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (5, true);
INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (6, false);
INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (7, false);
INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (8, false);
INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (9, false);
INSERT INTO public.discount_card (discount_card_id, discount_card_active) OVERRIDING SYSTEM VALUE VALUES (10, false);


--
-- TOC entry 3313 (class 0 OID 16397)
-- Dependencies: 210
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (1, 'coffee', 1.77, false);
INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (2, 'tea', 1.66, false);
INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (3, 'juice', 1.15, false);
INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (4, 'cake', 1.25, true);
INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (5, 'ice cream', 1.75, false);
INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (6, 'eggs', 2.50, true);
INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (7, 'cheese', 3.00, false);
INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (8, 'butter', 111.50, true);
INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (9, 'rice', 2.50, true);
INSERT INTO public.product (product_id, product_title, product_price, product_promotional) OVERRIDING SYSTEM VALUE VALUES (10, 'milk', 1.35, true);


--
-- TOC entry 3322 (class 0 OID 0)
-- Dependencies: 211
-- Name: discount_card_discount_card_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.discount_card_discount_card_id_seq', 10, true);


--
-- TOC entry 3323 (class 0 OID 0)
-- Dependencies: 209
-- Name: product_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_product_id_seq', 10, true);


--
-- TOC entry 3172 (class 2606 OID 16409)
-- Name: discount_card discount_card_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discount_card
    ADD CONSTRAINT discount_card_pkey PRIMARY KEY (discount_card_id);


--
-- TOC entry 3170 (class 2606 OID 16403)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);


-- Completed on 2022-12-21 18:11:30

--
-- PostgreSQL database dump complete
--

