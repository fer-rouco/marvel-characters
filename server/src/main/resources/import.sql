
INSERT INTO USERS (NAME, LAST_NAME, USER_NAME, MAIL, PASSWORD) VALUES('Pablo', 'Perez', 'perez', 'pperez@gmail.com', 'PPerez99');
INSERT INTO USERS (NAME, LAST_NAME, USER_NAME, MAIL, PASSWORD) VALUES('Maria', 'Suarez', 'msuarez', 'msuarez@gmail.com', 'MSuarez');
INSERT INTO USERS (NAME, LAST_NAME, USER_NAME, MAIL, PASSWORD) VALUES('Flor', 'Martinez', 'florm', 'florm@gmail.com', 'FlorM');
INSERT INTO USERS (NAME, LAST_NAME, USER_NAME, MAIL, PASSWORD) VALUES('Ignacio', 'Poletti', 'ignacio', 'ignaciopoletti@gmail.com', 'OpenPay');

-- Hash User Passwords
UPDATE USERS SET PASSWORD = HASH('SHA256', STRINGTOUTF8(PASSWORD));
