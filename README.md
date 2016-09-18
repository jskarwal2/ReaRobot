# ReaRobot
Coding Problem for Rea Group

How to compile and run the application:

This is a command line application. Maven has been used as build tool. To compile and run junit test cases just run

mvn clean install 

in the project home directory.

To run the program, go to target directory. This directory should have a file name ReaRobot-1.0.jar if build was successful. Run

java -jar ReaRobot-1.0.jar 

to start the program.

Assumptions:

It has been assumed that usage of any framework like Spring or usage of third party liberaries like Apache or Log4j etc was out of scope for this project. Only standard language(Java) libraries were used to solve the problem.

Due to above limitations, reviewers may find tight coupling in some parts of the program.

Coding Principles followed :

1. Code to interfaces.
2. Open and Close principle (Open for extention, closed for modifcation).

