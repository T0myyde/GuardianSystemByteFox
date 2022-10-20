package ch.tom.bytefox.guardiansystembytefox;

import ch.tom.bytefox.guardiansystembytefox.commands.ReportCommand;
import ch.tom.bytefox.guardiansystembytefox.events.PlayerLoginEvent;
import ch.tom.bytefox.guardiansystembytefox.mysql.banned.BannedService;
import ch.tom.bytefox.guardiansystembytefox.mysql.muted.MutedService;
import ch.tom.bytefox.guardiansystembytefox.mysql.report.ReportService;
import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.brokenstudio.cloud.cloudplugin.CloudPlugin;
import org.slf4j.Logger;

@Plugin(
        id = "guardiansystembytefox",
        name = "Guardiansystembytefox",
        version = "1.0-SNAPSHOT"
)
public class GuardianSystemByteFox {


    private Logger logger;
    private ProxyServer proxyServer;
    private GuardianSystemByteFox instance;
    private final ReportService reportService;
    private final BannedService bannedService;

    private final MutedService mutedService;

    @Inject
    public GuardianSystemByteFox(Logger logger, ProxyServer proxyServer) {
        this.logger = logger;
        this.proxyServer = proxyServer;
        this.instance = this;
        this.reportService = new ReportService();
        this.bannedService = new BannedService();
        this.mutedService = new MutedService();

        System.out.println("ByteFox | GuardSystem Started");
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        proxyServer.getEventManager().register(this, new PlayerLoginEvent(instance));
        proxyServer.getCommandManager().register(proxyServer.getCommandManager().metaBuilder("report").build(), new ReportCommand(proxyServer));
    }

    public GuardianSystemByteFox getInstance() {
        return instance;
    }

    public ReportService getReportService() {
        return reportService;
    }

    public Logger getLogger() {
        return logger;
    }

    public ProxyServer getProxyServer() {
        return proxyServer;
    }

    public BannedService getBannedService() {
        return bannedService;
    }

    public MutedService getMutedService() {
        return mutedService;
    }
}
