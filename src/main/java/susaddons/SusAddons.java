package susaddons;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.command.ServerCommandSource;

public class SusAddons implements CarpetExtension, ModInitializer {

    @Override
    public void onInitialize() {
        CarpetServer.manageExtension(new SusAddons());}

    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(SusAddonsSettings.class);}

    @Override
    public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {}
}
 