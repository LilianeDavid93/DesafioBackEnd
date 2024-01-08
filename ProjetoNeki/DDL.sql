-- public.skill definition

-- Drop table

-- DROP TABLE public.skill;

CREATE TABLE public.skill (
	skill_cd_id int4 NOT NULL,
	nome_skill varchar(200) NOT NULL,
	CONSTRAINT skill_pkey PRIMARY KEY (skill_cd_id),
	CONSTRAINT uk_h7kdq7tf7bg8r21b261pmry97 UNIQUE (nome_skill)
);


-- public.usuario definition

-- Drop table

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario (
	usu_cd_id int4 NOT NULL,
	nome_usuario varchar(200) NOT NULL,
	senha varchar(200) NOT NULL,
	CONSTRAINT uk_oieu9u1g4ltrbbqf8rrvb0ldc UNIQUE (nome_usuario),
	CONSTRAINT usuario_pkey PRIMARY KEY (usu_cd_id)
);


-- public.usuario_skill definition

-- Drop table

-- DROP TABLE public.usuario_skill;

CREATE TABLE public.usuario_skill (
	cod_usu_skill_cd_id int4 NOT NULL,
	"level" int2 NOT NULL,
	codigo_skill int4 NULL,
	codigo_usuario int4 NULL,
	CONSTRAINT usuario_skill_pkey PRIMARY KEY (cod_usu_skill_cd_id),
	CONSTRAINT fk1tccbwi2vpsu10nk09rg4q991 FOREIGN KEY (codigo_usuario) REFERENCES public.usuario(usu_cd_id),
	CONSTRAINT fk5fhsios7etxhho8a2te44384p FOREIGN KEY (codigo_skill) REFERENCES public.skill(skill_cd_id)
);

INSERT INTO public.skill
(skill_cd_id, nome_skill)
VALUES
(10003, 'NEXT'),
(10004, 'INGLES'),
(10005, 'PYTHON'),
(10006, 'ITALIANO'),
(10007, 'ALEMAO'),
(10008, 'PHP'),
(10009, 'JAVASCRIPT'),
(10010, 'RUBY'),
(10011, 'PEARL'),
(10012, 'SWIFT'),
(10013, 'SQL'),
(10021, 'TYPESCRIPT'),
(10014, 'POWERSHELL'),
(10015, 'KOTLIN'),
(10016, 'ÁRABE'),
(10017, 'JAPONÊS'),
(10018, 'BENGALÊS'),
(10019, 'FRANCÊS'),
(10020, 'COREANO');
