# 1933 Homework 9: Stacks
A Stack is a data structure that adds and removes from the same end. Think of a stack of plates-- if you add a new plate to the stack it has to be on top, and then if you want to remove a stack it also has to come from the top. Whenever you want to remove an item, you will get the one that was placed on the stack most recently. This behavior is called "Last In, First Out", or "LIFO" for short.

We traditionally call the operation of *adding* an item to the top of the stack **"pushing"**, and *removing* an item from the top of the stack **"popping"**.

While their operations are very simple, stacks are one of the most common data structure because this LIFO behavior appears very often. Think about using a text editor-- whenever you hit the "Undo" button, the program reverts your most recent action. All of your actions are pushed to a stack, and whenever you hit "Undo" it pops the most recent action from the stack.

In this assignment, we will implement the Stack data structure in two ways: using an array base, and using linked nodes.
### Associated zyBooks Reading
- 6.1 Stacks
## File Structure
In this folder, we have provided `Node.java` to represent a Node that holds integer data and has a next pointer, and `IStack.java` which is the interface that defines the methods that we'll include in each of our Stack implementations:
- `push(int data)`
- `pop()`
- `isEmpty()`
## 1. Array-Based Stack
Created a new file called `ArrayStack.java` that defines an `ArrayStack` class. This should implement our `IStack.java` interface. 

Our array stack will need two instance variables: 
- `array`, an integer array to store the elements in the stack
- `numElements`, an integer that keeps track of the number of elements that are currently in the stack

Note that `numElements` represents a *different* value to the array's length. The length is the total number of spots in the array, while `numElements` is the number of spots in the array that are currently being used to represent values in the stack.

Let's create a constructor for `ArrayStack` that takes in a `size` parameter to initialize an array of that size:
```Java
public ArrayStack(int size){
	// Constructor Code Here
}
```

Now we must implement the three methods listed in the interface!

### `push(int data)`
`push` should add the parameter `data` to the next open location in the array. Consider how the `numElements` instance variable could be used to find the next open index. Additionally, ensure to increment `numElements` to reflect the fact that we have pushed a new element onto the stack.

Note that the fact that arrays have fixed size means that there is a natural maximum capacity for how many elements we can push onto the stack. Make sure to write a check that ensures you don't throw an exception if `push` is called when there is no room in the array. Your code does not need to do anything in this case, it just needs to avoid the error.

Additionally, consider about how you would utilize a dynamic array to create an array-based stack with an unfixed size.

### `pop()`
The `pop` method needs to remove the top element from the stack and return its value.

First we should consider how removal will work for our stack. Recall that every cell in an array always stores some value-- we always have exactly `array.length` values in the array, no matter how many elements we actually consider to be stored in the stack as tracked by `numElements`. 

We can't truly "remove" an element from the underlying array because of this fixed size. But that doesn't matter, because we can decrement our `numElements` variable to shrink the portion of the array that our code considers to be within the stack. A "removed" value would still be stored in the array, but none of our methods would consider it to be an actual element of the stack. Later, if we were to push more elements, the popped element would eventually be overridden.

Therefore, our `pop` method really only needs to do a couple things: it should decrement the `numElements` variable, and return the element that was originally at the top of the stack. Be careful about how you do this-- remember that you want to return the element that was *originally* stored at `array[numElements]` before decrementing `numElements`.

Make sure to write a check to ensure your code doesn't throw an exception if `pop()` is called on an empty stack. In this case, you can return a default value of `-1`.

### `isEmpty()`
Stacks typically need a way to quickly determine if there are no elements within the stack. What instance variable would be useful to check how many elements are being stored? Write a boolean return statement that checks this instance variable.

### Testing the Class
Add this `toString` method to `ArrayStack.java`. It will only output the first `numElements` positions in the array, so anything past `numElements` is considered to not be a part of the stack. It includes the `"< TOP"` string on the right side of the output to reminder you that the right side of the array is the top of the stack.
```Java
public String toString(){  
	String outputString = "[";  
	for (int i=0; i<numElements; i++){  
		outputString += array[i];  
		if (i<numElements-1){  
			outputString += ", ";  
		}  
	}  
	outputString += "] < TOP";  
	return outputString;  
}
```

Write your own `main` method that tests your `push`, `pop`, and `isEmpty` methods.
## 1. Linked-Nodes-Based Stack
Created a new file called `LinkedStack.java` that defines an `LinkedStack` class. This should implement our `IStack.java` interface. 

This time we will implement a stack using an Unheaded Linked List. We have provided a Node class defined in `Node.java`. Since we are always adding and removing from the top of the stack, it makes sense to make this the end of the list that we have quicker access to. We should have the head of the linked list be the top, and we'll always push and pop at the head. For example, our linked list structure would look like this:
```
head
 3 -> 2 -> 1 -> null
 
pop()
     head
 3 -> 2 -> 1 -> null
 
push(4)
head
 4 -> 2 -> 1 -> null
```

Since we're always adding to and from the start of the list, there are no special cases for the `head` being null that we could avoid by making this a Headed Linked List.  Thus, our Linked List should be Unheaded (recall this means there is no dummy node kept at the beginning of the list).

We only need one instance variable this time, `Node head`, which stores the head of the linked list.

Now we must implement the three methods listed in the interface!

### `push(int data)`
`push` needs to add a new node that stores `data` to the front of the linked list. The new node's next pointer should point to the current `head`, then `head` should be updated to point to the new node. This is all we need to push a new element onto our linked stack! 

### `pop()`
The `pop` method is also pretty quick when using linked nodes. We need to store the `data` value that is in the current `head` node, then move the `head` forward to `head.getNext()` as to skip over the current head, since this will remove it from the sequence. Now that the popped node has been removed, we can return the `data` value.

Make sure to write a check to ensure your code doesn't throw an exception if `pop()` is called on an empty stack. In this case, you can return a default value of `-1`.
### `isEmpty()`
Once again, this method should indicate when there are no elements left in the stack. What would the `head` instance variable look like when we have no nodes in the linked list? Write a return statement that returns a boolean indicating if the list is empty.

### Testing the Class
Add this `toString` method to `LinkedStack.java`. This will output a string in the exact same format as for an `ArrayStack`. Notice how the `outputString` variable is *prepending* the data of each node, since traversing the while loop is actually starting from the top of the stack. If we want the top of the stack to be at the right of the string, we need to add to the string in reverse order of the traversal.
```Java
public String toString(){  
	String outputString = "";  
	Node curr = head;
	while (curr != null){
		outputString = curr.getData() + outputString;
		if (curr.getNext() != null){
			outputString = ", " + outputString;
		}
		curr = curr.getNext();
	}  
	return "[" + outputString + "] < TOP";  
}
```

Write your own `main` method that tests your `push`, `pop`, and `isEmpty` methods.

## Submission
Go to the Homework 9 submission on Gradescope, and add `ArrayStack.java` and `LinkedStack.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.
