package de.flaxxy.pokegame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	public GameFrame(String title)
	{
		super(title);
		setVisible(true);
		setIgnoreRepaint(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setPreferredSize(new Dimension(800,600));
		pack();
		setResizable(false);
		createBufferStrategy(2);
	}
	
}
