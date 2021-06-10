package marconymous.dev.classes;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.List;

public class GlobalFunctions {
    public static void addBoolsToList(List<String> list) {
        list.add("true");
        list.add("false");
    }

    public static void addPlayersToList(List<String> list) {
        for (Player p : Bukkit.getServer().getOnlinePlayers())
            list.add(p.getDisplayName());
    }
}
