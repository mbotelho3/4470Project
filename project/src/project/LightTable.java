package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LightTable extends JPanel{

	public Recognizer recog;
	private Image currPic;
	private JScrollPane scroll;
	private int PhotoView;
	public TComponent tc;
	private int BrowserView;
	private int SplitView;
	public int viewType;
	public PComponent pc;
	public JFrame parentFrame;
	public ArrayList<Image> imageList;	
	public int view;
	
	public LightTable(final JFrame frame){
		tc= new TComponent(this);
		view=0;
		recog= new Recognizer(this);
		parentFrame=frame;
		viewType=1;
		this.setBackground(Color.RED);
		PhotoView=1;
		BrowserView=2;
		SplitView=3;
	}
	//checks what view is set from menu & does appropriate function
	public void setNewView(ArrayList listy, int v){
		view=v;
		imageList=listy;
		if (v==1){
			removeAll();
			parentFrame.getContentPane();
			pc=new PComponent(this);
			pc.setImage((BufferedImage) listy.get(0));
			this.setLayout(new BorderLayout());
//			this.setPreferredSize(new Dimension(100,100));
			
			this.add(pc, BorderLayout.CENTER);
			this.add(pc);
			this.validate();
		}
		if (v==2){
			removeAll();
			validate();
			parentFrame.getContentPane();
			System.out.println(listy);
			this.setLayout(new BorderLayout());
			tc= new TComponent(this);
			this.add(tc);
			tc.makeView(listy);
		}
		if (v==3){
			
			JPanel j=new JPanel();
			removeAll();
			j.setLayout(new BorderLayout());
			
			tc=new TComponent(j);
			tc.makeView(listy);
            tc.setPreferredSize(new Dimension(200,200));
			pc=new PComponent(j);
			pc.setImage((BufferedImage) listy.get(0));

			j.add(pc,BorderLayout.CENTER);
			j.add(tc,BorderLayout.SOUTH);
            scroll = new JScrollPane(j);
            j.setAutoscrolls(true);
            this.add(scroll);
			validate();
			repaint();
			
		}
	}
	
//	public void mouseClicked(MouseEvent e) {
//		if (view==2){
//			//do nothing
//		}
//		else if (view==3 && e.getClickCount()==1){
//			Image i= tc.getSelected();
//			
//			
//		}
//		else{
//			//do nothing
//		}
//	}
	
	public menu getMenu(){
		return ((Driver) parentFrame).getMenu();
	}

	public Image getTC() {
		System.out.println("lt");
		return tc.getSelected();
	}
	
	public ArrayList getPhotos(){
		return imageList;
	}
	
	public int getSelectedInd (TComponent tc){
		return tc.getSIndex();
	}
}
