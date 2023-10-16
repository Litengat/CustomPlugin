package net.litengut.customplugin.utility;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ProgressBar {

    public int characters = 40;
    public String Character = "|";
    public String color = "§2";
    public String antiColor = "§7";
    public String antiCharacter = "|";

    public String getProgressBar(int num){
        String repeat = Character.repeat(num);
        String antirepeat = antiCharacter.repeat(characters  - num);
        return color + repeat + antiColor + antirepeat;
    }

}
