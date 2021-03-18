# Motivation Balance

---

A web-application for organizations to collect their employees' attitude on any factors (as for playstation, free coffee, scrum etc).

---

### Technology stack
* Spring 5
* Angular 11 **([link to a frontend repo](https://github.com/Bases16/ng-motivation-balance))**
* Spring-Security
* JPA (Hibernate)
* JTA (Atomikos)
* PostgreSQL
* JUnit 4
* Maven
---

### Try it now!
Click **[this link](https://ng-motivation-balance-demo.web.app)** and check if the application is deployed right now.   
First request to the server probably will take a while to "wake up" the backend after some time of not being used.  
Sign up a new user(with a role "SPECIALIST") or use credentials below:
- ADMIN (email: admin@test.com,  password: pass)
- MANAGER (email: manag1@test.com,  password: pass) - might be deleted
- SPECIALIST (email: spec1@test.com,  password: pass) - might be deleted

---

### Functionality
There is a **survey** with relevant factors and employees should take this survey to express their attitude on the factors.  
There are 3 options to choose on each factor: **LIKE, NEUTRAL and DISLIKE.**  
These estimations have their numeric equivalent: +1, 0 and -1 respectively.  
**All estimations are summed up and form a total balance**.  
With that we can see current motivation balance of an employee.

#### There are 3 types of users: ADMIN, MANAGER and SPECIALIST.
- **SPECIALIST** is able to take the survey and see history of own survey results.
- **MANAGER** as an employee is able to take the survey as well and also see results of employees related to this manager.
- **ADMIN**  is able to add/remove current factors, turn a specialist into a manager and vice-versa, assign employees to a particular manager, see all results, see overall statistic etc.

