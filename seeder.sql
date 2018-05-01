use pms_db;


# DROP TABLE IF EXISTS doctor_profiles;
# DROP TABLE if EXISTS questionnaires;
# DROP TABLE if EXISTS users;

INSERT into users(city, dob, email, first_name, gender, is_doctor, last_name, password, phone_number, state, street, zipcode) VALUES
  ('San Antonio', '05/07/1990', 'email1@email.com', 'Benny', 'M', 0, 'Harper', '1234', '2109999999', 'TX', '1234 Main', 78258),
  ('San Antonio', '02/10/1988', 'email2@email.com', 'Bobo', 'M', 1, 'Vilnus', '1234', '2108675309', 'TX', '54th Street', 78261),
  ('San Antonio', '08/18/1968', 'email3@email.com', 'Mary', 'F', 1, 'Carmichael', '1234', '1233214324', 'TX', '54th Street', 78216),
  ('San Antonio', '12/03/1802', 'email4@email.com', 'Ari', 'M', 0, 'Mino', '1234', '0092010392', 'TX', '233 Micha Street', 78258),
  ('Bulverde', '4/20/2001', 'email5@email.com', 'Ellen', 'M', 0, 'Parsons', '1234', '0292010392', 'TX', '88 Viaduck Drive', 78253);

INSERT INTO questionnaires(allergies, extra, history, medications, pat_id) VALUES
  ('I am allergic to all animals', 'N/A', 'My dad had cancer but beat it.', 'N/A', 1),
  ('Bees, rats and shellfish', 'I am afraid of needles', 'Heart disease', 'N/A', 4),
  ('Peanuts', 'N/A', 'Frequent psychotherapy', 'Lipator', 5);

INSERT INTO doctor_profiles(accolades, biography, doc_id, education, experience, image, practicing_field) VALUES
  ('None', 'Family man with a fondess for fishing', 2, 'Harvard Medical School', '5 years as cardiologist', '...', 'Cardiology'),
  ('Top Vamp Doctor 1823', 'Vampire doctor who enjoys being a vampire doctor. Only treats other vampires',3, 'Texas State', '48 years as Hematologist, 18 years as a virologist.', '...', 'Hematology');



