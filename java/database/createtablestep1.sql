CREATE TABLE doctor (
doctor_npi VARCHAR (50) NOT NULL UNIQUE,
user_id INT NOT NULL,
doctor_fullname VARCHAR (100) NOT NULL,
office_id VARCHAR (25) NOT NULL,
doctor_phone_number VARCHAR (20),
doctor_email VARCHAR (50),
CONSTRAINT pk_doctor PRIMARY KEY (doctor_npi),
CONSTRAINT fk_doctor_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);
-- alter table with foreign key for office id

CREATE TABLE office (
office_id SERIAL NOT NULL,
doctor_id VARCHAR,
office_street_address VARCHAR (100) NOT NULL,
office_city VARCHAR (50) NOT NULL,
office_state VARCHAR (50) NOT NULL,
office_zip_code VARCHAR (15) NOT NULL,
office_phone VARCHAR (20) NOT NULL,
office_open_time TIME NOT NULL,
office_close_time TIME NOT NULL,
office_open_days VARCHAR (15) NOT NULL,
CONSTRAINT pk_office PRIMARY KEY (office_id),
CONSTRAINT fk_office_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_npi)
);

CREATE TABLE availability(
availability_id SERIAL NOT NULL,
doctor_id VARCHAR NOT NULL,
time_slot TIMESTAMP NOT NULL,
CONSTRAINT pk_availability_id PRIMARY KEY (availability_id),
	CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_npi)
);
-- confirm that timestamp is correct data type

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
patient_dob DATE,
CONSTRAINT pk_patient PRIMARY KEY (patient_id),
CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE appointment(
	appointment_id SERIAL,
	patient_id INT NOT NULL,
	availability_id INT NOT NULL,
	CONSTRAINT pk_appointment PRIMARY KEY (appointment_id),
	CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patient (patient_id),
	CONSTRAINT fk_availability FOREIGN KEY (availability_id) REFERENCES availability (availability_id)
);





