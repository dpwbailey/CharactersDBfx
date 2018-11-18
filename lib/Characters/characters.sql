

DROP TABLE Characters;
DROP TABLE Players;



CREATE TABLE Players (
   playerID int NOT NULL,
   playerName varchar (255) NOT NULL,
  PRIMARY KEY (playerID)
);
CREATE TABLE Characters (
   playerID INT NOT NULL,
   charName varchar (32) NOT NULL,
   class VARCHAR(32) CONSTRAINT class_ck CHECK (class IN ('Death Knight', 'Demon Hunter', 'Druid','Hunter','Mage','Monk','Paladin','Priest','Rogue','Shaman','Warlock','Warrior')),
   FOREIGN KEY (playerID) REFERENCES Players(playerID)

);

INSERT INTO Players (playerName, playerID)
VALUES 
   ('Paul', 01), 
   ('Harvey', 02),
   ('Abbey', 03), 
   ('Dan', 04),
   ('Michael', 05);

INSERT INTO Characters (charName, playerID, class)
VALUES

   ('Rinarri',04, 'Paladin'),
   ('Traelosong',04, 'Mage'),
   ('genericName1',03, 'Death Knight'),
   ('genericName2',02, 'Priest'),
   ('genericName3',01, 'Demon Hunter'),
   ('genericName4',03, 'Druid'),
   ('genericName5',02, 'Hunter'),
   ('genericName6',01, 'Shaman'),
   ('genericName7',05, 'Monk'),
   ('genericName8',05, 'Priest');


