# Teacher [![travis-ci](https://travis-ci.org/felipepssouza/Teacher.svg?branch=master)](https://travis-ci.org/felipepssouza/Teacher) [![codecov](https://codecov.io/gh/felipepssouza/Teacher/branch/master/graph/badge.svg)](https://codecov.io/gh/felipepssouza/Teacher) <a href="https://codeclimate.com/github/felipepssouza/Teacher/maintainability"><img src="https://api.codeclimate.com/v1/badges/0088d15121216f6c5ceb/maintainability" /></a>


Project responsible to group words and get average of vowels of this groups

## TODO
- Class to get average of vowels per group (GroupedWords)
- Class responsible to print in this format ({a, o}, 6) -> 2.5 -> to represent group of words and average vowels
- Put dependency injection on classes
- Facade class to get those use case classes and the printer class
- Input class to receive the file to parse the words 


## Teacher - How it is organized:

Following the Clean Architeture of Uncle Bob. This is the structure: 
```
-ROOT
  - config (The bootstrap of the system is here, and any possible system configuration, like external confs)
  - usecase (Here are all the business rules)
```




