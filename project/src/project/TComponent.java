package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TComponent extends JComponent{

	private JFrame parentFrame;
	private JScrollPane scroll;
	
	public TComponent(final JFrame frame){
		parentFrame=frame;
		scroll = new JScrollPane();
	    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setViewportView(this);
	    scroll.getViewport().setBackground(Color.LIGHT_GRAY);
		parentFrame.getContentPane().add(BorderLayout.CENTER,scroll);
		this.setBackground(Color.ORANGE);
		setFocusable(true);
	}
	
	public void makeView(){
		this.setLayout(new GridLayout(3,3));
		ArrayList imList= ((Driver)parentFrame).getImage();
		for (int i=0; i<imList.size();i++){
			java.awt.Image t = ((Image)imList.get(i)).getThumbnail(new Dimension(100,100));
			ImageIcon icon= new ImageIcon(t);
			JLabel j = new JLabel(icon);
			this.add(j);
		}
	}
	
	
}