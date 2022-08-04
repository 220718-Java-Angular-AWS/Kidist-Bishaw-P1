create TABLE employees
(
    emp_id 	SERIAL,
    emp_first_name VARCHAR(100),
    emp_last_name VARCHAR(100),
    emp_address_id INT NOT NULL,
    emp_email VARCHAR(200),
    emp_emp_password VARCHAR(200),
    emp_role VARCHAR(100),
    CONSTRAINT employees_pk PRIMARY KEY (emp_id),
    CONSTRAINT emp_email_unique UNIQUE (emp_email),
    CONSTRAINT employees_address_fk FOREIGN KEY (address_id) REFERENCES address (address_id)
);


CREATE TABLE expensetypes (
	expense_id serial,
	expense_type varchar(200) NULL,
	description varchar(200) NULL,
	costlimit decimal(10, 2) NULL,
	CONSTRAINT expensetypes_pkey PRIMARY KEY (expense_id)
);


create table reimbursments
(
	reimbursment_id SERIAL ,
	user_name VARCHAR(200),
	email VARCHAR(200),
	password VARCHAR(200),
	constraint user_pk primary key (user_id)
);


CREATE TABLE address
(
	address_id		SERIAL,
	address			VARCHAR(200),
	city			VARCHAR(200),
	state			CHAR(2),
	zip				INT NOT NULL,
	CONSTRAINT address_pk PRIMARY KEY (address_id)
);


