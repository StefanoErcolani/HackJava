-- SELECT * FROM courses;
-- SELECT * FROM lessons;
-- SELECT * FROM students;
INSERT INTO courses (
    name,
    description,
    teacher_firstname,
    teacher_lastname
  )
VALUES (
    'name:varchar',
    'description:varchar',
    ':varchar',
    ':varchar'
  );
INSERT INTO lessons (description, course_id)
VALUES (
    'description:varchar',
    1
  );