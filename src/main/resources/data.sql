DELETE FROM student;
ALTER TABLE student ALTER COLUMN id RESTART WITH (SELECT MAX(id) + 1 FROM student);
INSERT INTO student (name, age) VALUES ('Alex', 60);
INSERT INTO student (name, age) VALUES ('Ethan', 23);
INSERT INTO student (name, age) VALUES ('Pierre', 47);
INSERT INTO student (name, age) VALUES ('Xavier', 35);
INSERT INTO student (name, age) VALUES ('Antoine', 15);