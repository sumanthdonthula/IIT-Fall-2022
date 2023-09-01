Problem 1:

We have 2 classes Jacobsthal.java and main.java

Jacobsthal.java:

Jacobsthal class is used in initiating the variables and methods associated with the recursive and iterative
method.

The main steps involved in Jacobsthal class is :
1) Created a Jacobsthal Recursive and Iteratives method which will accept the integer as an input arguement and
returns the Jacobsthal number.

Jacobsthal Recursive Method:
1)In the Jacobsthal Recursive method we will write the base cases using if loop for n=0 and 1
2)When n is greater than 1 then we will return the jacobian number recursively.

Jacobsthal Iterative Method:
1)Assigned three variables jn_1,jn_2,jacob correspondingly.
2)Assigbed base cases for 1 and 0
3)Inititated for loop to caluculate jacobian value for other than 1 and 0.


main.java:

main class is used to get the values of radius using scanner and calling the methods associated with Jacobsthal class

The main steps involved in main class is :

1)Created an instance of the Jacobsthal class
2)Scanning the size value using a scanner
3)Passed the size value to Jacobsthal Recursive and Iterative Methods Respectively
4)Calculated the execution time for Recursive and Iterative Methods.

Problem 2:

Created a Minimum.class file to print minimum value of an array.

1)In the minimum method we will write base case method when n=1 it will return element at
zeroth index.
2)When n is greater than 1 we will comparer the elements of the array recursively and
return the minimum element. 