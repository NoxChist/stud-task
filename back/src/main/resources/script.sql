CREATE DATABASE IF NOT EXISTS studtask;

CREATE TABLE IF NOT EXISTS studtask.group_st
(
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
    name         VARCHAR(10)  NOT NULL,
    date_created DATETIME     NOT NULL
);

CREATE TABLE IF NOT EXISTS studtask.student
(
    id             INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
    name           VARCHAR(50)  NOT NULL,
    date_admission DATE         NOT NULL,
    group_id       INT UNSIGNED NOT NULL,
    FOREIGN KEY (group_id) REFERENCES studtask.group_st (id)
);

CREATE INDEX idx_group_id ON student (group_id);