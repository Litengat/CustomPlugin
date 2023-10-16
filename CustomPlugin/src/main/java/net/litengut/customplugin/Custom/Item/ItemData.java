package net.litengut.customplugin.Custom.Item;

import com.google.gson.Gson;
import net.litengut.customplugin.utility.Meta;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemData {

    String DisplayName;
    Material material = Material.BARRIER;
    List<String> Lore = new ArrayList<>();
    int CustomModelData = 0;
    Map<Enchantment, Integer> Enchants = new HashMap<>();
    boolean Unbreakable = false;



    public static String toJson(ItemData meta){
        Gson gson = new Gson();
        return gson.toJson(meta);

    }
    public static ItemData fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, ItemData.class);
    }
}
