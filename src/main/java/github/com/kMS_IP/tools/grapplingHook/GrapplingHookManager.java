package github.com.kMS_IP.tools.grapplingHook;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

public class GrapplingHookManager{

    private static final int COOLDOWN_SEC = 5;
    private static final double GRAPPLING_FORCE = 1.5;
    private static final double MAX_DISTANCE = 45.0;

    private final Map<UUID, Long> cooldowns = new HashMap<>();

    /**
     * プレイヤーがグラップリングフックを使用できるかどうかチェック
     */
    public boolean canUseGrapplingHook(Player p) {
        UUID uuid = p.getUniqueId();
        long currentTime = System.currentTimeMillis();

        if(cooldowns.containsKey(uuid)) {
            long lastTime = cooldowns.get(uuid);
            long diffTime = currentTime - lastTime;

            long cooldownMills = COOLDOWN_SEC * 1000;
            if(diffTime < cooldownMills) {

                long remainingSec = (cooldownMills - diffTime) / 1000;
                p.sendMessage("&cグラップリングフックはクールタイム中です。残り: " +
                        remainingSec + " 秒");

                return false;
            }

        }

        return true;

    }

    /**
     * 実際の動き
     */

    public void useGrapplingHook(Player p,Location hookLocation) {

        UUID uuid = p.getUniqueId();

        if(!canUseGrapplingHook(p)) return;

        Location l = p.getLocation();
        double distance = l.distance(hookLocation);

        //距離チェック
        if(distance < MAX_DISTANCE) {
            p.sendMessage("&cフックが遠すぎます!!");
            return;
        }

        Vector dir = hookLocation.toVector().subtract(l.toVector());
        dir nomalize();
        dir.multiplay(GRAPPLING_FORCE);

        //y軸を少し上向きにして上昇するようにする
        dir.setY(dir.getY() + 0.3);

        //プレイヤーをぶっ飛ばす
        p.setVelocity(dir);

        //エフェクト表示

        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1,1.2f);

        //TODO クールダウン

        p.sendMessage("&aぶっ飛べ!")

    }

    /**
     * クールタイム設定
     */
    private void setCooldown(Player p) {

        cooldowns.put(p.getUniqueId(), System.currentTimeMillis());

    }

    /**
     *
     */

}