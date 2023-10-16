package net.litengut.customplugin.cmds;


import net.litengut.customplugin.Custom.Item;
import net.litengut.customplugin.utility.Meta;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CustomItemCmd implements CommandExecutor , TabCompleter  {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(args.length == 0) return false;
        if(args[0].equals("get") && args.length == 2){

            ItemStack item = player.getInventory().getItemInMainHand();
            String id = args[1];
            Item.ItemToJson(item,id);

            Item.reloadMetas();
            return true;
        }
        if(args[0].equals("getitems")) {
            sender.sendMessage(Item.Metas.keySet().toString());
        }
        if(args[0].equals("getValue") && args.length == 2) {
            Meta meta = Item.getMetaById(args[1]);
            sender.sendMessage(Meta.toJson(meta));
            return true;
        }
        if(args[0].equals("reload")){
            Item.reloadMetas();
            sender.sendMessage("reload");
            return true;
        }
        if(args.length == 2) {
            Material material = Material.valueOf(args[0].toUpperCase());
            String id = args[1];

            ItemStack item = new ItemStack(material);
            Meta meta = Item.getMetaById(id);

            ItemMeta itemMeta = meta.toItemMeta();


            item.setItemMeta(itemMeta);

            player.getInventory().addItem(item);
            sender.sendMessage("Gave [" + item.getItemMeta().getDisplayName()  +"§r] to " + sender.getName());
            return true;
        }



        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if(args.length == 0){return list;}
        if(args.length == 1){
            for(Material m : Material.values()){
                list.add(m.toString().toLowerCase());
            }
            list.add("get");
            list.add("getitems");
            list.add("getValue");
        }
        if(args.length == 2 && args[0] != "get" && args[0] != "getitems"){
            list.addAll(Item.Metas.keySet());
        }
        ArrayList<String> completerList = new ArrayList<>();

        String currentArgs = args[args.length-1].toLowerCase();
        for(String s : list) {
            String lowS = s.toLowerCase();
            if(lowS.startsWith(currentArgs)){
                completerList.add(s);
            }
        }

        return completerList;
    }


}
