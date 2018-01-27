package PhotoEffects;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Options extends JFrame implements ActionListener {
	
	JMenu file,effects;
	JMenuItem open,save,exit;
	JMenuItem sepia, blackAndWhite, grayScale, wave, solarise, xRay, edge, glassEffect, oilPaint, outline, sharpen;
	JMenuItem   redImage, blueImage, greenImage, yellowImage, emboss, invert, negative, mirror;
	JLabel label;
	JPanel panel = new JPanel();
	
	JFileChooser openchooser = new JFileChooser("select your Image");
	String filename = null;
	BufferedImage img;
	
	
	public Options(){
		
		//JFrame mainframe = new JFrame();
		JMenuBar m_bar1 = new JMenuBar();
		label = new JLabel();
		
		panel.add(label, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout());
		add(panel);
		
		file = new JMenu("File");
		effects = new JMenu("Effect");
		m_bar1.add(file);
		m_bar1.add(effects);
		setJMenuBar(m_bar1);
		
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		file.add(open);
		file.add(save);
		file.add(exit);
		
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		sepia = new JMenuItem("Sepia");
		effects.add(sepia);
		sepia.addActionListener(this);
		
		blackAndWhite = new JMenuItem("Black And White");
		effects.add(blackAndWhite);
		blackAndWhite.addActionListener(this);
		
		grayScale = new JMenuItem("GrayScale");
		effects.add(grayScale);
		grayScale.addActionListener(this);
		
		wave = new JMenuItem("Wave");
		effects.add(wave);
		wave.addActionListener(this);
		
		solarise = new JMenuItem("Solarise");
		effects.add(solarise);
		solarise.addActionListener(this);
		
		xRay = new JMenuItem("X-Ray");
		effects.add(xRay);
		xRay.addActionListener(this);
		
		edge = new JMenuItem("Edge");
		effects.add(edge);
		edge.addActionListener(this);
		
		glassEffect = new JMenuItem("GlassEffect");
		effects.add(glassEffect);
		glassEffect.addActionListener(this);
		
		oilPaint = new JMenuItem("Oil Paint");
		effects.add(oilPaint);
		oilPaint.addActionListener(this);
		
		outline = new JMenuItem("Outline");
		effects.add(outline);
		outline.addActionListener(this);
		
		sharpen = new JMenuItem("Sharpen");
		effects.add(sharpen);
		sharpen.addActionListener(this);
		
		redImage = new JMenuItem("RedImage");
		effects.add(redImage);
		redImage.addActionListener(this);
		
		blueImage = new JMenuItem("BlueImage");
		effects.add(blueImage);
		blueImage.addActionListener(this);
		
		greenImage = new JMenuItem("GreenImage");
		effects.add(greenImage);
		greenImage.addActionListener(this);
		
		yellowImage = new JMenuItem("YellowImage");
		effects.add(yellowImage);
		yellowImage.addActionListener(this);
		
		emboss = new JMenuItem("Emboss");
		effects.add(emboss);
		emboss.addActionListener(this);
		
		invert = new JMenuItem("Invert");
		effects.add(invert);
		invert.addActionListener(this);
		
		negative = new JMenuItem("Negative");
		effects.add(negative);
		negative.addActionListener(this);
		
		mirror = new JMenuItem("Mirror");
		effects.add(mirror);
		mirror.addActionListener(this);
		
		
		FileNameExtensionFilter openfilter = new FileNameExtensionFilter("Images", "jpg", "bmp");
		openchooser.setFileFilter(openfilter);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem compare = (JMenuItem) (e.getSource());
		Effects effect = new Effects();
		
		if (compare.getText().compareTo("Open") == 0) {
			setImage();

		} 
		else if (compare.getText().compareTo("Exit") == 0) {
			System.exit(0);

		} 
		else if (compare.getText().compareTo("Sepia") == 0) {
			effect.Sepia(img);
			DisplayImage();
		} 
		else if (compare.getText().compareTo("GrayScale") == 0) {
			effect.GrayScale(img);
			DisplayImage();
		} 
		
	}
	


	// prepare and read image
	private void setImage() {
		// TODO Auto-generated method stub
		int returnVal = openchooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filename = openchooser.getSelectedFile().getAbsolutePath();
			try {
				img = ImageIO.read(new File(filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			DisplayImage();
		} else {
			JOptionPane.showMessageDialog(null, "please select image");
		}
	}



	//display image
	private void DisplayImage() {
		// TODO Auto-generated method stub
		label.setIcon(new ImageIcon(img));
	}


}
