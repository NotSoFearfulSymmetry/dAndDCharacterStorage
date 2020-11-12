DROP TABLE IF EXISTS `role`;
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
INSERT INTO `user` VALUES (1,'ElfLord', 'WoodElvesAreBestElves@juno.com');
INSERT INTO `user` VALUES (2,'RogueOneThird','backstabber123@hotmail.com');
INSERT INTO `user` VALUES (3,'iamthedragon42','burninator@hsr.com');
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
INSERT INTO `character` VALUES (1, 'George Longshanks', 'human', 'male', 'Fighter 9', 15, 11, 13, 8, 6, 8, 57, 'Skills', 'Feats', 'Class Features', 'Equipment', 'Description', 'Background', FALSE, NULL, 1);
INSERT INTO `character` VALUES (2, 'Miri the Far-sighted', 'elf', 'female', 'Ranger 5', 12, 6, 12, 11, 11, 10, 34, 'Skills', 'Feats', 'Class Features', 'Equipment', 'Description', 'Background', TRUE, 'iamthedragon42', 2);
INSERT INTO `character` VALUES (3, 'Flint Firefist', 'dwarf', 'male', 'Monk 3', 13, 13, 13, 10, 10, 9, 22, 'Skills', 'Feats', 'Class Features', 'Equipment', 'Description', 'Background', FALSE, NULL, 3);
UNLOCK TABLES;



CREATE TABLE role(id INT AUTO_INCREMENT PRIMARY KEY, role_name VARCHAR(25) NOT NULL, user_name VARCHAR(15) NOT NULL, user_id INT NOT NULL, CONSTRAINT role_id_uindex UNIQUE (id), CONSTRAINT role_user_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE CASCADE ON DELETE CASCADE) ENGINE = InnoDB;
CREATE INDEX role_user_user_id_fk ON role (user_id);