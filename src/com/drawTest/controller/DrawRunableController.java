package com.drawTest.controller;

import java.util.Scanner;
import com.drawTest.model.Draw;
import java.util.InputMismatchException;

public class DrawRunableController {

	public boolean checkCoordinates(Draw draw, Integer x1, Integer y1, Integer x2, Integer y2) {

		if (x1 >= draw.getCanvasHeight() || x1<1 || x2 != null && (x2 >= draw.getCanvasHeight() || x2<1)  || y1 >= draw.getCanvasWidth() || y1<1
				|| y2 != null && (y2 >= draw.getCanvasWidth() || y2<1)) {
			return false;
		}		
		return true;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		DrawRunableController drawRunableController = new DrawRunableController();
		Draw draw = null;
		String rules = "Drawing Rules: \nYou should input one letter\n(L=Line, R=Rectangle, B=Bucket fill, C=Create Canvas) afterwards appropriate data for each command.\n"
				+ "For Example:\n C 20 4 \n L 1 2 6 2 \n R 16 1 20 3 \n B 10 5 o";
		System.out.println("Hello!\n" + rules);
		
		
		while (true) {
			
			System.out.println("Enter Command");
			char action = scan.next().charAt(0);
			action = Character.toUpperCase(action);
			/** Enter canvas dimensions **/
			if (action == 'C') {
				try {
					int N = scan.nextInt();
					int M = scan.nextInt();
					if(N>0 && M>0){
						draw = new Draw(M, N);
					}else{
						System.out.println("Please enter positive integers!!!");
						scan.nextLine();
						continue;
					}
					
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input.\n" + rules);
					scan.nextLine();
					continue;
				}

			}
			else if (draw == null) {/** When the canvas didn't set yet **/ 
				System.out.println("Sorry, but at first you should draw the canvas!!!");
				scan.nextLine();
				continue;
			} else if (action == 'L' || action == 'R') {/** Enter Line or Rectangle coordinates **/ 
				try {
					int x1 = scan.nextInt();
					int y1 = scan.nextInt();
					int x2 = scan.nextInt();
					int y2 = scan.nextInt();
					System.out.println("\n Press key enter");
					if (drawRunableController.checkCoordinates(draw, x1, y1, x2, y2)) {
						switch (action) {
						case 'L':/** Draw Line **/ 
							draw.drawLine(x1, y1, x2, y2);
							break;
						case 'R':/**
						 Draw Rectangle **/ 
							draw.drawRect(x1, y1, x2, y2);
							break;
						default:
							break;
						}
					} else{/** Coordinates are out of the canvas range **/ 
						System.out.println("Please enter correct coordinates!!!");
						scan.nextLine();
						continue;
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input.\n" + rules);
					scan.nextLine();
					continue;
				}

			} else if (action == 'B') {/** Enter Bucket Fill coordinates **/ 
				try {

					int x = scan.nextInt();
					int y = scan.nextInt();
					char fillChar = scan.next().charAt(0);
					if (drawRunableController.checkCoordinates(draw, x, y, null, null)){
						if(fillChar!='-' && fillChar!='|' && fillChar!='X'){
							draw.bucketFill(y, x, fillChar);
						}else{
							System.out.println("Please use an other symbol for color, it should not be '-', '|' and 'X'!");
							scan.nextLine();
							continue;
						}
					}
					else{
						System.out.println("Please enter correct coordinates for bucket fill!");
						scan.nextLine();
						continue;
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input.\n" + rules);
					scan.nextLine();
					continue;
				}

			} else if (action == 'Q') {
				System.out.println("Thank you for taking your time, I hope you like it! :) ");
				scan.close();
				return;
			} else {/** The case when there is not such command, it means the entered first letter is not C, L, R or B **/ 
				System.out.println("Sorry, but it is wrong command :( \n" + rules);
				scan.nextLine();
				continue;
			}
			scan.nextLine(); // This is in case if entered more data than need for example L 1 2 1 9 1 3 
			draw.drawCanvas();
		}
		
	}
	

}
