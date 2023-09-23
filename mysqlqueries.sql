USE freshnest;
SELECT * FROM user;

CREATE DATABASE susikumar_pitchaimuthu_corejava_project;
-- Chat new table creation
Use susikumar_pitchaimuthu_corejava_project;

-- Users table creation

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    profile_image LONGBLOB NOT NULL,
    gender VARCHAR(10),
    dob DATE,
    age INT,
    user_theme VARCHAR(1000),
    nationality VARCHAR(50),
    mobile_number BIGINT,
    is_admin TINYINT DEFAULT 0,
    register_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_deleted TINYINT DEFAULT 0
);


CREATE TABLE user_followers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    follower_id INT NOT NULL,
    following_id INT NOT NULL,
    followed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (follower_id) REFERENCES users(user_id),
    FOREIGN KEY (following_id) REFERENCES users(user_id)
);


-- Table to store chats
CREATE TABLE chats (
    chat_id INT AUTO_INCREMENT PRIMARY KEY,
    chat_type ENUM('direct', 'group') NOT NULL,
    chat_name VARCHAR(255) NOT NULL,
    group_image VARCHAR(255), -- For group chats only
    group_name LONGBLOB,  -- For group chats only
    group_theme VARCHAR(1000),
    is_active TINYINT(1) NOT NULL DEFAULT 0
);

-- Table to store chat participants (users in chats)
CREATE TABLE chat_participants (
    chat_participant_id INT AUTO_INCREMENT PRIMARY KEY,
    chat_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (chat_id) REFERENCES chats (chat_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

-- Table to store chat messages
CREATE TABLE chat_messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    chat_id INT NOT NULL,
    sender_id INT NOT NULL,
    message TEXT NOT NULL,
    is_delete TINYINT DEFAULT 0,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (chat_id) REFERENCES chats (chat_id),
    FOREIGN KEY (sender_id) REFERENCES users (user_id)
);

-- Create message read table
CREATE TABLE chat_message_read(
read_id INT AUTO_INCREMENT PRIMARY KEY,
message_id INT NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (message_id) REFERENCES chat_messages (message_id),
FOREIGN KEY (user_id) REFERENCES  users (user_id)
);



ALTER DATABASE susikumar_pitchaimuthu_corejava_project
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
    
  ALTER TABLE chat_messages
    CONVERT TO CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

ALTER TABLE chat_messages MODIFY message TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
    
-- still table cration queries

CREATE TABLE fresh_still (
    still_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    still_url LONGBLOB NOT NULL,
    still_name VARCHAR(255) NOT NULL,
    original_still_id INT,
    still_date DATE NOT NULL,
    still_time TIME NOT NULL,
    is_favourite TINYINT DEFAULT 0,
    is_delete TINYINT DEFAULT 0,
    deletion_date DATE NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);


-- invite table creation

CREATE TABLE fresh_invite (
    invite_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    invite_type VARCHAR(255) NOT NULL,
    invite_date DATE NOT NULL,
    invite_time TIME NOT NULL,
    special_person VARCHAR(255),
    invite_slogan VARCHAR(255),
    invite_explanation TEXT,
    invite_image LONGBLOB,
    is_delete TINYINT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users (user_id) 
);

CREATE TABLE invite_react_details (
    react_id INT AUTO_INCREMENT PRIMARY KEY,
    invite_id INT NOT NULL,
    user_id INT NOT NULL,
    is_send_request TINYINT DEFAULT 0,
    is_like TINYINT DEFAULT 0,
    is_reject TINYINT DEFAULT 0,
    invite_request_reaction ENUM('accepted', 'declined', 'yet_to_decide') DEFAULT 'yet_to_decide',
    invite_message TEXT,
    FOREIGN KEY (invite_id) REFERENCES fresh_invite (invite_id),
	FOREIGN KEY (user_id) REFERENCES users (user_id) 
);


-- Notification table 
CREATE TABLE notifications (
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    invite_id INT ,
    notification_type ENUM('follow_request', 'invite_request', 'tale_reaction', 'follow_accept', 'invite_request_accept') NOT NULL,
    notification_text TEXT NULL,
    notify_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_read BOOLEAN DEFAULT 0,
    is_active BOOLEAN DEFAULT 0,
    FOREIGN KEY (sender_id) REFERENCES users(user_id),
    FOREIGN KEY (receiver_id) REFERENCES users(user_id)
);

CREATE TABLE time_tales (
    tale_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL, 
    media_url LONGBLOB NOT NULL,
    duration DOUBLE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP DEFAULT (CURRENT_TIMESTAMP + INTERVAL 1 DAY), 
    is_delete BOOLEAN DEFAULT FALSE, 
    FOREIGN KEY (user_id) REFERENCES users(user_id) 
);


-- Gif table

CREATE TABLE gif_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    gif_name VARCHAR(255) NOT NULL,
    gif_data LONGBLOB NOT NULL
);


-- chat data retrieve data by user chat Id
SELECT cm.message_id, u.username AS sender, cm.message, cm.timestamp , cm.sender_id
FROM chat_messages cm JOIN users u ON cm.sender_id = u.user_id WHERE cm.chat_id = 1
ORDER BY cm.timestamp;


-- Check the user friends count
SELECT COUNT(*) AS mutual_follow_count
FROM UserFollowers AS uf1
JOIN UserFollowers AS uf2
    ON uf1.follower_id = UserA_ID
    AND uf1.following_id = UserB_ID
    AND uf2.follower_id = UserB_ID
    AND uf2.following_id = UserA_ID;


-- Filter the recently deleted images
SELECT *
FROM fresh_still
WHERE is_delete = 1
  AND deletion_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 30 DAY)
  AND deletion_date <= DATE_SUB(CURRENT_DATE(), INTERVAL 15 DAY);
