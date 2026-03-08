Nama : Gede Satya Putra Aryanta

NRP : 5027251012

## Repo ini akan berisi project-project atau tugas dari mata kuliah Strukdat

### Project 1. OOP, project Cat mhmmhmhmhm

This project is inspired by my cat in a video game called "Heartopia"

Plan : Make a cat class and have three attribute: Mood, energy, hunger. Then make a method that does various things such as eating, playing, petting the cat, etc.
Try to implement the four pillars of OOP (Encapsulation, Abstraction, Inheritance, and Polymorphism). 

Note to myself in the future, don't use AI to write code. Use AI to ask how to code

Project explanation :

This project is a simple Java program created to demonstrate the **four pillars of Object-Oriented Programming (OOP)**:
**Encapsulation, Inheritance, Abstraction, and Polymorphism.**

The program simulates different types of cats with shared behaviors such as eating and being petted, while allowing each type of cat to have its own unique way of playing.

---

# Project Overview

The base class `Cat` represents the general concept of a cat.
Two specific types of cats extend this class:

* **PersianCat**
* **SiameseCat**

All cats share common properties such as:

* name
* mood
* energy
* hunger

They also share common behaviors like eating, being petted, and showing their current status.

However, each type of cat behaves differently when playing.

---

# OOP Concepts Implemented

## 1. Encapsulation

Encapsulation is used to protect the internal data of the `Cat` class.
The attributes are declared as `private` so they cannot be accessed directly from outside the class.

```java
private String name;
private String mood;
private int energy;
private int hunger;
```

Getter methods are provided to access the values safely:

```java
public String getName()
public String getMood()
public int getEnergy()
public int getHunger()
```

This ensures the internal state of each object is controlled through class methods such as `eat()`, `pet()`, and `play()`.

---

## 2. Inheritance

Inheritance allows specific types of cats to reuse the behavior defined in the `Cat` class.

```java
class PersianCat extends Cat
class SiameseCat extends Cat
```

Both subclasses inherit methods like:

* `eat()`
* `pet()`
* `showStatus()`

This prevents code duplication and makes the design easier to maintain.

---

## 3. Abstraction

The `Cat` class is declared as an **abstract class**:

```java
public abstract class Cat
```

It contains an abstract method:

```java
public abstract void play();
```

This means every type of cat **must define its own way of playing**, while the base class only specifies that the behavior must exist.

Example implementations:

**PersianCat**

```java
@Override
public void play(){
    System.out.println(getName()+" is laying on its back");
}
```

**SiameseCat**

```java
@Override
public void play(){
    System.out.println(getName()+" is jumping everywhere!");
}
```

---

## 4. Polymorphism

Polymorphism allows objects of different subclasses to be treated as objects of the same parent class.

```java
Cat Tabi = new PersianCat("Tabi","Happy",50,50);
Cat Grayie = new SiameseCat("Grayie","Tired",0,0);
```

Even though both variables are declared as `Cat`, they behave differently when `play()` is called:

```java
Tabi.play();
Grayie.play();
```

Each object executes its own version of the method, demonstrating **runtime polymorphism**.

---

# Example Output

Example output from the program:

```
You offered Tabi to eat
Tabi is eating
You want to pet Tabi
Done Petting
You want to play with Tabi
Tabi is laying on its back
My cat Tabi is happy, its energy is: 50 and its hunger is 60

You offered Grayie to eat
Grayie is eating
You want to pet Grayie
Done Petting
You want to play with Grayie
Grayie is jumping everywhere!
My cat Grayie is tired, its energy is: 0 and its hunger is 10
```

---

# How to Run

1. Compile the program

```
javac Cat.java
```

2. Run the program

```
java Cat
```

---

# Author

Created as a simple demonstration of **Object-Oriented Programming in Java**.

In the main method, both cats are stored using the Cat reference type:

Although both variables are declared as Cat, the actual objects are different subclasses.

When the play() method is called, Java automatically executes the correct implementation depending on the object's actual type. This behavior is known as runtime polymorphism.
