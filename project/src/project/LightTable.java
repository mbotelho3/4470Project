package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LightTable extends JPanel{

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
	
	public LightTable(final JFrame frame){
		tc= new TComponent(this);
		scroll= new JScrollPane(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		parentFrame=frame;
		viewType=1;
		this.setBackground(Color.RED);
		PhotoView=1;
		BrowserView=2;
		SplitView=3;
	}
	
	public void setNewView(ArrayList listy, int v){
		if (v==1){
			removeAll();
			parentFrame.getContentPane();
			pc=new PComponent(this);
			pc.setImage(((Image) listy.get(0)).getImage());
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
			System.out.println("FUCKME");
			removeAll();
			validate();
//			parentFrame.getContentPane();
			this.setLayout(new GridBagLayout());
			GridBagConstraints c= new GridBagConstraints();
			tc=new TComponent(this);
			pc=new PComponent(this);
			pc.setImage(((Image) listy.get(0)).getImage());
			tc.makeView(listy);
			c.gridx = 0;
			c.gridy = 0;
			this.add(tc,c);
			c.gridx = 2;
			c.gridy = 0;
			this.add(pc,c);
			repaint();
//			parentFrame.getContentPane();
		}
	}

	public Image getTC() {
		System.out.println("lt");
		return tc.getSelected();
	}
}
