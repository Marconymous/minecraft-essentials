package marconymous.dev.events;

import marconymous.dev.classes.GlobalContainer;
import marconymous.dev.enums.SpecialRule;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;


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

    @EventHandler
    public void handleNoHunger(FoodLevelChangeEvent e) {
        // todo: fix
        if (!this.gc.getRules().get(SpecialRule.NOHUNGER)) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void handleNoRegen(EntityRegainHealthEvent e) {
        // todo: fix
        if (!this.gc.getRules().get(SpecialRule.NOHEAL)) return;
        e.setCancelled(true);
    }
}
