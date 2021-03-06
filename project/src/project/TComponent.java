package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TComponent extends JLabel implements MouseListener, KeyListener{

	private JPanel parentFrame;
	private JScrollPane scroll;
	private ArrayList<JLabel> buttList;
	public ArrayList<Image> imList;
	public ArrayList<java.awt.Image> imList2;
	private JLabel selected;
	public int selectedIndex;
	private static int i;
	private Dimension dim;
	
	public TComponent(final JPanel frame){
		selected= null;
		parentFrame=frame;
		buttList= new ArrayList();
		imList= new ArrayList();
		selectedIndex=0;
		scroll = new JScrollPane(this);
	    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setViewportView(this);
	    scroll.getViewport().setBackground(Color.LIGHT_GRAY);
	    addMouseListener(this);
	    addKeyListener(this);
//		parentFrame.getRootPane().add(BorderLayout.CENTER, this);
		this.setBackground(Color.BLUE);
		
	}
	// adds all images and makes the grid
	public void makeView(ArrayList<BufferedImage> imList){
		this.imList.addAll(imList);
		int row = (int) Math.floor(imList.size()/3);
		this.setLayout(new GridLayout(row,4,15,15));
//		this.setLayout(new FlowLayout(1,15,15));
		for (int i=0; i<imList.size();i++){
			dim= new Dimension (imList.get(i).getWidth(), imList.get(i).getHeight());
			java.awt.Image t = getThumbnail(new Dimension(100,100), imList.get(i));
			ImageIcon icon= new ImageIcon(t);
			JLabel j = new JLabel(icon);
			buttList.add(j);
			this.add(j);
		}
	}
//makes thumbnails of pics
	public java.awt.Image getThumbnail(Dimension dim, BufferedImage im){
		this.dim=dim;
		return im.getScaledInstance(dim.width, dim.height, BufferedImage.SCALE_SMOOTH);
	}
	
	
	//mark a button as selected
	public void buttonSelected(JLabel selected){
        selected.setBorder(new LineBorder(Color.BLACK, 2));
        System.out.println("in");
	}
	//deselct previous button
	public void buttonDeselect(JLabel b){
		//NEED TO FIND HOW BORDER TO NO COLOR
		b.setBorder(null);
		repaint();
		System.out.println("out");
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//check what was selected and deselect
	public void mouseClicked(MouseEvent e) {
		for (JLabel b:buttList){
			int x1=b.getX();
			int x2=b.getX()+b.getWidth();
			int y1=b.getY();
			int y2=b.getY()+b.getHeight();
			
			if (e.getX()>x1 && e.getX()<x2 && e.getY()>y1 && e.getY()<y2){
				if (selected!=null) buttonDeselect(selected);
				buttonSelected(b);
				selected= b;
			}
			
			selectedIndex= buttList.indexOf(b);
		}
		
		System.out.println(e.getXOnScreen()+ "," + e.getYOnScreen());
	}
	
	public void print(Object a){
		System.out.print(a);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("hi");
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public int getSIndex(){
		return selectedIndex;
	}
	
	public Image getSelected() {
		System.out.println(imList.size());
		System.out.println(imList.get(buttList.indexOf(selected)));
		return imList.get(buttList.indexOf(selected));
	}
	
//	public java.awt.Image getSelected2() {
//		return ((java.awt.Image)imList.get(buttList.indexOf(selected)));
//	}
	
	
	/*public void addListeners(){

		for (int j=i; i<buttList.size(); i++){
			System.out.println(buttList);
			buttList.get(i).addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	if (selected != i){
			    		buttList.get(selected).setSelected(false);
			    		selected(buttList.get(selected));
			    		System.out.println(i);
//			    		buttList.get(i).setSelected(true);
//			    		selected(buttList.get(i));
			    	}
			    }
			});
		}
	}
	

*/
	
}



//public class thumby {
//
//	private BufferedImage im;
//	private Dimension dim;
//	
//	public thumby(BufferedImage im){
//		this.im=im;
//		dim= new Dimension (im.getWidth(), im.getHeight());
//	}
//
//	public BufferedImage getImage() {
//		return im;
//	}
//	
//	
//	public java.awt.Image getThumbnail(Dimension dim){
//		this.dim=dim;
//		return im.getScaledInstance(dim.width, dim.height, BufferedImage.SCALE_SMOOTH);
//	}
//	
//	public Dimension getDimension(){
//		return dim;
//	}
//	
//	public BufferedImage giveMeBI(Image i){
//		
//		im= i;
//		return im;
//	}
//}
