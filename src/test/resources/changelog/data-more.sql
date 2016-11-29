insert into customer (id,name) values
(1,'customer-1'),
(2,'customer-2')

insert into person (id,name,customer_id) values
(1,'p-1',1),
(2,'p-2',1),
(3,'p-3',2)

insert into pet (id,name,person_id) values
(1,'pet-1',1),
(2,'pet-2',1),
(3,'pet-3',2),
(4,'pet-4',3),
(5,'pet-5',3)

insert into group (id,name) values
(1,'very important group')

insert into person_group(group,person) values
(1,1),
(1,2),
(1,3)

insert into pet_attribute (id,name,value,pet_id) values
(1,'name','ove',1),
(2,'name','ove2',2),
(3,'name','ove3',3),
(4,'name','ove4',4),
(5,'name','ove5',5),
(6,'name','ove5',1)

