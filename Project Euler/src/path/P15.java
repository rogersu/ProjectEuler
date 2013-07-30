package path;
/*Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
How many such routes are there through a 20×20 grid?
*/

public class P15{
	static long paths;
	static final int GRIDSIZE = 20;
	static long[][] pathRecord;
	
	public static void solve_P15(){
		pathRecord = new long[GRIDSIZE+1][GRIDSIZE+1];
		
		System.out.println("Number of Paths: " + recursiveFind(0, 0));
	}
	
	public static long recursiveFind(int x, int y){
		if (pathRecord[x][y] == 0){
			if (x == y){
				pathRecord[x][y] = (recursiveFind(x+1, y) * 2);
			}
			else{
				if (x < GRIDSIZE){
					pathRecord[x][y] = recursiveFind(x+1, y) + recursiveFind(x, y+1);
				}
				else{
					pathRecord[x][y] = 1;
				}
			}
		}
		return pathRecord[x][y];
	}
}
		
		
		
		
/*public class P15 {
	static final int GRIDSIZE = 20;
	Node head;
	static int paths = 0;
	
	private class Node{
		private byte x;
		private byte y;
		private Node left;
		private Node right;
		
		Node (byte x, byte y){
			this.x = x;
			this.y = y;
			left = null;
			right = null;
		}
		
		public byte getX(){
			return this.x;
		}

		public byte getY(){
			return this.y;
		}
		
		public Node getLeft() {
			return this.left;
		}

		public void setLeft(byte x, byte y) {
			this.left = new Node(x, y);
		}

		public Node getRight() {
			return this.right;
		}

		public void setRight(byte x, byte y) {
			this.right = new Node(x, y);
		}
	}
	
	public P15(){
		this.head = new Node((byte)0, (byte)0);
	}
	
	public void populateTree(Node node){
		Byte x = node.getX();
		Byte y = node.getY();
		if (x < GRIDSIZE & y < GRIDSIZE){
			if (x < GRIDSIZE){
				node.setLeft((byte)(node.getX()+1), (byte)node.getY());
				populateTree(node.getLeft());
			}
			if(y < GRIDSIZE){
				node.setRight((byte)node.getX(), (byte)(node.getY()+1));
				populateTree(node.getRight());
			}
		}
		else{
			paths++;
		}
	}
}*/
