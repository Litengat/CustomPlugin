package net.litengut.customplugin.utility;

import com.destroystokyo.paper.MaterialSetTag;
import com.destroystokyo.paper.MaterialTags;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.tools.Tool;
import java.util.Map;

public class CustomBlockData {
    public int breakDurability;
    public MaterialSetTag tool;
    public MaterialSetTag toolMaterial;












    static int getToolSpeed(Material material) {
        if(MaterialTags.WOODEN_TOOLS.isTagged(material)){return 2;}
        else if (MaterialTags.STONE_TOOLS.isTagged(material)){return 4;}
        else if (MaterialTags.IRON_TOOLS.isTagged(material)){return 6;}
        else if (MaterialTags.DIAMOND_TOOLS.isTagged(material)){return 8;}
        else if (MaterialTags.NETHERITE_TOOLS.isTagged(material)){return 9;}
        else if (MaterialTags.GOLDEN_TOOLS.isTagged(material)){return 12;}
        else {return 1;}
    }
    static MaterialSetTag getToolMaterial(Material material){
        if (MaterialTags.SWORDS.isTagged(material)) {return MaterialTags.SWORDS;}
        else if(MaterialTags.SHOVELS.isTagged(material)){return MaterialTags.SHOVELS;}
        else if(MaterialTags.PICKAXES.isTagged(material)){return MaterialTags.PICKAXES;}
        else if(MaterialTags.AXES.isTagged(material)){return MaterialTags.PICKAXES;}
        else if(MaterialTags.HOES.isTagged(material)){return MaterialTags.PICKAXES;}
        return null;
    }





}
