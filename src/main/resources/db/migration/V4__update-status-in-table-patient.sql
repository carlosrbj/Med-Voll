alter table patients add status varchar(255);
update doctors set status = "ACTIVE";