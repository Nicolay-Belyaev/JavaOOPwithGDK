package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import utils.Sides;
import classes.*;

import java.util.HashMap;

/*
Что сейчас плохо:
0. Это просто базовый драфт. Игровой логики нет, программа пока просто рисует текстурки в зависимости от составов команд.
1. Текстуры лайтсайдов сделаны отраженными. Надо сделать так, что бы все текстуры были ориентированы в одну сторону и
зеркалить их по Y для другой стороны на рендере.

Что хорошо бы сделать:
0. Собственно, ходы.
1. Анимации. У меня есть картинки с набором текстурами, но я пока не знаю, как их них сделать атласы.
2. Перемещения и атака. Придется немного подрихтовать логику расчета направления движения и поиграть со сдвигом +
установить "дальность" атаки ближнего боя. Схожая ситуация с дальнобойными атаками, штраф надо переделать.
 */

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture warlockPic, sharpshooterPic, roguePic, peasantPic, monkPic, xbowmanPic, lancerPic;
	HashMap<String, Texture> mapClassTexture;


	@Override
	public void create () {
		Sides.sidesGenerator();
		batch = new SpriteBatch();
		img = new Texture("battleground.jpg");
		warlockPic = new Texture("Warlock.png");
		sharpshooterPic = new Texture("Sharpshooter.png");
		roguePic = new Texture("Rogue.png");

		peasantPic = new Texture("Peasant.png");

		monkPic = new Texture("Monk.png");
		xbowmanPic = new Texture("Xbowman.png");
		lancerPic = new Texture("Lancer.png");

		mapClassTexture = new HashMap<>();
		mapClassTexture.put("Warlock", warlockPic);
		mapClassTexture.put("Sharpshooter", sharpshooterPic);
		mapClassTexture.put("Rogue", roguePic);
		mapClassTexture.put("Peasant", peasantPic);
		mapClassTexture.put("Monk", monkPic);
		mapClassTexture.put("Xbowman", xbowmanPic);
		mapClassTexture.put("Lancer", lancerPic);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		for (BaseHero character : Sides.darkside.getAliveHeroes()) {
			batch.draw(mapClassTexture.get(character.getClassName()),
					   character.getCoords().getX(),
					   character.getCoords().getY());
		}
		for (BaseHero character : Sides.lightside.getAliveHeroes()) {
			batch.draw(mapClassTexture.get(character.getClassName()),
					   character.getCoords().getX(),
					   character.getCoords().getY());
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
