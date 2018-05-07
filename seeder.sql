use pms_db;

DROP TABLE IF EXISTS questionnaires;
DROP TABLE if EXISTS users;

INSERT INTO users(accolades, biography, city, dob, education, email, experience, first_name, gender, image, is_doctor, last_name, license_id, my_doc_id, password, phone_number, practicing_field, state, street, username, zipcode) VALUES
  (null, null, 'San Antonio', '05/07/1990', null, 'bahodge@bahodge.com', null, 'Ben', 'Male', null, false, 'Hodge', null, 5, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', null, 'TX', '123 Main Street', 'ben', '12345'),
  (null, null, 'Austin', '03/17/1983', null, 'bobbyb@gmail.com', null, 'Bobby', 'Male', null, false, 'Barathean', null, 4, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', null, 'TX', '321 Indigo', 'bobby', '12345'),
  (null, null, 'San Antonio', '04/30/1957', null, 'ron@gmail.com', null, 'Ronnie', 'Male', null, false, 'McDonald', null, 5, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', null, 'TX', '1100 Vista Valet', 'ronnie', '78126'),
  ('Suma Cum Laude Northwest Vista', 'I have been working with patients since the dawn of time, therefore have become the best doctor ever. Being a doctor has been my passion ever since I could walk. ', 'San Antonio', '12/12/1988', 'MD Clinical Psychiatry', 'vic@vickymd.com', '3 Years Clinical Psychiatrist', 'Victoria', 'Female', 'https://thumbs.dreamstime.com/b/medical-people-young-asian-doctor-woman-female-smiling-portrait-multiracial-caucasian-32319194.jpg', true, 'Valentina', '12345678900987', 0, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', 'Psychiatry', 'TX', '2337 Hiline Drive', 'victoria', '78163'),
  ('Validictorian Northwest Vista', 'Mother of 5, doctor and friend to all my patients. I look forward to working with new illnesses to apply my expertise in healing the sick.', 'San Antonio', '12/31/1988', 'MD Orthodontist', 'alice@aliceMD.com', '12 Years as a dentist', 'Alice', 'Female', 'https://www.healthstaffrecruitment.com.au/wp-content/uploads/2015/05/bigstock-Portrait-of-young-woman-doctor-70264798.jpg', true, 'Almedra', '12345678900987', 0, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', 'Orthodontist', 'TX', '25626 Rabbitbrush', 'alice', '78256');


INSERT INTO questionnaires(allergies, extra, history, medications, patient_id) VALUES
  ('Cats', null, 'Family history of cancer', null, 1),
  ('Penicillin', null, 'Bad teeth', null, 2),
  ('Vampires and cookies', null, 'Alimony Checks', null, 3);


INSERT into  appointments(date_created, doc_id, pat_id, scheduled_time, status_id) VALUES
  ('2018/05/07', 4, 1, '12:00', 1),
  ('2018/05/07', 4, 2, '13:00', 1),
  ('2018/05/07', 4, 2, '14:00', 1),
  ('2018/05/07', 4, 3, '15:00', 1),
  ('2018/05/07', 4, 1, '16:00', 1);





