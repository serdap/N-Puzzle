package npuzzle;

import java.util.ArrayList;
import java.util.List;

public class Board {
	int[][] array;
	public Board(int[][] blocks) {
		for(int i = 0; i < blocks.length; i ++) {
			for(int j = 0; j < blocks.length; j ++) {
				array[i][j] = blocks[i][j];
			}
		}
	}
	
	public int dimension() {
		return array.length;
	}
	
	public int manhattan() {
		int a = 0;
    	int temp;
    	for(int i = 0; i < array.length; i++){
    		for(int j = 0; j< array[0].length; j++){
    			if(array[i][j] == 0){
    				temp = 0;
    			}
    			else{
    				/* 1 2 3
    				 * 4 5 2
    				 * 7 8 9 
    				 * i*3 +j +1
    				 */
    				int row = array[i][j]%array.length == 0? array[i][j]/array.length - 1 : array[i][j]/array.length;
    				int col = array[i][j]%array.length == 0? array.length-1 : array[i][j]%array.length -1;
    				temp = Math.abs(i-row)+ Math.abs(j-col);
    			}
    			a += temp;
    		}
    	}
        return a;
	}
	
	public boolean isGoal() {
		return manhattan() == 0;
	}
	
	public Board twin() {
		Board result = new Board(array);
		return result;
	}
	
	public boolean equals(Object y) {
		if(y instanceof Board) {
			Board object = (Board) y;
			if(object.dimension() != this.dimension()) return false;
			for(int i = 0; i < this.dimension(); i ++) {
				for(int j = 0; j < this.dimension(); j ++) {
					if(this.array[i][j] != object.array[i][j]) return false;
				}
			}
			return true;
		}
		return false;
	}
	
	private int[][] swap(int i, int j,int m, int n, int[][] a) {
        int[][] result = new int[a.length][a[0].length];
        for(int b = 0; b< a.length; b++) {
    		for(int c = 0; c < a[0].length; c++) {
    			result[b][c] = a[b][c];
    		}
        }
    	int temp = result[i][j];
    	result[i][j] = result[m][n];
    	result[m][n] = temp;
    	return result;
    }
    
    public Iterable<int[][]> neighbors(int[][] m) {
    	List<int[][]> result = new ArrayList<>();
    	int c=0,l=0;
    	int[][] temp = new int[m.length][m[1].length];
    	for(int i = 0; i< m.length; i++) {
    		for(int j = 0; j < m[0].length; j++) {
    			temp[i][j] = m[i][j];
    			if(m[i][j] == 0) {
    				c = i;
    				l = j;
    			}
    		}
    	}
    	
    	if((c+1) < m.length) {
    		result.add(swap(c,l, c+1, l, temp));
    	}
    	
    	if((c-1) >= 0) {
    		result.add(swap(c,l, c-1, l, temp));
    	}
    	
    	if((l+1) < m[0].length) {
    		
    		result.add(swap(c,l+1, c, l, temp));
    		//swap(c,l+1, c, l, temp);
    	}
    	
    	if((l-1) >= 0) {
    		
    		result.add(swap(c,l-1, c, l, temp));
    		//swap(c,l-1, c, l, temp);
    	}
    	
		return result;
	}
    
    public String toString() {
    	String result = "";
    	for(int i = 0; i < array.length; i ++) {
			for(int j = 0; j < array[0].length; j ++) {
				result.concat(array[i][j]+"");
			}
		}
    	return result;
    }
    
}
