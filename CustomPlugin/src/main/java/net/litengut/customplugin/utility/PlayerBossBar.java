package net.litengut.customplugin.utility;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerBossBar {

    static Map<Player, BossBar> bossBarMap = new HashMap<>();

    public static void addToBossBarMap(Player player) {
        BossBar bossBar = Bukkit.createBossBar(player.getName(), BarColor.WHITE, BarStyle.SOLID);
        bossBar.setVisible(false);
        bossBar.addPlayer(player);
        bossBarMap.put(player,bossBar);
    }
    public static void removeFromBossBarMap(Player player) {
        bossBarMap.remove(player);
    }
    public static BossBar getBossbar(Player player) {
        return bossBarMap.get(player);
    }
    public static void setBossBar(Player player,BossBar bossBar) {
        bossBarMap.put(player,bossBar);
    }
    public static void setVisible(Player player,boolean Visible){
        getBossbar(player).setVisible(Visible);
    }
}
