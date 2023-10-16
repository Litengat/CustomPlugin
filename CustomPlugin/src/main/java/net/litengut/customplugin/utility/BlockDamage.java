package net.litengut.customplugin.utility;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class BlockDamage {
    public static Material CustomBlockMaterial = Material.BARRIER;
    public static Map<Player, Long> times = new HashMap<>();

    public static void remove(Player player){
        times.remove(player);
    }
    public static void setStartTime(Player player) {
        times.put(player,getTime());
    }
    public static long getTime(){
        return System.currentTimeMillis() / 50;
    }
    public static long getStartTime(Player player){
        return times.get(player);
    }
    public static float getDuration(Player player) {
        return (int) (getTime() - getStartTime(player));
    }
    public static void progressBar(Player player,float num, int max ) {
        ProgressBar progressBar = new ProgressBar();
        progressBar.getProgressBar((int) (num * max));
        String progress = "[" + progressBar.getProgressBar((int) (num * max)) + "§r]";
        BossBar bar = PlayerBossBar.getBossbar(player);
        bar.setTitle(progress);
        bar.setProgress(num);
        bar.setColor(BarColor.YELLOW);
        PlayerBossBar.setBossBar(player,bar);
        PlayerBossBar.setVisible(player,true);
    }




}
