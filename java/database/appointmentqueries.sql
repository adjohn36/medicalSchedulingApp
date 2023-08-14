-- make availability slot in doctor_schedule table, remove availability from schedule_appointment


SELECT * FROM appointment;

SELECT * FROM schedule_appointment;

SELECT * FROM schedule;

SELECT * FROM doctor_schedule;

INSERT INTO appointment (patient_id, doctor_schedule_id, date_selected)
VALUES ('1', '7', '08/14/2023')
RETURNING appointment_id;
--doctor_id = 1, schedule_id = 5

SELECT schedule_id FROM doctor_schedule JOIN doctor ON doctor_schedule.doctor_id = doctor.doctor_id 
WHERE doctor.doctor_id = '5';

--from schedule_appointment table get available time slot

SELECT date_selected FROM appointment JOIN schedule_appointment ON appointment.appointment_id = schedule_appointment.appointment_id;

SELECT schedule_id FROM doctor_schedule WHERE doctor_id = '5';

SELECT schedule_id, date_selected FROM doctor_schedule JOIN appointment ON doctor_schedule.doctor_schedule_id = appointment.doctor_schedule_id WHERE doctor_id = '5';

SELECT schedule_id FROM schedule WHERE schedule_id != '9';



INSERT INTO schedule_appointment (appointment_id, schedule_id)
VALUES ('1', 'SELECT schedule_id FROM schedule_appointment JOIN doctor_schedule ON schedule_id WHERE schedule_appointment.schedule_id = doctor_schedule.schedule_id')

--booking appointment updates appointment and schedule_appointment tables

SELECT schedule_appointment.schedule_id  FROM schedule_appointment JOIN doctor_schedule ON schedule_appointment.schedule_id = doctor_schedule.doctor_schedule_id

WHERE doctor_schedule.doctor_id = '5';


SELECT * FROM appointment
JOIN doctor_schedule ON appointment.doctor_schedule_id = doctor_schedule.doctor_schedule_id
JOIN doctor ON doctor_schedule.doctor_id = doctor.doctor_id
JOIN patient ON appointment.patient_id = patient.patient_id;