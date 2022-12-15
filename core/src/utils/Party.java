package utils;

import classes.*;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Party extends ArrayList<BaseHero> {
    private final float zeroCoordY = 400;
    private final int shiftCoordY = 100;
    public Party() {}

    public Party(Party party1, Party party2) {
        this.addAll(party1);
        this.addAll(party2);
    }
    @Override
    public String toString() {
        StringBuilder resString = new StringBuilder();
        for (BaseHero character : this) {
            resString.append(character.getInfo())
                    .append("\n");
        }
        return resString.toString();
    }

    public Party getAliveHeroes() {
        Party aliveHeroes = new Party();
        for (BaseHero character : this) {
            if (!character.getStatus().equals("dead")) {
                aliveHeroes.add(character);
            }
        }
        return aliveHeroes;
    }

    public Party getDeadHeroes() {
        Party deadHeroes = new Party();
        for (BaseHero character : this) {
            if (character.getStatus().equals("dead")) {
                deadHeroes.add(character);
            }
        }
        return deadHeroes;
    }

    public Party getHeroesByClass(String heroClass) {
        Party oneClassHeroes = new Party();
        for (BaseHero character : this) {
            if (character.getClassName().equals(heroClass)) {
                oneClassHeroes.add(character);
            }
        }
        return oneClassHeroes;
    }

    public int getClassInitialHp(String heroClass) {
        int initialClassHp = 0;
        for (BaseHero character : this) {
            if (character.getClassName().equals(heroClass)) {
                initialClassHp += character.getInitialStackHp();
            }
        }
        return initialClassHp;
    }

    public int getClassCurrentHp(String heroClass) {
        int currentClassHp = 0;
        for (BaseHero character : this) {
            if (character.getClassName().equals(heroClass)) {
                currentClassHp += character.getCurrentStackHp();
            }
        }
        return currentClassHp;
    }

    //region методы для добавления персонажей в группу
    public void addPeasant(int peasants, int amount) {
        for (int i = 0; i < peasants; i++) {
            float x = (this == Sides.darkside) ? 1 : Gdx.graphics.getWidth() - 83;
            float y = (this.size() == 0) ? zeroCoordY : (this.get(this.size() - 1).getCoords().getY() - shiftCoordY);
            this.add(new Peasant(this, x, y, amount));
        }
    }
    public void addRogue(int rogues, int amount) {
        for (int i = 0; i < rogues; i++) {
            float x = (this == Sides.darkside) ? 1 : Gdx.graphics.getWidth() - 83;
            float y = (this.size() == 0) ? zeroCoordY : (this.get(this.size() - 1).getCoords().getY() - shiftCoordY);
            this.add(new Rogue(this, x, y, amount));
        }
    }
    public void addSharpshooter(int sharpshooters, int amount) {
        for (int i = 0; i < sharpshooters; i++) {
            float x = (this == Sides.darkside)? 1 : Gdx.graphics.getWidth() - 83;;
            float y = (this.size() == 0) ? zeroCoordY : (this.get(this.size() - 1).getCoords().getY() - shiftCoordY);
            this.add(new Sharpshooter(this, x, y, amount));
        }
    }
    public void addWarlock(int warlocks, int amount) {
        for (int i = 0; i < warlocks; i++) {
            float x = (this == Sides.darkside) ? 1 : Gdx.graphics.getWidth() - 83;
            float y = (this.size() == 0) ? zeroCoordY : (this.get(this.size() - 1).getCoords().getY() - shiftCoordY);
            this.add(new Warlock(this, x, y, amount));
        }
    }
    public void addMonk(int monks, int amount) {
        for (int i = 0; i < monks; i++) {
            float x = (this == Sides.darkside) ? 1 : Gdx.graphics.getWidth() - 83;
            float y = (this.size() == 0) ? zeroCoordY : (this.get(this.size() - 1).getCoords().getY() - shiftCoordY);
            this.add(new Monk(this, x, y, amount));
        }
    }
    public void addLancer(int lancer, int amount) {
        for (int i = 0; i < lancer; i++) {
            float x = (this == Sides.darkside) ? 1 : Gdx.graphics.getWidth() - 83;
            float y = (this.size() == 0) ? zeroCoordY : (this.get(this.size() - 1).getCoords().getY() - shiftCoordY);
            this.add(new Lancer(this, x, y, amount));
        }
    }
    public void addCrossbownman(int crossbownmans, int amount) {
        for (int i = 0; i < crossbownmans; i++) {
            float x = (this == Sides.darkside) ? 1 : Gdx.graphics.getWidth() - 83;
            float y = (this.size() == 0) ? zeroCoordY : (this.get(this.size() - 1).getCoords().getY() - shiftCoordY);
            this.add(new Xbowman(this, x, y, amount));
        }
    }

    //endregion
}
