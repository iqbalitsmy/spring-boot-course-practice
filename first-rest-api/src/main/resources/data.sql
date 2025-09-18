insert into user_details(id, birth_date, name)
values(1001, current_date(),'Ranga' );

insert into user_details(id, birth_date, name)
values(1002, current_date(),'Ranga 1' );

insert into user_details(id, birth_date, name)
values(1003, current_date(),'Ranga 2' );


insert into post(id, description, user_id)
values(1001, 'A description', 1001);

insert into post(id, description, user_id)
values(1002, 'leanr devObps', 1001);

insert into post(id, description, user_id)
values(1003, 'A description', 1002);

insert into post(id, description, user_id)
values(1004, 'leanr devObps', 1003);