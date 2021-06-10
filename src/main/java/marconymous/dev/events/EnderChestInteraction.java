package marconymous.dev.events;

import jdk.internal.org.jline.reader.ParsedLine;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.inventory.InventoryView;

public class EnderChestInteraction implements Listener {
    @EventHandler
    public void handleInventoryInteraction(InventoryClickEvent e) {
        InventoryView view = e.getView();

        if (!view.getTitle().contains("EnderChest") || !(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();

        String name = view.getTitle().split("\\s")[2];
        if (!p.getDisplayName().equals(name)) {
            e.setCancelled(true);
            return;
        }

        p.getEnderChest().setContents(e.getInventory().getContents());
    }
}
