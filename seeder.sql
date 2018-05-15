use pms_db;

INSERT INTO users(accolades, biography, city, dob, education, email, experience, first_name, gender, image, is_doctor, last_name, license_id, my_doc_id, password, phone_number, practicing_field, state, street, username, zipcode) VALUES
  (null, null, 'San Antonio', '05/07/1990', null, 'bahodge@bahodge.com', null, 'Ben', 'Male', null, false, 'Hodge', null, 5, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', null, 'TX', '123 Main Street', 'ben', '12345'),
  (null, null, 'Austin', '03/17/1983', null, 'bobbyb@gmail.com', null, 'Bobby', 'Male', null, false, 'Barathean', null, 4, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', null, 'TX', '321 Indigo', 'bobby', '12345'),
  (null, null, 'San Antonio', '04/30/1957', null, 'ron@gmail.com', null, 'Ronnie', 'Male', null, false, 'McDonald', null, 5, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', null, 'TX', '1100 Vista Valet', 'ronnie', '78126'),
  ('Suma Cum Laude Northwest Vista', 'I have been working with patients since the dawn of time, therefore have become the best doctor ever. Being a doctor has been my passion ever since I could walk. ', 'San Antonio', '12/12/1988', 'MD Clinical Psychiatry', 'vic@vickymd.com', '3 Years Clinical Psychiatrist', 'Victoria', 'Female', 'https://thumbs.dreamstime.com/b/medical-people-young-asian-doctor-woman-female-smiling-portrait-multiracial-caucasian-32319194.jpg', true, 'Valentina', '12345678900987', 0, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', 'Psychiatry', 'TX', '2337 Hiline Drive', 'victoria', '78163'),
  ('Validictorian Northwest Vista', 'Mother of 5, doctor and friend to all my patients. I look forward to working with new illnesses to apply my expertise in healing the sick.', 'San Antonio', '12/31/1988', 'MD Orthodontist', 'alice@aliceMD.com', '12 Years as a dentist', 'Alice', 'Female', 'https://www.healthstaffrecruitment.com.au/wp-content/uploads/2015/05/bigstock-Portrait-of-young-woman-doctor-70264798.jpg', true, 'Almedra', '12345678900987', 0, '$2a$10$VNliQx3VLs/n.k35c1/XO.ANTnD.3h.eP3LLlMULBBHRqElOFv1Ei', '123-456-7890', 'Orthodontist', 'TX', '25626 Rabbitbrush', 'alice', '78256'),
  ('Top 10% of course, MIT', 'Enjoy long walks on the beach', 'Austin', '03/02/1980', 'MD MIT', 'betty@bettymd.com', '3 years Surgeon', 'Betty', 'Female', 'http://wp1.jgahil90gmevoo9kqif.netdna-cdn.com/wp-content/uploads/2012/01/african-american-female-doctor.jpg', true, 'LaFea', '123456777', 0, '1234', '1234567890', 'Cardiology','TX','Houston Street','betty','12345'),
  ('4th best', 'Saving people is super neat, wish I could do it all the time!', 'Dallas', '03/02/1980', 'MD UTSA', 'cedric@bettymd.com', '5 years Surgeon', 'cedric', 'Male', 'https://www.colourbox.com/preview/4661529-attractive-portrait-of-confident-male-doctor.jpg', true, 'Paz', '123456777', 0, '1234', '1234567990', 'Oncology','TX','Devon Ave','cedric','12345');

INSERT INTO review (doc_id, pat_id, rating, review) VALUES
  (4, 1, 5, 'Amazing doctor, super nice and quirky'),
  (4, 2, 3, 'Was clean and effective, cured me instantly!'),
  (5, 1, 2, 'She was mean to me'),
  (5, 3, 3, 'Should probably work on her bedside manner'),
  (5, 2, 5, 'Who even is this guy?!! He said I wasnt even a human!'),
  (5, 1, 4, 'I agree, this guy isnt a human'),
  (6, 3, 5, 'Convinced me I needed more drugs! I hate the bill, but love the effects');


INSERT INTO questionnaires(allergies, extra, history, medications, patient_id) VALUES
  ('Cats', null, 'Family history of cancer', null, 1),
  ('Penicillin', null, 'Bad teeth', null, 2),
  ('Vampires and cookies', null, 'Alimony Checks', null, 3);


INSERT INTO appointments(date_created, doc_id, doctor_name, pat_id, patient_name, scheduled_time, status_id) VALUES
  ('2018/05/11', 4, 'Dr. Victoria Valentina', 1, 'Ben Hodge', '12:00', 1),
  ('2018/05/14', 5, 'Dr. Alice Almendra', 2, 'Ronnie McDonald', '13:00', 1),
  ('2018/05/14', 4, 'Dr. Victoria Valentina', 2, 'Bobby B', '14:00', 1),
  ('2018/05/11', 4, 'Dr. Victoria Valentina', 2, 'Bobby B', '15:00', 1),
  ('2018/05/11', 5, 'Dr. Alice Almendra', 3, 'Ronnie McDonald', '16:00', 1);

INSERT INTO sessions(doctor_id, notes, patient_id, prescriptions, procedures, time_end, time_start) VALUES
  (4, 'Patient exhibits mild head pain after falling down a set of stairs.', 1, null , 'Therapeutic massages around neck and cranium.', '12:30', '13:30'),
  (4, 'Patient now feels much better but his psychosis has taken a firm grip on his reality. Must remain observant.', 1, 'Zoloft - 100mg', 'Cranial massage and extended sessions.', '11:30', '13:30'),
  (4, 'Patient exhibits mild head pain after falling down a set of stairs.', 1, null , 'Therapeutic massages around neck and cranium.', '12:30', '13:30'),
  (5, 'Patient has broken leg', 2, 'Codeine - 150mg', 'Set bone and put into cast.', '11:30', '13:30'),
  (5, 'Patient leg is now exhibiting signs of infection. Upping dose of Codeine. Removing cast to allow leg to breath.' , 2, 'Codine - 200mg', 'Removed cast', '09:00', '11:20');







