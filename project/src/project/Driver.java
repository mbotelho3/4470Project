package project;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Driver extends JFrame{
	private menu menu;
	private Statbar stat;
	private Tools tools;
	private JPanel panel;
	public LightTable lt;
	public static PComponent pc;
	public static TComponent tc;
	private ArrayList<Image> imageList;
	
	//set everything to be added to driver
	public Driver(){
		stat= new Statbar();
		lt= new LightTable(this);
		imageList= new ArrayList();
		tools= new Tools(stat);
		menu= new menu(this, stat);
		panel= new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(800,700));
		this.getContentPane().add(panel);
		panel.setVisible(true);
		panel.add(menu, BorderLayout.NORTH);
		panel.add(stat, BorderLayout.SOUTH);
		panel.add(tools, BorderLayout.WEST);
		panel.add(lt, BorderLayout.CENTER);
		panel.setMinimumSize(new Dimension(100,100));
		this.setVisible(true);
		revalidate();
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}
	
	//if multiple images selected should go straight to browser view?
	public void setImage(ArrayList<Image> listy, int view) {
		
		for(Image i:listy){
			imageList.add(i);
		}
		lt.setNewView(imageList, view);
		imageList.removeAll(imageList);
		revalidate();
	}
	
	public void removeIt(Image i, int view){
		imageList.remove(i);
		lt.setNewView(imageList, view);
		revalidate();
	}
	
	public Image getTC(){
		System.out.println("d");
		return lt.getTC();
	}
	
	public ArrayList getImage() {
		return imageList;
	}
	
	public static void main (String[] args){
		Driver d= new Driver();
	}

	public LightTable getLightTable() {
		return lt;
	}
}