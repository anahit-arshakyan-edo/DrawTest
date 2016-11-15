package com.drawTest.model;

import java.util.Arrays;

public class Draw {
	private char[][] canvas;
	
	public Draw(int M, int N){
		this.canvas = new char[M + 2][N + 2];
		for (int i = 1; i < M + 1; i++){
			Arrays.fill(this.canvas[i], ' ');
			this.canvas[i][0] = '|';
			this.canvas[i][N+1] = '|';
		}       
		
		Arrays.fill(this.canvas[0], '-');
		Arrays.fill(this.canvas[M+1], '-');
	}
	
	
	/** Method to draw raw **/
	public void drawLine(int x1, int y1, int x2, int y2){
		
		if(x1 == x2){
			for(int i = y1; i<=y2; i++){
				this.canvas[i][x1] = 'X';
			}
			
		}else if(y1 == y2){
			for(int i = x1; i<=x2; i++){
				this.canvas[y1][i] = 'X';
			}		
		}else{
			System.out.println("Sorry but we can draw just horisontal or vertical lines :(");
		}
	}
	
	/** Method to draw rectangle **/
	public void drawRect(int x1, int y1, int x2, int y2){
		for(int i = y1; i<=y2; i++){
			this.canvas[i][x1] = 'X';
			this.canvas[i][x2] = 'X';
		}
		for(int i = x1; i<=x2; i++){
			this.canvas[y1][i] = 'X';
			this.canvas[y2][i] = 'X';
		}
				
	}
	/** Method to fill bucket **/
    public void bucketFill( int x, int y, char c) 
    {
    	if(x>= this.getCanvasWidth() || y>=this.getCanvasHeight())
    		return;
        if (this.canvas[x][y]!= 'X' && this.canvas[x][y]!= '-' && this.canvas[x][y]!= '|' && this.canvas[x][y]!= c)
        {
        	this.canvas[x][y] = c;
             
            bucketFill(x + 1, y, c);
            bucketFill(x - 1, y, c);
            bucketFill(x, y + 1, c);
            bucketFill(x, y - 1, c);
        }
        
    }
    
    /** Method to display canvas **/
    public void drawCanvas()
    {
        
        for (int i = 0; i < this.canvas.length; i++)
        {
            for (int j = 0; j < this.canvas[i].length; j++){
            	System.out.print(this.canvas[i][j] +" ");
            }
            	                
            System.out.println();
        }
    }
    
    public int getCanvasWidth(){
    	return this.canvas.length-1;
    }
    
    public int getCanvasHeight(){
    	return this.canvas[0].length-1;
    }
    
   

}
