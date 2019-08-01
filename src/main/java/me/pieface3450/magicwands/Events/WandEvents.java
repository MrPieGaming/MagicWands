package me.pieface3450.magicwands.Events;

import me.pieface3450.magicwands.Wands.FireballWandItem;
import me.pieface3450.magicwands.Wands.LightningWandItem;
import me.pieface3450.magicwands.Wands.TeleportWandItem;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Set;

public class WandEvents implements Listener {

    @EventHandler
    public void onTeleportClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        ItemStack wand = new ItemStack(TeleportWandItem.teleportWandItem());
        if ((event.getAction() == Action.RIGHT_CLICK_AIR) &&
                (p.getInventory().getItemInMainHand().equals(wand))) {
            Location tpLocation = staredAtBlock(p).getLocation().add(0.0D, 1.0D, 0.0D);
            Vector currentDirection = p.getLocation().getDirection();
            tpLocation.setDirection(currentDirection);

            double currentHealth = p.getHealth();
            double futureHealth = currentHealth - 4.0D;
            if (futureHealth <= 0.0D) {
                p.setHealth(0.0D);
            } else {
                p.setHealth(futureHealth);
                p.teleport(tpLocation);
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.5F, 1.0F);
                p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 0);
            }
        }
    }

    @EventHandler
    public void onFireballClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack wand = new ItemStack(FireballWandItem.fireballWandItem());
        if ((event.getAction() == Action.RIGHT_CLICK_AIR) &&
                (player.getInventory().getItemInMainHand().equals(wand))) {
            double currentHealth = player.getHealth();
            double futureHealth = currentHealth - 2.0D;
            if (futureHealth <= 0.0D) {
                player.setHealth(0.0D);
            } else {
                player.setHealth(futureHealth);

                Fireball fireball = player.launchProjectile(Fireball.class);
                fireball.setVelocity(fireball.getVelocity().multiply(10));
            }
        }
    }

    @EventHandler
    public void onLightningClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        ItemStack wand = new ItemStack(LightningWandItem.lightningWandItem());
        if ((event.getAction() == Action.RIGHT_CLICK_AIR) &&
                (p.getInventory().getItemInMainHand().equals(wand))) {
            Location lightningLocation = staredAtBlock(p).getLocation().add(0.0D, 1.0D, 0.0D);

            double currentHealth = p.getHealth();
            double futureHealth = currentHealth - 6.0D;
            if (futureHealth <= 0.0D) {
                p.setHealth(0.0D);
            } else {
                p.setHealth(futureHealth);
                p.getWorld().strikeLightning(lightningLocation);
            }
        }
    }

    private Block staredAtBlock(Player p) {
        return p.getTargetBlock((Set<Material>) null, 25);
    }
}
