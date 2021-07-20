INSERT INTO `project`.`test`
(`memo`)
VALUES
('test memo2');

UPDATE `project`.`test`
SET
`memo` = 'edit memo2'
WHERE `idx` = 2;

DELETE FROM project.test
WHERE idx = 2;
