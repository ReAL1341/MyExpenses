CREATE TABLE IF NOT EXISTS auth_tokens (
    auth_token VARCHAR(1000) PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS myexpenses_categories (
	category_id INT PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(40) NOT NULL,
	user_id VARCHAR(255) NOT NULL
);