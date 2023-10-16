package net.litengut.customplugin.Custom;

import com.google.gson.Gson;
import net.litengut.customplugin.CustomPlugin;
import net.litengut.customplugin.utility.Meta;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import java.io.*;
import com.google.gson.GsonBuilder;
import java.util.HashMap;

public class CustomItem {
    public static HashMap<String,Meta> Metas = new HashMap<String,Meta>();
    static String DataFolder;

    public static Meta getMetaById(String id){
        return Metas.get(id);
    }

    public static void onEnable() {
        Plugin plugin = CustomPlugin.getPlugin(CustomPlugin.class);
        DataFolder = plugin.getDataFolder().getPath() + "\\Items\\";


        Bukkit.getConsoleSender().sendMessage(DataFolder);
        reloadMetas();
    }

    public static void reloadMetas(){
        Metas.clear();
        File[] FilePaths = listAllJsonFile();
        for(File file : FilePaths) {
            String path = file.getName();
            String name = path.replace(".json", "");
            Bukkit.getConsoleSender().sendMessage(path);

            Metas.put(name,getMeta(path));
        }
    }
    static Meta getMeta(String path) {
        Gson gson = new Gson();
        File file = new File(DataFolder, path);
        try {
            FileReader reader = new FileReader(file);

            Meta meta = gson.fromJson(reader, Meta.class);
            return meta;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static File[] listAllJsonFile() {
        File dir = new File(DataFolder);
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".json");
            }
        });
        return files;
    }


    public static void ItemToJson(ItemStack item,String path) {
        ItemMeta itemMeta = item.getItemMeta();
        Meta meta = Meta.fromItemMeta(itemMeta);
        File file = new File(DataFolder, path + ".json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(file.getPath())) {
            gson.toJson(meta, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void print(String s){
        Bukkit.getConsoleSender().sendMessage(s);
    }
}
