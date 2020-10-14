--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
 /*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ElfLord', 'WoodElvesAreBestElves@juno.com'),(2,'RogueOneThird','backstabber123@hotmail.com'),(3,'iamthedragon42','burninator@hsr.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `character`
--

DROP TABLE IF EXISTS `character`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `character` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(70) DEFAULT NULL,
  `race` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `class_and_level` varchar(100) DEFAULT NULL,
  `strength` int(3) DEFAULT NULL,
  `dexterity` int(3) DEFAULT NULL,
  `constitution` int(3) DEFAULT NULL,
  `intelligence` int(3) DEFAULT NULL,
  `wisdom` int(3) DEFAULT NULL,
  `charisma` int(3) DEFAULT NULL,
  `hit_points` int(3) DEFAULT NULL,
  `skills` varchar(500) DEFAULT NULL,
  `feats` varchar(500) DEFAULT NULL,
  `class_features` varchar(500) DEFAULT NULL,
  `equipment` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `background` varchar(500) DEFAULT NULL,
  `second_user_access` boolean() DEFAULT 0,
  `second_username` varchar() DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `character_id_uindex` (`id`),
  KEY `character_user_id_fk` (`user_id`),
  CONSTRAINT `character_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character`
--

LOCK TABLES `character` WRITE;
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
INSERT INTO `character` VALUES (1, 'George Longshanks', 'human', 'male', 'Fighter 9', 15, 11, 13, 8, 6, 8, 57, 'Climb 12, Jump 12', 'Improved Initiative, Weapon Focus (greatsword), Weapon Specialization (greatsword), Weapon Focus(warhammer), Weapon Specialization (warhammer), 5 more', 'Proficient with all armor, all shields, and all simple and martial weapons', '+1 greatsword, full plate, bag of holding, 5 greater healing potions', 'A big, bulky man - not too bright or charming, but more than capable of tearing through his enemies.  His dark, shaggy hair suggests a wild life, and the scars that cover him from head to toe support that interpretation.', 'Born, grew up, became an adventurer.  Did I mention my companions and I all met in an inn?');
INSERT INTO `character` VALUES (2, 'Miri the Far-sighted', 'elf', 'female', 'Ranger 5', 12, 6, 12, 11, 11, 10, 34);
INSERT INTO `character` VALUES (3, 'Flint Firefist', 'dwarf', 'male', 'Monk 3', 13, 13, 13, 10, 10, 9, 22);
/*!40000 ALTER TABLE `character` ENABLE KEYS */;
UNLOCK TABLES;