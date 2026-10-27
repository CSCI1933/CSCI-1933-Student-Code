# 1933 Homework 6: Headed Linked Lists
In the last assignment, you implemented `add` and `delete` methods for a Linked List. You may recall that we needed to write special cases for when the list was empty-- otherwise, we would start our traversal on `head` which is `null`, leading to our code attempting to call methods on a null pointer, which throws the infamous `NullPointerException`!

A common way to avoid this exception without needing to write special cases in many of our methods is to use a Headed Linked List. This is a special kind of Linked List that keeps a "Sentinel" or "Dummy" node at the front of the list at all times. This doesn't represent actual data, but is kept there to ensure the head is never null.

In this assignment, we will write some more Linked List operations, but this time with a headed structure!
### Associated zyBooks Reading
- 3.8 Doubly linked lists, Header and trailer sentinels
## 1. Headed Linked List Structure
In this folder, we have provided `Node.java` to represent a Node that holds integer data and has a next pointer, and `ILinkedList.java`, which is the interface that defines the methods we'll implement in this assignment. Read `ILinkedList.java` for descriptions of the methods. Note that this has some key differences from the interface used in last week's assignment.

Now create a file called `HeadedLinkedList.java` that defines a `HeadedLinkedList` class. This should implement our `ILinkedList.java` interface. 

As with the unheaded linked list implementation, this will only require a `head` instance variable that holds a Node, representing the entry point into the list. The difference is that in our headed structure, we will consider this `head` node to be a dummy node that doesn't hold real data.

Even when the list is empty, this dummy node should be present-- in your constructor, initialize `head` to hold a new node. The value in its data field doesn't really matter since we will never use it (it's a dummy value after all), but you still need to put *something* in there. Perhaps `0` is a logical choice.
## 2. Adding to the End (again!)
Just like the previous assignment, we'll start by writing a method that adds elements to the end. Add the `add` method signature from `ILinkedList.java` to `HeadedLinkedList.java`.

This will be quite similar to the previous solution, except that the headed structure allows us to avoid the special case for when the list is empty! This is because our logic for the `add` method is to traverse the list until we're on a node whose next pointer is null. This was an unsafe operation for the unheaded structure because an empty list meant the head was null, so we would immediately hit a `NullPointerException` upon trying to access the next pointer of the head. In the headed structure, the head always points to the dummy node, so it will never hit the `NullPointerException` when starting the traversal!

As a reminder, the logic for adding to the end is that you first need to traverse to the current last element, which you can detect because its next pointer is `null`, then modify its next pointer to store a new node that stores `data`.

### Testing the Method
Add this `toString` method to `HeadedLinkedList.java`. It is slightly different from the `toString` in last week's assignment because it skips over the dummy node. 

```Java
public String toString(){
	// DO NOT MODIFY
	String output = "";
	Node current = head.getNext();
	while (current != null){
		output += current.getData() + " -> ";
		current = current.getNext();
	}
	output += "null";
	return output;
}
```

Write your own `main` method that tests your `add` method.

## 3. Finding the Index
While we can't use index numbers to immediately jump to a location like we do with arrays, index numbers are still useful to describe the positions of elements in a linked list. Next we'll implement `indexOf`, which will return the index number of the first occurrence of the `data` argument.

 Our elements will be indexed in a 0-based manner, like arrays-- the first non-dummy node will be considered index 0, or alternatively, you can think of the dummy node stored in `head` as being index -1.

We'll definitely need to make sure to skip over the dummy node; otherwise, it could make our method return the wrong index number! Even though it intentionally doesn't represent any useful data, remember that we still had to populate its `data` field with a dummy value, perhaps `0`. If we didn't skip the dummy, running `indexOf(0)` would return after seeing the dummy node instead of searching the real data of the list.

So we'll start by creating a `Node current` variable that starts at `head`'s next node, which is the first node with actual data. We'll also create an `index` variable that starts at `0` and will keep track of the index we are currently on.

We'll run a while loop as long as `current` is not `null`. Inside the loop, check if `current`'s data is equal to the `data` parameter. If so, we should return the current index. Otherwise, we should move both `current` and `index` forward.

If the loop finishes without returning from the if statement, there must be no instances of `data` in the list. We can indicate this by returning `-1` outside of the loop.
## 4. Inserting in the Middle
Our next method is going to insert new nodes into any location within the sequence. The second parameter, `index`, will determine the location where the new data will be placed in the list. Elements with higher indices will be shifted to the right, as shown in this example:
```
Before Insertion:
  head
0 (dummy) -> 10 -> 20 -> 30 -> null
   -1        0     1     2 
   
After insert(25, 2):
  head
0 (dummy) -> 10 -> 20 -> 25 -> 30 -> null
   -1        0     1     2     3
```

The method returns a boolean indicating whether the element was successfully inserted. If it is called with an out-of-bounds index, the method should return `false`.

Add the `insert` method signature from the interface.

For starters, we should check if the method was called with a negative index. We know this to be out of bounds, so we can immediately return `false` in this case. This linked list structure isn't keeping track of the total number of elements though, so we will need to complete the traversal to check if the index is too high for the number of elements.

Next, we can set up our traversal. We want to traverse until we're on the node right before the index we want to insert into, because we need to make the previous node point to the new node. We will set up a `Node current` variable that starts at the head, as well as `int nextIndex` which represents the index of the node *after* `current`. 

Now we can set up the while loop that will drive the traversal. The loop should end if we have reached `index` because that means we are ready to add the element, *or* if we run out of nodes, which means there weren't enough nodes to count up to `index`-- in other words, `index` was out of bounds.

So our while loop should continue as long as `nextIndex` is less than or equal to `index` *and* `current` is not `null`. We should move both `current` and `nextIndex` forward within the loop.

Once the loop ends, we know that one of the ending conditions has been met, so we need to figure out which one! Write an if statement that checks if `nextIndex` is equal to `index`. If so, we have found the proper location to add the new node. 

Our goal here is to insert a new node between `current` and `current.getNext()`. Make the new node and set its next pointer to be `current`'s next pointer, then update `current`'s next pointer to be the new node.

If `nextIndex` is not equal to `index`, the loop must have exited because we ran out of nodes before reaching `index`, meaning the argument was out of bounds! In this case, we can simply return `false`.
## Submission
Go to the Homework 6 submission on Gradescope, and add `HeadedLinkedList.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages, which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.
