package de.flaxxy.pokegame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
	public static final long fixedTime=10;
	public static final int tileHeight=10, tileWidth=10;
	GameFrame window;
	boolean isRunning;
	ArrayList<Entity> entityList;
	public static void main(String[] args) {
		new Main();
	}
	public Main()
	{
		
		init();
		gameLoop();
	}
	private void init()
	{
		isRunning=true;
		window=new GameFrame("PokeGame");
		entityList=new ArrayList<>();
		Entity ent=new Entity();
		ent.x=8;
		ent.y=6;
		entityList.add(ent);
	}
	private void gameLoop()
	{
		long lastTime=System.currentTimeMillis(), delta=0;
		while(isRunning)
		{
			
			//System.out.println(delta);
			update(delta/1000f);
			Graphics2D g2d=(Graphics2D)(window.getBufferStrategy().getDrawGraphics());
			g2d.fillRect(0, 0, window.getWidth(), window.getHeight());
			paint(g2d);
			g2d.dispose();
			window.getBufferStrategy().show();
			delta=System.currentTimeMillis()-lastTime;
			lastTime=System.currentTimeMillis();
			try {
				if(delta<fixedTime)
				Thread.sleep(fixedTime-delta);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//@param delta time in sec
	private void update(float delta)
	{
		for(Entity ent : entityList)
		{
			ent.move(Direction.EAST);
			ent.update(delta);
		}
	}
	private void paint(Graphics2D g)
	{
		for(Entity ent : entityList)
		{
			ent.paint(g);
		}
		
	}
}
