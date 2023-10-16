package net.litengut.customplugin;



import net.litengut.customplugin.Custom.Item;
import net.litengut.customplugin.cmds.CustomItemCmd;
import net.litengut.customplugin.listeners.Conection;
import net.litengut.customplugin.listeners.click;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public final class CustomPlugin extends JavaPlugin {


    @Override
    public void onEnable() {
        Item.onEnable();
        PluginManager plugin = Bukkit.getPluginManager();
        plugin.registerEvents(new click(),this);
        plugin.registerEvents(new Conection(),this);



        getCommand("CustomItem").setExecutor(new CustomItemCmd());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
