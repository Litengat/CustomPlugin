package net.litengut.customplugin.utility;

import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meta {

    String DisplayName = "";

    List<String> Lore = new ArrayList<>();
    int CustomModelData = 0;

    Map<Enchantment, Integer> Enchants = new HashMap<>();

    boolean Unbreakable = false;

    public boolean isDisplayName() {
        return DisplayName.isEmpty();
    }
    public boolean isLore() {return Lore.isEmpty();}

    public List<String> getLore() {
        return Lore;
    }

    public void setLore(List<String> lore) {
        Lore = lore;
    }

    public int getCustomModelData() {
        return CustomModelData;
    }

    public void setCustomModelData(int customModelData) {
        CustomModelData = customModelData;
    }

    public Map<Enchantment, Integer> getEnchants() {
        return Enchants;
    }

    public void setEnchants(Map<Enchantment, Integer> enchants) {
        Enchants = enchants;
    }

    public boolean getUnbreakable() {
        return Unbreakable;
    }

    public void setUnbreakable(boolean unbreakable) {
        Unbreakable = unbreakable;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public ItemMeta toItemMeta(){
        ItemStack stack = new ItemStack(Material.STONE);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(getDisplayName());
        meta.setLore(getLore());

        meta.setCustomModelData(getCustomModelData());
        meta.setUnbreakable(getUnbreakable());
        for( Enchantment e : Enchants.keySet()){
            meta.addEnchant(e, Enchants.get(e), false);
        }

        return meta;
    }
    public static Meta fromItemMeta(ItemMeta itemMeta){
        Meta meta = new Meta();

        if(itemMeta.hasDisplayName()) meta.setDisplayName(itemMeta.getDisplayName());
        if(itemMeta.hasLore()) meta.setLore(itemMeta.getLore());
        if(itemMeta.hasCustomModelData()) meta.setCustomModelData(itemMeta.getCustomModelData());
        if(itemMeta.hasEnchants()) meta.setEnchants(itemMeta.getEnchants());

        meta.setUnbreakable(meta.getUnbreakable());
        return meta;
    }
    public static String toJson(Meta meta){
        Gson gson = new Gson();
        return gson.toJson(meta);

    }
    public static Meta fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Meta.class);
    }
    static void print(String s){
        Bukkit.getConsoleSender().sendMessage(s);
    }
}
