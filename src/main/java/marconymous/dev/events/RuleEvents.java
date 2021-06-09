package marconymous.dev.events;

import marconymous.dev.classes.GlobalContainer;
import marconymous.dev.enums.SpecialRule;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class RuleEvents implements Listener {
    private final GlobalContainer gc;

    public RuleEvents(GlobalContainer gc) {
        this.gc = gc;
    }

    @EventHandler
    public void handleInstaDeath(EntityDamageEvent e) {
        if (!this.gc.getRules().get(SpecialRule.INSTADEATH)) return;
        if (!(e.getEntity() instanceof Player)) return;

        Player p = (Player) e.getEntity();
        p.setHealth(0);
    }

    @EventHandler
    public void handleFallDamage(EntityDamageEvent e) {
        if (!this.gc.getRules().get(SpecialRule.NOFALLDAMAGE)) return;
        if (!(e.getEntity() instanceof Player)) return;

        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) e.setCancelled(true);
    }
}
