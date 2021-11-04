-- Changing the starting point of starting Primary Key in the database.
-- The number should be greater than the Primart Key in the database.
ALTER TABLE hb_student_tracker.student AUTO_INCREMENT = 3000;

-- Clean up the DB and start AUTO_INCREMENT from value 1?
-- This will delete all the rows from DB and reset sequence 
-- to 1
TRUNCATE hb_student_tracker.student;
