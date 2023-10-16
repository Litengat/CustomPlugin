package net.litengut.customplugin.listeners;
import net.litengut.customplugin.utility.BlockDamage;
import net.litengut.customplugin.utility.PlayerBossBar;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageAbortEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;

public class click implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onBlockDamage(BlockDamageEvent event) {
        BlockDamage.remove(event.getPlayer());
        if(event.getBlock().getType() == BlockDamage.CustomBlockMaterial){
            BlockDamage.setStartTime(event.getPlayer());

        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {

    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockDamageAbort(BlockDamageAbortEvent event) {
        if(event.getBlock().getType() == BlockDamage.CustomBlockMaterial){
            PlayerBossBar.setVisible(event.getPlayer(),false);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerAnimation(PlayerAnimationEvent event) {
        Player player = event.getPlayer();
        if(BlockDamage.times.get(player) != null) {
            if (event.getAnimationType() == PlayerAnimationType.ARM_SWING) {
                Block block = player.getTargetBlockExact(5);
                if (block != null && block.getType() == BlockDamage.CustomBlockMaterial) {
                    BlockDamage.progressBar(player,BlockDamage.getDuration(player) / 40  ,40);
                    if (BlockDamage.getDuration(player) >= 40) {
                        block.setType(Material.AIR);
                        BlockDamage.remove(player);
                        PlayerBossBar.setVisible(player,false);

                    }
                }

            }
        }
    }

}
