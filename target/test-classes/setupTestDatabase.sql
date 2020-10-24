DROP TABLE IF EXISTS `character`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ElfLord', 'WoodElvesAreBestElves@juno.com');
INSERT INTO `user` VALUES (2,'RogueOneThird','backstabber123@hotmail.com');
INSERT INTO `user` VALUES (3,'iamthedragon42','burninator@hsr.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


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
  `second_user_access` boolean DEFAULT FALSE NOT NULL,
  `second_username` varchar(25) DEFAULT NULL,
  `user_id` int not null,
  PRIMARY KEY (`id`),
  UNIQUE KEY `character_id_uindex` (`id`),
  KEY `character_user_id_fk` (`user_id`),
  CONSTRAINT `character_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;



LOCK TABLES `character` WRITE;
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
INSERT INTO `character` VALUES (1, 'George Longshanks', 'human', 'male', 'Fighter 9', 15, 11, 13, 8, 6, 8, 57, 'Climb 12, Jump 12', 'Improved Initiative, Weapon Focus (greatsword), Weapon Specialization (greatsword), Weapon Focus(warhammer), Weapon Specialization (warhammer), 5 more', 'Proficient with all armor, all shields, and all simple and martial weapons', '+1 greatsword, full plate, bag of holding, 5 greater healing potions', 'A big, bulky man - not too bright or charming, but more than capable of tearing through his enemies.  His dark, shaggy hair suggests a wild life, and the scars that cover him from head to toe support that interpretation.', 'Born, grew up, became an adventurer.  Did I mention my companions and I all met in an inn?', FALSE, NULL, 1);
INSERT INTO `character` VALUES (2, 'Miri the Far-sighted', 'elf', 'female', 'Ranger 5', 12, 6, 12, 11, 11, 10, 34, 'Handle Animal 8, Hide 8, Move Silently 8, Listen 8, Spot 8, Survival 8', 'Precise Shot, Point-blank Shot', 'Proficient with light armor, non-tower shields, and all simple and martial weapons; favored enemy (orcs), wild empathy, archery style, animal companion (hawk)', '+1 Longbow, Endless Quiver, travel kit', 'With hair like spun gold, and eyes the color of a stormy sky on the cusp of clearing, Mirindeneven Lothellendar of the Forgotten Forest, known to her companions as Miri the Far-sighted, is the very picture of grace and elegance.  This is due entirely to extensive training, because with her natural dexterity, there is a reasonable chance that she could fall out of a boat and miss the water.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', TRUE, 'iamthedragon42', 2);
INSERT INTO `character` VALUES (3, 'Flint Firefist', 'dwarf', 'male', 'Monk 3', 13, 13, 13, 10, 10, 9, 22, 'Balance 6, Diplomacy 6, Jump 6, Sense Motive 6', 'Improved Unarmed Strike, Stunning Fist', 'Monk weapon proficiencies, Wisdom bonus to AC, Flurry of Blows, Evasion, Fast Movement', 'quarterstaff', 'About four-foot-four, 200 pounds, well-trimmed red beard, head hair shaved off, friendly enough, as long as you do not interrupt his meditations', 'Flint came from the Firefist clan of the dwarves who live in the Fellhammer Mountains.  He never had much taste for the wild, boisterous celebrations of his people, and when he came of age, he left to seek a quieter, more contemplative life with the monastic Order of the Open Palm.  Though his journey has only just begun, Flint believes he has found his path.', FALSE, NULL, 3);
/*!40000 ALTER TABLE `character` ENABLE KEYS */;
UNLOCK TABLES;