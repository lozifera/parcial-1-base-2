PGDMP  )                    |            Notas    16.2    16.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24727    Notas    DATABASE     |   CREATE DATABASE "Notas" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Bolivia.1252';
    DROP DATABASE "Notas";
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    24779 
   estudiante    TABLE     �   CREATE TABLE public.estudiante (
    id_estudiante integer NOT NULL,
    nombre character varying(50),
    papellido character varying(50),
    mapellido character varying(50),
    fecha_nacimiento date,
    carrera character varying(100)
);
    DROP TABLE public.estudiante;
       public         heap    postgres    false    4            �            1259    24778    estudiante_id_estudiante_seq    SEQUENCE     �   CREATE SEQUENCE public.estudiante_id_estudiante_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.estudiante_id_estudiante_seq;
       public          postgres    false    4    216            �           0    0    estudiante_id_estudiante_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.estudiante_id_estudiante_seq OWNED BY public.estudiante.id_estudiante;
          public          postgres    false    215            �            1259    24785    materia    TABLE     �   CREATE TABLE public.materia (
    codigo character varying(20) NOT NULL,
    nombre character varying(100),
    numero_creditos integer
);
    DROP TABLE public.materia;
       public         heap    postgres    false    4            �            1259    24790    nota    TABLE     �   CREATE TABLE public.nota (
    id_estudiante integer NOT NULL,
    codigo_materia character varying(20) NOT NULL,
    nota double precision
);
    DROP TABLE public.nota;
       public         heap    postgres    false    4            X           2604    24782    estudiante id_estudiante    DEFAULT     �   ALTER TABLE ONLY public.estudiante ALTER COLUMN id_estudiante SET DEFAULT nextval('public.estudiante_id_estudiante_seq'::regclass);
 G   ALTER TABLE public.estudiante ALTER COLUMN id_estudiante DROP DEFAULT;
       public          postgres    false    215    216    216            �          0    24779 
   estudiante 
   TABLE DATA           l   COPY public.estudiante (id_estudiante, nombre, papellido, mapellido, fecha_nacimiento, carrera) FROM stdin;
    public          postgres    false    216   �       �          0    24785    materia 
   TABLE DATA           B   COPY public.materia (codigo, nombre, numero_creditos) FROM stdin;
    public          postgres    false    217   >       �          0    24790    nota 
   TABLE DATA           C   COPY public.nota (id_estudiante, codigo_materia, nota) FROM stdin;
    public          postgres    false    218   �       �           0    0    estudiante_id_estudiante_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.estudiante_id_estudiante_seq', 5, true);
          public          postgres    false    215            Z           2606    24784    estudiante estudiante_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_pkey PRIMARY KEY (id_estudiante);
 D   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT estudiante_pkey;
       public            postgres    false    216            \           2606    24789    materia materia_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.materia
    ADD CONSTRAINT materia_pkey PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.materia DROP CONSTRAINT materia_pkey;
       public            postgres    false    217            ^           2606    24794    nota nota_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_pkey PRIMARY KEY (id_estudiante, codigo_materia);
 8   ALTER TABLE ONLY public.nota DROP CONSTRAINT nota_pkey;
       public            postgres    false    218    218            _           2606    24800    nota nota_codigo_materia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_codigo_materia_fkey FOREIGN KEY (codigo_materia) REFERENCES public.materia(codigo);
 G   ALTER TABLE ONLY public.nota DROP CONSTRAINT nota_codigo_materia_fkey;
       public          postgres    false    217    218    4700            `           2606    24795    nota nota_id_estudiante_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_id_estudiante_fkey FOREIGN KEY (id_estudiante) REFERENCES public.estudiante(id_estudiante);
 F   ALTER TABLE ONLY public.nota DROP CONSTRAINT nota_id_estudiante_fkey;
       public          postgres    false    4698    216    218            �   e   x�3��M,�L�K����+I<�1��'� ������@��L�В�1%73/���(193?�˔�'5?/5��*�3�47��P���9=���3KRs��b���� H      �   `   x��u100��M,I�=��$39��ӄ��3$�vxm1P�Ә+ �����3�(?�(17193?O����������)�8U!%U�%�$�(a����� ;��      �   1   x�3�trt100�45�2��700�47 ��<�9���L�b���� ���     