# 1933 Homework 10: Queues
A Queue is a data structure that adds from the back and removes from the front. It's just like a real world queue when you're waiting in line-- you get in the back of the line, wait as people from the front get processed, and you only leave the line once you reach the front. This behavior is called "First In, First Out", or "FIFO" for short, since the earlier you get in line the earlier you will get through the line.

We traditionally call the operation of *adding* an item to the back of the queue **"enqueuing"**, and *removing* an item from the front of the queue **"dequeuing"**.

In this assignment, we will implement the Queue data structure in two ways: using linked nodes, and using an array base.
### Associated zyBooks Reading
- 6.2 Queues
## File Structure
In this folder, we have provided `Node.java` to represent a Node that holds integer data and has a next pointer, and `IQueue.java` which is the interface that defines the methods that we'll include in each of our Queue implementations:
- `void enqueue(int data)`
- `int dequeue()`
- `boolean isEmpty()`
## 1. Linked-Nodes-Based Queue
Create a new file called `LinkedQueue.java` that defines a `LinkedQueue` class. This should implement our `IQueue.java` interface.

Since we are adding and removing from opposite ends, we need to have quick access to both ends of the linked list. This motivates us keeping both a head and tail pointer-- we'll consider the head to be the front of our queue, since we'll easily be able to remove elements from the front by moving the head forward.

So let's create two instance variables, and let's name them in ways that will make it easy to remember which reference holds which end of the queue:
- `Node front` - this will be the head of the linked list, which is where we remove from
- `Node back` - this will be the tail of the linked list, which is where we add to

When a queue is empty, both of these variables will be `null`. This actually means we don't need to explicitly write a constructor method-- Java by default provides a hidden constructor method for each class that leaves all of the instance variables at their default value, and since both of the instance variables are reference types, their default value is `null`. However, it may be helpful to explicitly write a constructor method for readability, which would look like this:
```Java
public LinkedQueue() {
// Constructor is Optional: the instance variables already store null by default
	front = null;
	back = null;
}
```

Now we must implement the three methods listed in the interface!

### `enqueue(int data)`
When we enqueue, we want to add a new node that stores `data` to the end of the queue. We can do this super easily in O(1) constant time thanks to our `back` instance variable that serves as a tail pointer!

It's important to remember that this is an unheaded linked list though. (Recall that unheaded means there is *no* dummy node kept at the front of the list. Our `front` variable will store `null` when the list is empty.) This mandates that we have two cases, one for when `front` is `null`, and another for when it isn't null, meaning there is at least one node in the sequence.
1. If the list is empty, meaning `front == null`
   - We should add the new node directly into the sequence. Remember that we need to update both the `front` and `back` variables-- since the new node is the *only* node in the sequence, it is actually *both* the front and back!
2. If the list is not empty, meaning `front != null`
   - We simply need to add the new node to the end of the sequence. We should place the new node after our `back` variable, but don't forget to update the `back` variable to reflect the fact that there is a new node at the very back of the queue.

### `dequeue()`
While we added to the back of the queue, we want to remove from the front. Our `dequeue` method should remove the first node from the sequence and return the value stored inside of it.

Start by saving the data stored in the front node-- if we don't save this first then we'll have no way of returning this data later after removing it from the sequence!

Then we need to actually perform the removal step. How can we update our instance variables to remove the first node from the sequence? Once you do that step, you can return the saved data.

Consider the special case where we dequeue the last element in the queue. Make sure we update *both* our `front` and `back` pointers correctly in this case!

Make sure to write a check to ensure your code doesn't throw an exception if `dequeue()` is called on an empty queue. In this case, you can return a default value of `-1`.
### `isEmpty()`
Write a boolean statement that returns whether the linked list is empty.

### Testing the Class
Add this `toString` method to `LinkedQueue.java`.
```Java
public String toString() {  
    String outputString = "";  
    Node curr = front;  
    while (curr != null){  
        outputString += curr.getData();  
        if (curr.getNext() != null){  
            outputString += ", ";  
        }  
        curr = curr.getNext();  
    }  
    return "FRONT > [" + outputString + "] < BACK";  
}
```

Write your own `main` method that tests your `enqueue`, `dequeue`, and `isEmpty` methods.
## 2. Array-Based Queue
### Thought Process
Before we start our implementation of the Array-Based queue, we should think through how to best handle this implementation.

One important realization is that arrays have fixed size and always store exactly that number of elements. For an integer array, each cell of the array will store the default value of 0 until it is replaced, so we will need to have additional logic to tell the queue which elements to consider to be part of the queue, and which elements are currently unused spots in the array.

An obvious first idea is to have elements simply be added at the back of the array and removed from the front, which could look something like this for an underlying array of size 5:
```
Initial State:
[0, 0, 0, 0, 0]

enqueue(1)
[1, 0, 0, 0, 0]

enqueue(2)
[1, 2, 0, 0, 0]

enqueue(3)
[1, 2, 3, 0, 0]

dequeue()
[2, 3, 0, 0, 0]
```
The issue with this basic approach is that we need to shift all elements to the left every time we dequeue, which makes it an O(n) operation. We could improve this to O(1) by making it so the front of the queue is not necessarily at the front of the array-- let's add variables that allow us to track where the ends of the queue are, and we will be able to move these dynamically when we add and remove elements.

In this example, `S` will represent the start of the queue and `E` will represent the end:
```
Initial State:
[0, 0, 0, 0, 0]
 S
 E
 
enqueue(1)
[1, 0, 0, 0, 0]
 S  E
 
enqueue(2)
[1, 2, 0, 0, 0]
 S     E
 
enqueue(3)
[1, 2, 3, 0, 0]
 S        E
 
dequeue()
[1, 2, 3, 0, 0]
    S     E
    
dequeue()
[1, 2, 3, 0, 0]
       S  E
       
enqueue(4)
[1, 2, 3, 4, 0]
       S     E
       
enqueue(5)
[1, 2, 3, 4, 5]
 E     S     
 
enqueue(6)
[6, 2, 3, 4, 5]
    E  S     
```
Notice how we looped back from the end to the start of the array (kind of like PacMan going off the right side of the screen and reappearing on the left). This behavior can easily be captured using the remainder/modulo operator ( `%` ).

<details>
    <summary>Click for a brief explanation of Modulo</summary>
Recall that the `%` operator gives the remainder of division. For example:

- `17 % 5 = 2` because `17 = 5*3+2`
- `123 % 100 = 23` because `123 = 100*1+23`

As it is a remainder, note the only possible values for `x % n` are `0` to `n-1`. For example, consider many values of `x % 3`:

- `0 % 3 = 0     (3*0+0)`
- `1 % 3 = 1     (3*0+1)`
- `2 % 3 = 2     (3*0+2)`
- `3 % 3 = 0     (3*1+0)`
- `4 % 3 = 1     (3*1+1)`
- `5 % 3 = 2     (3*1+2)`
- `6 % 3 = 0     (3*2+0)`
- `7 % 3 = 1     (3*2+1)`
- `8 % 3 = 2     (3*2+2)`

Notice how the result strictly loops between 0, 1, and 2. This is the behavior that will be useful for allowing us to loop between the ends of the array, so when we index off the right side of the array it goes back to the left side.

If we were to take a number `x % array.length`, it will always evaluate to a value between `0` and `array.length - 1` inclusively, which are exactly the valid indices.

</details>

## Array Queue Structure
Create a new file called `ArrayQueue.java` that defines an `ArrayQueue` class. This should implement our `IQueue.java` interface.

We're going to need three instance variables:
- `int[] array`, which will be the array that we store our queue elements in
- `int frontIndex`, which will store the index number of the front element
- `int numElements`, which will store the total number of elements stored in the queue. We can use this in combination with `frontIndex` to figure out where the back of the queue is.

Let's create a constructor for `ArrayQueue` that takes in a `size` parameter to initialize an array of that size:
```Java
public ArrayQueue(int size){
	// Constructor Code Here
}
```
### `enqueue(int data)`
The first step is to compute the index of the array that we should add this new element to. Create a new variable called `int index` that will store this index value.

Remember that we are using the `frontIndex` instance variable to save the location of the start of the queue. The end of the queue would be `numElements` ahead of the start of the queue, so what expression would evaluate to the index of the end of the queue? And what should we include in this expression to ensure the computed value loops back when it goes off the right side of the array?

Once you have computed the `index`, you can store `data` in this index of the array. Finally, make sure to increase `numElements` since we have now added a new element to our queue.

Note that the fact that arrays have fixed size means that there is a natural maximum capacity for how many elements we can enqueue in the queue. Make sure to write a check that ensures you don't throw an exception if `enqueue` is called when there is no room in the array to add another element to the queue. Your code does not need to do anything in this case, it just needs to avoid the error.

Additionally, consider how you would utilize a dynamic array to create an array-based queue with an unfixed size.

### `dequeue()`
To dequeue, let's start by saving the front element of the queue in a variable so we can easily return it later.

Then, remember that we're using `frontIndex` to store the index of the first element in the queue. If we are removing an element from the front of the queue, this will now make it so the element immediately *after* this one will be the new front element. Write a line of code to move `frontIndex` forward, but remember that it has to loop back around to the left side of the array if it goes off of the right side.

Don't forget to update the `numElements` instance variable to reflect how the number of elements have changed.

Finally, you can return the original front element that was just removed.

Make sure to write a check to ensure your code doesn't throw an exception if `dequeue()` is called on an empty queue. In this case, you can return a default value of `-1`.
### `isEmpty()`
What instance variable can we check in our queue to see if there are no elements inside of it?

### Testing the Class
Add this `toString` method to `ArrayQueue.java`. This will output a string in the exact same format as for a `LinkedQueue`.
```Java
public String toString() {
   String outputString = "";
   for (int i = 0; i < numElements; i++){
      outputString += array[(frontIndex + i) % array.length];
      if (i<numElements-1) {
         outputString += ", ";
      }
   }
   return "FRONT > [" + outputString + "] < BACK";
}
```

Write your own `main` method that tests your `enqueue`, `dequeue`, and `isEmpty` methods.

## Submission
Go to the Homework 10 submission on Gradescope, and add `LinkedQueue.java` and `ArrayQueue.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.

