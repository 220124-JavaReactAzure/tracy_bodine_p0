# tracy_bodine_p0

## Banking Application Assignment
- I have chosen to do the banking app for my Project Zero.

### Banking Application Details

#### User Stories

- The user needs to be able to:
	- register a new user account with the system (must be secured with a password)
	- login with my existing credentials
	- create at least one account
	- deposit funds into an account (use doubles, not ints)
	- withdraw funds from an account (no overdrafting!)
	- view the balance of my account(s) (all balance displays must be in proper currency format)
	- view the transaction history for an account
	- create multiple accounts per user (checking, savings, etc.)
	- share a joint account with another user
	- transfer money between accounts

#### Additionally
- Must be able to persist data into a relational database
- Use of custom data structures (do not use java.util Collection types!)
- Basic validation of user input (e.g. no registration for classes outside of registration window, no negative deposits/withdrawals, no overdrafting, etc.)
- Unit tests for all business-logic classes
- All exceptions are properly caught and handled
- Proper use of OOP principles
- Documentation (all classes and methods have basic documentation)
- Database is 3rd Normal Form Compliant
- Referential integrity (e.g. if a class is removed from the catalog, no students should be registered for it)
- Logging messages and exceptions to a file using a custom logger
- Generation of basic design documents (e.g. relational diagram, class diagram, flows, etc.)

#### Tech Stack
- Java 8
- Apache Maven
- PostgreSQL (hosted on Azure PostgreSQL Server)
- Git SCM (hosted on GitHub)


## First Steps
- Create Classes for:
	- Main Bank App Driver
	- Bank Information
	- Account Types
		- Checking
		- Savings
		- Mortgage
	- Customer Information
	- Actions
	- Create Relational DB
	- 
	
	