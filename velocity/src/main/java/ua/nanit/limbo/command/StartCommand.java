package ua.nanit.limbo.command;

import ua.nanit.limbo.NanoLimboVelocity;
import ua.nanit.limbo.command.exception.SendComponentException;

import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.velocity.annotation.CommandPermission;
import ua.nanit.limbo.server.LimboServer;

import java.io.IOException;

@Command("limbostart")
public class StartCommand {
    @Dependency
    private NanoLimboVelocity plugin;

    @Default
    @CommandPermission("limbo.start")
    public void execute(CommandActor actor, LimboServer limboServer) throws SendComponentException, IOException {
        if (limboServer.isRunning())
            throw new SendComponentException(plugin.getLimboConfig().getMessages().message("already-running"));
        limboServer.start();
        throw new SendComponentException(plugin.getLimboConfig().getMessages().message("successfully-started"));
    }
}
