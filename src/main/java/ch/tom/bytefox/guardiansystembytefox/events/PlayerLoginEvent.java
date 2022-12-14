package ch.tom.bytefox.guardiansystembytefox.events;

import ch.tom.bytefox.guardiansystembytefox.GuardianSystemByteFox;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.LoginEvent;
import com.velocitypowered.api.proxy.Player;
import dev.brokenstudio.cloud.byteplayer.BytePlayer;
import dev.brokenstudio.cloud.cloudplugin.CloudPlugin;
import net.kyori.adventure.text.Component;

public class PlayerLoginEvent {
    private GuardianSystemByteFox plugin;

    public PlayerLoginEvent(GuardianSystemByteFox plugin) {
        this.plugin = plugin;
    }

    @Subscribe
    public void onPlayerLogin(LoginEvent event) {
        Player player = event.getPlayer();
        BytePlayer bytePlayer = CloudPlugin.api().getBytePlayerHandler().getBytePlayer(player.getUniqueId());

        if (plugin.getBannedService().get(player.getUniqueId().toString()) == null) {
            bytePlayer.setProperty("Guard_Banned", false);
        } else {
            bytePlayer.setProperty("Guard_Banned", true);
            player.disconnect(Component.text("§cYou are banned!\nReason: " + plugin.getBannedService().get(player.getUniqueId().toString()).getReason()));
        }



        if (plugin.getMutedService().get(player.getUniqueId().toString()) == null) {
            bytePlayer.setProperty("Guard_Muted", false);
        } else {
            bytePlayer.setProperty("Guard_Muted", true);
        }
    }
}
