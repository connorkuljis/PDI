# Programming Design and Implementation (COMP 1007) Assignment

# Approach to Data Validation
One aspect of the approach to data validation in this assignment is to minimise repetition of handling and validating user input. To aid this I have made use of a separate UserInterface class, in conjunction with method overloading to validate user input from the keyboard. The class submodules 'userInput' can validate the following datatypes: Integer, Double, Long, Float, String and Character. The submodules/methods take in 3 parameters. A short string message to display to the user, a minimum value and a maximum value. These modules help mitigate the chances of error and exceptions where the flow of the program is disrupted. This approach also underpins the idea of making programs more readable by other humans. Instead of mutiple lines of code and nested loops, it can be done in a more readable fashion on one line, avoiding repetition and reducing the total number of lines of code in the program.

Another aspect in my approach to data validation is the idea that there is upper and lower level exception handling. Exceptions could occur anywhere in my code, but wrapping everything in a try catch block can be hard to read and confusing. My solution to this problem is to isolate a small areas to my program that does use exception handling, and if needed, re-throw exceptions to the caller - which can then loop untill no exception is raised. This is most evident in the FileIO class where the program is reading/writing to a file, based on user input. In my readFile method, (which opens a given file based on a file name, and attempts to create a multidimensional array from it) I can catch and re-throw some custom exceptions such as: FileNotFoundException, IllegalArgumentException and NumberFormatException. This allows the upper level caller to handle responsibilty and simply catch the base Exception class. 

# Design and Justification of Classes and Class Functionality
My reasoning and design of my classes mainly centers around the assignment specification and avoiding complicating things further than needed.
In total there 7 classes, 2 of which are model classes - Image and Date.

## Menu
The main functionality stems from my Menu class which is a base skeleton of the program which branches off and calls other small sub-menus for further functionality. This gives it a more readable structure and avoids having multiple nesting ofcase/switch statements and makes it more cohesive at the expense of more coupling.

## Model Classes

## Static Classes
Static Classes include: DetectEdges, FileIO, PDIMath and UserInterface.
The functionality of these classes follow:
**insert photo**

# Importance of static and model classes

# Real World Implication
There are many implications of the convolute algorithm, it could also be used to remove or isolate lines in an image. Imagine an image with horizontal and vertical lines, but we just singular lines running in one direction. By applying a convolution with either horizontal or vertical kernels we could remove any of the opposing lines. This could be used in the context of maps, diagrams or topography, eg: a train map, circuit diagram, satellite image, barcode.


# Challenges Faced in Design and Implementation
One of the challenges I faced was *naming*, more specifically having meaningful names wether it be for variables, methods, arguments, classes, directories or files. It was clear to me once dealing with many different class files with multiple methods, especially looking bad at earlier practicals, things can get messy and and without proper comments can sometimes make little sense; even if they technically fit the Univeristy style guide. I have learnt to use longer, intention revealing names, creating names where the length of name is relative to the scope of the program and understanding the purpose of good naming. 

Another obstacle was the grand design/implementation and the linking of different submodules together. When I first started I wasnt quite sure where things needed to go and in what order. Just a general sense of direction. But by breaking things down in to small tasks helped me overcome this obstacle. 

Testing. Many times when refactoring, stripping/ adding functionality you are not sure if what you have done will break the program, or give you wrong output even if it compiles. This leads on to the point of testing as I spent a lot of time just testing the program by hand, compiling it, running it, then exploring through the menu by hand trying to find any exceptions, then going back - adding a print statement to double check if the program is working optimally. I found it hard to write test harnesses, especially in regards to user input. In the end i created a testMain file to skip user input and hard code some input values for singular methods.







