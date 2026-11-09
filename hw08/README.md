# 1933 Homework 8: Hash Tables
A common situation in computer science (and day-to-day life) is needing to lookup a collection of information based on a unique **key** value. We can find student information by looking up a unique student ID; we can find the title, author, genre, and more about a book by looking up its ISBN; we can find the definition of a word by searching for that word in a dictionary.

This key-value-mapping behavior can be implemented with a data structure called a Hash Table, which may also be referred to as an Associative Array, Dictionary, or Map.

You could imagine how we could implement the most basic key-value-mapping data structure by having an array that stores key-value pairs, and every time we lookup a key we would scan through the array and check if the key in the array matches what we are searching for. If so, we would return the associated value. 

This basic implementation would work in O(n), since we are linearly scanning through the array. Hash Tables are a better choice of implementation because they can be as fast as O(1) for addition and lookup. Their speed all depends on how well a **hash function** is able to spread elements evenly among the array. The Hash Function takes in a key as input and deterministically computes an index number as output. We can then add this key-value pair to that index or check that index for this key. 

One important consideration is that we likely want to store a large number of elements in our hash table, and that means our hash function will naturally have **collisions**, which means multiple key values map to the same index. This requires some sort of **collision handling** strategy, of which there are many. In this assignment, we will be using a strategy called **chaining**, where each index of the array actually stores a linked list, and whenever an element is added to the hash table, it is added to the end of the linked list in its hashed index.
### Associated zyBooks Reading
- 10.1 Maps
- 10.2 Hash Tables
## File Structure
In this folder, we have provided the following files:
- `PairNode.java` : Represents a node that stores a key-value pair where both values are Strings
	- Each `PairNode` has a `String key` and a `String val`, as well as a `PairNode next` pointer to the next node
- `IHashTable.java` : The interface that defines the methods you will implement to create a Hash Table
	- `public int hash(String key)`
	- `public void add(String key, String val)`
	- `public String get(String key)`
- `CollisionTest.java` : Provided to help with testing. You do not need to modify this file.
- `USCities.csv` : Provided to help with testing. You do not need to modify this file.

## Setup
Create a new file called `HashTable.java` that defines a `HashTable` class. This should implement our `IHashTable.java` interface. 

We only need one instance variable, `table`, which will serve as the underlying array. Remember that for the chaining collision handling strategy, each index in the array needs to be a linked list. This means we should make `table` an array of data type `PairNode`. We can access the head of each of these linked lists by accessing `table[index]`, and then do our typical linked list traversal operations from there.

Create a constructor that takes in `int size` which determines the starting size of the `table` array.

As you work on your methods, it may be helpful for testing to visually see the state of the Hash Table. You can add this `toString` method which represent the state of each linked list in every index of the array.
```Java
public String toString(){  
    StringBuilder sb = new StringBuilder();  
    for (int i = 0; i < table.length; i++){  
        sb.append(i+":\t");  
        PairNode curr = table[i];  
        while (curr != null){  
            sb.append("(\"" + curr.getKey() + "\", \"" + curr.getValue() + "\") -> ");  
            curr = curr.getNext();  
        }  
        sb.append("null\n");  
    }  
    return sb.toString();  
}
```
## `hash`
The core of our Hash Table is the hash function. A good hash function will spread elements evenly throughout the length of the array, which will lead to a very fast hash function. A bad hash function will end up placing many different elements in the same location, which is called **clustering** and slows down the hash table. The design of the hash function depends on what kind of data we can expect the keys to hold.

Part of your score for this assignment will be determined by how well your hash function works. 20 out of the 100 points will be awarded based on how low you can get the collision rate for the autograder test:
- 5/20 points for 50% collisions or less
- 10/20 points for 30% collisions or less
- 15/20 for 25% collisions or less
- 20/20 for 20% collisions or less

Today we will design our hash function to work for general string keys-- the hash function would look different if we used integer keys instead, or even if we had string keys with more specific formats, like license plates.

There are two steps to a hash function:
1. Converting the key into a Hash Code
	- This means some computations have to be done to the key to output *any* integer, so long as every time the computation is done on the same key, it must output the same integer. The resulting integer is called the Hash Code
	- This is the step that requires the programmer to consider how to best design the hash function
2. Compressing the Hash Code
	- Now the Hash Code needs to be compressed so it maps to an index that is inside the bounds of the array
	- This step is almost always done by using the modulo operator `%`

So the first step is to convert the key into the Hash Code, or in other words, come up with some algorithm to convert our string keys into integers. Your design for this step will be very open ended-- you need to write an algorithm that computes and stores an integer based on the string parameter. Remember that your goal is to make it so there is less than a 25% collision rate in our Gradescope tests.

Here are a few suggestions for possible hash code functions, along with examples that would produce collisions. Note that some of these examples would be quite poor on their own, but could serve as inspiration for pretty good hash functions.
- `Hash Code = length of the key string`
	- `"ABCDE"` and `"12345"` collide because they both have 5 characters
- `Hash Code = the ASCII value of the first character`
	- `"Hello"` and `"Hi"` would collide because they both start with `H`
	- You can use the `charAt` method (`stringName.charAt(index)`) to index to a specific character in a string variable. It will return a `char` type.
	- You can use `char` types as if they are numbers. Java will treat it as if you are doing arithmetic with an integer with the value of the [ASCII Code](https://www.asciitable.com) of that character. For example, the character `'A'` would be treated as the integer `65`.
- `Hash Code = the sum of the ASCII values of all the characters`
	- `"LISTEN"` and `"SILENT"` would collide because they are anagrams (contain the same characters in a different order) and thus sum the same values in a different order
	- `"ABC"` and `"BBB"` would collide because `A+B+C=65+66+67=198`, and `B+B+B=66+66+66=198`

Once you have your hash code, you need to compress it to the bounds of the array. The modulo operator (`%`) is the perfect tool for this because `x % n` produces `x` values in the range `0` to `n-1`, which is exactly the valid indices of an array of size `n`.

Your `hash` function should return your hash code modulo the length of the array.

## `add`
Now that we have our `hash` method that will apply a hash function to our keys to compute the index a pair should be placed in, we are ready to create our `add` method!

Add the method signature for `add` as defined in the `IHashTable` interface.

The first step of this method is to call our `hash` method on the `key` parameter, and assign the return value to an `int index` variable. This will be the index of the `table` array that we want to add to.

Next, let's create a new `PairNode` object that stores the `key` and `value` parameters. This will be the new node that will be added to the end of the linked list.

Now we must write an algorithm to add the new node to the end of the linked list whose head is stored in `table[index]`. It will be more convenient to treat these nodes as unheaded linked lists-- just remember to have a case for when the head is `null` to avoid the Null Pointer Exception.

Recall that the steps of a method to add to the end are:
1. Start a variable at the head
2. Run a loop until the variable's next pointer is `null`
3. After the loop, update the variable's next pointer to point to the new node

(While it is *possible* to write a chaining Hash Table that uses headed linked lists, it would be less efficient, add unnecessary complexity, and most importantly for this assignment, mess up the autograder that checks how many collisions you have. For this reason, we will require that your linked list implementations are **UNHEADED** for this assignment.)

## `get`
The power of a Hash Table comes from how quickly we can retrieve elements after adding them. Let's write the `get` method to perform this retrieval! This method should return the `value` associated with the `key` parameter if the `key` is present in the Hash Table, or return `null` if the `key` is not present.

Add the method signature for `get` as defined in the `IHashTable` interface.

Once again, the first step is to assign an `int index` variable to the result of calling `hash` on the `key` parameter. 

Now we must perform a linked list traversal starting at `table[index]`. Write a while loop that runs through the list, and for each node, check if its `key` instance variable is equal to our `key` parameter. Recall that these variables are strings, so we should use `.equals()`! If the keys are ever equal, we have found the pair we are looking for, so let's return this node's `value`.

If we exit the loop without having returned, `key` must not have been previously added to the Hash Table. We should return `null` to indicate we couldn't find the `key`.

## Testing
Remember that one of the Gradescope tests will be based on how well your hash function avoids collisions:
- 5/20 points for 50% collisions or less
- 10/20 points for 30% collisions or less
- 15/20 for 25% collisions or less
- 20/20 for 20% collisions or less

You can test your collision rate locally by adding these lines to your `main` method. It will call helper methods in the `CollisionTest.java` file that we have provided.
```Java
	try {  
	    HashTable ht = CollisionTest.csvToHashTable("USCities.csv");  
	    System.out.println(ht);     // Prints out the Hash Table's toString. Remove this line to unclutter the output.  
	    System.out.println(CollisionTest.collisionReport(ht));  
	}  
	catch (FileNotFoundException e){  
	    System.out.println(e);  
	}
```

## Submission
Go to the Homework 8 submission on Gradescope, and add `HashTable.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.
