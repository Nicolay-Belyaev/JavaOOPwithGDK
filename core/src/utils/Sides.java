package utils;

public class Sides {
    public static Party darkside = new Party();
    public static Party lightside = new Party();

    public static void sidesGenerator() {
        darkside.addWarlock(1,1);
        darkside.addSharpshooter(1,1);
        darkside.addRogue(1, 1);
        darkside.addPeasant(1,1);

        lightside.addMonk(1,1);
        lightside.addCrossbownman(1,1);
        lightside.addLancer(1, 1);
    }

}



