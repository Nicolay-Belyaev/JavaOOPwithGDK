package utils;

import classes.BaseHero;

public class Turn {
    public static void Turn() {

        //region melee
        for (BaseHero character : Sides.darkside
                .getHeroesByClass("Rogue")
                .getAliveHeroes()) {
            character.step(Sides.lightside);
        }
        for (BaseHero character : Sides.lightside
                .getHeroesByClass("Lancer")
                .getAliveHeroes()) {
            character.step(Sides.darkside);
        }
        //endregion

        //region RDD
        for (BaseHero character : Sides.darkside
                .getHeroesByClass("Sharpshooter")
                .getAliveHeroes()) {
            character.step(Sides.lightside);
        }
        for (BaseHero character : Sides.lightside
                .getHeroesByClass("Xbowman")
                .getAliveHeroes()) {
            character.step(Sides.darkside);
        }
        //endregion

        //region Support
        for (BaseHero character : Sides.darkside
                .getHeroesByClass("Warlock")
                .getAliveHeroes()) {
            character.step(Sides.lightside);
        }
        for (BaseHero character : Sides.lightside
                .getHeroesByClass("Monk")
                .getAliveHeroes()) {
            character.step(Sides.darkside);
        }
        //endregion

        //region Peasants
        for (BaseHero character : Sides.darkside
                .getHeroesByClass("Peasant")
                .getAliveHeroes()) {
            character.step(Sides.lightside);
        }

        for (BaseHero character : Sides.lightside
                .getHeroesByClass("Peasant")
                .getAliveHeroes()) {
            character.step(Sides.darkside);
        }
        //endregion


    }
}
