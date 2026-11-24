# 1933 Homework 11: Binary Search Trees
We have already worked with a few data structures to store data linearly; arrays and linked lists work very well to represent linear sequences. There are many situations however that call for a hierarchical structure, which is better modeled using trees. Family trees model ancestry; in statistics, Decision Trees model probability; even in this course, Inheritance Trees model class relationships.

Trees are data structures that use nodes to store data hierarchically. A single node represents the root of the tree (which is perhaps confusing terminology because this is the top of the tree), and every node can have zero or more children nodes to represent a parent-child relationship.

A Binary Tree is a specific kind of tree where each node has a maximum of **two** children-- though these children can be empty, so each node can have zero, one, or two children. We label these children as the left child and the right child.

Getting even more specific, a Binary *Search* Tree is a special kind of Binary Tree that makes sure to keep data organized in a way that makes it very fast to find and retrieve elements. It does this by imposing the rule that a parent node's value is greater than *all values* in its left subtree, and less than *all values* in its right subtree. This condition applies to every single node in the tree.

(Note that we often do not allow duplicates in a binary search tree, but if we do allow them, we would just need to include equal elements in one side or the other. For example, we might say the parent node's value is greater than *or equal to* all values in the left subtree, while it is still strictly less than all values in the right subtree.)
### Associated zyBooks Reading
- 8.1 General Trees
- 8.2 Binary Trees
- 11.1 Binary Search Trees
## File Structure
In this folder, we have included a `Node.java`. Since Binary Trees have two children per node, this Node class has two pointers, called `left` and `right`. While we have mostly only seen Nodes with a single pointer so far, you can include as many pointers in your class as you need.

Also included is `BST.java` which is the interface that defines the methods that we'll include in our Binary Search Tree implementation:
- `boolean insert(int data)`
- `boolean contains(int data)`
## Structure
Create a new file called `BinarySearchTree.java` that defines a `BinarySearchTree` class. This should implement our `BST.java` interface.

In Linked Lists, we kept track of the `head` node because it was our entry point into the list. For trees, we keep track of the `root` to serve the same purpose. This represents the highest node of the tree, so all other nodes are children or further down descendants.

Create a private Node instance variable called `root` to serve this purpose.
## Recursion
Recursion is extremely useful for tree algorithms because trees are recursive structures; every node is the root of a smaller subtree. We will use recursion to write both of the methods in the `BST.java` interface.

We traverse through the tree by writing a recursive method that passes in the current node as a parameter. Then, each execution of this recursive method only needs to consider that current node and its immediate children-- we don't need to think about the tree structure as a whole.

But this can introduce a problem: we want other classes to be able to call our methods, but other classes can't pass in a starting node because the `root` instance variable should be private!

This motivates us creating a couple methods that work together. For many tree algorithms, we will have a public "driver" method that kicks off the recursion. The driver method will take in only the parameters that the user would care about, and not anything related to the innerworkings of the Binary Search Tree.

Additionally, we will have a private "helper" method that actually performs the recursion. This one can use any of the private information in the class since it is also hidden in the innerworkings of the Binary Search Tree. The driver method will call the helper method to get the recursion started.
## 1. Insertion
We want our `insert` method to insert data into the proper location in the Binary Search Tree, and return `true` if it succeeded. The only case where insertion should fail and return `false` is if we try to add a duplicate element that is already in the tree.

Add the following method signatures to `BinarySearchTree.java`:
```Java
// Driver Method
public boolean insert(int data){

}

// Helper Method
private boolean insertHelper(Node curr, int data){

}
```


### Driver
Let's start by writing the driver method, `insert`. When we added to an unheaded linked list, there were two cases: if the head was empty, we would update the head variable; if the head wasn't empty, we would traverse the structure. These are the exact cases we'll have for our Binary Search Tree insertion as well.

If the root is currently null, we want to add at the root. In this case, make a new Node that stores `data` and store it in our instance variable. Don't forget to return to indicate we have successfully added our data.

Otherwise, we will want to perform our traversal. This is where we call our helper method. Write a return statement that calls the `insertHelper` method, passes in the root as our starting `curr` Node, and passes down the `data` as well.

### Helper
Now we can write the actual recursion in `insertHelper`. Remember that this recursive helper method only needs to worry about one node at a time (`curr`) and doesn't need to know anything about the rest of the tree.

First, we need to compare the data in `curr` to the `data` we want to insert. There are three cases, some of which have sub cases:
- If `data == curr.getData()`, we are attempting to insert a duplicate element so we should return `false`.
- If `data < curr.getData()`, we need to attempt to insert `data` somewhere in `curr`'s left subtree.
  - If `curr`'s left pointer is null, we want to insert right there. Update `curr`'s left pointer to point to a new node. Insertion has succeeded, so return `true`.
  - If `curr`'s left pointer is not null, we need to traverse the left subtree further to find where to add the new data. Write a recursive call to continue the algorithm in the left subtree.
- If `data > curr.getData()`, we need to attempt to insert `data` somewhere in `curr`'s right subtree.
  - If `curr`'s right pointer is null, we want to insert right there. Update `curr`'s right pointer to point to a new node. Insertion has succeeded, so return `true`.
  - If `curr`'s right pointer is not null, we need to traverse the right subtree further to find where to add the new data. Write a recursive call to continue the algorithm in the right subtree.

Remember that we need to return to indicate if the insertion has succeeded or not. When we find a duplicate element we will return `false`, and when we update pointers to point to a new node we return `true`. In the recursive cases, we don't yet know if the insertion will succeed or not-- in these cases, we need to return the result of the recursive call.

### Testing the Method
Add this `toString` method and these helper methods to `BinarySearchTree.java`. Note that you'll need to import `java.util.Arrays` for it to work:

```Java
import java.util.Arrays;
```

This `toString` is a little more complicated than the ones we've seen in the past. Feel free to take a look through it to try to understand how it is outputting a tree structure that can vary in length and width depending on where the nodes are placed.
```Java
private int getHeight(Node node) {
  if (node == null) return 0;
  return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
}

public String toString() {
  int height = getHeight(root);
  if (height == 0) return "Empty Tree";

  int rows = height * 2 - 1;
  int cols = (int)(Math.pow(2, height)) * 3;
  char[][] grid = new char[rows][cols];
  for (char[] row : grid) Arrays.fill(row, ' ');

  fillGrid(grid, root, 0, 0, cols - 1);

  StringBuilder sb = new StringBuilder();
  for (char[] row : grid) {
    String line = new String(row).stripTrailing();
    if (!line.isEmpty()) sb.append(line).append("\n");
  }
  return sb.toString();
}

private void fillGrid(char[][] grid, Node node, int row, int left, int right) {
  if (node == null) return;

  int mid = (left + right) / 2;
  String valStr = String.valueOf(node.getData());
  for (int i = 0; i < valStr.length(); i++) {
    grid[row][mid + i] = valStr.charAt(i);
  }

  if (node.getLeft() != null) {
    int childMid = (left + mid - 1) / 2;
    grid[row + 1][(mid + childMid) / 2] = '/';
    fillGrid(grid, node.getLeft(), row + 2, left, mid - 1);
  }
  if (node.getRight() != null) {
    int childMid = (mid + 1 + right) / 2;
    grid[row + 1][(mid + childMid) / 2] = '\\';
    fillGrid(grid, node.getRight(), row + 2, mid + 1, right);
  }
}
```

Write your own `main` method that tests your `insert` method for adding a few elements.
## 2. Contains
The benefit of organizing data in a Binary Search Tree is that we can search for elements in $O(h)$ time, when $h$ is the height of the tree. Let's write our `contains` method which will return a boolean indicating whether an element is stored in our tree.

Once again, we'll use a Driver and Helper pattern:
```Java
// Driver
public boolean contains(int data){

}

// Helper
private boolean containsHelper(Node curr, int data){

}
```

Our driver can be super simple this time. We don't need to do any specific checks, we can simply call the helper. Write a return statement in `contains` that calls `containsHelper` to kick off the recursion.

Now we can write the helper. First, we should check if we have run out of nodes, because if so, we have traversed through an entire subtree without finding `data`. So if our `curr` node is null, we haven't found the element and should return `false`.

After this case, we should check if we actually have found the desired `data`. Check if our `curr` node stores the data we are searching for, and return accordingly.

Finally, if we haven't found the data but also haven't run out of nodes, we need to traverse further. If `data` is less than the data in our `curr` node, we need to check the left subtree, so write a recursive case to traverse leftward. Otherwise, `data` must be greater than the data in `curr`, so write a recursive case to traverse rightward.

Add test cases to your `main` method to check if your `contains` method is working.

## Submission
Go to the Homework 11 submission on Gradescope, and add `BinarySearchTree.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.
