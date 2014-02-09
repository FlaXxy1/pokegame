package de.flaxxy.pokegame;

import java.awt.Color;
import java.awt.Graphics;

public class Entity {
	public int x,y;
	public float progress;
	public float speed;
	public Direction dir;
	public boolean moving;
	public Entity()
	{
		moving=false;
		progress=0;
		dir=Direction.SOUTH;
		speed=2;
	}
	public void update(float delta)
	{
		System.out.println(x+" "+y);
		if(moving)
		{
			progress=Math.min(1, progress+speed*delta);
		}
		if(progress==1)
		{
			progress=0;
			moving=false;
			switch(dir)
			{
			case NORTH:
				y--;
				break;
			case SOUTH:
				y++;
				break;
			case WEST:
				x--;
				break;
			case EAST:
				x++;
			}
		}
	}
	public boolean move(Direction newDir)
	{
		if(moving)
			return false;
		dir=newDir;
		progress=0;
		moving=true;
		return true;
	}
	public final void paint(Graphics g)
	{
		switch(dir)
		{
		case NORTH:
			draw(g,x*Main.tileWidth,(y-progress)*Main.tileHeight);
			break;
		case SOUTH:
			draw(g,x*Main.tileWidth,(y+progress)*Main.tileHeight);
			break;
		case WEST:
			draw(g,(x-progress)*Main.tileWidth,y*Main.tileHeight);
			break;
		case EAST:
			draw(g,(x+progress)*Main.tileWidth,y*Main.tileHeight);
		}
	}
	private void draw(Graphics g, float x, float y)
	{
		g.setColor(Color.magenta);
		g.drawRect((int)x, (int)y, 10, 10);
	}
}
