
# CSCI 1933 Lab 6: Debugging!

Welcome to Lab 6! 

When code refuses to compile or doesn't behave as we'd like it to, there's a bug present. Whether it's a flaw in syntax or logic, these ultimately need fixing to make programs work as desired. This week, we'll be doing a review of frequently encountered bugs, and we'll introduce some tools and thought processes you can use to help resolve bugs in future programs. 

Let's get started!

Note: For this lab, you MUST be using an IDE (IntelliJ, Visual Studio Code, etc.). Our TAs are most familiar with the IntelliJ debugger, but you're free to explore similar functionality in other IDEs for this lab.

```bash
git pull
```
*Note: In the terminal, navigate to the top of the `CSCI-1933-Student-Code` directory using the `cd` command.*


## Review: Errors in Java

In the past few labs, you've likely seen a few errors come up from each of the common categories.

> **Compiler Errors** - these occur when your program includes patterns outside Java's set rules as a language. This is usually syntax error like forgetting a semicolon at the end of a line or using a variable that isn't initialized. These are caught by the Java compiler when you run the "javac" command, and they're generally easier to resolve.
> 
> **Runtime Errors** - these are a bit trickier since you'll be able to compile your code successfully. Syntax-wise, all is well, but your program encounters an breaking issue when it runs due to a flaw in logic. A few common ones are listed below:
> 1. ArrayIndexOutOfBoundsException: when you try to index a position in an array that doesn't exist, you'll encounter this error. If you tried to use Python's negative indexing on an array, you've probably seen this one! Commonly, an iterator may be off by one or we've calculated an index incorrectly if we're using arbitrary points in an array like we do for binary search.
> ```
> int[] nums = new int[10];
> nums[10] = 11; // This throws the out of bounds error since indices are [0-9]!  
> ```
> 2. NullPointerException: If your code tries to use a variable that hasn't been initialized or instantiated (nothing exists yet), you'll see this exception pop up in the stack trace. 
> ```
> Book[] books = new Book[20];
> books[1].getAuthor(); // we haven't instantiated any books yet, so we're trying to call the getAuthor method on null. 
> ``` 

Additionally, you may encounter logical errors in which all syntax is correct, the program runs without error, but it doesn't do exactly what it was intended to do. These can be the trickiest and most time consuming, and usually take some careful debugging and use of specific test cases to diagnose.

## Milestone 1: Print Statements vs The IntelliJ Debugger

Among the basic tools for debugging, print statments can be a great place to start if we're testing code flow or wanting to do a quick visualization of variable states.

However, some data types (like Arrays) don't visualize quite as nicely with a basic print statment. In these situations, we could write a custom method to create strings for debugging, but we could also take advantage of the IntelliJ debugger! 

IntelliJ has many built-in features that make it easier to debug, like setting points to pause program execution and viewing the state of variables. For later milestones, you may find it helpful to to use this tool. Take some time to practice using the built-in debugger with the SumDigits.java file and familiarize yourself with Step Into, Step Over, and Step Out. 

[🔍 Click here for a Introduction to the IntelliJ Debugger](https://github.umn.edu/CSCI-1933/Student-Resources/blob/main/DebuggingGuide.pdf)

✅ Checkoff: Explain to a TA how to:

- Set breakpoints

- Use Step Into / Step Over / Step Out


# Super Secret Messages

Your arch-nemesis Rat Man has been passing encoded messages back and forth across Lab 6 City with his henchmen! 

He's up to no good, and luckily we've intercepted several of his messenger rats. Alas! Another group of them got into our decryption program's code and it's no longer running correctly. 

You'll need to use all your debugging skill to fix the program, decode Rat Man's messages, and help us save Lab 6 City from his nefarious scheme.  

## Milestone 2: Fix the Syntax

Those dastardly little rats have wreaked havoc on Decrypter.java's carefully constructed syntax! As your first step, comment back in the code for Decrypter.java and try to compile this program. 

Once you've done so, fix all of the rats' syntax errors until the file compiles successfully. **When you make changes, make a note of what errors are being resolved.**

✅ Checkoff: Check in with a TA once it's compiling successfully to receive credit for this milestone. Your TA may ask about what errors you needed to fix.

## Milestone 3: Guided Debugging

Luckily, you're not in this alone! Our team of assistants has identified some initial issues and written up a guide on how to find them. Follow the instructions below to get the first few addressed.

Bug #1: 

Run Decrypter.java as an application. You should see the following:

```
Decrypting...
```

Notice we never get a notification that execution is finished! The program must be stuck somewhere.

Now take a look at this loop in decryptAll():
```
for (int i = 0; i < messageFiles.length; i--) {
```

Let's add a breakpoint here. Run the debugger, and take a look at what's happening to the variable "i" each time through the loop.
<details>
  <summary>Reveal Cause of Bug</summary>
  

> We're stuck in an infinite loop since we're moving in the opposite direction of our stopping
> condition! Let's change the increment to positive (i++) so it eventually stops. 
</details>

Bug #2: 

Now everything's running and that's great, but your output likely looks like this:
```
Message 1: 
Bxxw fn'uu bcartn fqnan cqnh unjbc ngynlc, jwm juu xo Ujk 6 Lrch fruu kn dwmna vh lxvvjwm! Bzdnjt!

Message 2: 
null

Message 3: 
Ck yzxoqk lxus znk ykckxy gz znk yzxuqk ul sojtomnz.
Znkox inkkyk corr hk uaxy! Ywakgq!
```
It looks like Rat Man's messages are still encoded, and the second one is showing as "null". 
Let's look at the loop one more time with a breakpoint. Again, pay careful attention to how variables are incrementing.

<details>
  <summary>Reveal Cause of Bug</summary>
  

> Looks like we're double incrementing i! This means each loop, i increases by 2 rather than 1 which makes us skip some messages.
> Let's remove the internal i++ since that's causing us to skip one.  
</details>

✅ Checkoff: Show a TA your code with all 3 messages printing to the screen. At this point messages are still be encoded, so don't worry if they're unintelligible so long as there are three shown.

## Milestone 4: 
Now it's up to you to fix the remaining decode issues and uncover Rat Man's plot! These issues may be in Decrypter or EncodedMessage, so be open-minded with where you're setting breakpoints.

Rat Man's henchmen can't handle too complex a cipher. Our team knows he'll always use a [Caesar Cipher](https://en.wikipedia.org/wiki/Caesar_cipher), which shifts each letter in the alphabet by a fixed number (e.g., A → C if the shift is 2).

To decode Rat Man's messages, we shift each character by some amount. 

Rat Man can't resist ending his messages with a "Squeak!" every time, so the decode method analyzes this last word to find the shift amount.

Once you've addressed the errors and the program is bug-free, you should see four messages printed to the screen. 

Again, **when you make changes, make a note of what errors are being resolved.**

✅ Checkoff: Show a TA all 4 messages printing on screen. Your TA may ask further questions about what changes were necessary to make this program run.
