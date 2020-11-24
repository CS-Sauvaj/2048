package fr.hugosimony._2048_;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class Bouton extends JButton{
	private static final long serialVersionUID = 1L;
	
	Game game;
	
	public Bouton(int x, int j, Game game) {
		this.game = game;
		setIcon(game.img0);
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent event) {
				int keyCode = event.getKeyCode();
				Direction direction = null;
				
				if(keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_UP) {
					
					if (keyCode == KeyEvent.VK_LEFT)
						direction = Direction.LEFT;
					else if (keyCode == KeyEvent.VK_RIGHT)
						direction = Direction.RIGHT;
					else if (keyCode == KeyEvent.VK_DOWN)
						direction = Direction.DOWN;
					else if (keyCode == KeyEvent.VK_UP)
						direction = Direction.UP;
					
					game.hasMooved = false;
					mooveTab(direction);
					if(!game.isFull() && game.hasMooved)
						game.randomNumber(false);
					if(game.isFull()) {
						
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// Do nothing
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// Do nothing
			}
			
		});
	}
	
	private void mooveTab(Direction direction) {
		
		if(direction == Direction.LEFT) {
			for(int x = 0; x < 4; x++) {
				for(int y = 0; y < 4; y++) {
					boolean done = false;
					int y_ = y+1;
					while(y_<4 && !done) {
						if(game.tableau_bouton[x][y].getText().equals("") && !(game.tableau_bouton[x][y_].getText().equals(""))) {
							game.tableau_bouton[x][y].setText(game.tableau_bouton[x][y_].getText());
							setImage(x, y, Integer.parseInt(game.tableau_bouton[x][y].getText()));
							game.tableau_bouton[x][y_].setText("");
							setImage(x, y_, 0);
							y--;
							done = true;
							game.hasMooved = true;
						}
						else if(game.tableau_bouton[x][y].getText().equals(game.tableau_bouton[x][y_].getText()) && !(game.tableau_bouton[x][y].getText().equals("")))  {
							updtateScore(x,y);
							game.tableau_bouton[x][y_].setText("");
							setImage(x, y_, 0);
							done = true;
							game.hasMooved = true;
						}
						y_++;
					}
				}
			}
		}else if(direction == Direction.RIGHT) {
			for(int x = 0; x < 4; x++) {
				for(int y = 3; y >= 0; y--) {
					boolean done = false;
					int y_ = y-1;
					while(y_>=0 && !done) {
						if(game.tableau_bouton[x][y].getText().equals("") && !(game.tableau_bouton[x][y_].getText().equals(""))) {
							game.tableau_bouton[x][y].setText(game.tableau_bouton[x][y_].getText());
							setImage(x, y, Integer.parseInt(game.tableau_bouton[x][y].getText()));
							game.tableau_bouton[x][y_].setText("");
							setImage(x, y_, 0);
							y++;
							done = true;
							game.hasMooved = true;
						}
						else if(game.tableau_bouton[x][y].getText().equals(game.tableau_bouton[x][y_].getText()) && !(game.tableau_bouton[x][y].getText().equals("")))  {
							updtateScore(x,y);
							game.tableau_bouton[x][y_].setText("");
							setImage(x, y_, 0);
							done = true;
							game.hasMooved = true;
						}
						y_--;
					}
				}
			}
		}
		else if(direction == Direction.UP) {
			for(int y = 0; y < 4; y++) {
				for(int x = 0; x < 4; x++) {
					boolean done = false;
					int x_ = x+1;
					while(x_<4 && !done) {
						if(game.tableau_bouton[x][y].getText().equals("") && !(game.tableau_bouton[x_][y].getText().equals(""))) {
							game.tableau_bouton[x][y].setText(game.tableau_bouton[x_][y].getText());
							setImage(x, y, Integer.parseInt(game.tableau_bouton[x][y].getText()));
							game.tableau_bouton[x_][y].setText("");
							setImage(x_, y, 0);
							x--;
							done = true;
							game.hasMooved = true;
						}
						else if(game.tableau_bouton[x][y].getText().equals(game.tableau_bouton[x_][y].getText()) && !(game.tableau_bouton[x][y].getText().equals("")))  {
							updtateScore(x,y);
							game.tableau_bouton[x_][y].setText("");
							setImage(x_, y, 0);
							done = true;
							game.hasMooved = true;
						}
						x_++;
					}
				}
			}
		}
		else if(direction == Direction.DOWN) {
			for(int y = 0; y < 4; y++) {
				for(int x = 3; x >= 0; x--) {
					boolean done = false;
					int x_ = x-1;
					while(x_>=0 && !done) {
						if(game.tableau_bouton[x][y].getText().equals("") && !(game.tableau_bouton[x_][y].getText().equals(""))) {
							game.tableau_bouton[x][y].setText(game.tableau_bouton[x_][y].getText());
							setImage(x, y, Integer.parseInt(game.tableau_bouton[x][y].getText()));
							game.tableau_bouton[x_][y].setText("");
							setImage(x_, y, 0);
							x++;
							done = true;
							game.hasMooved = true;
						}
						else if(game.tableau_bouton[x][y].getText().equals(game.tableau_bouton[x_][y].getText()) && !(game.tableau_bouton[x][y].getText().equals("")))  {
							updtateScore(x,y);
							game.tableau_bouton[x_][y].setText("");
							setImage(x_, y, 0);
							done = true;
							game.hasMooved = true;
						}
						x_--;
					}
				}
			}
		}
	}

	private void updtateScore(int x, int y) {
		int value = Integer.parseInt(game.tableau_bouton[x][y].getText());
		game.score+=value*2;
		game.label_score.setText("Score : " + game.score);
		game.tableau_bouton[x][y].setText(Integer.toString(value*2));
		setImage(x, y, value*2);
	}
	
	public void setImage(int x, int y, int value) {
		
		if(value == 2)
			game.tableau_bouton[x][y].setIcon(game.img2);
		else if(value == 4)
			game.tableau_bouton[x][y].setIcon(game.img4);
		else if(value == 8)
			game.tableau_bouton[x][y].setIcon(game.img8);
		else if(value == 16)
			game.tableau_bouton[x][y].setIcon(game.img16);
		else if(value == 32)
			game.tableau_bouton[x][y].setIcon(game.img32);
		else if(value == 64)
			game.tableau_bouton[x][y].setIcon(game.img64);
		else if(value == 128)
			game.tableau_bouton[x][y].setIcon(game.img128);
		else if(value == 256)
			game.tableau_bouton[x][y].setIcon(game.img256);
		else if(value == 512)
			game.tableau_bouton[x][y].setIcon(game.img512);
		else if(value == 1024)
			game.tableau_bouton[x][y].setIcon(game.img1024);
		else if(value == 2048)
			game.tableau_bouton[x][y].setIcon(game.img2048);
		else
			game.tableau_bouton[x][y].setIcon(game.img0);
	}
}
