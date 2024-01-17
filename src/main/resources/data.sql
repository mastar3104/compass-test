-- INSERT INTO facilitator(name, created_at, updated_at) VALUES ("先生1", NOW(), NOW()) ;
-- INSERT INTO facilitator(name, created_at, updated_at) VALUES ("先生2", NOW(), NOW()) ;
--
-- INSERT INTO classroom(name, facilitator_id, created_at, updated_at) VALUES ("特待クラス1", 1, NOW(), NOW()) ;
-- INSERT INTO classroom(name, facilitator_id, created_at, updated_at) VALUES ("特待クラス2", 1, NOW(), NOW()) ;
-- INSERT INTO classroom(name, facilitator_id, created_at, updated_at) VALUES ("普通科クラス1", 2, NOW(), NOW()) ;
-- INSERT INTO classroom(name, facilitator_id, created_at, updated_at) VALUES ("普通科クラス2", 2, NOW(), NOW()) ;
-- INSERT INTO classroom(name, facilitator_id, created_at, updated_at) VALUES ("普通科クラス3", 2, NOW(), NOW()) ;
--
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒1", "student_1", 1, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒2", "student_2", 1, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒3", "student_3", 1, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒4", "student_4", 1, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒5", "student_5", 1, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒6", "student_6", 1, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒7", "student_7", 2, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒8", "student_8", 2, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒9", "student_9", 2, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒10", "student_10", 2, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒11", "student_11", 2, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒12", "student_12", 2, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒13", "student_13", 2, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒14", "student_14", 3, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒15", "student_15", 3, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒16", "student_16", 3, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒17", "student_17", 3, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒18", "student_18", 3, NOW(), NOW()) ;
-- INSERT INTO student(name, login_id, classroom_id, created_at, updated_at) VALUES ("特待 生徒19", "student_19", 3, NOW(), NOW()) ;
--
--
--
-- 1. 先生が担当するクラスに所属する生徒一覧を取得する (全ての絞り込み条件を使用)
INSERT INTO facilitator (name, created_at, updated_at) VALUES ('Teacher1', NOW(), NOW());
INSERT INTO classroom (name, facilitator_id, created_at, updated_at) VALUES ('特待クラス1', 1, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('あいだ', 'alice', 1, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('いぐち', 'bob', 1, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('うえだ', 'charlie', 1, NOW(), NOW());

-- 2. 先生が担当するクラスに所属する生徒一覧を取得する (必須の絞り込み条件のみ使用)
INSERT INTO facilitator (name, created_at, updated_at) VALUES ('Teacher2', NOW(), NOW());
INSERT INTO classroom (name, facilitator_id, created_at, updated_at) VALUES ('特待クラス2', 2, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('えのもと', 'emily', 2, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('おいかわ', 'david', 2, NOW(), NOW());

-- 3. 先生が担当するクラスに所属する生徒一覧を取得する (絞り込み条件なし)
INSERT INTO facilitator (name, created_at, updated_at) VALUES ('Teacher3', NOW(), NOW());
INSERT INTO classroom (name, facilitator_id, created_at, updated_at) VALUES ('普通科クラス1', 3, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('かまくら', 'jack', 3, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('きじま', 'ivy', 3, NOW(), NOW());

-- 4. 先生が担当するクラスに所属する生徒一覧を取得する (ソート条件あり)
INSERT INTO classroom (name, facilitator_id, created_at, updated_at) VALUES ('普通科クラス2', 3, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('くらもと', 'hilary', 4, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('けんとく', 'gai', 4, NOW(), NOW());
INSERT INTO student (name, login_id, classroom_id, created_at, updated_at) VALUES ('こさか', 'felix', 4, NOW(), NOW());
