CREATE TABLE departments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE professors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    department_id BIGINT,

    FOREIGN KEY (department_id)
        REFERENCES departments(id)
);

CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    department_id BIGINT,

    FOREIGN KEY (department_id)
        REFERENCES departments(id)
);

CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    professor_id BIGINT,

    FOREIGN KEY (professor_id)
        REFERENCES professors(id)
);

CREATE TABLE student_courses (
    student_id BIGINT,
    course_id BIGINT,

    PRIMARY KEY (student_id, course_id),

    FOREIGN KEY (student_id)
        REFERENCES students(id),

    FOREIGN KEY (course_id)
        REFERENCES courses(id)
);

