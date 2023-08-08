CREATE TABLE doctor (
doctor_npi VARCHAR (50) NOT NULL UNIQUE,
doctor_id SERIAL NOT NULL,
user_id INT NOT NULL,
doctor_fullname VARCHAR (100) NOT NULL,
office_id INT NOT NULL,
doctor_phone_number VARCHAR (20),
doctor_email VARCHAR (50)
--CONSTRAINT fk_doctor_user FOREIGN KEY (user_id) REFERENCES users (user_id)
--CONSTRAINT pk_doctor PRIMARY KEY (doctor_id)
);


CREATE TABLE office (
office_id SERIAL NOT NULL,
doctor_id INT,
office_street_address VARCHAR (100) NOT NULL,
office_city VARCHAR (50) NOT NULL,
office_state VARCHAR (50) NOT NULL,
office_zip_code VARCHAR (15) NOT NULL,
office_phone VARCHAR (20) NOT NULL,
office_open_time TIME NOT NULL,
office_close_time TIME NOT NULL,
office_open_days VARCHAR (15) NOT NULL
--CONSTRAINT pk_office PRIMARY KEY (office_id),
--CONSTRAINT fk_office_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id)
);
ALTER TABLE office ADD office_name VARCHAR NOT NULL;
--ALTER TABLE office ALTER COLUMN doctor_id TYPE INT USING doctor_id::integer;


--ALTER TABLE availability ADD slot_available BOOLEAN;
--ALTER TABLE availability ALTER COLUMN doctor_id TYPE INT USING doctor_id::integer;

CREATE TABLE patient(
patient_id SERIAL,
user_id INT NOT NULL,
patient_full_name VARCHAR (100),
patient_street_address VARCHAR (100),
patient_city VARCHAR (50),
patient_state VARCHAR (50),
patient_zip_code VARCHAR (20),
patient_phone_number VARCHAR (20),
patient_email VARCHAR (50),
patient_dob DATE
--CONSTRAINT pk_patient PRIMARY KEY (patient_id),
--CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

--Date column
--Table for Doctor's schedule?
--Day of the week, timeslot
--Doctor, Patient, Date, Timeslot in one table

--CREATE TABLE availability(
--availability_id SERIAL NOT NULL,
--doctor_id INT NOT NULL,
--time_slot TIMESTAMP NOT NULL, --30 minute appointments
--slot_available BOOLEAN,
--date_selected DATE NOT NULL
--CONSTRAINT pk_availability_id PRIMARY KEY (availability_id),
--CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id)
--);

CREATE TABLE schedule(
schedule_id SERIAL,
day_of_the_week VARCHAR,
time_slot TIME
--CONSTRAINT 
);

--Join table for appointment and schedule?
CREATE TABLE schedule_appointment(
booked_id SERIAL,
schedule_id INT,
date_selected DATE,
slot_available BOOLEAN,
);

CREATE TABLE booked_doctor(
doctor_id INT,
booked_id INT,
);

CREATE TABLE doctor_schedule(
doctor_id INT,
schedule_id INT
--slot_available BOOLEAN
);

CREATE TABLE appointment(
	appointment_id SERIAL,
	patient_id INT NOT NULL,
	schedule_id INT NOT NULL,
	doctor_id INT NOT NULL,
--	slot_available BOOLEAN,
	date_selected DATE NOT NULL
--	CONSTRAINT pk_appointment PRIMARY KEY (appointment_id),
--	CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patient (patient_id),
--	CONSTRAINT fk_availability FOREIGN KEY (availability_id) REFERENCES availability (availability_id)
);



--ALTER TABLE doctor ADD CONSTRAINT fk_office FOREIGN KEY (office_id) REFERENCES office (office_id);

CREATE TABLE review(
	review_id SERIAL,
	reviewer INT,
	review_rating INT,
	review_content VARCHAR (10000),
	review_date DATE
--	CONSTRAINT pk_review PRIMARY KEY (review_id),
--	CONSTRAINT fk_reviewer FOREIGN KEY (reviewer) REFERENCES users (user_id)
);

CREATE TABLE review_response(
	response_id SERIAL,
	review_id INT,
	responder INT,
	response_content VARCHAR (10000)
--	CONSTRAINT pk_response PRIMARY KEY (response_id),
--	CONSTRAINT fk_review FOREIGN KEY (review_id) REFERENCES review (review_id),
--	CONSTRAINT fk_responder FOREIGN KEY (responder) REFERENCES users (user_id)
);

CREATE TABLE doctor_patient(
doctor_id INT,
patient_id INT
--CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
--CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patient (patient_id),
--CONSTRAINT pk_doctor_patient PRIMARY KEY (doctor_id, patient_id)
);

