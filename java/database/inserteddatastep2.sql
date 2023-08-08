INSERT INTO office (office_street_address, office_city, office_state, office_zip_code, 
					office_phone, office_open_time, office_close_time, office_open_days, office_name)
VALUES ('735 Ogletown Stanton Rd, #3302', 'Newark', 'DE', '19713', '302-623-1234', '8:00AM', '4:30PM', 'Monday - Friday', 'Spine Center'),
('14 Sandhill Dr, Unit 101', 'Middletown', 'DE', '19709', '302-378-1234', '8:00AM', '5:00PM', 'Monday - Friday', 'Familycare Associates LLC'),
('401 Brandywine Parkway, Suites 100 & 101', 'Wilmington', 'DE', '19803', '302-655-1234', '9:00AM', '5:00PM', 'Monday - Friday', 'Orthopaedic Specialists, PA'),
('383 Limestone Rd', 'Wilmington', 'DE', '19808', '302-274-1234', '8:00AM', '5:00PM', 'Monday - Friday', 'Plastic Surgery Associates'),
('920 Dupont Parkway', 'Townsend', 'DE', '19734', '302-449-1234', '8:00AM', '5:00PM', 'Monday - Friday', 'Pediatric Doctors of Delaware')
RETURNING office_id;

SELECT * FROM office;
--INSERT INTO users (username, )

INSERT INTO patient (user_id, patient_full_name, patient_street_address, patient_city, patient_state, patient_zip_code, patient_phone_number,
					patient_email, patient_dob)
VALUES ('1', 'Stephanie Adams', '271 Adams St', 'Hockessin', 'DE', '19707', '302-123-4567', 'stephanieadamsisfantastic@yahoo.com', '01/01/2000')
RETURNING patient_id;

INSERT INTO schedule (day_of_the_week, time_slot)
VALUES ('Monday', '10:00AM')
RETURNING schedule_id;

INSERT INTO doctor (doctor_npi, user_id, doctor_fullname, office_id, doctor_phone_number, doctor_email)
VALUES ('1', '2', 'Afreen Kazi', '1', '302-098-7654', 'drafreenkazi@gmail.com');

SELECT * FROM doctor;

SELECT * FROM appointment WHERE schedule_id = '1';

SELECT * FROM schedule;

SELECT * FROM doctor_schedule;

INSERT INTO doctor_schedule (doctor_id, schedule_id)
VALUES ('1', '1')

SELECT day_of_the_week, time_slot FROM schedule;