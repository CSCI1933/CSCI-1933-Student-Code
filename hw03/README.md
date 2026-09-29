# 1933 Homework 3: Dynamic Arrays
Containers naturally have a size limitation. Think of your backpack-- as you fill it up, at some point you will hit the maximum volume that the backpack can handle and won't be able to stuff another notebook inside.

Arrays are the same way. When you declare an array, you have to specify the number of elements it stores, and this number can never change. An array's length is fixed, so it will always be stuck at the length it was declared at.

But we don't always know how many elements we'll eventually need to store! It would be useful to have a way to dynamically "grow" arrays to fit more elements. This can be done by implementing a data structure called a Dynamic Array.

Dynamic Arrays *seem* like they're  arrays that can grow, but of course we established that arrays have fixed length. In reality, a Dynamic Array "grows" by creating a brand new larger array, copying every element from the original to the new array, and then replacing the original with the new array.

In this assignment, we will create a Dynamic Array that grows as we add elements to the end!
### Associated zyBooks Reading
- 7.2 Array Lists: Implementing a dynamic array

### Additional Resources
- [Animated Arrays Explanation Video](https://youtu.be/9vDEQnW-mnk)
	- Why Arrays have Fixed Size: [3:10 to 5:10](https://youtu.be/9vDEQnW-mnk?t=190)
	- How Dynamic Arrays work: [5:10 to 6:53](https://youtu.be/9vDEQnW-mnk?t=310)

## 1. Setup
Create a file called `DynamicArray.java` that defines a `DynamicArray` class. Remember to write the code block that defines the class.

We're going to need to create two instance variables:
- `int[] array`, which will reference the integer array that stores data
- `int numElements`, which will track the number of elements being stored in the array

Note that `numElements` will typically be *different* from the size of the array (`array.length`), because there may be some unused space in the array at any point in time. For example, `array` may have capacity for 8 elements but only currently stores 5, so `numElements` would be 5. The remaining 3 spots in the array are currently unused.

Add this `toString` method to your file for testing purposes. Notice how the for loop on runs `numElement` times, so the string will only contain the elements that were added to the Dynamic Array, and will not include any of the empty space in the array.
```Java
public String toString(){  
    String outputString = "[";  
    for (int i=0; i<numElements; i++){  
        outputString += array[i];  
        if (i<numElements-1){  
            outputString += ", ";  
        }  
    }  
    outputString += "]";  
    return outputString;  
}
```

We will also need a constructor to set up our instance variables. Add this method signature:
```Java
public DynamicArray(int size){  

}
```

This constructor will take in the `size` argument to determine the initial length of the array. Inside of this constructor, you'll need to initialize both instance variables to their proper values. Remember that `array.length` and `numElements` represent *different* values for our Dynamic Array!
## 2. Resizing
Before we can write our method to add to the array, we'll need to create a helper method that performs the resizing operation.

Add this method signature to `DynamicArray.java`:
```Java
private void resize(){

}
```

This method is private because it should only be able to be used inside of our `add` method.  No other classes should be able to resize our internal array.

First, we'll need to create a new integer array that has the bigger size. We typically implement Dynamic Arrays by doubling the array length every time we hit capacity. Create a new integer array `newArray` that has a size twice as large as the current `array`.

Now we'll need to copy over all the elements of `array` into `newArray`, in the same positions. What control structure should we use to access each element? What should we do within that control structure to copy elements over?

Once you have completed the copying step, we can reassign the `array` instance variable to store the `newArray`. Now we have a larger array that stores the same elements!

## 3. Adding
We can finally write our `add` method. Add this method signature to `DynamicArray.java`:
```Java
public void add(int data){  

}
```
Our goal is to add `data` to the first open spot in the array, but if we detect we have run out of space, we should first resize the array to make more room.

What could we check about our instance variables to determine if the number of elements is currently hitting the capacity of the array? Write an if statement that calls `resize();` in this case.

After we have handled the possibility where we need to resize, we are guaranteed to have enough space to add another element. A convenient trick is that `numElements` also happens to be the first open index when we fill an array from left to right. Add the logic to store `data` in the first open index of the array, and increase the number of elements.

### Testing
Let's add a main method to test our Dynamic Array! Add the following method to your file, which will create a Dynamic Array object that starts with a length of 1.
```Java
public static void main(String[] args){
	DynamicArray array = new DynamicArray(1);
}
```
Add a few lines of code test your `add` method. Recall that you have a `toString` method, which means you can print out `array` to inspect how the data structure changes.
## Submission
Go to the Homework 3 submission on Gradescope, and add `DynamicArray.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.

