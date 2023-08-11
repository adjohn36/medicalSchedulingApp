INSERT INTO doctor_schedule (doctor_id, schedule_id)
VALUES ('1', '2'), ('1', '3'), ('1', '4'), ('1', '5'), ('1', '6'), ('1', '7'), ('1', '8'), ('1', '20'), ('1', '21'), ('1', '22'), ('1', '23'),
('1', '35'), ('2', '1'), ('2', '2'), ('2', '3'), ('2', '4'), ('2', '5'), ('2', '6'), ('2', '7'), ('2', '8'), ('2', '9'), ('2', '50'), ('2', '55');

INSERT INTO doctor_schedule (doctor_id, schedule_id)
VALUES ('3', '67'), ('4', '80'), ('5', '89');

INSERT INTO doctor_office  (office_id, doctor_id)
VALUES ('2', '2'), ('3', '3'), ('4', '4'), ('5', '5');

INSERT INTO appointment (patient_id, doctor_schedule_id, date_selected)
VALUES ('2', '9', '08/14/2023'), ('3', '25', '08/16/2023'), ('2', '14', '08/15/2023'), ('4', '27', '08/17/2023'), ('5', '29', '08/18/2023');