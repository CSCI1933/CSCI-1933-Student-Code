# CSCI 1933: Hash Tables

Today, we'll be exploring Hash Tables by building out functionality from scratch! We'll explore basic functionality, collision handling, and resizing hash tables. 

Let's begin!

```bash
git pull
```
*Note: In the terminal, navigate to the top of the `CSCI-1933-Student-Code` directory using the `cd` command.*

## Hash Tables

A hash table is a data structure that efficiently supports insertions, deletions, and lookups. It works by using a **hash function** to map a value to an index in an array. In the implementation you will be working with, each index in the array contains a linked list to handle collisions.

Each value will hash to exactly one index; however, different values can hash to the same index. These are called collisions. A good hash function distributes values evenly across the array, resulting in an even distribution of collisions.

Java has a Hashtable class, however, you will be working with our own implementation of hash tables in the HashTable.java file. Most of it has already been implemented for you. Your task is to write a simple hash function for Strings to see how this works. Complete the `hash()` method in the HashTable class.


## Milestone 1 Checkoff

> Show a TA your `hash()` function, explain how it generates values distributed over the table.

## Milestone 2 

Now that we can hash items, the next step is two complementary methods: adding a value to the table and checking to see if the table contains a value. 

When two values map to the same location, we'll need to resolve the collision. 

## Milestone 2 Checkoff

> Show a TA your `add()` and `contains()` methods, be prepared to demonstrate understanding of how add handles collisions.
> > What is the Big O time complexity of these methods?
> > 
> > What is the average time complexity with a good hash function? 

## Milestone 3

Our next step will be to remove elements from the hash table, using the `delete()` method. You'll need to consider where in the chain an element could be and handle each individual case. 

## Milestone 3 Checkoff

> Show a TA your `delete()` method. Demonstrate deleting an element from a position containing multiple collisions. Use contains() to verify that the deleted element is gone and that the other elements are still present. 

## Milestone 4

As more elements are inserted into a hash table, the number of collisions can increase. This can make operations such as contains(), add(), and delete() less efficient as time goes on. At some point, it can be more efficient to increase a hash table's capacity when it becomes too full.

For this milestone, we'll implement resizing in your HashTable class.

Your hash table should keep track of the number of elements it contains and its current capacity (the number of indices in its underlying array).

When the number of elements becomes too large relative to the capacity, your hash table should create a larger array and redistribute its existing elements.

For this lab, use a load factor of 0.75. The load factor is calculated as:

Load Factor = Number of Elements / Capacity


When inserting an element would cause the load factor to exceed 0.75, resize the table by doubling its capacity.

When resizing, remember:
1. Create a new array with twice the capacity.
2. Recalculate the hash index for every existing element using the new capacity.
3. Insert each existing element into its new location.
Important: **You cannot simply copy the existing linked lists into the new array**. Because the capacity has changed, the hash index for an element may also change. Every element must be rehashed.

Test your implementation by inserting enough elements to trigger multiple resizes. Verify that all previously inserted elements can still be found using `contains()`.

### Milestone 4 Checkoff
Show a TA how your hash table detects when resizing is necessary. Demonstrate inserting enough elements to trigger a resize, explain why existing elements must be rehashed, and verify that all elements remain accessible afterward.

Next, demonstrate the test case using canterbury.txt. 
>> How many times does resize() trigger for this test case, given the original table size?
>> 
>> What would a better starting size be, knowing the number of unique words in this file?
>>> Hint: Keep in mind we have a load factor of 0.75

