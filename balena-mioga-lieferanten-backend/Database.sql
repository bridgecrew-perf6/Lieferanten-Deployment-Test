
CREATE TABLE IF NOT EXISTS `zulieferer` (
  `ID`  INT  NOT NULL  ,
  `title` VARCHAR(255),
  `description` VARCHAR(255),
  `uuid` VARCHAR(128),
  `updated_at` TIME,
  `success_at` TIME,
  `timetable_id` INT,
  PRIMARY KEY (`ID`)
);

CREATE TABLE IF NOT EXISTS `protocol` (
  `ID`  INT  NOT NULL  ,
  `SFTP` VARCHAR(6),
  `RESTAPI` VARCHAR(6),
  `SCP` VARCHAR(6),
  `HTTP` VARCHAR(6),
  `HTTPS` VARCHAR(6),
  `FTP` VARCHAR(6),
  `website` VARCHAR(6),
  PRIMARY KEY (`ID`)
);

CREATE TABLE IF NOT EXISTS `anrede` (
  `ID`  INT  NOT NULL  ,
  `anrede` VARCHAR(32),
  PRIMARY KEY (`ID`)
);



CREATE TABLE IF NOT EXISTS `fileFormat` (
  `ID`  INT  NOT NULL  ,
  `file_type` VARCHAR(5),
  `FK_Zuliefer_ID` INT,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`FK_Zuliefer_ID`) REFERENCES `zulieferer`(`ID`)
);


CREATE TABLE "actions" (
  "ID"    INT NOT NULL,
  "title" VARCHAR(255),
  "description"   VARCHAR(255),
  "commandline"   VARCHAR(255),
  "uuid"  VARCHAR(128),
  "updated_at"    TEXT,
  "success_at"    TEXT,
  "FK_Zuliefer_ID"    INT,
  PRIMARY KEY("ID"),
  FOREIGN KEY("FK_Zuliefer_ID") REFERENCES "zulieferer"("ID")
);

CREATE TABLE IF NOT EXISTS `contacts` (
  `ID`  INT  NOT NULL  ,
  `title` VARCHAR(255),
  `description` VARCHAR(255),
  `company` INT(255),
  `FK_Anrede_ID` INT,
  `vorname` VARCHAR(24),
  `name` VARCHAR(255),
  `telefone` VARCHAR(64),
  `mobile` VARCHAR(64),
  `email` VARCHAR(255),
  `anmerkung` VARCHAR(255),
  `updated_at` TIME,
  `success_at` TIME,
  `FK_Zuliefer_ID` INT,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`FK_Zuliefer_ID`) REFERENCES `zulieferer`(`ID`),
  FOREIGN KEY (`FK_Anrede_ID`) REFERENCES `anrede`(`ID`)
);

CREATE TABLE IF NOT EXISTS `connections` (
  `ID`  INT  NOT NULL  ,
  `FK_protocol_ID` INT,
  `title` VARCHAR(50),
  `url` VARCHAR(255),
  `description` VARCHAR(255),
  `FK_Zuliefer_ID` INT,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`FK_Zuliefer_ID`) REFERENCES `zulieferer`(`ID`),
  FOREIGN KEY (`FK_protocol_ID`) REFERENCES `protocol`(`ID`)
);



CREATE TABLE `auths` (
  `ID`  INT  NOT NULL ,
  `no_auth` INT,
  `login_auth` INT,
  `token_auth` INT,
  `key_auth` INT,
  `FK_Connection_ID` INT,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`FK_Connection_ID`) REFERENCES `connections`(`ID`)
);


