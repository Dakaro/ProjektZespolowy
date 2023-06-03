package Chambers;

import Game.Game;
import Models.Character.Hero;
import Others.Item;
import Others.ItemType;

import static Others.Item.getRandomItemType;
import static Others.ItemFactory.createItem;

public class TraderChamber extends Chamber {

    Hero myHero;

    public Hero getHero(){
        return myHero;
    }

    public TraderChamber(Game game){
        super(game);
        myHero = this.game.getHero();
    }

    @Override
    public void loadChamber() {
        game.getView().loadTraderChamber(game, this);
    }

    public Item[] getTraderItems(){
        ItemType itemType = getRandomItemType(myHero.getProf());
        Item [] items = new Item[3];
        items[0] = createItem(myHero.getLevel(),itemType,  myHero.getProf() );
        itemType = getRandomItemType(myHero.getProf());
        items[1] = createItem(myHero.getLevel(),itemType,  myHero.getProf() );
        itemType = getRandomItemType(myHero.getProf());
        items[2] = createItem(myHero.getLevel(),itemType,  myHero.getProf() );
        return items;
    }

    public int getGoldBalance(){
        return myHero.getMoney();
    }

    public int buyItem(Item it){
        if( myHero.getMoney() >= it.getValue() ){
            myHero.setMoney( myHero.getMoney() - it.getValue() );
            myHero.changeEQ(it);
        }

        return myHero.getMoney();
    }




}