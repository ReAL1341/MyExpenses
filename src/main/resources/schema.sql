CREATE TABLE IF NOT EXISTS auth_tokens (
    auth_token VARCHAR(1000) PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS myexpenses_categories (
	category_id VARCHAR(255) PRIMARY KEY,
	category_name VARCHAR(40) NOT NULL,
	user_id VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS myexpenses_items (
	item_id VARCHAR(255) PRIMARY KEY,
	record_date DATE NOT NULL,
	item_name VARCHAR(255) NOT NULL,
	payment_balance VARCHAR(255) NOT NULL,
	payment_amount INT NOT NULL,
	category_id VARCHAR(255) NOT NULL,
	user_id VARCHAR(255) NOT NULL
);