package ChessGame;


import java.util.LinkedList;



public class Piece {
	//coordinates of the piece
	int xPoint; int yPoint;
	boolean isWhite; //state whether piece is on the white or the black
	LinkedList<Piece> pL;
	String name; //the name of the chess piece
	
	public Piece(int xPoint, int yPoint, boolean isWhite, String n,LinkedList<Piece>pL) //this is the class method
	{
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		this.isWhite = isWhite;
		this.name = n;
		pL.add(this);
	}
	
	public void move(int x, int y)
	{
		//move the chess piece
		for (Piece p: pL)
		{
			if (p.xPoint == x && p.yPoint == y)
			{
				//kill the piece at that point
				p.kill();
			}
		}
		//now move the piece to that position:
		this.xPoint = x;
		this.yPoint = y;
		
		/**can also use: pL.stream().filter( (p) -> (p.xPoint==x && p.yPoint==y) ).forEachOrdered(p) -> {
			p.kill();
			} **/
	}
	public void kill()
	{
		pL.remove(this);
	}
}
