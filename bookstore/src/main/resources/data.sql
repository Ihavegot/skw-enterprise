insert into books (title, author, genre) values ('Twilight Zone: The Movie', 'Jacqueline Vye', 'Fantasy|Horror|Sci-Fi|Thriller');
insert into books (title, author, genre) values ('Ice Rink, The (La patinoire)', 'Thomasa Garaghan', 'Comedy|Romance');
insert into books (title, author, genre) values ('Schlussmacher', 'Lynn Rebbeck', 'Comedy');
insert into books (title, author, genre) values ('Hunky Dory', 'Kania Blonfield', 'Drama|Musical');
insert into books (title, author, genre) values ('American Tail, An', 'Gerti Pearson', 'Adventure|Animation|Children|Comedy');
insert into books (title, author, genre) values ('Shutter', 'Arnold Cutforth', 'Fantasy|Horror|Mystery|Thriller');
insert into books (title, author, genre) values ('Tale of the Wind, A (Histoire de vent, Une)', 'Roldan Rhodes', 'Documentary');
insert into books (title, author, genre) values ('Drishyam', 'Charmian Cutting', 'Children|Drama|Thriller');
insert into books (title, author, genre) values ('Modern Affair, A', 'Rafaela Guthrum', 'Romance');
insert into books (title, author, genre) values ('Little Vampire, The', 'Basil Seson', 'Adventure|Children');
insert into books (title, author, genre) values ('Lentsu', 'Lucio Eslie', 'Comedy');
insert into books (title, author, genre) values ('Danger! 50,000 Zombies', 'Cull Harmes', 'Comedy|Horror');
insert into books (title, author, genre) values ('Neptune''s Daughter', 'Hodge Comrie', 'Comedy|Musical|Romance');
insert into books (title, author, genre) values ('Eden', 'Adamo Durning', 'Crime|Drama');
insert into books (title, author, genre) values ('Suspect Zero', 'Reese Dicke', 'Crime|Thriller');
insert into books (title, author, genre) values ('Rape of Europa, The', 'Wallis Hebard', 'Documentary');
insert into books (title, author, genre) values ('Mine Games', 'Dani Ewin', 'Mystery|Thriller');
insert into books (title, author, genre) values ('Little Dorrit', 'Nicholas Moukes', 'Drama|Romance');
insert into books (title, author, genre) values ('Legend of 1900, The (a.k.a. The Legend of the Pianist on the Ocean) (Leggenda del pianista sull''oceano)', 'Bryn Colpus', 'Drama');
insert into books (title, author, genre) values ('Pit and the Pendulum, The', 'Peggie Fearneley', 'Horror');
insert into books (title, author, genre) values ('Svensson, Svensson - I nöd och lust', 'Ellette Ormesher', 'Comedy');
insert into books (title, author, genre) values ('Heartlands', 'Torey Abella', 'Comedy|Drama');
insert into books (title, author, genre) values ('Blue Is the Warmest Color (La vie d''Adèle)', 'Eustace Glancey', 'Drama|Romance');
insert into books (title, author, genre) values ('Before the Devil Knows You''re Dead', 'Jeremy Guerry', 'Crime|Drama|Thriller');
insert into books (title, author, genre) values ('Not Another Teen Movie', 'Neile Rambadt', 'Comedy');
insert into books (title, author, genre) values ('Born to Defense (Zhong hua ying xiong)', 'Dorothy Camsey', 'Action|War');
insert into books (title, author, genre) values ('Terminator, The', 'Kahlil Poad', 'Action|Sci-Fi|Thriller');
insert into books (title, author, genre) values ('Urgh! A Music War', 'Emmanuel Weld', 'Documentary');
insert into books (title, author, genre) values ('Blitz', 'Lexy Tokell', 'Action|Crime|Thriller');

insert into customers (username, password, email) values ('suwuperreader123', 'booklover123', 'bookmaniac@example.com');

insert into orders (uid, orderdate, city, postcode, address) values (1, current_date, 'Lublin', '20-100', 'ul.Motylowa 9');

insert into orders_books (orders_id, books_id) values (1, 10);
insert into orders_books (orders_id, books_id) values (1, 20);