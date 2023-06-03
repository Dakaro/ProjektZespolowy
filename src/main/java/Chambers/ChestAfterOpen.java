package Chambers;


import Game.Game;
import Models.Character.Hero;
import Others.Item;
import Others.ItemType;

import java.util.concurrent.ThreadLocalRandom;

import static Others.Item.getRandomItemType;
import static Others.ItemFactory.createItem;

public class ChestAfterOpen extends Chamber {
    Hero myHero;

    public Hero getHero(){
        return myHero;
    }
    public ChestAfterOpen(Game game){
        super(game);
        myHero = game.getHero();
    }

    @Override
    public void loadChamber() {
        game.getView().loadChestAfterOpen(game, this);
    }

    public int getFoundGold(){
        int coins = ThreadLocalRandom.current().nextInt(0, myHero.getLevel() * 100 );
        myHero.setMoney(myHero.getMoney() + coins);
        return coins;
    }

    public Item getFoundItem(){
        ItemType itemType = getRandomItemType(myHero.getProf());
        Item item = createItem(myHero.getLevel(),itemType,  myHero.getProf() );
        return item;
    }

}