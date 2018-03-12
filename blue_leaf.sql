-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: blue_leaf
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `buyerusertable`
--

DROP TABLE IF EXISTS `buyerusertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyerusertable` (
  `registryID` int(32) NOT NULL,
  `productID` int(128) NOT NULL DEFAULT '0',
  `BuyerUserID` int(32) NOT NULL,
  PRIMARY KEY (`BuyerUserID`,`registryID`,`productID`),
  KEY `ProductID_idx` (`productID`),
  KEY `registryID_idx` (`registryID`),
  CONSTRAINT `BuyerUserID_1` FOREIGN KEY (`BuyerUserID`) REFERENCES `userinfotable` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ProductID_1` FOREIGN KEY (`productID`) REFERENCES `producttable` (`productID`) ON DELETE CASCADE,
  CONSTRAINT `registryID_1` FOREIGN KEY (`registryID`) REFERENCES `userregistrytable` (`registryID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyerusertable`
--

LOCK TABLES `buyerusertable` WRITE;
/*!40000 ALTER TABLE `buyerusertable` DISABLE KEYS */;
INSERT INTO `buyerusertable` VALUES (900,900,126),(903,900,129),(903,902,129);
/*!40000 ALTER TABLE `buyerusertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privateregistrymappingtable`
--

DROP TABLE IF EXISTS `privateregistrymappingtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privateregistrymappingtable` (
  `userID` int(64) NOT NULL,
  `registryID` int(32) DEFAULT NULL,
  `BuyerUserID` int(32) NOT NULL,
  PRIMARY KEY (`userID`,`BuyerUserID`),
  KEY `buyerUserID_idx` (`BuyerUserID`),
  KEY `registryID_idx` (`registryID`),
  CONSTRAINT `BuyerUserID_2` FOREIGN KEY (`BuyerUserID`) REFERENCES `userinfotable` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `registryID_2` FOREIGN KEY (`registryID`) REFERENCES `userregistrytable` (`registryID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userID_2` FOREIGN KEY (`userID`) REFERENCES `userinfotable` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privateregistrymappingtable`
--

LOCK TABLES `privateregistrymappingtable` WRITE;
/*!40000 ALTER TABLE `privateregistrymappingtable` DISABLE KEYS */;
INSERT INTO `privateregistrymappingtable` VALUES (124,901,125),(124,901,129),(124,901,131),(124,909,127);
/*!40000 ALTER TABLE `privateregistrymappingtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productbrandtable`
--

DROP TABLE IF EXISTS `productbrandtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productbrandtable` (
  `brandID` int(32) NOT NULL,
  `brandName` varchar(64) NOT NULL,
  PRIMARY KEY (`brandID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productbrandtable`
--

LOCK TABLES `productbrandtable` WRITE;
/*!40000 ALTER TABLE `productbrandtable` DISABLE KEYS */;
INSERT INTO `productbrandtable` VALUES (1,'Nike'),(2,'Wildcraft'),(3,'Apple'),(4,'Chanel');
/*!40000 ALTER TABLE `productbrandtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcategorytable`
--

DROP TABLE IF EXISTS `productcategorytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productcategorytable` (
  `categoryID` int(32) NOT NULL,
  `categoryName` varchar(64) NOT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategorytable`
--

LOCK TABLES `productcategorytable` WRITE;
/*!40000 ALTER TABLE `productcategorytable` DISABLE KEYS */;
INSERT INTO `productcategorytable` VALUES (1,'Electronics'),(2,'Instruments'),(3,'Accessories');
/*!40000 ALTER TABLE `productcategorytable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producttable`
--

DROP TABLE IF EXISTS `producttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producttable` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `imageURL` varchar(255) DEFAULT NULL,
  `rating` int(8) DEFAULT NULL,
  `certification` int(4) DEFAULT NULL,
  `brand_brandID` int(32) NOT NULL,
  `category_categoryID` int(32) NOT NULL,
  PRIMARY KEY (`productID`),
  KEY `fk_product_brand1_idx` (`brand_brandID`),
  KEY `fk_product_category1_idx` (`category_categoryID`),
  CONSTRAINT `fk_product_brand1` FOREIGN KEY (`brand_brandID`) REFERENCES `productbrandtable` (`brandID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_category1` FOREIGN KEY (`category_categoryID`) REFERENCES `productcategorytable` (`categoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=907 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producttable`
--

LOCK TABLES `producttable` WRITE;
/*!40000 ALTER TABLE `producttable` DISABLE KEYS */;
INSERT INTO `producttable` VALUES (900,'PEN',40,'https://www.ocado.com/productImages/694/69470011_0_640x640.jpg?identifier=714be623f5d0897642f2c9d8c484ff77',4,0,4,3),(902,'IPHONE',1400,'https://www.o2.co.uk/shop/homepage/images/shop15/brand/apple/iphone-6s/apple-iphone-6s-2016-ios-ios-10-gallery-img-5-101016.jpg',5,1,3,1),(905,'MAC',1400,'https://support.apple.com/content/dam/edam/applecare/images/en_US/mac/macfamily-productnav-imac_2x.png',5,1,3,1),(906,'BIKE',300,'https://i5.walmartimages.com/asr/a7e27abf-7a38-4fdb-9492-1eef94d13606_1.344ff1008d0bcaad1c2e805772ea9a3c.jpeg?odnHeight=72&odnWidth=90&odnBg=FFFFFF',4,1,1,2);
/*!40000 ALTER TABLE `producttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registry_product`
--

DROP TABLE IF EXISTS `registry_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registry_product` (
  `registry_userID` int(32) NOT NULL,
  `registry_userType` int(2) NOT NULL,
  `product_itemID` int(128) NOT NULL,
  PRIMARY KEY (`registry_userID`,`registry_userType`,`product_itemID`),
  KEY `fk_registry_has_product_product1_idx` (`product_itemID`),
  KEY `fk_registry_has_product_registry1_idx` (`registry_userID`,`registry_userType`),
  CONSTRAINT `fk_registry_has_product_product1` FOREIGN KEY (`product_itemID`) REFERENCES `producttable` (`productID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_registry_has_product_registry1` FOREIGN KEY (`registry_userID`) REFERENCES `userregistrytable` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registry_product`
--

LOCK TABLES `registry_product` WRITE;
/*!40000 ALTER TABLE `registry_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `registry_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registryproducttable`
--

DROP TABLE IF EXISTS `registryproducttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registryproducttable` (
  `registryID` int(32) NOT NULL,
  `productID` int(128) NOT NULL,
  PRIMARY KEY (`registryID`,`productID`),
  KEY `ProductId_idx` (`productID`),
  CONSTRAINT `registryID` FOREIGN KEY (`registryID`) REFERENCES `userregistrytable` (`registryID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registryproducttable`
--

LOCK TABLES `registryproducttable` WRITE;
/*!40000 ALTER TABLE `registryproducttable` DISABLE KEYS */;
INSERT INTO `registryproducttable` VALUES (900,900),(901,900),(903,900),(903,902);
/*!40000 ALTER TABLE `registryproducttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfotable`
--

DROP TABLE IF EXISTS `userinfotable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfotable` (
  `userID` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(128) NOT NULL,
  `userType` int(2) NOT NULL,
  `phoneNum` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `Unq_emial` (`email`),
  KEY `fk_user_type_idx` (`userType`),
  CONSTRAINT `fk_user_type` FOREIGN KEY (`userType`) REFERENCES `usertypetable` (`userType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfotable`
--

LOCK TABLES `userinfotable` WRITE;
/*!40000 ALTER TABLE `userinfotable` DISABLE KEYS */;
INSERT INTO `userinfotable` VALUES (124,'User123RAD1','137433','test1@gmail.com',1,4699703250),(125,'Radhika','test','test@gmail.com',2,123456789),(126,'User1','test2','test2@gmail.com',1,123456789),(127,'User12','test22','test22@gmail.com',2,123456789),(129,'User123','test213','test23@gmail.com',1,123456789),(131,'User124','test214','test213@gmail.com',1,123456789),(132,'UserNew1','testxxx','test3333@gmail.com',1,123456789),(133,'test53','test53','test53@gmail.com',1,1234567891);
/*!40000 ALTER TABLE `userinfotable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userregistrytable`
--

DROP TABLE IF EXISTS `userregistrytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userregistrytable` (
  `registryID` int(32) NOT NULL AUTO_INCREMENT,
  `registryType` int(4) NOT NULL,
  `userID` int(32) NOT NULL,
  `RegistryName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`registryID`,`userID`),
  KEY `fk_registry_user1_idx` (`userID`),
  CONSTRAINT `fk_registry_user1` FOREIGN KEY (`userID`) REFERENCES `userinfotable` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=917 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userregistrytable`
--

LOCK TABLES `userregistrytable` WRITE;
/*!40000 ALTER TABLE `userregistrytable` DISABLE KEYS */;
INSERT INTO `userregistrytable` VALUES (900,1,124,'MyPublicRegistry'),(901,1,124,'MyPrivateRegistry'),(903,1,124,'My_NEW_PublicRegistry'),(909,0,124,'MyPublicRegistry'),(910,1,124,'MyPublicRegistry'),(911,1,124,'MyPublicRegistry'),(913,1,126,'sunny'),(914,0,126,'birthday'),(915,0,126,'Spring'),(916,1,126,'Birthday');
/*!40000 ALTER TABLE `userregistrytable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertypetable`
--

DROP TABLE IF EXISTS `usertypetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertypetable` (
  `userType` int(2) NOT NULL,
  `Role` varchar(16) NOT NULL,
  PRIMARY KEY (`userType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertypetable`
--

LOCK TABLES `usertypetable` WRITE;
/*!40000 ALTER TABLE `usertypetable` DISABLE KEYS */;
INSERT INTO `usertypetable` VALUES (1,'ADMIN'),(2,'CUSTOMER');
/*!40000 ALTER TABLE `usertypetable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-02  2:05:22
