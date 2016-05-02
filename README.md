# Proco
Proco is a questionnaire application. The current version allows the user to test his or her knowledge in different topics related to Information Technologies and Programming Languages. The pilot version provides correct answers and allows the user to check off whether he/she feels that the question was answered correctly or not. The application provides statistical data after the test session is completed. If the user wishes, the test data can be saved along with the user's username and password.

- [Demo Application](http://tomcat-vgorbic1.rhcloud.com/proco/)
- [Problem Statement](#problem-statement)
- [Contents and Features](#contents-and-features)
- [Technologies and Techniques](#technologies-and-techniques)
- [Prototype and Design](#prototype-and-design)
- [Database](#database)
- [Project Plan](https://github.com/vgorbic1/proco/blob/master/project_plan.md)
- [Development Journal](https://github.com/vgorbic1/proco/blob/master/journal.md)
- [Time Log](https://github.com/vgorbic1/proco/blob/master/timeLog.md)

### Problem Statement
The author feels the need in an application that would attest his knowledge in a particular IT topic. Additionally, the program has to serve as a tool to memorize or refresh different technical concepts. The application may help with preparation for job interviews,  writing technical assignments or self-testing.

#### Issues
Information on many IT topics is scattered throughout the Internet. At times, it is difficult to define the level of knowledge on a particular subject or technology. Frequently, at a job interview, the employer asks the applicant to map his or her skill with a scale from one to ten. Such definition is highly biased and does not provide a real picture.

#### Objectives
Create a simple application that can test the user's knowledge in a particular field. Let the user choose a category of questions and the number of questions to answer. After giving the right answer, the program should let the user choose if his or her answer was right. Provide simple statistics on the current test session and recommend books or articles that will help in studying the topic. Give the user a choice to save the test's results.

#### Requirements
The application should have a simple but pleasant interface with intuitive navigation. The system should be secure. Updating of the questionnaire database should be done by an administrator. It should be simple, fast and secure. 

#### Constraints
The program should be written in Java and fully tested before May 15, 2016.

[Top &#8593;](#proco)

### Contents and Features
- A pool of questions and correct answers implemented using a database.
- User registration to allow access to past test results.
- A list of publications (books or articles) on the test specific topic.
- Hints, guides, or other documentation on how to use the application.
- Web services that allow access to the pool of questions and answers.

[Top &#8593;](#proco)

### Technologies and Techniques
#### Security / Authentication
- admin role: create/read/update questions and answers
- user role: perform tests; submit registration info in order to save test results; retrieve recent test statistics.
- all: anyone can take a test.

#### Database (MySQL and Hibernate)
- Store users and roles
- Store questions and answers
- Store user password and statistics

#### Web Services or APIs
- Service consumer: Get ISBN data for suggested publications.
- Service provider: Present question-answer pairs on a specific category or level. (under consideration)

#### CSS framework
- [Pure.css](http://purecss.io/)

#### Logging
- Configurable logging using Log4j. Only errors will normally be logged in a procoLog file.

#### Hosting
- Demo site and database hosted on [OpenShift](https://tomcat-vgorbic1.rhcloud.com/proco/).

#### Integration
- Jenkins for Continuous Integration. (under consideration)

#### Testing
- jUnit tests to achieve 80% code coverage.

#### Independent Research Topic:
- Encoding (Database settings to permit UTF-8 charset)

[Top &#8593;](#proco)

### Prototype and Design
#### Use Case Diagram
![Use Case Diagram](https://github.com/vgorbic1/proco/blob/master/images/use_case.jpg)
#### Pages - Views
|Page | URL | Description |
| --- | --- | --- |
|welcome|/|Describes the purpose of the application and invites visitor to take a test or check statistics from previously taken tests. |
|register|/register|Displays a form to accept visitor's username and password|
|test setup|/test-setup|Provides access to set categories, number of questions, and invites to take a test|
|test|/test|Displays a question, answer, and main controls. The last view provide statistics and invites user to take another test or save the statistics.|
|statistics|/stat|Display statistics on all tests, if user is successfully logged in. Invites to take another test|
|Administrator login|/admin/|Displays a form for administrator's login|
|Administrator's console|/admin/console|Displays a buttons to manage questions and users.|
|Add Question|admin/question-add|Displays a form to add new question.|
|All Questions|admin/questions-all|Displays a list of all questions available.|
|Edit Question|admin/edit-question|Displays a form to edit existing question.|
|error|error.jsp|Generic Error page. For example, if access to a resource is denied|

#### Screen Design
Application root:

![index.jsp](https://github.com/vgorbic1/proco/blob/master/images/index.jpg)

register.jsp

![register.jsp](https://github.com/vgorbic1/proco/blob/master/images/register.jpg)

test.jsp

![test.jsp](https://github.com/vgorbic1/proco/blob/master/images/test.jpg)

quest.jsp question only

![quest.jsp](https://github.com/vgorbic1/proco/blob/master/images/quest_q.jpg)

quest.jsp question with answer

![quest.jsp](https://github.com/vgorbic1/proco/blob/master/images/quest_a.jpg)

stat.jsp

![stat.jsp](https://github.com/vgorbic1/proco/blob/master/images/stat.jpg)

admin/tests.jsp

![admin/tests.jsp](https://github.com/vgorbic1/proco/blob/master/images/admin_tests.jpg)

#### Application Flow
![app_flow.jsp](https://github.com/vgorbic1/proco/blob/master/images/app_flow.jpg)

[Top &#8593;](#proco)

### Database
#### Database Diagram
![db.jsp](https://github.com/vgorbic1/proco/blob/master/images/db.jpg)

####Table Structure
**Table users**

|column name|datatype|constraints|
|---|---|---|
|user_id|int(11)|pimary key, auto_increment, not null|
|username|varchar(255)|not null|
|pass|varchar(255)|not null|

**Table users_roles**

|column name|datatype|constraints|
|---|---|---|
|username|varchar(255)|pimary key, not null|
|role|varchar(255)|pimary key, not null|

**Table questions**

|column name|datatype|constraints|
|---|---|---|
|question_id|int(11)|pimary key, auto_increment, not null|
|category|varchar(50)|not null|
|level|varchar(50)|not null|
|inquiry|text|not null |
|answer|test|not null|

[Top &#8593;](#proco)
