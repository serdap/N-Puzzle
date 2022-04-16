package npuzzle;

import java.util.ArrayList;
import java.util.List;

public class Solver {
	private Board board;
	int steps = 0;
	int priority = 0;
	public Solver(Board initial) {
		for(int i = 0; i < initial.array.length; i ++) {
			for(int j = 0; j < initial.array.length; j ++) {
				board.array[i][j] = initial.array[i][j];
			}
		}
	}
	
	public int getPriority() {
		return steps + board.manhattan();
	}
	
	public boolean isSolvable() {
		return board.manhattan()%2 == 0;
	}
	
	public int moves() {
		return -1;
	}
	
	public Iterable<Board> solution(){
		List<Board> result = new ArrayList<>();
		if(isSolvable() == true) {
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[][] blocks = ...;
		Board initial = new Board(blocks);
		// solve the puzzle
		Solver solver = new Solver(initial);
		// print solution to standard output
		if (!solver.isSolvable())
		System.out.println("No solution possible");
		else {
		System.out.println("Minimum number of moves = " + solver.moves());
		for (Board board : solver.solution())
		System.out.println(board);
		}
	}
}
