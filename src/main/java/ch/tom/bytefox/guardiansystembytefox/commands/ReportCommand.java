package ch.tom.bytefox.guardiansystembytefox.commands;

import ch.tom.bytefox.guardiansystembytefox.GuardianSystemByteFox;
import ch.tom.bytefox.guardiansystembytefox.enums.Messages;
import ch.tom.bytefox.guardiansystembytefox.enums.Reasons;
import ch.tom.bytefox.guardiansystembytefox.mysql.report.Report;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.brokenstudio.cloud.cloudplugin.CloudPlugin;
import dev.brokenstudio.cloud.uuid.UUIDFetcher;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.text.Component;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportCommand implements SimpleCommand {

    private GuardianSystemByteFox plugin;

    public ReportCommand(GuardianSystemByteFox plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Invocation invocation) {
        String[] args = invocation.arguments();
        Player player = (Player) invocation.source();
        if (args.length == 2) {
            Optional<Player> target = CloudPlugin.api().getProxyServer().getPlayer(UUIDFetcher.getUUID(args[0]));
            if (target.get() != null) {
                if (target.get().getUsername() == player.getUsername()) {
                    List<Integer> reasons = Stream.of(Reasons.values())
                            .map(Reasons::getId).toList();

                    Integer lastId = reasons.get(reasons.size() -1);
                    if (isNumeric(args[1])) {
                        if (Integer.valueOf(args[1]) <= lastId && Integer.valueOf(args[1]) != 0) {
                            String reason = Reasons.getById(Integer.parseInt(args[1]));
                            player.sendMessage(Component.text(Messages.PREFIX.getMessages() + "§aDu hast erfolgreich §e" + target.get().getUsername() + " §areported. \n §8» §7Es wird sich ein Teammtiglied um dich kümmern.\n \n§7Grund: " + reason));
                            plugin.getReportService().create(new Report(player.getUniqueId().toString(), target.get().getUniqueId().toString(), true, reason));
                            System.out.println(plugin.getReportService().getList());
                        }  else {
                            player.sendMessage(Component.text(Messages.PREFIX.getMessages() + "§cBenutze bitte eine Richtige ID!"));
                        }
                    } else {
                        player.sendMessage(Component.text(Messages.PREFIX.getMessages() + "§cBenutze bitte eine Richtige Nummer (1-"+reasons.size()+")!"));
                    }
                } else {
                    player.sendMessage(Component.text(Messages.PREFIX.getMessages() + "§7Du kannst dich nicht selbst reporten."));
                }
            } else {
                player.sendMessage(Component.text(Messages.NO_PLAYER_MESSAGE.getMessages()));
            }



        } else {
            invocation.source().sendMessage(Component.text("§7-- §bReasons §7--"));
            for (Reasons reasons : Reasons.values()) {
                invocation.source().sendMessage(Component.text(reasons.getId() + "§8 | §7"+reasons.name()));
            }

            invocation.source().sendMessage(Component.text(" "));
            invocation.source().sendMessage(Component.text("§cBenutze bitte /report <player> <id>"));
        }
    }

    @Override
    public List<String> suggest(Invocation invocation) {
        return SimpleCommand.super.suggest(invocation);
    }

    @Override
    public CompletableFuture<List<String>> suggestAsync(Invocation invocation) {
        return SimpleCommand.super.suggestAsync(invocation);
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return SimpleCommand.super.hasPermission(invocation);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
