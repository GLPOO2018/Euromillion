package fr.esiea.euro.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JCanvas extends JPanel {
	
	private final static int WIDTH = 501;
	private final static int HEIGHT = 501;
	private int shape;
	private int order;
	private int fgColor;
	private int bgColor;
	
	public JCanvas() {
		super();
		shape=0;
		order=0;
		fgColor=0;
		bgColor=0;
	}
	
	public void setShape(int shape) {
		this.shape = shape;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public void setFgColor(int fgColor) {
		this.fgColor = fgColor;
	}
	
	public void setBgColor(int bgColor) {
		this.bgColor = bgColor;
	}
	
	public int getShape() {
		return shape;
	}
	
	public int getOrder() {
		return order;
	}
	
	public int getFgColor() {
		return fgColor;
	}
	
	public int getBgColor() {
		return bgColor;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Color color = g.getColor();
		setForegroundColor(g);
		setBackgroundColor();
		paintGraph(g);
		g.setColor(color);
	}
	
	private void setForegroundColor(Graphics g) {
		switch (fgColor) {
		case 0 :
			g.setColor(Color.ORANGE);
			break;
		case 1 :
			g.setColor(Color.CYAN);
			break;
		case 2 :
			g.setColor(Color.MAGENTA);
			break;
		case 3 :
			g.setColor(Color.BLACK);
			break;
		case 4 :
			g.setColor(Color.WHITE);
			break;
		case 5 :
			g.setColor(Color.RED);
			break;
		case 6 :
			g.setColor(Color.GREEN);
			break;
		case 7 :
			g.setColor(Color.BLUE);
			break;
		case 8 :
			g.setColor(Color.YELLOW);
			break;
		case 9 :
			g.setColor(Color.PINK);
			break;
		default :
			break;
		}
	}
	
	private void setBackgroundColor() {
		if((fgColor==bgColor)&&(bgColor>2)) {
			bgColor=(bgColor+1)%10;
		}
		switch (bgColor) {
		case 0 :
			setBackground(Color.LIGHT_GRAY);
			break;
		case 1 :
			setBackground(Color.GRAY);
			break;
		case 2 :
			setBackground(Color.DARK_GRAY);
			break;
		case 3 :
			setBackground(Color.BLACK);
			break;
		case 4 :
			setBackground(Color.WHITE);
			break;
		case 5 :
			setBackground(Color.RED);
			break;
		case 6 :
			setBackground(Color.GREEN);
			break;
		case 7 :
			setBackground(Color.BLUE);
			break;
		case 8 :
			setBackground(Color.YELLOW);
			break;
		case 9 :
			setBackground(Color.PINK);
			break;
		default :
			break;
		}
	}
	
	private void paintGraph(Graphics g) {
		for (int n=order;n>0;n--) {
			for (int i=(int)Math.pow(3, n-1);i>0;i--) {
				for (int j=(int)Math.pow(3, n-1);j>0;j--) {
					switch (shape) {
					case 0 :
						g.fillRect(
							(1+3*(j-1))*WIDTH/(int)Math.pow(3,n), 
							(1+3*(i-1))*HEIGHT/(int)Math.pow(3,n), 
							WIDTH/(int)Math.pow(3,n), 
							HEIGHT/(int)Math.pow(3,n));
						break;
					case 1 :
						g.fillOval(
							(1+3*(j-1))*WIDTH/(int)Math.pow(3,n), 
							(1+3*(i-1))*HEIGHT/(int)Math.pow(3,n), 
							WIDTH/(int)Math.pow(3,n), 
							HEIGHT/(int)Math.pow(3,n));
						break;
					default :
						break;
					}
				}
			}
		}
		
	}

}
