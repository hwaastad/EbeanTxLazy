insert into t_customer (id,"name") values
(1,'customer-1'),
(2,'customer-2');

insert into t_person (id,"name",customer_id) values
(1,'p-1',1),
(2,'p-2',1),
(3,'p-3',2);

insert into t_pet (id,"name",person_id) values
(1,'pet-1',1),
(2,'pet-2',1),
(3,'pet-3',2),
(4,'pet-4',3),
(5,'pet-5',3);

insert into t_group (id,"name") values
(1,'very important group');

insert into t_person_group(agroup,aperson) values
(1,1),
(1,2),
(1,3);

insert into t_pet_attribute (id,"name","value",pet_id) values
(1,'dfg','ove',1),
(2,'bvc','ove2',2),
(3,'ert','ove3',3),
(4,'nagfdme','ove4',4),
(5,'namwrete','ove5',5),
(6,'xxx','ove5',1);