This repository contains the solution for the Credit Check Test.
Inside the docs folder there are two documents:
Installation.odt: contains the instructions to install and test the solution
Design and Architecture.odt: contains the description of the solution, with its object model, service layer, and data model.

Remarks:
Due to time constraints (the description of the test said to spend from 3 to 6 hours), I  made the following simplifications:
There is no database provided with the solution, the data model was created having a relational database in mind (e.g. MySql).
Therefore only a stub of a data access layer was created as an example, in a real application I would consider using JPA and a ORM (e.g. Hibernate).
There is no user interface to test the solution, because making one with a javascript framework (e.g. Angular) as in the test description would require too much time.
For the same reason there is only a stub of a web services API, but I would use Jersey and create a RESTful API.
The test class DecisionEngineTest covers the user stories 3 and 4 requested in the test description.