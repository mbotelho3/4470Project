package project;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;


public class menu extends JMenuBar {
	
	public TComponent tc;
	private JFrame parentFrame;
	private PhotoView defaultPanel;
	private ButtonGroup bgroup;
	private JMenu fileop;
//	private ButtonGroup bgroup2;
//	private ButtonGroup bgroup3;
//	private JMenu drawop;
	private File[] myFilesDude;
	private JMenuItem importp;
//	private JMenuItem lineCol;
//	private JMenuItem lineW;
	private BufferedImage a;
	private JMenuItem delete;
	private JMenuItem exit;
	private JMenu viewop;
	private JRadioButtonMenuItem photoView;
//	private JRadioButtonMenuItem colblack;
//	private JRadioButtonMenuItem colred;
//	private JRadioButtonMenuItem colblue;
	private JRadioButtonMenuItem browser;
	private JRadioButtonMenuItem split;
	private BufferedImage buffImg;
	private ArrayList listy;
	public Statbar statbar;
	public int view;

	public menu(final JFrame frame, final Statbar sbar){
		statbar=sbar;
		view=1;
		parentFrame = frame;
		fileop= new JMenu("File");
		importp = new JMenuItem("Import Photo");
		delete = new JMenuItem("Delete Selected Photos");
		exit =new JMenuItem("Exit Program");
		
		listy= new ArrayList();
		
		fileop.add(importp);
		fileop.add(delete);
		fileop.add(exit);
		
		add(fileop);
	
		viewop = new JMenu("View");
		bgroup= new ButtonGroup();

		photoView = new JRadioButtonMenuItem("Photo Viewer");
		photoView.setSelected(true);
		defaultPanel= new PhotoView();
		
//		drawop= new JMenu("Draw Tools");
//		bgroup2= new ButtonGroup();
//		lineCol= new JMenuItem("Line Color");
//		lineW= new JMenuItem("Line Weight");
//		colblack = new JRadioButtonMenuItem("Black");
//		colred = new JRadioButtonMenuItem("Red");
//		colblue = new JRadioButtonMenuItem("Blue");
//		colblack.setSelected(true);
//		
	//	bgroup2.add(lineCol);
		//bgroup2.add(lineW);
	
		
		
		frame.getContentPane().add(defaultPanel);
		browser=new JRadioButtonMenuItem("Browser");
		split = new JRadioButtonMenuItem("Split Mode");
		
		bgroup.add(photoView);
		bgroup.add(browser);
		bgroup.add(split);
		
		viewop.add(photoView);
		viewop.add(browser);
		viewop.add(split);
		
		add(viewop);
		
		importp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				statbar.setText("Import has been selected");
				JFileChooser choose= new JFileChooser();
				choose.setMultiSelectionEnabled(true);
				int opt= choose.showOpenDialog(frame);
				if (opt == JFileChooser.APPROVE_OPTION){
					myFilesDude = choose.getSelectedFiles();
					
				}
					try {
						for (File f:myFilesDude){
							a= ImageIO.read(f);
							BufferedImage img = a;
							listy.add(img);
						}
						((Driver)parentFrame).setImage(listy, view);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
				} 					
			}
		});
		
		exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		});
		
		delete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        statbar.setText("Delete was selected");
		        Image i= ((Driver)parentFrame).getTC();
		        System.out.println("m");
		        listy.remove(listy.indexOf(i));  
		        ((Driver)parentFrame).setImage(listy, view);
		    }
		});
		
		photoView.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	statbar.setText("Photo Viewer was selected");
		    	defaultPanel.setVisible(true);
		    	view=1;
		    	((Driver)parentFrame).setImage(listy, view);
//		    	listy.removeAll(listy);
		      }
		});
		
		browser.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	statbar.setText("Browser was selected");
		    	view=2;
		    	((Driver)parentFrame).setImage(listy, view);
//		    	listy.removeAll(listy);
		      }
		});
		
		split.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	statbar.setText("Split Mode was selected");
		    	view=3;
		    	((Driver)parentFrame).setImage(listy, view);
//		    	listy.removeAll(listy);
		      }
		});
	
	}
	
	public Statbar getStatBar(){
		return statbar;
	}
	
	public File[] getFile(){
		return myFilesDude;
	}


}