package me.pieface3450.magicwands.Events;

import me.pieface3450.magicwands.Items.BookOfFlyingItem;
import me.pieface3450.magicwands.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.math.BigDecimal;
import java.util.HashMap;

public class BookOfFlyingEvents implements Listener {

    private final Main plugin;

    private HashMap<String, Integer> bofEventIds = new HashMap<>();

    public BookOfFlyingEvents(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        ItemStack bof = new ItemStack(BookOfFlyingItem.bofItem());
        if ((event.getItemDrop().getItemStack().equals(bof)) && (event.getPlayer().getGameMode() != GameMode.CREATIVE) &&
                (event.getPlayer().getAllowFlight())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.DARK_RED + "Disable flight before dropping the book.");
        }
    }

    @EventHandler
    public void onShiftClick(InventoryClickEvent event) {
        if (event.getSlot() == -1 || event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) return;

        if (event.getClick().isShiftClick()) {
            Inventory clicked = event.getClickedInventory();
            if (clicked == event.getWhoClicked().getInventory()) {
                ItemStack clickedOn = event.getCurrentItem();

                if (clickedOn != null && clickedOn.equals(BookOfFlyingItem.bofItem())) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getSlot() == -1 || event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) return;

        Inventory clicked = event.getClickedInventory();
        if (clicked != event.getWhoClicked().getInventory()) {
            ItemStack onCursor = event.getCursor();

            if (onCursor != null && onCursor.equals(BookOfFlyingItem.bofItem())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        if (event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) return;
        ItemStack dragged = event.getOldCursor();

        if (dragged.equals(BookOfFlyingItem.bofItem())) {
            int inventorySize = event.getInventory().getSize();

            for (int i : event.getRawSlots()) {
                if (i < inventorySize) {
                    event.setCancelled(true);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onBookToggle(PlayerInteractEvent event) {
        if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;

        final Player player = event.getPlayer();
        final ItemStack bof = new ItemStack(BookOfFlyingItem.bofItem());

        if (player.getInventory().getItemInMainHand().equals(bof)) {
            if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && !bofEventIds.containsKey(event.getPlayer().getName())) {
                if (player.getLevel() != 0) {
                    player.setAllowFlight(true);
                    player.sendMessage(ChatColor.AQUA + "Flight has been enabled. Double-tap " + ChatColor.BLUE + "'Space'" + ChatColor.AQUA + " to enable/disable flight");
                    bofEventIds.put(player.getName(), Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            if (getTotalExperience(player) <= 0 || (getTotalExperience(player) - 2) < 0) {
                                player.setAllowFlight(false);
                                player.sendMessage(ChatColor.RED + "Flight has been disabled (Out of experience)");
                                // cancel scheduler here
                                Bukkit.getServer().getScheduler().cancelTask(bofEventIds.get(player.getName()));
                                bofEventIds.remove(player.getName());
                            } else setTotalExperience(getTotalExperience(player) - 2, event.getPlayer());
                        }
                    }, 10L, 5L));
                } else if (player.getLevel() <= 0) player.sendMessage(ChatColor.RED + "Not enough experience");
            }
            if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && !bofEventIds.isEmpty() && bofEventIds.get(player.getName()) != null) {
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.RED + "Flight has been disabled");
                Bukkit.getServer().getScheduler().cancelTask(bofEventIds.get(player.getName()));
                bofEventIds.remove(player.getName());
            }
        }
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent event) {
        if (bofEventIds.containsKey(event.getPlayer().getName()))
            Bukkit.getServer().getScheduler().cancelTask(bofEventIds.get(event.getPlayer().getName()));
        bofEventIds.remove(event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        if (bofEventIds.containsKey(event.getPlayer().getName()))
            Bukkit.getServer().getScheduler().cancelTask(bofEventIds.get(event.getPlayer().getName()));
        bofEventIds.remove(event.getPlayer().getName());
    }

    private int getTotalExperience(Player player) {
        int experience = 0;
        int level = player.getLevel();
        if (level >= 0 && level <= 15) {
            experience = (int) Math.ceil(Math.pow(level, 2) + (6 * level));
            int requiredExperience = 2 * level + 7;
            double currentExp = Double.parseDouble(Float.toString(player.getExp()));
            experience += Math.ceil(currentExp * requiredExperience);
            return experience;
        } else if (level > 15 && level <= 30) {
            experience = (int) Math.ceil((2.5 * Math.pow(level, 2) - (40.5 * level) + 360));
            int requiredExperience = 5 * level - 38;
            double currentExp = Double.parseDouble(Float.toString(player.getExp()));
            experience += Math.ceil(currentExp * requiredExperience);
            return experience;
        } else {
            experience = (int) Math.ceil(((4.5 * Math.pow(level, 2) - (162.5 * level) + 2220)));
            int requiredExperience = 9 * level - 158;
            double currentExp = Double.parseDouble(Float.toString(player.getExp()));
            experience += Math.ceil(currentExp * requiredExperience);
            return experience;
        }
    }

    private void setTotalExperience(int xp, Player player) {
        //Levels 0 through 15
        if (xp >= 0 && xp < 351) {
            //Calculate Everything
            int a = 1;
            int b = 6;
            int c = -xp;
            int level = (int) (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            int xpForLevel = (int) (Math.pow(level, 2) + (6 * level));
            int remainder = xp - xpForLevel;
            int experienceNeeded = (2 * level) + 7;
            float experience = (float) remainder / (float) experienceNeeded;
            experience = round(experience, 2);
            /*System.out.println("xpForLevel: " + xpForLevel);
            System.out.println(experience); */

            //Set Everything
            player.setLevel(level);
            player.setExp(experience);
            //Levels 16 through 30
        } else if (xp >= 352 && xp < 1507) {
            //Calculate Everything
            double a = 2.5;
            double b = -40.5;
            int c = -xp + 360;
            double dLevel = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            int level = (int) Math.floor(dLevel);
            int xpForLevel = (int) (2.5 * Math.pow(level, 2) - (40.5 * level) + 360);
            int remainder = xp - xpForLevel;
            int experienceNeeded = (5 * level) - 38;
            float experience = (float) remainder / (float) experienceNeeded;
            experience = round(experience, 2);
            /*System.out.println("xpForLevel: " + xpForLevel);
            System.out.println(experience);*/

            //Set Everything
            player.setLevel(level);
            player.setExp(experience);
            //Level 31 and greater
        } else {
            //Calculate Everything
            double a = 4.5;
            double b = -162.5;
            int c = -xp + 2220;
            double dLevel = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            int level = (int) Math.floor(dLevel);
            int xpForLevel = (int) (4.5 * Math.pow(level, 2) - (162.5 * level) + 2220);
            int remainder = xp - xpForLevel;
            int experienceNeeded = (9 * level) - 158;
            float experience = (float) remainder / (float) experienceNeeded;
            experience = round(experience, 2);
            /*System.out.println("xpForLevel: " + xpForLevel);
            System.out.println(experience);*/

            //Set Everything
            player.setLevel(level);
            player.setExp(experience);
        }
    }

    private float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_DOWN);
        return bd.floatValue();
    }
}