insert into books (title, author, genre, price) values ('Twilight Zone: The Movie', 'Jacqueline Vye', 'Fantasy|Horror|Sci-Fi|Thriller', 34.2);
insert into books (title, author, genre, price) values ('Ice Rink, The (La patinoire)', 'Thomasa Garaghan', 'Comedy|Romance', 43.2);
insert into books (title, author, genre, price) values ('Schlussmacher', 'Lynn Rebbeck', 'Comedy', 65.2);
insert into books (title, author, genre, price) values ('Hunky Dory', 'Kania Blonfield', 'Drama|Musical', 12.2);
insert into books (title, author, genre, price) values ('American Tail, An', 'Gerti Pearson', 'Adventure|Animation|Children|Comedy', 34.2);
insert into books (title, author, genre, price) values ('Shutter', 'Arnold Cutforth', 'Fantasy|Horror|Mystery|Thriller', 9.2);
insert into books (title, author, genre, price) values ('Tale of the Wind, A (Histoire de vent, Une)', 'Roldan Rhodes', 'Documentary', 32.2);
insert into books (title, author, genre, price) values ('Drishyam', 'Charmian Cutting', 'Children|Drama|Thriller', 11.2);
insert into books (title, author, genre, price) values ('Modern Affair, A', 'Rafaela Guthrum', 'Romance', 33.2);
insert into books (title, author, genre, price) values ('Little Vampire, The', 'Basil Seson', 'Adventure|Children', 24.2);

insert into customers (username, password, email, authorities) values ('superreader123', '{noop}superreader123', 'superreader123@example.com', 'ROLE_USER');
insert into customers (username, password, email, authorities) values ('lukasz123', '{noop}lukasz123', 'lukasz123@example.com', 'ROLE_ADMIN');