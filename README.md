# ITCS 4102 _ Extra Credit Acivity

This is a java program that uses data pulled from Twitter of a specific search string within a period of time,
to perform the following tasks:

	i)	The top n users who have tweeted the most related to the search string for the entire timeline 
	ii)	The top n users who have tweeted the most for every hour
	iii)The top n users who have the maximum followers
	iv)	The top n tweets which have the maximum retweet count

Note: The data pulled from twitter including: user name, number of followers, the content of the tweet, 
date of time the tweet was made and the number of retweets.
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for testing purposes. 

### Prerequisites
To compile java programs you must have JDK installed on your system. 
If you don’t have already installed, visit this links to install and configure Java on your system.

(http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html)

## Running the tests
The code can then be compiled and executed using command line arguments or using an IDE such as Eclipse.

A step by step series of examples that tell you to run the program using command line
This instruction applies for both Windows and MAC OS 

1.	First, navigate to the directory contains the java files

```
C:\extraCreditActivity>cd 4102Week13
```
2. To run a Java program, you first need to compile it. After compiling the java program a .class 
file created with the class name. 

```
C:\extraCreditActivity\4102Week13> javac Driver.java
```
Note: If you get the error "'javac' is not recognized as an internal or external command,
operable program or batch file.", refers to this link to set up the environment
(https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/)

3. Finally, run your java program with ‘java’ command.
```
C:\extraCreditActivity\4102Week13> java Driver 
```

## Built With

* [Java Pattern class](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html) 
* [Java Matcher class](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html) 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details