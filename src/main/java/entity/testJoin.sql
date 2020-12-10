SELECT *
FROM dnd_character
INNER JOIN user
ON dnd_character.user_id = user.id;