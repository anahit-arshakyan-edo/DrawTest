I. File List

Draw.java						It is the model file of our draw tool
DrawRunableController.java		This controller is for implementation
README.md						This file


II. Description

The application is for painting.
With this application you can draw a canvas, inside of canvas you can draw lines, rectangles and also you can fill with color like bucket filling.
Here are the commands list:

	1. Enter letter 'C' it means you are going to draw a canvas. After letter you should enter 2 integer for 		with and height and just 		enter. For example:
		C 20 20
		
	2. When you draw a canvas you can draw lines (vertical and horizontal) inside of canvas. For drawing a 		line you should start with letter 'L' then enter 4 integers (x1, y1, x2, y2), which are in canvas 		range. After enter you will see the canvas again where you 	will see your line which is drawn with 		'X' symbols.
		For example:
		  x1 y1 x2 y2
		L 10 11 10 18
		
	3. 'R' means you are going to draw a rectangle. Then you need to add 4 integers (x1, y1, x2, y2). When 		you press enter you will see new drawn canvas with the rectangle. You can have crossed rectangles or 		crossed with lines.
		For example:
		  x1 y1 x2 y2
		R 10 10 15 18
		
	4. 'B' command means you want to fill the area where you put your point. B is command like bucket fill in 		paint. you need enter B after the point coordinates it means 2 integer (x, y) after a symbol which 		will be your chosen color.
		For example:
		  x y color
		B 1 2 G
				
	5. 'Q' means you want to end the program. 
	
	All commands are not case sensitive. 
	
III. Test Cases

	1. Without drawing canvas try to use command L, R or B.
	2. For commands C, L, R, B enter big numbers bigger than allowed size of integers.
	3. For commands C, L, R, B enter negative values.  
	4. For commands L, R and B enter integers more than with or height of canvas.
	5. For commands C, L, R and B instead of integers enter letters or other symbols
	6. For the third parameter of command B enter -, | or X