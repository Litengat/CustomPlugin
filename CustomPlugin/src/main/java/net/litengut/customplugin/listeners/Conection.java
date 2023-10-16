package net.litengut.customplugin.listeners;

import net.litengut.customplugin.utility.PlayerBossBar;
import net.litengut.customplugin.utility.ProgressBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Conection implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        PlayerBossBar.addToBossBarMap(event.getPlayer());
        event.getPlayer().sendMessage("bossBar");



    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        PlayerBossBar.removeFromBossBarMap(event.getPlayer());


    }
}
