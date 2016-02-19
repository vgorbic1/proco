# Proco
Proco is a questionnaire application. The current version allows the user to test his knowledge in different topics related to Information Technologies and Programming Languages. The pilot version provides correct answers and allows the user to check off whether he/she feels that the question was answered correctly or not. The application provides statistical data after the test session is completed.

- [Demo Application](http://tomcat-vgorbic1.rhcloud.com/proco/)
- [Problem Statement](#problem-statement)
- [Contents and Features](#contents-and-features)
- [Technologies and Techniques](#technologies-and-techniques)
- [Prototype and Design](#prototype-and-design)
- [Database](#database)
- [Project Plan](https://github.com/vgorbic1/proco/blob/master/project_plan.md)
- [Development Journal](https://github.com/vgorbic1/proco/blob/master/journal.md)

### Problem Statement
The author feels a need in an application that would attest his knowledge in a particular IT topic. Additionally, the program has to serve as a tool to memorize or refresh different technical concepts. The application may help with preparation for job interviews or writing technical assignments.

#### Issues
Information on many IT topics is scattered throughout the Internet. At times, it is difficult to define the level of knowledge on a particular subject or technology. Frequently, at a job interview, the employer asks the applicant to map his or her skill with a scale from one to ten. Such definition is highly biased and does not provide real picture.

#### Objectives
Create a simple application that can test user's knowledge in a particular field. Let user choose category of questions and the number of questions to answer. After giving the right answer, the program should let the user to choose if his or her answer was right. Provide simple statistics on the current test session and recommend books or articles that will help studying the topic.

#### Requirements
The application should have simple but pleasant interface with intuitive navigation. The system should be secure. Updating of the questionnaire database should be simple, fast and secure. 

#### Constraints
The program should be written in Java and fully tested before May 15, 2016.

[Top &#8593;](#proco)

### Contents and Features
- A pool of questions and correct answers implemented using a database.
- User registration to allow access to past session results.
- A list of publications (books or articles) on the topic.
- Hints, guides, or other documentation on how to use the application.

[Top &#8593;](#proco)

### Technologies and Techniques
#### Security / Authentication
- admin role: create/read/update/delete (crud) questions and answers
- user role: submit registration info get test results
- all: anyone can view list of publications (no login required)

#### Database (MySQL and Hibernate)
- Store users and roles
- Store questions and answers
- Store user password and statistics

#### Web Services or APIs
- ISNB data for suggested publications

#### CSS framework
- Pure CSS

#### Logging
- Configurable logging using Log4J. Only errors will normally be logged.

#### Hosting
- Demo site and database hosted on [OpenShift](https://tomcat-vgorbic1.rhcloud.com/pico/)

#### Integration
- Jenkins for Continuous Integration

#### Testing
- jUnit tests to achieve 80% code coverage

#### Independent Research Topic:
- Encoding

[Top &#8593;](#proco)

### Prototype and Design
#### Use Case Diagram
![Use Case Diagram](https://github.com/vgorbic1/proco/blob/master/images/use_case.jpg)
#### Pages - Views
|Page | File| Description |
| --- | --- | --- |
|welcome|index.jsp|Describes the purpose of the application and invites visitor to register in order to take a test|
|register|register.jsp|Displays a form to accept visitor's username and password|
|login|login.jsp|Displays a form to log in the app|
|test|test.jsp|Provides access to set categories, number of questions, and invites to take a test|
|question|quest.jsp|Displays a question, answer, and main controls|
|statistics|stat.jsp|Display statistics on the taken test. Invites to take another test|
|admin-login|admin/login.jsp|Displays a form for administrator's login|
|admin-console|admin/tests.jsp|Displays a form to add or remove question / answer / category|
|error|error.jsp|Generic Error page. For example, if access to a resource is denied|

#### Screen Design
[image]
#### Application Flow
[image]

[Top &#8593;](#proco)

### Database
#### Database Diagram
[image]
####Table Structure
[image]

[Top &#8593;](#proco)
