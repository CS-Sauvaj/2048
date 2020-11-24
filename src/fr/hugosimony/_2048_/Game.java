package fr.hugosimony._2048_;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame{
	private static final long serialVersionUID = 1L;

	public Bouton[][] tableau_bouton; 
	
	public int score = 0;
	public JLabel label_score = new JLabel();
	
	public boolean hasMooved = false;
	
	//***********************************************************************************************************
	// Images :
	
	public final URL img0_url = Game.class.getResource("images/0.PNG");
	public final ImageIcon img0 = new ImageIcon(img0_url);
	public final URL img2_url = Game.class.getResource("images/2.PNG");
	public final ImageIcon img2 = new ImageIcon(img2_url);
	public final URL img4_url = Game.class.getResource("images/4.PNG");
	public final ImageIcon img4 = new ImageIcon(img4_url);
	public final URL img8_url = Game.class.getResource("images/8.PNG");
	public final ImageIcon img8 = new ImageIcon(img8_url);
	public final URL img16_url = Game.class.getResource("images/16.PNG");
	public final ImageIcon img16 = new ImageIcon(img16_url);
	public final URL img32_url = Game.class.getResource("images/32.PNG");
	public final ImageIcon img32 = new ImageIcon(img32_url);
	public final URL img64_url = Game.class.getResource("images/64.PNG");
	public final ImageIcon img64 = new ImageIcon(img64_url);
	public final URL img128_url = Game.class.getResource("images/128.PNG");
	public final ImageIcon img128 = new ImageIcon(img128_url);
	public final URL img256_url = Game.class.getResource("images/256.PNG");
	public final ImageIcon img256 = new ImageIcon(img256_url);
	public final URL img512_url = Game.class.getResource("images/512.PNG");
	public final ImageIcon img512 = new ImageIcon(img512_url);
	public final URL img1024_url = Game.class.getResource("images/1024.PNG");
	public final ImageIcon img1024 = new ImageIcon(img1024_url);
	public final URL img2048_url = Game.class.getResource("images/2048.PNG");
	public final ImageIcon img2048 = new ImageIcon(img2048_url);
	
	//***********************************************************************************************************
	
	boolean ia_on;
	
	public Game(boolean ia_on) {
		
		this.ia_on = ia_on;
		
		setTitle("2048 [IA Off] - Made by Hugo Simony-Jungo");
		if(ia_on)
			setTitle("2048 [IA On] - Made by Hugo Simony-Jungo");
	    setSize(420, 500);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    addWindowListener(new WindowAdapter() {
	    	@Override
	    	public void windowClosed(WindowEvent e) {
	    		System.exit(0);
	    	}
		});
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());
	    
	    label_score = new JLabel();
	    Font font_score = new Font("Arial", 1, 40);
	    
	    label_score.setText("Score : " + score);
	    label_score.setFont(font_score);
	    label_score.setHorizontalAlignment(0);
	    label_score.setVerticalAlignment(0);
	    
	    panel.add("North", label_score);
	    
	    JPanel panel_game = new JPanel();
	    
	    panel_game.setLayout(new GridLayout(4, 4));
	    
	    tableau_bouton = new Bouton[4][4];
	    
	    for (int i = 0; i < 4; i++) {
	    	for (int j = 0; j < 4; j++) {
	    		Bouton bouton = new Bouton(i, j, this);
		        panel_game.add(bouton);
		        tableau_bouton[i][j] = bouton;
	    	}
	    }
	    
	    randomNumber(true);
	    
	    panel.add("Center", panel_game);
	    
	    add(panel);
	}
	
	public void randomNumber(boolean first_placement) {
		int random_x;
		int random_y;
		int random;
		if(first_placement) {
			random_x = (int) (Math.random() * 4);
			random_y = (int) (Math.random() * 4);
			tableau_bouton[random_x][random_y].setText("2");
			tableau_bouton[0][0].setImage(random_x, random_y, 2);
		}
		boolean placed = false;
		while(!placed) {
			random_x = (int) (Math.random() * 4);
			random_y = (int) (Math.random() * 4);
			if(tableau_bouton[random_x][random_y].getText().equals("")) {
				random = (int) (Math.random() * 4);
				if(random == 0) {
					random = 4;
					tableau_bouton[0][0].setImage(random_x, random_y, 4);
				}else {
					random = 2;
					tableau_bouton[0][0].setImage(random_x, random_y, 2);
				}
				tableau_bouton[random_x][random_y].setText(Integer.toString(random));
				placed = true;
			}
		}
	}
	
	public boolean isFull() {
		boolean full = true;
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				if(tableau_bouton[x][y].getText() == "")
					full = false;
			}
		}
		return full;
	}
	
}
