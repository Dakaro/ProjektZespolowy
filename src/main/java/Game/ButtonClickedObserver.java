package Game;

import Models.Character.Profession;

public interface ButtonClickedObserver {
     void onPlayButtonClicked();
     void onSelectButton(Profession prof, String name);
}
