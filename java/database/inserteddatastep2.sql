INSERT INTO office (office_street_address, office_city, office_state, office_zip_code, 
					office_phone, office_open_time, office_close_time, office_open_days, office_name)
VALUES ('735 Ogletown Stanton Rd, #3302', 'Newark', 'DE', '19713', '302-623-1234', '8:00AM', '4:30PM', 'Monday - Friday', 'Spine Center'),
('14 Sandhill Dr, Unit 101', 'Middletown', 'DE', '19709', '302-378-1234', '8:00AM', '5:00PM', 'Monday - Friday', 'Familycare Associates LLC'),
('401 Brandywine Parkway, Suites 100 & 101', 'Wilmington', 'DE', '19803', '302-655-1234', '9:00AM', '5:00PM', 'Monday - Friday', 'Orthopaedic Specialists, PA'),
('383 Limestone Rd', 'Wilmington', 'DE', '19808', '302-274-1234', '8:00AM', '5:00PM', 'Monday - Friday', 'Plastic Surgery Associates'),
('920 Dupont Parkway', 'Townsend', 'DE', '19734', '302-449-1234', '8:00AM', '5:00PM', 'Monday - Friday', 'Pediatric Doctors of Delaware')
RETURNING office_id;

