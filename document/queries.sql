--
--      CREATE TABLES
--
CREATE TABLE IF NOT EXISTS `tb_doctor`
(
    `id`         BINARY(16),
    `address`    VARCHAR(255) DEFAULT NULL,
    `name`       VARCHAR(255) NOT NULL,
    `surname`    VARCHAR(255) NOT NULL,
    `phone`      VARCHAR(15)  DEFAULT NULL,
    `speciality` TINYINT,

    PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `tb_patient`
(
    `id`         BINARY(16),
    `first_name` VARCHAR(255) NOT NULL,
    `last_name`  VARCHAR(255) NOT NULL,
    `email`      VARCHAR(255) DEFAULT NULL,

    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `tb_appointment`
(
    `id`           BINARY(16),
    `doctor_id`    BINARY(16),
    `patient_id`   BINARY(16),
    `meeting_time` BIGINT,

    CONSTRAINT `fk_appointment_doctor` FOREIGN KEY `fk_appointment_doctor` (`doctor_id`) REFERENCES `tb_doctor` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_appointment_patient` FOREIGN KEY `fk_appointment_patient` (`patient_id`) REFERENCES `tb_patient` (`id`) ON DELETE CASCADE,
--       check if meeting epoch time is greater than 0
    CONSTRAINT `ch_valid_meeting_time` CHECK ( `meeting_time` > 0 ),

    PRIMARY KEY (`id`)
    );
--
--      CRUD Query examples (for doctor)
--


SELECT * FROM tb_doctor;
SELECT * FROM tb_doctor WHERE id='UUID'


INSERT INTO tb_doctor (id, address, name, surname, phone, speciality)
    VALUES ({{DATA}});


UPDATE `tb_doctor`
SET
--     Fill with random data
`name`='sdegs',
`surname`='aegswgh',
`address`='esaggh',
`phone`='111111111',
`speciality`=2
WHERE id = 'UUID';


DELETE FROM tb_doctor WHERE id='UUID'

-- Lazy fetch
SELECT *
FROM `tb_doctor` td LEFT OUTER JOIN  `tb_appointment` ta ON td.id = ta.doctor_id;