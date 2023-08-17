USE freshnest;
SELECT * FROM user;

 -- INSERT INTO user (email, username, password) VALUES(? , ? ,?); 
 
-- DELETE FROM user;

-- Create freshnest databse
Create database freshnest;

-- Chat new table creation
Use susikumar_pitchaimuthu_corejava_project;
Use freshnest;

-- Users table creation

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    profile_image VARCHAR(255),
    gender VARCHAR(10),
    dob DATE,
    age INT,
    nationality VARCHAR(50),
    mobile_number BIGINT,
    is_deleted TINYINT DEFAULT 0
);


CREATE TABLE chats (
    chat_id INT AUTO_INCREMENT PRIMARY KEY,
    chat_type VARCHAR(255) NOT NULL,
    chat_name VARCHAR(255) NOT NULL
);

CREATE TABLE chat_participants (
    chat_participant_id INT AUTO_INCREMENT PRIMARY KEY,
    chat_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (chat_id) REFERENCES chats (chat_id),
	FOREIGN KEY (user_id) REFERENCES users (user_id)

);

CREATE TABLE chat_messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    chat_id INT NOT NULL,
    sender_id INT NOT NULL,
    message TEXT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (chat_id) REFERENCES chats (chat_id),
    FOREIGN KEY (sender_id) REFERENCES users (user_id)
    );
-- still table cration queries

CREATE TABLE fresh_still (
    still_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    still_url VARCHAR(255) NOT NULL,
    still_name VARCHAR(255) NOT NULL,
    still_date DATE NOT NULL,
    still_time TIME NOT NULL,
    is_favourite TINYINT DEFAULT 0,
    is_delete TINYINT DEFAULT 0,
    is_update TINYINT DEFAULT 0,
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
    is_delete TINYINT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users (user_id) 
);
CREATE TABLE invite_react_details (
    react_id INT AUTO_INCREMENT PRIMARY KEY,
    invite_id INT NOT NULL,
    reactor_id INT NOT NULL,
    is_accept TINYINT DEFAULT 0,
    is_like TINYINT DEFAULT 0,
    is_dislike TINYINT DEFAULT 0,
    invite_message TEXT,
    FOREIGN KEY (invite_id) REFERENCES fresh_invite (invite_id)
);




