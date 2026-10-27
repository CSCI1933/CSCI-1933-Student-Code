# CSCI 1933 Lab 07: Inheritance

Inheritance is the mechanism in Java by which one class is allowed to inherit the features (fields and methods) of another class. Inheritance is useful when we want to create a new class, and there is already a class which includes some of the features we want to implement. We can derive our new class from an existing class to reuse code.

The first inheritance mechanism we will be exploring is interfaces. Like a class, an interface can have methods and variables, but the methods declared in interfaces are abstract by default (only method signature, no implementation). Interfaces specify what a class must do, but not how. It is the blueprint of the class.

We can extend this idea even further by introducing abstract classes. Abstract classes contain variables and methods, and may even contain method implementations (unlike interfaces). However, abstract classes cannot be instantiated!

In this lab, you will be implementing an interface Drivable.java and extending an abstract class Vehicle.java. Both of these files are provided on Canvas. Remember that in this course, each class you write should be in a separate file.

Let's begin!

```bash
git pull
```
*Note: In the terminal, navigate to the top of the `CSCI-1933-Student-Code` directory using the `cd` command.*

## Milestone 1

### Implementing Drivable

Write an implementation for the following two classes.

- `public class Bike implements Drivable` - This class should be an implementation of the interface Drivable.java. Make each method print" \<class type\> moving \<direction\>", where \<class type\> is the name of the class and \<direction\> is either Forward or Backward
- `public class Scooter implements Drivable` - This class should be an implementation of the interface Drivable.java. Make each method print "\<class type\> moving \<direction\>", where \<class type\> is the name of the class and \<direction\> is either Forward or Backward

For example, calling `movingBackward()` on a Bike object should output "Bike moving backward".

### Milestone 1 Checkoff

> To test your classes, create a VehicleTester.java file that contains a main method to test each of the move methods in Bike and Scooter. Show this code to a TA.

## Milestone 2

### Extend Vehicle

Now we will work with an abstract class. Open the file Vehicle.java and examine the abstract class. Since all vehicles start and stop their movement by turning on an engine, these two methods have been explicitly implemented in the Vehicle class.

Implement the following three classes as children of the Vehicle class. For each class you write, you must implement the abstract methods provided in Vehicle, along with any other methods we ask you to implement for that specific class. Implement the move methods like you did before.

Make each moving method print \<class type\> moving <direction\>, where \<class type\> is the name of the class and \<direction\> is either Forward or Backward.

- `public class Car extends Vehicle` — Have a constructor that takes in one argument, `int mpg`, which represents a Car's MPG. Also add a default constructor that sets `mpg` to 30.0. `getMPG()` should just return `mpg`.
- `public class Helicopter extends Vehicle` — Implement the constructors and `getMPG()` as you did in the Car class, but with a default MPG of 0.3. After implementing the abstract methods, create two new ones:

  - `public void movingUp()` — Prints out "Helicopter moving up".
  - `public void movingDown()` — Prints out "Helicopter moving down".

- `public class Train extends Vehicle` — Implement the constructors and `getMPG()`, but with a default MPG of 470.0. After implementing the abstract methods, create two new ones:

  - `public void enteringStation()` — Prints out "Train entering station".
  - `public void leavingStation()` — Prints out "Train leaving station".

The Vehicle class also contains a member variable to keep track of the number of all Vehicle objects ever instantiated. You should make sure that your extending classes hold that property accordingly. You can test this out with the method public static final int getNumVehicles () from the Vehicle class.

Finally, add a toString method for each class that returns "\<class type\>: \<MPG\>". This will be important for seeing the results in Milestone 3.

When you are finished, try this code in VehicleTester:

```Java
Car car = new Car(30);
System.out.println(car);
car.movingForward();
car.movingBackward();
System.out.println("Total Number of Vehicles: " + Vehicle.getNumVehicles());
```

Should output:

  Car: 30.0
  Car moving forward
  Car moving backward
  Total number of vehicles: 1

**NOTE:** In order to access an element in the parent class, you can use "super.field" or "super.methodName()", but inherited "non-private" fields can be accessed directly in the child class.

### Milestone 2 Checkoff

Write more tests in your VehicleTester class to demostrate Car, Helicopter, Train, and `getNumVehicles()` work as intended and show them to a TA.

## Milestone 3

### Sorting Vehicles

Now that we have our parent class and three child extensions of it, let's explore another reason inheritance is useful.

### Implement compareTo()

You may have noticed that the Vehicle class implements the Comparable interface. This allows us to sort vehicles by some parameter, but to do so you must implement the compareTo method in
`this.compareTo(Vehicle v)` should return:

- less than 0 if v has a larger MPG than `this` Vehicle.
- greater than 0 if v has a smaller MPG than `this` Vehicle.
- 0 if v has the same MPG as `this` Vehicle and they are of the same class.
- Lexigraphic order if v has the same MPG as `this` Vehicle and they are of different classes.  

  - You can test this by using `v.getClass()`.

We have provided you with a file called VehicleSorter.java. This file acts as the testing area for the compareTo method that resides in the Vehicle class. Because each class inherits the same method from Vehicle.java, we can call compareTo on any Vehicle object and get a meaningful result. In VehicleSorter you will add several vehicles to the vehicles list provided to you. The Collections.sort method that is called on the list uses the compareTo method in the Vehicle class, so it will not sort correctly until compareTo is properly implemented.

### Milestone 3 Checkoff

Demonstrate for a TA your VehicleSorter class by printing the sorted list. Make sure the list is not sorted to begin with!
