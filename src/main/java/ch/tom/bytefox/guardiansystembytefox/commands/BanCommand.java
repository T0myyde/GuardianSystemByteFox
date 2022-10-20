package ch.tom.bytefox.guardiansystembytefox.commands;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.ProxyServer;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BanCommand implements SimpleCommand {

    private ProxyServer plugin;

    public BanCommand(ProxyServer plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Invocation invocation) {

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
