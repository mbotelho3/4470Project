package project;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Image {

	private BufferedImage im;
	private Dimension dim;
	
	public Image(BufferedImage im){
		this.im=im;
		dim= new Dimension (im.getWidth(), im.getHeight());
	}

	public BufferedImage getImage() {
		return im;
	}
	
	
	public java.awt.Image getThumbnail(Dimension dim){
		this.dim=dim;
		return im.getScaledInstance(dim.width, dim.height, BufferedImage.SCALE_SMOOTH);
	}
	
	public Dimension getDimension(){
		return dim;
	}
}
