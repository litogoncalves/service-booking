-- Para Paises e Codigo de Paises: https://countrycode.org/ --
-- Insert de Paises --
INSERT INTO country(id,status_id, language,version,created_date,last_update_date,created_by,last_update_by,name, code) VALUES (1,1,'EN', 1,current_date(),null,'rafael.goncalves',null,'Afghanistan', 'AFG')
INSERT INTO country(id,status_id,language,version,created_date,last_update_date,created_by,last_update_by,name, code) VALUES (2,1, 'EN',1,current_date(),null,'rafael.goncalves',null,'Albania', 'ALB')
-- Para Nacionalidade: https://www.ef.com/wwen/english-resources/english-grammar/nationalities/ --
-- Insert de Nacionalidades --
INSERT INTO nationality(id,status_id, language,version,created_date,last_update_date,created_by,last_update_by,name, country_code) VALUES (1,1,'EN', 1,current_date(),null,'rafael.goncalves',null,'Afghan', 'AFG')
INSERT INTO nationality(id,status_id,language,version,created_date,last_update_date,created_by,last_update_by,name, country_code) VALUES (2,1, 'EN', 1,current_date(),null,'rafael.goncalves',null,'Albanian', 'ALB')
-- Insert de Provincias (Já completo) --
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (1,'Maputo Cidade',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (2,'Maputo Provincia',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (3,'Gaza',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (4,'Inhambane',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (5,'Manica',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (6,'Sofala',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (7,'Zambezia',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (8,'Tete',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (9,'Nampula',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (10,'Niassa',2, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO province(id,name, country_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (11,'Cabo Delegado',2, 1, 1,current_date(),null,'rafael.goncalves',null)
-- Insert de Distritos (Somente Maputo Cidade Completo) --
INSERT INTO district(id,name, province_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (1,'Distrito Urbano de Kampfumo (antigo Distrito Urbano Nº1)',1, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO district(id,name, province_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (2,'Distrito Urbano de Nlhamankulu/Chamanculo (antigo Distrito Urbano Nº 2)',1, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO district(id,name, province_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (3,'Distrito Urbano de KaMaxaquene/Maxaquene (antigo Distrito Urbano Nº 3)',1, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO district(id,name, province_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (4,'Distrito Urbano de KaMavota/Mavota (antigo Distrito Urbano Nº 4)',1, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO district(id,name, province_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (5,'Distrito Municipal de KaMubukwane (antigo Distrito Urbano Nº 5)',1, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO district(id,name, province_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (6,'Distrito Municipal de KaTembe/Catembe (antigo Distrito Urbano Nº 6)',1, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO district(id,name, province_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (7,'Distrito Municipal de KaNyaka/Inhaca (antigo Distrito Urbano Nº 7)',1, 1, 1,current_date(),null,'rafael.goncalves',null)
INSERT INTO district(id,name, province_id, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (8,'Maputo Cidade',1, 1, 1,current_date(),null,'rafael.goncalves',null)
-- Insert de Codigo de Paises (Codego de Telemovel) --
INSERT INTO country_code(id,name, code, language, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (1,'Afghanistan(+93)', ' AFG','EN', 1,1,current_date(),null,'rafael.goncalves',null)
INSERT INTO country_code(id,name, code, language, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (2,'Albania(+355)', 'ALB','EN', 1,1,current_date(),null,'rafael.goncalves',null)
INSERT INTO country_code(id,name, code, language, status_id,version,created_date,last_update_date,created_by,last_update_by) VALUES (3,'Algeria(+213)', 'DZA', 'EN', 1,1,current_date(),null,'rafael.goncalves',null)