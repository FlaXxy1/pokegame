package de.flaxxy.lwjgltest;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {

	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			
			e.printStackTrace();
		}
		while(!Display.isCloseRequested()){
			Display.update();
		}
		Display.destroy();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
}
