package Maps;

import Chambers.*;
import Game.Game;

public class MapGenerator {

    Game game;

    WinChamber win; // no exit, please do not set option1 and option2
    DiedChamber died; // no exit, please do not set option1 and option2
    FoodFountainChamber food; // one exit
    LeftRight leftRight;
    MonsterChamber monsterChamber; // one exit
    TraderChamber traderChamber; // one exit
    Boss boss; // no exit, please do not set option1 and option2
    EmptyRoom empty;   /// one exit
    TrapChamber trapChamber;  //one exit
    ChestAfterOpen chestAfterOpen;  // one exit

    Chamber[][] maps = new Chamber[5][20];

    public MapGenerator(Game game){
        game = game;
         win = new WinChamber(game);
         died = new DiedChamber(game);
         food = new FoodFountainChamber(game);
         empty = new EmptyRoom(game);
         leftRight = new LeftRight(game);
         monsterChamber = new MonsterChamber(game);
         traderChamber = new TraderChamber(game);
         trapChamber = new TrapChamber(game);
         chestAfterOpen = new ChestAfterOpen(game);
         boss = new Boss(game);
    }

    public Chamber getMap( int version ){
        return maps[version][0];
    }

    public void prepareMap(){
        // first map:
        maps[0][0] = food;
        maps[0][1] = monsterChamber;
        maps[0][2] = chestAfterOpen;
        maps[0][3] = leftRight;
        maps[0][4] = empty;
        maps[0][5] = trapChamber;
        maps[0][6] = traderChamber;
        maps[0][7] = boss;

        maps[0][0].option1 = maps[0][1];
        maps[0][0].option1 = maps[0][2];
        maps[0][2].option1 = maps[0][4];
        maps[0][3].option1 = maps[0][2];
        maps[0][4].option1 = maps[0][5];
        maps[0][4].option2 = maps[0][6];
        maps[0][5].option1 = maps[0][6];
        maps[0][6].option1 = maps[0][7];

        /*
        // second map :
        maps[1][1] = trapChamber;
        maps[1][0] = chestAfterOpen;
        maps[1][2] = food;
        maps[1][3] = empty;
        maps[1][4] = food;
        maps[1][5] = monsterChamber;
        maps[1][6] = chestAfterOpen;
        maps[1][7] = monsterChamber;
        maps[1][8] = trapChamber;
        maps[1][9] = food;
        maps[1][10] = chestAfterOpen;
        maps[1][11] = empty;
        maps[1][12] = traderChamber;
        maps[1][13] = chestAfterOpen;
        maps[1][14] = food;
        maps[1][15] = monsterChamber;
        maps[1][16] = monsterChamber;
        maps[1][18] = food;
        maps[1][19] = boss;

        maps[1][0].option1 = maps[1][1];
        maps[1][0].option2 = maps[1][2];
        maps[1][1].option1 = maps[1][2];
        maps[1][1].option2 = maps[1][3];
        maps[1][2].option1 = maps[1][1];
        maps[1][2].option2 = maps[1][3];
        maps[1][3].option1 = maps[1][2];
        maps[1][3].option2 = maps[1][4];
        maps[1][4].option2 = maps[1][5];
        maps[1][5].option1 = maps[1][7];
        maps[1][5].option2 = maps[1][6];
        maps[1][6].option1 = maps[1][7];
        maps[1][6].option2 = maps[1][8];
        maps[1][7].option1 = maps[1][6];
        maps[1][7].option2 = maps[1][9];
        maps[1][8].option1 = maps[1][9];
        maps[1][9].option1 = maps[1][8];
        maps[1][9].option2 = maps[1][10];
        maps[1][10].option1 = maps[1][11];
        maps[1][10].option2 = maps[1][12];
        maps[1][11].option1 = maps[1][12];
        maps[1][12].option1 = maps[1][17];
        maps[1][12].option2 = maps[1][13];
        maps[1][13].option1 = maps[1][14];
        maps[1][14].option1 = maps[1][16];
        maps[1][14].option2 = maps[1][15];
        maps[1][15].option1 = maps[1][16];
        maps[1][15].option2 = maps[1][17];
        maps[1][16].option1 = maps[1][17];
        maps[1][17].option1 = maps[1][18];
        maps[1][17].option2 = maps[1][19];
        maps[1][18].option1 = maps[1][19];
        maps[1][19].option1 = maps[1][19];

        // third map :
        maps[2][0] = chestAfterOpen;
        maps[2][1] = food;
        maps[2][2] = chestAfterOpen;
        maps[2][3] = empty;
        maps[2][4] = food;
        maps[2][5] = monsterChamber;
        maps[2][6] = monsterChamber;
        maps[2][8] = trapChamber;
        maps[2][9] = monsterChamber;
        maps[2][10] = chestAfterOpen;
        maps[2][11] = traderChamber;
        maps[2][12] = monsterChamber;
        maps[2][14] = food;
        maps[2][15] = empty;
        maps[2][16] = chestAfterOpen;
        maps[2][18] = trapChamber;
        maps[2][19] = boss;

        maps[2][0].option1 = maps[2][1];
        maps[2][0].option2 = maps[2][2];
        maps[2][1].option1 = maps[2][3];
        maps[2][1].option2 = maps[2][2];
        maps[2][2].option1 = maps[2][3];
        maps[2][2].option2 = maps[2][5];
        maps[2][3].option1 = maps[2][7];
        maps[2][3].option2 = maps[2][4];
        maps[2][4].option1 = maps[2][5];
        maps[2][4].option2 = maps[2][6];
        maps[2][5].option1 = maps[2][6];
        maps[2][5].option2 = maps[2][8];
        maps[2][6].option1 = maps[2][1];
        maps[2][6].option2 = maps[2][2];
        maps[2][7].option1 = maps[2][9];
        maps[2][8].option1 = maps[2][5];
        maps[2][9].option1 = maps[2][10];
        maps[2][9].option2 = maps[2][12];
        maps[2][10].option1 = maps[2][11];
        maps[2][11].option1 = maps[2][12];
        maps[2][11].option2 = maps[2][14];
        maps[2][12].option1 = maps[2][13];
        maps[2][13].option1 = maps[2][14];
        maps[2][13].option2 = maps[2][15];
        maps[2][14].option1 = maps[2][15];
        maps[2][14].option2 = maps[2][16];
        maps[2][15].option1 = maps[2][16];
        maps[2][16].option1 = maps[2][17];
        maps[2][16].option2 = maps[2][18];
        maps[2][17].option1 = maps[2][19];
        maps[2][18].option1 = maps[2][19];
        maps[2][19].option1 = maps[2][19];

        // fourth map :
        maps[3][0] = monsterChamber;
        maps[3][1] = food;
        maps[3][2] = monsterChamber;
        maps[3][3] = empty;
        maps[3][4] = monsterChamber;
        maps[3][5] = chestAfterOpen;
        maps[3][6] = monsterChamber;
        maps[3][7] = monsterChamber;
        maps[3][8] = trapChamber;
        maps[3][9] = food;
        maps[3][10] = monsterChamber;
        maps[3][11] = monsterChamber;
        maps[3][12] = traderChamber;
        maps[3][13] = empty;
        maps[3][14] = food;
        maps[3][15] = chestAfterOpen;
        maps[3][16] = monsterChamber;
        maps[3][18] = trapChamber;
        maps[3][19] = boss;

        maps[3][0].option1 = maps[3][1];
        maps[3][0].option2 = maps[3][2];
        maps[3][1].option1 = maps[3][3];
        maps[3][1].option2 = maps[3][2];
        maps[3][2].option1 = maps[3][5];
        maps[3][2].option2 = maps[3][4];
        maps[3][3].option1 = maps[3][4];
        maps[3][4].option1 = maps[3][5];
        maps[3][4].option2 = maps[3][6];
        maps[3][5].option1 = maps[3][6];
        maps[3][5].option2 = maps[3][8];
        maps[3][6].option1 = maps[3][7];
        maps[3][7].option1 = maps[3][9];
        maps[3][8].option1 = maps[3][9];
        maps[3][9].option1 = maps[3][12];
        maps[3][9].option2 = maps[3][10];
        maps[3][10].option1 = maps[3][11];
        maps[3][11].option1 = maps[3][12];
        maps[3][11].option2 = maps[3][13];
        maps[3][12].option1 = maps[3][14];
        maps[3][12].option2 = maps[3][13];
        maps[3][13].option1 = maps[3][14];
        maps[3][13].option2 = maps[3][15];
        maps[3][14].option1 = maps[3][15];
        maps[3][14].option2 = maps[3][16];
        maps[3][15].option1 = maps[3][16];
        maps[3][15].option2 = maps[3][17];
        maps[3][16].option1 = maps[3][17];
        maps[3][17].option1 = maps[3][19];
        maps[3][17].option2 = maps[3][18];
        maps[3][18].option1 = maps[3][19];
        maps[3][19].option1 = maps[3][19];

        // fifth map :
        maps[4][0] = monsterChamber;
        maps[4][1] = monsterChamber;
        maps[4][2] = monsterChamber;
        maps[4][3] = food;
        maps[4][4] = monsterChamber;
        maps[4][5] = monsterChamber;
        maps[4][6] = chestAfterOpen;
        maps[4][7] = traderChamber;
        maps[4][8] = trapChamber;
        maps[4][9] = monsterChamber;
        maps[4][10] = monsterChamber;
        maps[4][12] = monsterChamber;
        maps[4][13] = monsterChamber;
        maps[4][14] = food;
        maps[4][15] = monsterChamber;
        maps[4][16] = monsterChamber;
        maps[4][17] = monsterChamber;
        maps[4][18] = trapChamber;
        maps[4][19] = boss;

        maps[4][0].option1 = maps[4][1];
        maps[4][1].option1 = maps[4][3];
        maps[4][1].option2 = maps[4][2];
        maps[4][2].option1 = maps[4][3];
        maps[4][3].option1 = maps[4][6];
        maps[4][3].option2 = maps[4][4];
        maps[4][4].option1 = maps[4][5];
        maps[4][5].option1 = maps[4][6];
        maps[4][5].option2 = maps[4][8];
        maps[4][6].option1 = maps[4][7];
        maps[4][7].option1 = maps[4][9];
        maps[4][7].option2 = maps[4][8];
        maps[4][8].option1 = maps[4][10];
        maps[4][9].option1 = maps[4][10];
        maps[4][10].option1 = maps[4][11];
        maps[4][10].option2 = maps[4][14];
        maps[4][11].option1 = maps[4][13];
        maps[4][11].option2 = maps[4][12];
        maps[4][12].option1 = maps[4][13];
        maps[4][13].option1 = maps[4][14];
        maps[4][13].option2 = maps[4][19];
        maps[4][14].option1 = maps[4][17];
        maps[4][14].option2 = maps[4][15];
        maps[4][15].option1 = maps[4][16];
        maps[4][16].option1 = maps[4][19];
        maps[4][16].option2 = maps[4][17];
        maps[4][17].option1 = maps[4][19];
        maps[4][17].option2 = maps[4][18];
        maps[4][18].option1 = maps[4][19];
        maps[4][19].option1 = maps[4][19];

         */
    }
}

