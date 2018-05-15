JAVA CANDIDATE EXERCISE

The exercise is to write a controller for a length of fairy lights. There are 20 fairy lights in alternating colours red, green, and white that can be independently turned on and off. The controller is a java program that is given the name of a sequencing algorithm for turning the lights on and off. When launched, the program will execute the requested sequencing algorithm until it is terminated.  As each light is turned on or off, the program should output the message 'Light <number> <colour> <on/off>', for example 'Light 1 red on'.

The following sequencing algorithms are required:
1. 'sequence' : each light is turned on for 0.5 seconds then off in turn from first to last.
2. 'colour' : all of the red lights are turned on for 1 second, then all the green for 1 second then all the white for 1 second.
3. 'alternate' : the 'sequence' algorithm runs for 30 seconds, then the 'colour' algorithm for 30 seconds.

As soon as the algorithm completes, it should start again.  It should be easy to modify the program to support the following changes:
• Add more lights or change the light order.
• Add a new light colour.
• Add new controller algorithms.

Test Assessment Critieria
1. Working to specification
2. Simple and Elegant solution
3. Meaningful and useful test cases
4. Reusing code and abstracting classes where required
5. Good Comments and No spelling mistakes

