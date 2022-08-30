-- create_temp_user.sql

-- password: P@55w0rd
-- user_id : pietp

INSERT INTO Employee(authority,email,enabled,fullname,id_number,password,user_id   )
VALUES('ROLE_ADMIN','pietp@gmail.com',1,'Piet Pompies',12345,'$2a$10$r4325krPku2wNegHS5zLY.4PWtbc4Xz7Zu4NfS2AWaiNVNONtrt.2','pietp');
