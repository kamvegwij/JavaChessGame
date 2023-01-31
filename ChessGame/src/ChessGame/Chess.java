/**MADE A CHESS GAME: KAMVE GWIJANA**/
package ChessGame;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Chess {
	
	public static void createChessBoard() throws IOException
	{
		//create the list of the pieces:
		LinkedList<Piece> pL = new LinkedList<>();
	
		//get the pieces from an image:
		BufferedImage all = ImageIO.read(new File("C:/Users/gwijg/eclipse-workspace/ChessGame/src/chess.png"));
		Image imgs[] = new Image[12];
		int index = 0;
		for (int y = 0; y < 400; y+=200)
		{
			for (int x = 0; x < 1200; x+=200)
			{
				imgs[index] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
				index++;
			}
		}
		//black pieces:
		Piece brook = new Piece(0, 0, false, "rook", pL);
		Piece brook2 = new Piece(7, 0, false, "rook", pL);
		Piece bknight = new Piece(1, 0, false, "knight", pL);
		Piece bknight2 = new Piece(6, 0, false, "knight", pL);
		Piece bbishop = new Piece(2, 0, false, "bishop", pL);
		Piece bbishop2 = new Piece(5, 0, false, "bishop", pL);
		Piece bqueen = new Piece(3, 0, false, "queen", pL);
		Piece bking = new Piece(4, 0, false, "king", pL);
		Piece bpawn = new Piece(0, 1, false, "pawn", pL);
		Piece bpawn2 = new Piece(1, 1, false, "pawn", pL);
		Piece bpawn3 = new Piece(2, 1, false, "pawn", pL);
		Piece bpawn4 = new Piece(3, 1, false, "pawn", pL);
		Piece bpawn5 = new Piece(4, 1, false, "pawn", pL);
		Piece bpawn6 = new Piece(5, 1, false, "pawn", pL);
		Piece bpawn7 = new Piece(6, 1, false, "pawn", pL);
		Piece bpawn8 = new Piece(7, 1, false, "pawn", pL);
		
		//white pieces:
		Piece wrook = new Piece(0, 7, true, "rook", pL);
		Piece wrook2 = new Piece(7, 7, true, "rook", pL);
		Piece wknight = new Piece(1, 7, true, "knight", pL);
		Piece wknight2 = new Piece(6, 7, true, "knight", pL);
		Piece wbishop = new Piece(2, 7, true, "bishop", pL);
		Piece wbishop2 = new Piece(5, 7, true, "bishop", pL);
		Piece wqueen = new Piece(3, 7, true, "queen", pL);
		Piece wking = new Piece(4, 7, true, "king", pL);
		Piece wpawn = new Piece(0, 6, true, "pawn", pL);
		Piece wpawn2 = new Piece(1, 6, true, "pawn", pL);
		Piece wpawn3 = new Piece(2, 6, true, "pawn", pL);
		Piece wpawn4 = new Piece(3, 6, true, "pawn", pL);
		Piece wpawn5 = new Piece(4, 6, true, "pawn", pL);
		Piece wpawn6 = new Piece(5, 6, true, "pawn", pL);
		Piece wpawn7 = new Piece(6, 6, true, "pawn", pL);
		Piece wpawn8 = new Piece(7, 6, true, "pawn", pL);
		
		JFrame frame = new JFrame();
		frame.setBounds(10, 10, 512, 512); /**the bounds of the board **/
		frame.setUndecorated(true);
		JPanel pn = new JPanel()
				{
					/**board background**/
					@Override
					public void paint(Graphics g)
					{
						boolean white = true;
						for (int y = 0; y<8; y++)
						{
							for (int x = 0; x<8; x++)
							{
								if (white)
								{
									g.setColor(new Color(235, 240, 208));
								}
								else
								{
									g.setColor(new Color(115, 148, 85));
								}
								//g.fillRect(x*64, y*64, 64, 64);
								g.fill3DRect(x*64, y*64, 64, 64, true); //MADE THE CHESS BOARD LOOK 3D
								white = !white;
							}
							white = !white;
						}
						for (Piece p:pL)
						{
							int ind = 0;
							if(p.name.equalsIgnoreCase("king")) {
								ind = 0;
							}
							if(p.name.equalsIgnoreCase("queen")) {
								ind = 1;
							}
							if(p.name.equalsIgnoreCase("bishop")) {
								ind = 2;
							}
							if(p.name.equalsIgnoreCase("knight")) {
								ind = 3;
							}
							if(p.name.equalsIgnoreCase("rook")) {
								ind = 4;
							}
							if(p.name.equalsIgnoreCase("pawn")) {
								ind = 5;
							}
							if(!p.isWhite) {
								ind += 6;
							}
							
							g.drawImage(imgs[ind], p.xPoint*64, p.yPoint*64, this);
						
						}
					}
				};
				
		frame.add(pn); /** background to the board**/
		frame.setDefaultCloseOperation(3); /**to close the board**/
		frame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException
	{
		createChessBoard();
		
	}
}
