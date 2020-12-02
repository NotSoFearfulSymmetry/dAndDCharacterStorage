SET foreign_key_checks = 0;
DELETE FROM role;
DELETE FROM `character`;
DELETE FROM user;

INSERT INTO user (username, password, email) VALUES ('ElfLord', 'testPassword1', 'WoodElvesAreBestElves@juno.com');
INSERT INTO user (username, password, email) VALUES ('RogueOneThird', 'testPassword2', 'backstabber123@hotmail.com');
INSERT INTO user (username, password, email) VALUES ('iamthedragon42', 'testPassword3', 'burninator@hsr.com');

INSERT INTO `character` (name, race, gender, class_and_level, strength, dexterity, constitution, intelligence, wisdom, charisma, hit_points, skills, feats, class_features, equipment, description, background, second_user_access, second_username, user_id) VALUES ('George Longshanks', 'human', 'male', 'Fighter 9', 15, 11, 13, 8, 6, 8, 57, 'Skills', 'Feats', 'Class Features', 'Equipment', 'Description', 'Background', FALSE, NULL, 1);
INSERT INTO `character` (name, race, gender, class_and_level, strength, dexterity, constitution, intelligence, wisdom, charisma, hit_points, skills, feats, class_features, equipment, description, background, second_user_access, second_username, user_id) VALUES ('Miri the Farsighted', 'elf', 'female', 'Ranger 5', 12, 6, 12, 11, 11, 10, 34, 'Skills', 'Feats', 'Class Features', 'Equipment', 'Description', 'Background', TRUE, 'iamthedragon42', 2);
INSERT INTO `character` (name, race, gender, class_and_level, strength, dexterity, constitution, intelligence, wisdom, charisma, hit_points, skills, feats, class_features, equipment, description, background, second_user_access, second_username, user_id) VALUES ('Flint Firefist', 'dwarf', 'male', 'Monk 3', 13, 13, 13, 10, 10, 9, 22, 'Skills', 'Feats', 'Class Features', 'Equipment', 'Description', 'Background', FALSE, NULL, 3);

INSERT INTO role (role_name, username, user_id) VALUES ('admin', 'ElfLord', 1);
INSERT INTO role (role_name, username, user_id) VALUES ('user', 'iamthedragon42', 3);
INSERT INTO role (role_name, username, user_id) VALUES ('user', 'RogueOneThird', 2);

SET foreign_key_checks = 1;
