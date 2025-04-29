
DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    salary DOUBLE
);
INSERT INTO employees VALUES (1, 'Alice', 'HR', 50000.0);
INSERT INTO employees VALUES (2, 'Bob', 'IT', 60000.0);
INSERT INTO employees VALUES (3, 'Charlie', 'Finance', 55000.0);
