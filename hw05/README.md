# 1933 Homework 5: Linked Lists
So far in this course, we have mostly used arrays to store collections of data, but you may have noticed that arrays are somewhat "rigid". They have a fixed size, and you end up needing to shift many elements if you want to add or remove elements in the middle of the array without leaving gaps. 

A Linked List is an alternative data structure that gives us a more flexible way of storing collections, where there is no fixed capacity and elements can easily be modified anywhere in the list.

Linked Lists are built on a fundamental data structure called Linked Nodes, which is a general term for structures built from nodes that store data and are linked together by references.

A Linked List is a linear ordering of linked nodes. By modifying references, nodes can be inserted or deleted at any point in the list in constant time.

In this assignment we will create the most basic operations of a Linked List!
### Associated zyBooks Reading
- 3.6 Singly linked lists
## Node Class
Before we can start thinking about making the Linked List, we need to start by making Nodes! Create a new file called `Node.java` that defines a `Node` class.

When it comes to the nodes of a Linked List, we need two instance variables:
- `data`, which represents the actual data being stored by a node. In this example, let's make this of type `int`
- `next`, which is the link to the next node in the sequence. Since we are linking to other nodes, this should have the `Node` data type

Add the following methods:
- `Node(int data)`, a constructor that initializes `data` and sets `next` to `null`
- `int getData()`, a getter for `data`
- `Node getNext()`, a getter for `next`
- `void setNext()`, a setter for `next`

## Linked List Structure
Now we're ready to create the actual Linked List data structure. We have provided an Interface called `ILinkedList.java`, which declares the methods that you'll need to add into your Linked List implementation. Interfaces are special files that list methods that *must* be included in any implementation of the interface.

In the same folder, create a new file called `LinkedList.java` that defines a `LinkedList` class. To make this file implement the interface, add the following class definition:
```Java
public class LinkedList implements ILinkedList {

}
```

This syntax acts as a sort of "contract", saying that we must complete the interface's methods in order to compile. We will create two methods in this assignment:
- `add(int data)` will add `data` to the end of the sequence
- `delete(int data)` will delete the first occurrence of `data`

Now we can start writing the LinkedList class!

The links between the nodes already do most of the work for the structure of a Linked List, so there is only one thing that the Linked List object itself needs to keep track of-- the start of the sequence. Let's create a `Node` instance variable called `head`. This will act like our entry point into the list. You can initialize this variable to `null` because the list starts off empty.

## Adding to the End
Add the following method signature to `LinkedList.java`:
```Java
public void add(int data){

}
```

Let's start by creating the new node that we're going to add to the end. Create a new `Node` variable called `newNode` that stores `data`.

Our logic to add to the list will need to be slightly different for two possible states of the list:
1. If the list is empty, meaning `head == null`
2. If the list has elements, meaning `head != null`

Many Linked List operations will need to handle these two cases separately.

Let's start with the first case; write an if statement that checks if the list is empty. If so, we can simply store `newNode` inside of the `head` instance variable! Nice and quick.

The second case, where the list is not empty, will take a little bit more work. Remember that there is no indexing to jump around a linked list like with arrays. If we want to add to the end of a linked list, we will need to traverse there first. 

To see how linked list traversal works, it can be helpful to first think about how traversal works in an array. This is a while loop that goes through the indices of an array:
```Java
int i = 0; // variable that starts at the beginning
while (i < arr.length){ // while that variable isn't at the end yet
	i++; // move that variable forward
}
```

This structure of starting a variable at the beginning, looping until it's at the end, and moving the variable forward inside the loop is the same structure we will use to traverse our Linked List.

Note that we need to avoid doing this traversal if we were in Case 1, where the list was originally empty; otherwise it might add the same element twice! Make sure to write this traversal logic in an `else` case of the check that the list was empty, or you can alternatively `return` to exit the function within your if statement for Case 1 (note that you can simply write `return;` as a standalone statement in a `void` method).

We will start by creating our variable that starts at the beginning. We are traversing from node to node, so this should be a `Node` type. Let's call it `current`. What variable should we initialize this to, which represents the beginning of the linked list?

Next we need to set up our while loop. In Linked List operations, we often want to stop a traversal when we're on the node right *before* where we want to make changes. In this case, we want to add a new node after the sequence, so we should make our loop stop while `current` stores the very last node that is currently in the sequence.

To do this, we can observe that the very last node is distinct in that it doesn't point to another node. We can tell when `current` is on the last node because its `next` pointer will be `null`. Write a while loop condition that continues until `current`'s next pointer is `null`.

Within the while loop, make sure to iterate `current` forward by reassigning it to the node that comes after `current`. How can we get the node that comes next in the sequence?

Once you have your while loop working, it will end once `current` is on the final node in the sequence. That means we can finally add the new node after the while loop is done. Do this by updating `current`'s next pointer from `null` to `newNode`.

### Testing the Method
It would be helpful to be able to print out the state of the Linked List for testing purposes. Add this `toString` method to `LinkedList.java`. Read through the logic to understand how it is working.
```Java
public String toString(){
	// DO NOT MODIFY
	String output = "";
	Node current = head;
	while (current != null){
		output += current.getData() + " -> ";
		current = current.getNext();
	}
	output += "null";
	return output;
}
```

This will allow you to see the state of the linked list. Create your own `main` method that tests the `add` method to verify its correctness.

## Deleting from the Middle
Now let's see how Linked Lists really shine by modifying the list in the middle! This method will delete the first occurrence of `data` from the list. It returns a `boolean` that indicates whether an element was indeed deleted. If `data` doesn't appear in the list, nothing should change, and the method returns `false`.


Add this method signature to `LinkedList.java`:
```Java
	public boolean delete(int data){
	
	}
```

Once again, we need to separately consider the case where the linked list is empty. Luckily for us, this is as easy as a special case can get! If the linked list is empty, we can immediately exit the method because we know there are no elements that can be deleted. Write an if statement that checks if the list is empty, and immediately return if so.

To delete a node from the sequence, we need to change the next pointer of the node BEFORE the node to delete to point to the node AFTER the node to delete. This is effectively making the pointer "jump over" the node we want to get rid of, which removes it from the sequence.

Take this simple sequence, where we want to delete the `2`:
```
Originally:
1 -> 2 -> 3 -> null

After deleting 2:
  ┌-------┐
  |       ▼
1 ┘  2 -> 3 -> null
```
While `2` still points to `3`, the `2` has still been removed from the sequence.

To perform this operation, we need to navigate to the node right before the one we want to delete. But this poses a slight problem-- if the node we need to delete is the first in the sequence, meaning it is the `head`, there is no node before it! This means we should have another special case.

Add an if statement that checks if the `head`'s data is equal to the `data` parameter. If so, let's delete it by making `head` point to `head`'s next node. This makes the `head` jump over the first node in the sequence. Since `head` is the entry point into the list, moving it past the first element makes the first element inaccessible. Then we can `return` to exit the method.
```
Originally:
head ┐
     ▼
     1 -> 2 -> 3 -> null
     
After deleting 1:
head -----┐
          ▼
     1 -> 2 -> 3 -> null
```

With those special cases out of the way, we can now get into the general logic for deleting. Let's set up a traversal through the linked list that ends on the final element, very similar to the traversal from your `add` method.

The only difference is we need to check if we need to delete the next node within the while loop. Add an if statement that checks if the next node's data is equal to the `data` parameter. If so, we should perform the "jumping over" step to delete the next node. You can do this by setting `current`'s `next` parameter to be the node two ahead of current (its next node's next node). Then we can `return` to exit the method.

Write your own test cases in your `main` method to check the correctness of your `delete` method.
## Submission
Go to the Homework 5 submission on Gradescope, and add `LinkedList.java`  and `Node.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.
