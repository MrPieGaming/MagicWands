package me.pieface3450.magicwands.Events;

import me.pieface3450.magicwands.Items.WandItems;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Set;

public class WandEvents implements Listener {

    private ItemStack fireballWand = WandItems.fireballWandItem();
    private ItemStack lightningWand = WandItems.lightningWandItem();
    private ItemStack teleportWand = WandItems.teleportWandItem();

    @EventHandler
    public void onWandRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack wand = player.getInventory().getItemInMainHand();

        if (event.getAction() == Action.RIGHT_CLICK_AIR) {

            if (wand.equals(fireballWand)) { // fireball wand
                double currentHealth = player.getHealth();
                double futureHealth = currentHealth - 2.0D;
                if (futureHealth <= 0.0D) {
                    player.setHealth(0.0D);
                } else {
                    player.setHealth(futureHealth);

                    Fireball fireball = player.launchProjectile(Fireball.class);
                    fireball.setVelocity(fireball.getVelocity().multiply(15));
                }
            } else if (wand.equals(lightningWand)) { // lightning wand
                Location lightningLocation = staredAtBlock(player, 25).getLocation().add(0.0D, 1.0D, 0.0D);

                double currentHealth = player.getHealth();
                double futureHealth = currentHealth - 6.0D;
                if (futureHealth <= 0.0D) {
                    player.setHealth(0.0D);
                } else {
                    player.setHealth(futureHealth);
                    player.getWorld().strikeLightning(lightningLocation);
                }
            } else if (wand.equals(teleportWand)) { // teleport wand
                Location tpLocation = staredAtBlock(player, 50).getLocation().add(0.0D, 1.0D, 0.0D);
                Vector currentDirection = player.getLocation().getDirection();
                tpLocation.setDirection(currentDirection);

                double currentHealth = player.getHealth();
                double futureHealth = currentHealth - 4.0D;
                if (futureHealth <= 0.0D) {
                    player.setHealth(0.0D);
                } else {
                    player.setHealth(futureHealth);
                    player.teleport(tpLocation, PlayerTeleportEvent.TeleportCause.PLUGIN);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.5F, 1.0F);
                    player.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, null);
                }
            }
        }
    }

    private Block staredAtBlock(Player p, int blockDistance) {
        return p.getTargetBlockExact(blockDistance, FluidCollisionMode.ALWAYS);
    }
}
