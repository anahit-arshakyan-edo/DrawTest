package com.drawTest.controller;

import java.util.Scanner;
import com.drawTest.model.Draw;

public class DrawRunableController {

	public boolean checkCoordinates(Draw draw, Integer x1, Integer y1, Integer x2, Integer y2) {
		
	     if(x1>= draw.getCanvasHeight() || x2!=null && x2 >= draw.getCanvasHeight() || y1 >= draw.getCanvasWidth() || y2!=null && y2 >= draw.getCanvasWidth()){
	    	 return false;
	     }
	     return true;
		
	}
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner( System.in );  
		DrawRunableController drawRunableController = new DrawRunableController();
		Draw draw = null;
		 /** Enter canvas dimensions **/
		while(true){
			 System.out.println("Enter Command");
		     char action = scan.next().charAt(0);
		     if(action == 'C'){
		    	 int N = scan.nextInt();
			     int M = scan.nextInt();
		    	 draw = new Draw(M, N);        
			 }else if(draw == null){
		    	 System.out.println("Sorry, but at first you should draw the canvas!!!");
		    	 scan.reset();
		    	 continue;
		     }else if(action == 'L'){
		    	 int x1 = scan.nextInt();
			     int y1 = scan.nextInt();
			     int x2 = scan.nextInt();
			     int y2 = scan.nextInt();
			     if(drawRunableController.checkCoordinates(draw, x1, y1, x2, y2))
			    	 draw.drawLine(x1, y1, x2, y2);
			     else System.out.println("Please enter correct coordinates for drawing line!");
			     
		     }else if(action == 'R'){
		    	 int x1 = scan.nextInt();
			     int y1 = scan.nextInt();
			     int x2 = scan.nextInt();
			     int y2 = scan.nextInt();
			     if(drawRunableController.checkCoordinates(draw, x1, y1, x2, y2))
			    	 draw.drawRect(x1, y1, x2, y2);
			     else System.out.println("Please enter correct coordinates for drawing Rectangle!");
		    	 
		     }else if(action == 'B'){
		    	 int x = scan.nextInt();
			     int y = scan.nextInt();
			     char fillChar = scan.next().charAt(0);
			     if(drawRunableController.checkCoordinates(draw, x, y, null, null))
			    	 draw.bucketFill(y, x, fillChar);
			     else System.out.println("Please enter correct coordinates for bucket fill!");
			     
		     }else if(action == 'Q'){
		    	 System.out.println("Thank you for taking your time, I hope you like it! :) ");
		    	 return;
		     }else{
		    	 System.out.println("Sorry, but it is wrong command :( ");
		    	 scan.reset();
		    	 continue;
		     }
		     draw.drawCanvas();
		}
       
        
	}

}
