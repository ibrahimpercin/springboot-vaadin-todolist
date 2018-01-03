CREATE TABLE IF NOT EXISTS Todo(id IDENTITY PRIMARY KEY, done BOOLEAN, text VARCHAR(255));
DELETE FROM Todo;
INSERT INTO Todo VALUES(1,true,'Be good');
INSERT INTO Todo VALUES(2,true,'Keep it simple Stupid !');
INSERT INTO Todo VALUES(3,false,'The Way Get Started Is To Quit Talking And Begin Doing');
INSERT INTO Todo VALUES(4,false,'Don’t Let Yesterday Take Up Too Much Of Today.');