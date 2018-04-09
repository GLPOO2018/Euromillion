package fr.esiea.euro.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class EuroJFrame extends JFrame {

	private final EuroModel model;
	private final JTable tab;
	private final JSplitPane split;
	private JCanvas canvas;
	
	public EuroJFrame() {
		setTitle("Euromillion");
		setPreferredSize(new Dimension(507,750));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		model = new EuroModel();
		tab = new JTable(model);
		tab.setAutoCreateRowSorter(true);
		
		final JScrollPane scroll = new JScrollPane(tab);
		canvas = new JCanvas();
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, canvas, scroll);
		split.setDividerLocation(501);
		split.setEnabled(false);
		getContentPane().add(split, BorderLayout.CENTER);
		
		final JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.ORANGE);
		final JButton drawButton = new JButton(new DrawAction());
		final JButton saveButton = new JButton(new SaveAction());
		final JButton cleanButton = new JButton(new CleanAction());
		buttonPanel.add(drawButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(cleanButton);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
	}
	
	private class DrawAction extends AbstractAction {

		public DrawAction() {
			super("Draw");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			final int[] rows = tab.getSelectedRows();
			int shape = 0;
			int order = 0;
			int fgColor = 0;
			int bgColor = 0;
			for (int row : rows) {
				shape = (shape + (int)tab.getValueAt(row, 1))%2;
				order = (order = (int)tab.getValueAt(row, 2))%5;
				fgColor = (fgColor + (int)tab.getValueAt(row, 3))%10;
				bgColor = (bgColor + (int)tab.getValueAt(row, 4))%10;
			}
			canvas.setShape(shape);
			canvas.setOrder(1+order);
			canvas.setFgColor(fgColor);
			canvas.setBgColor(bgColor);
			canvas.repaint();
		}
	}
	
	private class SaveAction extends AbstractAction {
		
		private SaveAction() {
			super("Save");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			BufferedImage bufferedImage = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
			canvas.paint(bufferedImage.createGraphics());
			
			try {
				ImageIO.write(bufferedImage, "png", new File("Image.png"));
			} catch (Exception e) {
				System.out.println("Oups");
			}
		}
		
	}
	
	private class CleanAction extends AbstractAction {

		public CleanAction() {
			super("Clean");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			final int[] rows = tab.getSelectedRows();
			for (int row : rows) {
				canvas.setShape(0);
				canvas.setOrder(0);
				canvas.setFgColor(0);
				canvas.setBgColor(0);
			}
			canvas.repaint();
		}
	}
	
}
