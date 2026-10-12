# 1933 Homework 4: Sorting
As a student, you probably have systems and strategies to stay organized (or at least attempt to stay organized). It is much more efficient to get work done when your files, assignments, and tasks are kept in some sort of structure. A similar principle applies to data-- when data is organized in a known structure, it is much easier and more efficient to work with.

One of the most common ways of structuring data is to arrange it in sorted order, as this makes it much easier to search for elements. Think of a dictionary, and how hard it would be to find the definition of a word if the whole thing wasn't sorted alphabetically!

Unstructured data can be arranged into sorted order using sorting algorithms. There are many sorting algorithms that each have pros and cons, but in this assignment we will be focusing on three of the basic sorting algorithms: **Selection Sort, Insertion Sort,** and **Bubble Sort**.
### Associated zyBooks Reading
- 3.2 Sorting an array

All of the algorithms in this assignment will be applied to arrays of integers. This is perhaps the clearest way to write these algorithms, but it should also be noted that the same algorithms can be modified to work on different data types or data structures.

Create a file called `Sorting.java` that defines a `Sorting` class.

Each of these sorting algorithms works by swapping and moving elements in slightly different ways. To observe these differences, we will create helper methods to print out the state of the array after modifying it!

```Java
private static String arrayString(int[] arr){  
    // DO NOT MODIFY  
    String outputString = "[";  
    for (int i=0; i<arr.length; i++){  
        outputString += arr[i];  
        if (i<arr.length-1){  
            outputString += ", ";  
        }  
    }  
    outputString += "]";  
    return outputString;  
}  
  
private static void swap(int[] arr, int idx1, int idx2){  
    // DO NOT MODIFY  
  
    String pair = arr[idx1] + " <-> " + arr[idx2];  
    String indices = "(index " + idx1 + " <-> " + idx2 + ")";  
  
    // Swap the elements  
    int temp = arr[idx1];  
    arr[idx1] = arr[idx2];  
    arr[idx2] = temp;  
  
    // This print might look strange, but it is just using a different print method to format the output in a more readable way.  
    System.out.printf("%-12s %-20s %s%n", pair, indices, arrayString(arr));  
}

private static void place(int[] arr, int val, int idx){  
    // DO NOT MODIFY  
    String placement = val + " to index " + idx;  
  
    // Place the element  
    arr[idx] = val;  
  
    // This print might look strange, but it is just using a different kind of print method to format the output a little nicer.  
    System.out.printf("%-12s %s%n", placement, arrayString(arr));  
}
```

The `swap` helper method will allow you to swap two positions of an array by index. If you wanted to swap indices `0` and `3` of an array called `arr`, you would write `swap(arr, 0, 3);`.

The `place` helper method simply inserts an element in an index. To place the value `5` in index `1` of `arr`, you would write `place(arr, 5, 1);`.

Paste these method into your file, and read the implementations and try to understand how they works. Make sure to not modify this code or the autograder might fail!
## 1. Selection Sort
The Selection Sort algorithm works by finding the smallest element in the array and swapping it with the first position. Then it finds the second smallest element, and swaps it with the second position. It continues this until every element has been processed, which results in a sorted array.

**After each element is processed, it is stored in its final position within the array, and will never need to be moved again.**

Add this method signature to your file. It will take in an unsorted array and sort it **in place**, which means the sorting by shuffling elements around in the same data structure instead of utilizing any external data structures. Recall that arrays are reference type, so the changes made inside this method will persist where the method is called. Thanks to this, we can use the results of the sort without needing to return an array.

```Java
public static void selectionSort(int[] arr) {
	// 1. Outer loop picks spots in the array one by one
	// 2. Inner loop finds the smallest element in the rest of the array
	// 3. Swap the outer loop's spot with the smallest element
}
```

We should start by setting up one for loop which goes through the length of the array. The counter variable, which you may call `i`, will keep track of the location that we will be swapping the smallest unsorted element to. The first time the loop runs, it will find the smallest element and swap it to index 0. The second time, it will find the second smallest element and swap it to index 1, and so on, always swapping the next smallest element to index `i`.

Now we will need to add logic to find the smallest element from the current index onward. What does a simple algorithm look like to find the smallest element? Consider adding another for loop with an if statement to perform this task.

After you find the smallest element, you will then need to swap this element and the current index of the outer loop (`i`). Recall that you should use the `swap` helper method in this assignment!

You can test your algorithm by adding this main method:

```Java
public static void main(String[] args){
	int[] selectionData = {31, 4, 1, 5, 92, 65};
	selectionSort(selectionData);
	System.out.println("SELECTION SORT RESULT: " + arrayString(selectionData));
}
```

We expect to see the Selection Sort go through these steps:

0. `[31, 4, 1, 5, 92, 65]`: This is the starting state.
1. `[1, 4, 31, 5, 92, 65]` : `31` and `1` swapped places, so the smallest element `1` could be moved to the left-most side of the array. We can think of `[1]` as being its own fully sorted segment, while `[4, 31, 5, 92, 65]` is still unsorted.
2. `[1, 4, 31, 5, 92, 65]` : Nothing changed in this step! That is because the smallest element remaining was `4`, which was already the element in the location. A swap did technically occur, the algorithm just swapped the element with itself. Now `[1,4]` is a fully sorted segment.
3.  `[1, 4, 5, 31, 92, 65]` : `5` was the next smallest element, so it is swapped with `31`.
4. `[1, 4, 5, 31, 92, 65]` : Once again, it looks like nothing changed because `31` swapped with itself. The sorted segment is now `[1, 4, 5, 31]`.
5. `[1, 4, 5, 31, 65, 92]` : The last two elements were swapped. The sorted segment is now `[1, 4, 5, 31, 65]`. But since there is only one unsorted element `92`, and this is guaranteed to be greater than the sorted subarray, this step has actually implicitly placed the final element in its proper location. The array is fully sorted!

## 2. Insertion Sort
The Insertion Sort algorithm is often compared to manually sorting a deck of cards, . 

It builds a sorted subarray from left to right. Whenever the algorithm processes a new element, it will assume everything to the left of it is in sorted order. It compares the element to each value in the subarray to move it into its proper sorted position within the subarray.

**After each element is processed, it is stored in sorted order amongst the elements that have already been processed. This may or may not be its final sorted position.**

Add this method signature to your file.

```Java
public static void insertionSort(int[] arr) {
	// 1. Outer loop grabs one element at a time to store in "current"
	// 2. Inner loop searches in the sorted subarray (to the left of current's starting position) for the proper location of current
	// 3. As it searches, it shifts elements greater than current to the right
	// 4. Once the proper location of current is found, insert current there
}
```

We will start by setting up a for loop whose counter `i` will store the index of the element we are currently inserting into the sorted subarray. We can always consider index 0 of the array to already be in the sorted subarray, since a single element on its own is always sorted. Therefore we should have this loop start at index 1 and go for the length of the array.

Inside of this loop, let's start by creating a variable called `current`that stores `arr[i]`, the current element. To return to the deck of cards analogy, this is like pulling the card out of the hand to sort it.

Now we'll find this `current`'s proper spot in the subarray by comparing it to each value already in the subarray. If the other value is greater than `current`, we should shift that value to the right to make room for `current`. This process will repeat until we find a value that is less than or equal to the `current`, at which point we know `current` needs to go immediately to the right of that value.

We can create a new counter variable `j` that starts immediately to the left of `i`, or in other words, `j` starts at rightmost element of the sorted subarray. Now let's set up a while loop finds the position `j` that `current` should be swapped to!

We'll make the while loop run so long as`j` is greater than or equal to 0 (to keep it in bounds) and `arr[j]` is greater than `current`. When this is the case, we know we'll need to search further left to find the proper spot, so we need to shift `arr[j]` to the right to make room for `current`. We should shift the value in index `j` over to index `j+1`, then decrement `j` to move it to the left.

Once this while loop exits, we know that `j` has landed on the first element that is less than `current`, so `current` should be placed at `j+1`. Use the `place` helper method to perform this task.

Test your algorithm by adding this to the bottom of your main method:

```Java
int[] insertionData = {31, 4, 1, 5, 92, 65};
insertionSort(insertionData);
System.out.println("INSERTION SORT RESULT: " + arrayString(insertionData));
```

We expect to see the Insertion Sort go through these steps:

0. `[31, 4, 1, 5, 92, 65]`: This is the starting state. `[31]` is considered to be the sorted subarray.
1. `[4, 31, 1, 5, 92, 65]`: `4` was the current element. It should go before `31` in the subarray, so `31` was shifted to the right and `4` was placed in index `0`. The sorted subarray is now `[4, 31]`.
2. `[1, 4, 31, 5, 92, 65]`: `1` was the current element. It is less than both `4` and `31` so they were both shifted to the right and `1` was placed in index `0`. The sorted subarray is now `[1, 4, 31]`.
3. `[1, 4, 5, 31, 92, 65]`: `5` was the current element. `31` was the only element that needed to be shifted, and `5` was placed in index `2`. The sorted subarray is now `[1, 4, 5, 31]`.
4. `[1, 4, 5, 31, 92, 65]`: `92` was the current element. The array didn't change state in this step because `92` was already in its proper location within the subarray, so it was placed in the same location. The sorted subarray is now `[1, 4, 5, 31, 92]`.
5. `[1, 4, 5, 31, 65, 92]`: `65` was the current element. `92` was shifted to the right and `65` was placed in index `4`. The sorted subarray is now `[1, 4, 5, 31, 65, 92]`, which is the entire array, so the algorithm is complete.

## 3. Bubble Sort
The Bubble Sort algorithm works by stepping forward in the array and continually comparing neighboring elements, swapping them if they are out of order. 

It starts by comparing the first and second element, and swaps them if the first was bigger than the second. Then it steps forward to do the same with the second and third elements, then third and fourth, etc. 

Notice if you continue this pattern for the entire length of the array, it is guaranteed that the largest element in the array will continually be swapped to the right until it is in the rightmost position. This process is repeated for the second largest element, and so on until the array is sorted. This is where the algorithm gets its name-- because the large elements "bubble" up to the top. 

**After each pass through the array, the rightmost segment of the array holds the largest elements in their final sorted order.**

Add this method signature to your file.

```Java
public static void bubbleSort(int[] arr) {
	// 1. Outer loop tracks the number of passes through the array
	// 2. Inner loop goes through the array comparing adjacent elements
	// 3. A pair of adjacent elements is swapped if they are out of order, meaning the left element is greater than the right element
}
```

We will first set up our outer loop which will repeat the "bubbling" process enough times to guarantee all elements bubble up to their correct position. The counter variable, `i`, will represent how many elements have bubbled up. No elements have bubbled up at first, and we eventually want all `arr.length` elements to be in their proper positions, so this should loop from `0` to `arr.length`.

Inside of this loop we will add a second for loop that will actually perform the bubbling passes. Recall that we will always be considering two neighboring elements at a time-- because of this, we need to ensure the loop never attempts to access an adjacent element that would be out of bounds. A good way to do this is to have the inside loop start its counter `j` at `1`, so we can use `j` and `j-1` as the neighboring indices which are guaranteed to always both be in bounds so long as `j` doesn't get too large.

So now we just need to figure out the upper bound for the `j` loop. We want to stop this loop before it enters the rightmost elements of the array that have already been bubbled up, since these are already in their final sorted positions. Remember that `i` represents the number of elements that have bubbled up. When `i` is `0`, we would want this loop to go for the entirety of `arr.length`. When `i` is `1`, we would want to stop before the rightmost element, so we want the loop to go for `arr.length-1`. Consider how we can generalize this pattern.

Within this inner loop, we need to swap the elements in indices `j` and `j-1` if they are out of order. Add an if statement to check if they need to swap, and call the `swap` helper method if so.

Test your algorithm by adding this to the bottom of your main method:

```Java
int[] bubbleData = {31, 4, 1, 5, 92, 65};
bubbleSort(bubbleData);
System.out.println("BUBBLE SORT RESULT: " + arrayString(bubbleData));
```

We expect to see the Insertion Sort go through these steps:

0. `[31, 4, 1, 5, 92, 65]`: This is the starting state. No elements have bubbled up.
1. `[4, 31, 1, 5, 92, 65]`: It considers the pair `31, 4`, and swaps them to put them in order.
2. `[4, 1, 31, 5, 92, 65]`: It considers the pair `31, 1`, and swaps them to put them in order.
3. `[4, 1, 5, 31, 92, 65]`: It considers the pair `31, 5`, and swaps them to put them in order.
4. `[4, 1, 5, 31, 65, 92]`: It considers the pair `31, 92`, which are already in order so no swap is necessary. Next it considers `92, 65`, and swaps them to put them in order. This concludes the first pass through the array, and `92` has bubbled up.
5. `[1, 4, 5, 31, 65, 92]`: It considers the pair `4, 1`, and swaps them to put them in order. At this point the array is actually properly sorted, but a basic Bubble Sort implementation will actually continue checking pairs after this point. This is inefficient, and can be avoided using an optimization that we will discuss in lecture!

## Submission
Go to the Homework 4 submission on Gradescope, and add `Sorting.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.
