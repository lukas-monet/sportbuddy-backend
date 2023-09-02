BEGIN;

CREATE TABLE activity (
      id SERIAL PRIMARY KEY,
      user_id UUID,
      type_of_sport_activity VARCHAR(255),
      location VARCHAR(255),
      number_of_people INT,
      time TIMESTAMP
);

COMMIT;