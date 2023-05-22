package Maps;

import Chambers.*;
import Game.Game;

public class MapGenerator {

    Game game;

    WinChamber win;
    DiedChamber died;
    FoodFountainChamber food;
    FightChamber fight;
    DungeonChamber dungeon;
    EmptyRoom empty;
    LeftRight leftRight;
    CheckStats checkStats;  //one exit road
    BreakTime breakTime; // one exit road
    ChestCheck chestCheck; //one exit road
    HealthChamber healthChamber;
    MonsterChamber monsterChamber;
    TraderChamber traderChamber;
    TrapChamber trapChamber;  //one exit road
    ChestAfterOpen chestAfterOpen;  // one exit road
    Boss boss;

    Chamber[][] maps = new Chamber[5][20];

    public MapGenerator(Game game){
        WinChamber win = new WinChamber(game);
        DiedChamber died = new DiedChamber(game);
        FoodFountainChamber food = new FoodFountainChamber(game);
        FightChamber fight = new FightChamber(game);
        DungeonChamber dungeon = new DungeonChamber(game);
        EmptyRoom empty = new EmptyRoom(game);
        LeftRight leftRight = new LeftRight(game);
        CheckStats checkStats = new CheckStats(game); //one exit road
        BreakTime breakTime = new BreakTime(game); // one exit road
        ChestCheck chestCheck = new ChestCheck(game); //one exit road
        HealthChamber healthChamber = new HealthChamber(game);
        MonsterChamber monsterChamber = new MonsterChamber(game);
        TraderChamber traderChamber = new TraderChamber(game);
        TrapChamber trapChamber = new TrapChamber(game); //one exit road
        ChestAfterOpen chestAfterOpen = new ChestAfterOpen(game); // one exit road
        Boss boss = new Boss(game);
    }

    public void prepareMap(){
        // short example of first map
        maps[0][0] = monsterChamber;
        maps[0][1] = food;
        maps[0][2] = traderChamber;
        maps[0][3] = empty;

        maps[0][0].option1 = maps[0][1];
        maps[0][0].option2 = maps[0][2];
        /*
        and for rest the same
         */

        // second map :
        maps[1][0] = food;
        /*
        and so on...
         */
    }



}

