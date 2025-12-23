package ua.nanit.limbo.command;

import ua.nanit.limbo.NanoLimboBungee;

import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.exception.SendMessageException;

@Command("limbohelp")
public class HelpCommand {
    @Dependency
    private NanoLimboBungee plugin;

    @Default
    public void execute(CommandActor actor) {
        throw new SendMessageException(plugin.getLimboConfig().getMessages().message("help"));
    }
}
