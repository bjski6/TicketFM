
insert into Company (name, companyType_id) values ("BRW", 2);
insert into Company (name, companyType_id) values ("l&d", 2);
insert into Company (name, companyType_id) values ("ASPLEX", 2);
insert into Company (name, companyType_id) values ("PROLOGIS", 1);
insert into Company (name, companyType_id) values ("SPIE", 3);
insert into Company (name, companyType_id) values ("SAMACO", 2);


insert into Installation (name) value ("HVAC (ogrzewanie, wentylacja, chłodnictwo)");
insert into Installation (name) value ("Instalacje elektryczne i oświetleniowe");
insert into Installation (name) value ("Systemy przeciwpożarowe");
insert into Installation (name) value ("Instalacje wodno-kanalizacyjne");
insert into Installation (name) value ("Budynek");
insert into Installation (name) value ("Tereny zewnętrzne");
insert into Installation (name) value ("Inne");

-- cos nie dziala
--  insert into Equipment (name, model, serialNo, manufacturer, installation_id, statusEq_id) value ("Kocioł gazowy", "Victrix", "223155548", "Immergas",1,2);


insert into EquipmentStatus (equipmentStatus) value ("W ruchu");
insert into EquipmentStatus (equipmentStatus) value ("Zdemontowane");


insert into PermissionsPerson (permission) value ("administrator");
insert into PermissionsPerson (permission) value ("user");
insert into PermissionsPerson (permission) value ("superUser");
insert into PermissionsPerson (permission) value ("gość");

insert into CompanyType (companyType) value ("Właściciel/Zarządca");
insert into CompanyType (companyType) value ("Najemca");
insert into CompanyType (companyType) value ("Obsługa techniczna");
insert into CompanyType (companyType) value ("Serwis sprzątający");
insert into CompanyType (companyType) value ("Ochrona");



insert into Person (name,surname, email, password, phoneNumber) values ("Bartosz", "Jankowski", "bjski@gmail.com","bjskii","555774267");
insert into Person (name,surname, email, password, phoneNumber) values ("Krzysztof", "Jotel", "krzych@gmail.com","krisopfer","457125486");
insert into Person (name,surname, email, password, phoneNumber) values ("Michał", "Kilof", "likol@wp.com","nikosad","354852487");
insert into Person (name,surname, email, password, phoneNumber) values ("Kornel", "Jorec", "liiiolo@gmail.com","jalowiec","364885211");

--
--
-- insert into Installation (name,installationType_Id) value ("Instalacja gazowa wewnętrzna", 1);
-- insert into Installation (name,installationType_Id) value ("Kotłownie i kotły gazowe", 1);
-- insert into Installation (name,installationType_Id) value ("Promienniki gazowe", 1);
-- insert into Installation (name,installationType_Id) value ("Instalacja gazowa zewnętrzna", 1);
-- insert into Installation (name,installationType_Id) value ("Centrale wentylacyjne", 1);
-- insert into Installation (name,installationType_Id) value ("Wentylatory dachowe/bytowe", 1);
-- insert into Installation (name,installationType_Id) value ("Klimatyzacja", 1);
-- insert into Installation (name,installationType_Id) value ("Inne", 1);
--
--
-- insert into Installation (name,installationType_Id) value ("Transformator + baterie kondensatorów", 2);
-- insert into Installation (name,installationType_Id) value ("PZO i rozdzielnie SN", 2);
-- insert into Installation (name,installationType_Id) value ("Rozdzielnie NN", 2);
-- insert into Installation (name,installationType_Id) value ("Badanie sprzętu dielektrycznego", 2);
-- insert into Installation (name,installationType_Id) value ("Instalacja odgromowa i przeciwprzepięciowa", 2);
-- insert into Installation (name,installationType_Id) value ("Oświetlenie zewnętrzne", 2);
-- insert into Installation (name,installationType_Id) value ("Oświetlenie wewnętrzne", 2);
-- insert into Installation (name,installationType_Id) value ("Telewizja przemysłowa CCTV", 2);
-- insert into Installation (name,installationType_Id) value ("Inne", 2);
--
--
-- insert into Installation (name,installationType_Id) value ("Pompownia pożarowa", 3);
-- insert into Installation (name,installationType_Id) value ("Instalacja tryskaczowa", 3);
-- insert into Installation (name,installationType_Id) value ("Zawory, zasuwy", 3);
-- insert into Installation (name,installationType_Id) value ("Instalacja hydrantowa zewnętrzna", 3);
-- insert into Installation (name,installationType_Id) value ("Instalacja hydrantowa wewnętrzna", 3);
-- insert into Installation (name,installationType_Id) value ("Podręczny sprzęt gaśniczy", 3);
-- insert into Installation (name,installationType_Id) value ("System oddymiania i napowietrzania", 3);
-- insert into Installation (name,installationType_Id) value ("Instalacja sygnalizacji i wykrywania pożaru", 3);
-- insert into Installation (name,installationType_Id) value ("Instalacja sygnalizacji i wykrywania gazu", 3);
-- insert into Installation (name,installationType_Id) value ("Wyłączniki pożarowe prądu", 3);
-- insert into Installation (name,installationType_Id) value ("Okna, drzwi, bramy pożarowe", 3);
-- insert into Installation (name,installationType_Id) value ("Inne", 3);
--
--
-- insert into Installation (name,installationType_Id) value ("Przepompownia ścieków", 4);
-- insert into Installation (name,installationType_Id) value ("Przepompownia wód deszczowych", 4);
-- insert into Installation (name,installationType_Id) value ("Separatory ropopochodne", 4);
-- insert into Installation (name,installationType_Id) value ("Odwodnienia dachu", 4);
-- insert into Installation (name,installationType_Id) value ("Odwodnienia liniowe", 4);
-- insert into Installation (name,installationType_Id) value ("Stacja uzdatniania wody", 4);
-- insert into Installation (name,installationType_Id) value ("Inne", 4);
--
-- insert into Installation (name,installationType_Id) value ("Dach", 5);
-- insert into Installation (name,installationType_Id) value ("System asekuracji na dachu", 5);
-- insert into Installation (name,installationType_Id) value ("Bramy, doki", 5);
-- insert into Installation (name,installationType_Id) value ("Posadzka", 5);
-- insert into Installation (name,installationType_Id) value ("Elewacja, ściany wewnętrzne", 5);
-- insert into Installation (name,installationType_Id) value ("Słupy", 5);
-- insert into Installation (name,installationType_Id) value ("Inne", 5);
--
--
-- insert into Installation (name,installationType_Id) value ("Kostka brukowa", 6);
-- insert into Installation (name,installationType_Id) value ("Szlabany", 6);
-- insert into Installation (name,installationType_Id) value ("Ogrodzenie", 6);
-- insert into Installation (name,installationType_Id) value ("Utrzymanie terenów zewnętrznych", 6);
-- insert into Installation (name,installationType_Id) value ("Utrzymanie terenów zielonych", 6);
-- insert into Installation (name,installationType_Id) value ("Odśnieżanie", 6);
-- insert into Installation (name,installationType_Id) value ("Inne", 6);
--
--
-- insert into Installation (name,installationType_Id) value ("Dezynfekcja, deratyzacja", 7);
-- insert into Installation (name,installationType_Id) value ("Usługi złotej rączki", 7);
-- insert into Installation (name,installationType_Id) value ("Ślusarz", 7);
-- insert into Installation (name,installationType_Id) value ("Inne", 7);
--
--
--
