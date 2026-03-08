Nama : Gede Satya Putra Aryanta

NRP : 5027251012

## Repo ini akan berisi project-project atau tugas dari mata kuliah Strukdat

### Project 1. OOP, project Cat mhmmhmhmhm

This project is inspired by my cat in a video game called "Heartopia"

Plan : Make a cat class and have three attribute: Mood, energy, hunger. Then make a method that does various things such as eating, playing, petting the cat, etc.
Try to implement the four pillars of OOP (Encapsulation, Abstraction, Inheritance, and Polymorphism). 

Note to myself in the future, don't use AI to write code. Use AI to ask how to code

Project explanation :

In this project, I implemented the four main principles of Object-Oriented Programming (OOP): Encapsulation, Inheritance, Abstraction, and Polymorphism. The program simulates different types of cats with shared behaviors and specialized actions.

**Encapsulation**
  
Encapsulation is implemented by restricting direct access to the internal data of the Cat class. The attributes of the cat are declared as private so they cannot be modified directly from outside the class.

**Inheritance**

Inheritance is used to create specific types of cats that share the common properties and behaviors defined in the Cat class.
Because of inheritance, both subclasses automatically gain access to the methods defined in Cat, such as:

eat()

pet()

showStatus()

getter methods

This avoids rewriting the same functionality and allows specialized behavior to be added when necessary.

**Abstraction**

Abstraction is applied by defining Cat as an abstract class:

Inside the class, the play() method is declared as an abstract method:

This means every type of cat must implement its own version of how it plays. The base class only defines that a cat must be able to play, but the exact behavior is left to the subclasses.


**Polymorphism**

Polymorphism allows objects of different classes to be treated as objects of the same parent class.

In the main method, both cats are stored using the Cat reference type:

Although both variables are declared as Cat, the actual objects are different subclasses.

When the play() method is called, Java automatically executes the correct implementation depending on the object's actual type. This behavior is known as runtime polymorphism.
