-- Host: localhost    Database: db_world
-- ------------------------------------------------------
-- Server version	5.7.11-log

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `District` char(35) NOT NULL,
  `Name` char(45) NOT NULL,
  `Population` int(11) NOT NULL,
  `CountryCode` char(3) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_city_country` (`CountryCode`),
  CONSTRAINT `fk_city_country` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`)
) ENGINE=InnoDB AUTO_INCREMENT=4080 DEFAULT CHARSET=utf8;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `Code` char(3) NOT NULL,
  `Capital` int(11) DEFAULT NULL,
  `Code2` char(2) NOT NULL,
  `Continent` varchar(25) NOT NULL,
  `GNP` float DEFAULT NULL,
  `GNPOld` float DEFAULT NULL,
  `GovernmentForm` char(45) NOT NULL,
  `HeadOfState` char(60) DEFAULT NULL,
  `IndepYear` smallint(6) DEFAULT NULL,
  `LifeExpectancy` float DEFAULT NULL,
  `LocalName` char(60) NOT NULL,
  `Name` char(52) NOT NULL,
  `Population` int(11) NOT NULL,
  `Region` char(26) NOT NULL,
  `SurfaceArea` float NOT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `countrylanguage`
--

DROP TABLE IF EXISTS `countrylanguage`;

CREATE TABLE `countrylanguage` (
  `CountryCode` char(3) NOT NULL,
  `Language` char(30) NOT NULL,
  `IsOfficial` varchar(2) NOT NULL,
  `Percentage` float NOT NULL,
  PRIMARY KEY (`CountryCode`,`Language`),
  CONSTRAINT `fk_language_country` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--In case of error in countrylanguage

drop index UK_gin0dr6u1ryp5jwedcc3b18pw | 'or the name of the unique constraint'
	on countrylanguage;
	
--List all contraints of the database 
select *
	from information_schema.table_constraints
	where constraint_schema = 'db_world'; 
