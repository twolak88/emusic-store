create table users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(100) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

insert into users(username, password, enabled) values('admin', '$2y$12$8mqNgb7bnY.wt/oUJGxw0.M0a.NAr/tiJgQ1tcm6pzacVp1XcbLD.', 1);
insert into authorities(username, authority) values('admin', 'ROLE_ADMIN');
