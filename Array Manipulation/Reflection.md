
# Reflection – Array Manipulation in Java

## Project Overview

This project focused on manipulating arrays in Java by creating arrays, identifying duplicate values, sorting data, and finding common elements between multiple arrays.

The program uses several methods to separate different operations and make the code more organized and reusable.

The main goal was to improve my understanding of arrays, nested loops, and methods while learning how to compare and manipulate data.

---

## What I Learned

Before starting this project, I already understood the basics of arrays, including creating arrays, assigning values, and iterating through them using regular `for` loops. I also had experience creating methods, passing information into methods, and returning values.

However, I wanted to improve my understanding of how to compare values within arrays and how to organize more complex operations into separate methods.

Throughout this project, I learned:

- **Array Iteration:** How to correctly iterate through arrays and access individual elements using their indexes.
- **Comparing Array Values:** How to compare values at different positions within arrays while iterating through them.
- **Nested Loops:** How to use nested `for` loops to compare multiple elements and identify duplicates or common values.
- **Method Organization:** How to separate different operations into multiple methods instead of placing all the logic inside `main()`.
- **Returning Arrays:** How to create new arrays inside methods and return them to be used in other parts of the program.
- **Array Manipulation:** How to remove duplicate values without modifying the original arrays.
- **Sorting:** How to use `Arrays.sort()` to organize array values in ascending order.

One of my biggest takeaways was understanding how multiple methods can work together to accomplish a larger task.

---

## Code Demonstrations

This section contains screenshots or short recordings demonstrating important parts of the program.

### 1. Removing Duplicate Values

**Method:** `createArrayWithoutDuplicates()`

This method uses nested loops to compare array elements and identify duplicate values. Unique values are stored in a temporary array before being copied into a correctly sized array.

<!-- Insert screenshot or recording here -->
<img width="492" height="326" alt="image" src="https://github.com/user-attachments/assets/ca091388-ff4a-414c-bb21-4338d18f6322" />


### 2. Finding Common Elements

**Method:** `findCommonElements()`

This method compares two arrays using nested loops and identifies values that appear in both. The returned array can then be compared against another array to find elements shared across multiple arrays.

<!-- Insert screenshot or recording here -->
<img width="429" height="242" alt="image" src="https://github.com/user-attachments/assets/e4a022f0-35ab-4738-8198-967a9af5090c" />

### 3. Displaying Array Values

**Method:** `display()`

This method takes an array and its name as parameters, then displays each value alongside its corresponding index.

<!-- Insert screenshot or recording here -->
<img width="461" height="98" alt="image" src="https://github.com/user-attachments/assets/98d6a76f-82b4-4294-b954-96b77e79b6a3" />

---

## Challenges

One of the main things I struggled with going into this project was understanding how to compare values within iteration loops.

Although I already understood how to use regular and nested `for` loops, applying them to compare different elements within an array was more challenging.

Another challenge was creating methods that performed more complex operations. Specifically, I had to understand how to create a new array inside a method, populate it with the correct values, and return it so that it could be used elsewhere in the program.

Finding common elements also required additional thought because I needed to compare the first two arrays, store their common values, and then compare those results against the third array.

Working through these challenges helped me become more comfortable with nested loops, array comparisons, and returning arrays from methods.

---

## What Went Well

I was able to successfully separate the program into multiple methods, with each method responsible for a specific operation.

I also successfully used temporary arrays to manipulate data without changing the original arrays.

Another part of the program that went well was finding common elements between all three arrays. By calling the same method twice and using the returned array, I was able to accomplish the comparison without creating an entirely separate method.

The final output correctly removes duplicates, sorts the arrays, and identifies `4` and `6` as the values shared between all three arrays.

---

## What I Would Improve

If I were to revisit this project, I would focus on making the methods more efficient and expanding the program's functionality.

Some improvements I would consider include:

- Improving the efficiency of duplicate detection and array comparisons.
- Adding support for user-input arrays instead of relying on predefined values.
- Adding error handling for empty arrays.
- Expanding the program to compare more than three arrays.
- Improving the formatting of the displayed output.

I would also like to become more comfortable designing complex methods before writing the actual code, as this would help make the development process more efficient.

---

## Final Thoughts

This project helped me strengthen my understanding of arrays and how they can be manipulated using methods and loops.

The biggest thing I learned was how to compare values within arrays using nested loops and how to return newly created arrays from methods.

I also gained a better understanding of how multiple methods can work together to complete a larger task while keeping the code organized.

Overall, this project helped me become more confident working with arrays, solving problems involving multiple iterations, and writing more organized Java programs.
