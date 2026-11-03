
# Assignment 9 – Java Array Manipulation

## Overview

This project demonstrates Java array manipulation through methods, loops, and array processing. It focuses on creating arrays, identifying and removing duplicate values, sorting arrays, finding common elements, and displaying results.

### Key Concepts
- Java arrays
- Methods and return values
- Nested `for` loops
- Duplicate detection
- Array sorting
- Comparing elements between arrays
- Passing arrays to methods

---

## Objectives

The program performs three main tasks:

1. Create and display three integer arrays containing different values.
2. Remove duplicate values, sort the resulting arrays, and display them.
3. Identify and display the elements shared between all three arrays.

---

## Array Data

The program uses the following three integer arrays:

```java
int[] numbers1 = {4, 11, 5, 10, 7, 6, 8, 9};
// No duplicates

int[] numbers2 = {5, 6, 3, 8, 8, 7, 4, 5};
// 5 and 8 are duplicated

int[] numbers3 = {3, 3, 4, 3, 6, 3};
// 3 appears four times
```

These values are used throughout the program to demonstrate array manipulation.

---

## Program Tasks

### Task 1 – Create and Display Arrays

- Create three integer arrays named `numbers1`, `numbers2`, and `numbers3`.
- Display each array using the `display()` method.
- Display one array element per line, including its index.

### Task 2 – Remove Duplicates and Sort Arrays

- Call `createArrayWithoutDuplicates()` on each original array.
- Store each returned array in a new variable.
- Sort each duplicate-free array using `Arrays.sort()`.
- Display all three sorted arrays using the `display()` method.

**Expected Results:**

| Array | Result After Removing Duplicates |
|---|---|
| `numbers1` | 4, 5, 6, 7, 8, 9, 10, 11 |
| `numbers2` | 3, 4, 5, 6, 7, 8 |
| `numbers3` | 3, 4, 6 |

### Task 3 – Find Common Elements

- Call `findCommonElements()` to identify values shared between two arrays.
- Store the returned array in a variable.
- Call the method twice to identify the elements shared by all three arrays.
- Display the final array of common elements.

**Expected Result:**

```text
Common Elements Between 3 Arrays
-----------------------------------------
array[0] = 4
array[1] = 6
```

---

## Required Methods

The program is organized around three methods.

### 1. display()

Displays the values of an array along with its name.

```java
public static void display(int[] array, String arrayName)
```

**Requirements:**
- Accept an integer array and its name.
- Display the array name.
- Display each element on its own line.
- Include the element's index.

### 2. createArrayWithoutDuplicates()

Creates and returns a new array containing only unique values from the original array.

```java
public static int[] createArrayWithoutDuplicates(int[] arrayWithDuplicates)
```

**Requirements:**
- Identify duplicate values manually.
- Use nested regular `for` loops to compare elements.
- Store unique values in a temporary array.
- Create a correctly sized array containing only the unique values.
- Return the new array without modifying the original.
- Do not print anything inside the method.

### 3. findCommonElements()

Finds and returns the elements shared between two arrays.

```java
public static int[] findCommonElements(int[] array1, int[] array2)
```

**Requirements:**
- Compare the values in both incoming arrays.
- Use nested regular `for` loops.
- Identify elements that appear in both arrays.
- Create and return a new array containing the common values.
- Do not print anything inside the method.

---

## Implementation Guidelines

### Loops and Arrays

- Use regular indexed `for` loops.
- Do not use enhanced `for-each` loops.
- Use standard Java arrays rather than `ArrayList`.
- Preserve the original array values.

### Duplicate Removal

Duplicate detection must be implemented manually using loops and comparisons.

One recommended approach:

1. Create a temporary array to hold unique values.
2. Iterate through the original array.
3. Compare each element against the values already stored in the temporary array.
4. Add the element only if it has not already been included.
5. Create a new array with the exact number of unique elements.
6. Copy the unique values into the new array.
7. Return the correctly sized array.

**Important:** Do not return the temporary array because unused positions will contain default values of `0`.

### Finding Common Elements

- Both incoming arrays are already sorted.
- Use nested loops to compare their elements.
- Store matching values in a new array.
- At least one common value will always exist between the incoming arrays.

### Array References

Java passes array references to methods. This means methods receive a reference to the original array rather than an independent copy.

Changes made to an array inside a method can affect the original array.

---

## Example Output

```text
*******************************
Original Arrays
*******************************

numbers1
-----------------------------------------
array[0] = 4
array[1] = 11
array[2] = 5
array[3] = 10
array[4] = 7
array[5] = 6
array[6] = 8
array[7] = 9

numbers2
-----------------------------------------
array[0] = 5
array[1] = 6
array[2] = 3
array[3] = 8
array[4] = 8
array[5] = 7
array[6] = 4
array[7] = 5

numbers3
-----------------------------------------
array[0] = 3
array[1] = 3
array[2] = 4
array[3] = 3
array[4] = 6
array[5] = 3

*******************************
No Duplicates and Sorted
*******************************

numbers1 - No Duplicate Values & Sorted
-----------------------------------------
array[0] = 4
array[1] = 5
array[2] = 6
array[3] = 7
array[4] = 8
array[5] = 9
array[6] = 10
array[7] = 11

numbers2 - No Duplicate Values & Sorted
-----------------------------------------
array[0] = 3
array[1] = 4
array[2] = 5
array[3] = 6
array[4] = 7
array[5] = 8

numbers3 - No Duplicate Values & Sorted
-----------------------------------------
array[0] = 3
array[1] = 4
array[2] = 6

*******************************
Finding Common Elements
*******************************

Common Elements Between 3 Arrays
-----------------------------------------
array[0] = 4
array[1] = 6
```

---

## Development Approach

A recommended development process:

1. Implement each method individually.
2. Test each method to verify it produces the expected results.
3. Build the `main()` method around the completed methods.
4. Run the entire program and verify the output.

---

## Skills Demonstrated

- Designing reusable Java methods.
- Processing arrays using indexed iteration.
- Implementing nested loops.
- Identifying and removing duplicate values.
- Creating and returning dynamically sized arrays.
- Sorting arrays.
- Comparing multiple arrays to find shared values.
- Organizing code into modular components.
