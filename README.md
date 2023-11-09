# IDEA EDU course project

## Project
This is the *Bulls and Cows (Java)* project that is part of Hyperskill platform from Jetbrains Academy.

Purpose of the project is to learn Java OOP basics and to get more familiar with its ecosystem.

## Technologies

- Java 17

## Project description
Bulls and Cows CLI game application.

## Changelog
07.11.2023
- Created repo
- Printed predefined game log
- Completed stage 1

07.11.2023
- Implemented game skeleton
- Get number from the user and check it on a predefined (temp) 4 digit secret number.
- Compare the two numbers, a correctly guessed digit is a cow, and if its position is also correct, then it's a bull.
- After player tries to guess the word, program will print out a graded result.
- Completed stage 2

07.11.2023
- Removed predefined secret code
- Added method for creating a pseudo-random string digit
- It has a max length of 10 and a min length of 1
- Each digit from the string is between `0-9` and is unique
- Also there is a restriction regarding the generated secret, it cannot start with `0`
- Completed stage 3

07.11.2023
- Added main game loop
- Game will continue until the digit is found (or when the number of bulls is equal to the length of the secret word)
- Completed stage 4

07.11.2023
- refactored the previous solution for creating the secret code to using existing java methods like the `Math.random()`
- Completed stage 5

09.11.2023
- User will get asked for the range of possible characters in the secret code
- Symbols used to generate the secret can also contain lowercase latin characters `a-z`
- Now that the secret can contain letters, the secret can start with `0`, I've removed the restriction
- Also user will get a friendly message with the secret word hidden and showing the last/end numbers/letters, if both are used. 
- e.g `The secret is prepared: **** (0-9, a-f).`
- Completed stage 6

## Project status

Completed 6/7 stages