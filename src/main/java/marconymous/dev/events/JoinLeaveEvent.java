package marconymous.dev.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.WHITE + e.getPlayer().getDisplayName());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + ChatColor.WHITE + e.getPlayer().getDisplayName());
    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        e.setLeaveMessage(ChatColor.GRAY + "[" + ChatColor.RED + "- (kick)" + ChatColor.GRAY + "] " + ChatColor.WHITE + e.getPlayer().getDisplayName());
    }
}
