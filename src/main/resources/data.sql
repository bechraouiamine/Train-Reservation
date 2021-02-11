insert into train (id, ref) values ('026cc3c8-3a0c-4083-a05b-e908048c1b08', 'express_2000');
insert into train (id, ref) values ('d72a9fd6-6c5b-11eb-9439-0242ac130002', 'local_1000');

insert into coach (id, ref, train_id) values ('0bd75dc8-6c5c-11eb-9439-0242ac130002', 'A', 'd72a9fd6-6c5b-11eb-9439-0242ac130002');
insert into coach (id, ref, train_id) values ('d08edb30-6c5e-11eb-9439-0242ac130002', 'B', 'd72a9fd6-6c5b-11eb-9439-0242ac130002');
insert into coach (id, ref, train_id) values ('d08eda7c-6c5e-11eb-9439-0242ac130002', 'C', 'd72a9fd6-6c5b-11eb-9439-0242ac130002');

insert into coach (id, ref, train_id) values ('d08ed9be-6c5e-11eb-9439-0242ac130002', 'A', '026cc3c8-3a0c-4083-a05b-e908048c1b08');
insert into coach (id, ref, train_id) values ('d08ed900-6c5e-11eb-9439-0242ac130002', 'B', '026cc3c8-3a0c-4083-a05b-e908048c1b08');

insert into seat (id, ref, coach_id) values ('28766862-6c60-11eb-9439-0242ac130002','1','0bd75dc8-6c5c-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28766ad8-6c60-11eb-9439-0242ac130002','2','0bd75dc8-6c5c-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28766e02-6c60-11eb-9439-0242ac130002','3','0bd75dc8-6c5c-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28766ede-6c60-11eb-9439-0242ac130002','4','0bd75dc8-6c5c-11eb-9439-0242ac130002');

insert into seat (id, ref, coach_id) values ('28766f9c-6c60-11eb-9439-0242ac130002','1','d08edb30-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28767064-6c60-11eb-9439-0242ac130002','2','d08edb30-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28767122-6c60-11eb-9439-0242ac130002','3','d08edb30-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('287671ea-6c60-11eb-9439-0242ac130002','4','d08edb30-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('2876729e-6c60-11eb-9439-0242ac130002','5','d08edb30-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('2876735c-6c60-11eb-9439-0242ac130002','6','d08edb30-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28767668-6c60-11eb-9439-0242ac130002','7','d08edb30-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28767730-6c60-11eb-9439-0242ac130002','8','d08edb30-6c5e-11eb-9439-0242ac130002');

insert into seat (id, ref, coach_id) values ('287677f8-6c60-11eb-9439-0242ac130002','1','d08eda7c-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('287678b6-6c60-11eb-9439-0242ac130002','2','d08eda7c-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('2876796a-6c60-11eb-9439-0242ac130002','3','d08eda7c-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28767a28-6c60-11eb-9439-0242ac130002','4','d08eda7c-6c5e-11eb-9439-0242ac130002');

insert into seat (id, ref, coach_id) values ('28767adc-6c60-11eb-9439-0242ac130002','1','d08ed9be-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28768270-6c60-11eb-9439-0242ac130002','2','d08ed9be-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('2876834c-6c60-11eb-9439-0242ac130002','3','d08ed9be-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('2876840a-6c60-11eb-9439-0242ac130002','4','d08ed9be-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('287684be-6c60-11eb-9439-0242ac130002','5','d08ed9be-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('2876857c-6c60-11eb-9439-0242ac130002','6','d08ed9be-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('2876863a-6c60-11eb-9439-0242ac130002','7','d08ed9be-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('287686f8-6c60-11eb-9439-0242ac130002','8','d08ed9be-6c5e-11eb-9439-0242ac130002');

insert into seat (id, ref, coach_id) values ('28768946-6c60-11eb-9439-0242ac130002','1','d08ed900-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28768a0e-6c60-11eb-9439-0242ac130002','2','d08ed900-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28768acc-6c60-11eb-9439-0242ac130002','3','d08ed900-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28768b80-6c60-11eb-9439-0242ac130002','4','d08ed900-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28768c3e-6c60-11eb-9439-0242ac130002','5','d08ed900-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28768cfc-6c60-11eb-9439-0242ac130002','6','d08ed900-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28768f5e-6c60-11eb-9439-0242ac130002','7','d08ed900-6c5e-11eb-9439-0242ac130002');
insert into seat (id, ref, coach_id) values ('28769030-6c60-11eb-9439-0242ac130002','8','d08ed900-6c5e-11eb-9439-0242ac130002');

