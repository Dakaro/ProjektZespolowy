package Chambers;


import Game.Game;
import Models.Character.Hero;
import Others.Item;
import Others.ItemType;

import java.util.concurrent.ThreadLocalRandom;

import static Others.Item.getRandomItemType;
import static Others.ItemFactory.createItem;

public class ChestAfterOpen extends Chamber {

    public ChestAfterOpen(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadChestAfterOpen(game, this);
    }

    public int getFoundGold(){
        Hero myHero = this.game.getHero();
        int coins = ThreadLocalRandom.current().nextInt(0, myHero.getLevel() * 100 );
        myHero.setMoney(myHero.getMoney() + coins);
        return coins;
    }

    public Item getFoundItem(){
        Hero myHero = this.game.getHero();
        ItemType itemType = getRandomItemType();
        Item item = createItem(myHero.getLevel(),itemType,  myHero.getProf() );
        return item;
    }

}