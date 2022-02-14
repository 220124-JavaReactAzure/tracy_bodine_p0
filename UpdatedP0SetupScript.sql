--Database creation script for Tracy Bodine's P0 Project
--Formated with ctrl+f

--drop table if exists account;
--drop table if exists customer;


CREATE TABLE IF NOT EXISTS customer (
	customer_id varchar (40) PRIMARY KEY,
	firstname varchar (40) NOT NULL,
	lastname varchar (40) NOT NULL,
	email varchar (255) UNIQUE NOT NULL,
	username varchar(40) UNIQUE NOT NULL,
	password varchar(40) NOT NULL 	
);

SELECT
	*
FROM
	customer;

CREATE TABLE IF NOT EXISTS account (
	accountid varchar (40) CHECK (accountid <> ''),
	accountname varchar(40) NOT NULL CHECK (accountname <> ''),
	accounttype varchar(40) NOT NULL CHECK (accounttype <> ''),
	accountbalance numeric,
--	accountbalance varchar (40) NOT NULL CHECK (accountbalance <> ''),
	originator varchar(40) NOT NULL CHECK (originator <> ''),
--	originator_id varchar (40) NOT NULL CHECK (originator_id <> ''),
	CONSTRAINT account_pk PRIMARY KEY (accountid),
--	CONSTRAINT accountoriginator_fk FOREIGN KEY (originator_id)REFERENCES customer(customer_id)
	CONSTRAINT accountoriginator_fk FOREIGN KEY (originator)REFERENCES customer(username)
);

SELECT
	*
FROM
	account;
