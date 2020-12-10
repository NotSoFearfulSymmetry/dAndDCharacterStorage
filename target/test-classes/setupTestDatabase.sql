SET foreign_key_checks = 0;

DELETE FROM role;
DELETE FROM dnd_character;
DELETE FROM user;

INSERT INTO user (id, username, password, email) VALUES (1, 'ElfLord', 'testPassword1', 'WoodElvesAreBestElves@juno.com');
INSERT INTO user (id, username, password, email) VALUES (2, 'RogueOneThird', 'testPassword2', 'backstabber123@hotmail.com');
INSERT INTO user (id, username, password, email) VALUES (3, 'iamthedragon42', 'testPassword3', 'burninator@hsr.com');

INSERT INTO dnd_character (id, name, race, gender, class_and_level, strength, dexterity, constitution, intelligence, wisdom, charisma, hit_points, skills, feats, class_features, equipment, description, background, second_user_access, second_username, user_id) VALUES (1, 'George Longshanks', 'human', 'male', 'Fighter 9', 15, 11, 13, 8, 6, 8, 57, 'Skills', 'Feats', 'Class Features', 'Equipment', 'Description', 'Background', FALSE, NULL, 1);
INSERT INTO dnd_character (id, name, race, gender, class_and_level, strength, dexterity, constitution, intelligence, wisdom, charisma, hit_points, skills, feats, class_features, equipment, description, background, second_user_access, second_username, user_id) VALUES (2, 'Miri the Farsighted', 'elf', 'female', 'Ranger 5', 12, 6, 12, 11, 11, 10, 34, 'Skills', 'Feats', 'Class Features', 'Equipment', 'Description', 'Background', TRUE, 'iamthedragon42', 2);
INSERT INTO dnd_character (id, name, race, gender, class_and_level, strength, dexterity, constitution, intelligence, wisdom, charisma, hit_points, skills, feats, class_features, equipment, description, background, second_user_access, second_username, user_id) VALUES (3, 'Flint Firefist', 'dwarf', 'male', 'Monk 3', 13, 13, 13, 10, 10, 9, 22, 'Skills', 'Feats', 'Class Features', 'Equipment', 'Description', 'Background', FALSE, NULL, 3);

INSERT INTO role (id, role_name, username, user_id) VALUES (1, 'admin', 'ElfLord', 1);
INSERT INTO role (id, role_name, username, user_id) VALUES (2, 'user', 'iamthedragon42', 3);
INSERT INTO role (id, role_name, username, user_id) VALUES (3, 'user', 'RogueOneThird', 2);

SET foreign_key_checks = 1;
