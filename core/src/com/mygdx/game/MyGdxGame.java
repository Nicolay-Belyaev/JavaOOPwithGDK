package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import main.main;
import main.main.*;
import classes.BaseHero;

import java.util.HashMap;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture warlockPic, sharpsooterPic, roguePic, monkPic, xbowmanPic, lancerPic, peasantPic;
	HashMap<String, Texture> mapClassTexture = new HashMap<>();
	Texture currentTexture;
	int lightsideCurrentCoordY = 0;
	int darksideCurrentCoordY = 28;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("battleground.jpg");


		warlockPic = new Texture("warlock.png");
		sharpsooterPic = new Texture("warlock.png");
		roguePic = new Texture("warlock.png");
		monkPic = new Texture("warlock.png");
		xbowmanPic = new Texture("warlock.png");
		lancerPic = new Texture("warlock.png");
		peasantPic = new Texture("warlock.png");


		mapClassTexture.put("warlock", warlockPic);
		mapClassTexture.put("sharpshooter", sharpsooterPic);
		mapClassTexture.put("rogue", roguePic);
		mapClassTexture.put("monk", monkPic);
		mapClassTexture.put("xbowman", xbowmanPic);
		mapClassTexture.put("lancer", lancerPic);
		mapClassTexture.put("peasant", peasantPic);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		for (BaseHero character : main.darkside) {
			currentTexture = mapClassTexture.get(character.getClassName());
			batch.draw(currentTexture, 1, darksideCurrentCoordY);
			darksideCurrentCoordY += 100;
		}
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
