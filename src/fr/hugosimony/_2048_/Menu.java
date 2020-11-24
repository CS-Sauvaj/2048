package fr.hugosimony._2048_;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public Menu() {

		setTitle("2048 [Menu]");
	    setSize(500, 300);
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
	    panel.setLayout(new GridLayout(2, 1));
	    
	    Font font_play = new Font("Arial", 1, 50);
	    Font font_ia = new Font("Arial", 1, 30);
	    
	    JButton play = new JButton("Jouer");
	    play.setFont(font_play);
	    play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Game game = new Game(false);
				game.setVisible(true);
			}
		});
	    
	    JButton ia = new JButton("Laisser jouer l'IA");
	    ia.setFont(font_ia);
	    ia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Game game = new Game(true);
				game.setVisible(true);
			}
		});
	    
	    panel.add(play);
	    panel.add(ia);
	    
	    add(panel);
	}
}
