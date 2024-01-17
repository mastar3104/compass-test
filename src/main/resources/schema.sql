DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS classroom;
DROP TABLE IF EXISTS facilitator;

CREATE TABLE facilitator
(
    id         INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    created_at DATETIME                                                     NOT NULL,
    updated_at DATETIME                                                     NOT NULL,
    deleted    BOOLEAN                                                      NOT NULL DEFAULT false
) ENGINE=InnoDB COMMENT '先生情報';

CREATE TABLE classroom
(
    id             INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    facilitator_id INT UNSIGNED NOT NULL,
    created_at     DATETIME                                                     NOT NULL,
    updated_at     DATETIME                                                     NOT NULL,
    deleted        BOOLEAN                                                      NOT NULL DEFAULT false,
    FOREIGN KEY (facilitator_id) REFERENCES facilitator (id)
) ENGINE=InnoDB COMMENT 'クラス情報';

CREATE TABLE student
(
    id           INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    login_id     VARCHAR(63)                                                  NOT NULL UNIQUE,
    classroom_id INT UNSIGNED NOT NULL,
    created_at   DATETIME                                                     NOT NULL,
    updated_at   DATETIME                                                     NOT NULL,
    deleted      BOOLEAN                                                      NOT NULL DEFAULT false,
    FOREIGN KEY (classroom_id) REFERENCES classroom (id),
    index name_index (name)
) ENGINE=InnoDB COMMENT '生徒情報';

