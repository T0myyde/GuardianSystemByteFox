package ch.tom.bytefox.guardiansystembytefox.commands;

import ch.tom.bytefox.guardiansystembytefox.enums.Reasons;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;

import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ReportCommand implements SimpleCommand {

    private ProxyServer proxyServer;

    public ReportCommand(ProxyServer proxyServer) {
        this.proxyServer = proxyServer;
    }

    @Override
    public void execute(Invocation invocation) {
        if (invocation.arguments().length != 2) {

        } else {
            invocation.source().sendMessage(Component.text("§7-- §bReasons §7--"));
            for (Reasons reasons : Reasons.values()) {
                invocation.source().sendMessage(Component.text("§c"+reasons.name()));
            }

            invocation.source().sendMessage(Component.text(" "));
            invocation.source().sendMessage(Component.text("§cBenutze bitte /report <player> <reason>"));
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
}
