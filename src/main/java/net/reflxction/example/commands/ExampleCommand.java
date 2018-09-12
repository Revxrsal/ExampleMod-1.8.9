/*
 * * Copyright 2018 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.reflxction.example.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.reflxction.example.ExampleMod;
import net.reflxction.example.commons.Multithreading;
import net.reflxction.example.commons.Settings;
import net.reflxction.example.utils.SimpleSender;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class which handles command input for "/example"
 */
public class ExampleCommand implements ICommand {

    /**
     * Gets the name of the command
     */
    @Override
    public String getCommandName() {
        return "example";
    }

    /**
     * Gets the usage string for the command.
     *
     * @param sender The command sender that executed the command
     */
    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/example <toggle / check / update>";
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("ex");
    }

    /**
     * Callback when the command is invoked
     *
     * @param sender The command sender that executed the command
     * @param args   The arguments that were passed
     */
    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        switch (args.length) {
            case 0:
                SimpleSender.send("&cIncorrect command usage. Try " + getCommandUsage(sender));
                break;
            case 1:
                switch (args[0]) {
                    case "toggle":
                        Settings.ENABLED.set(!Settings.ENABLED.get());
                        SimpleSender.send(Settings.ENABLED.get() ? "&aExampleMod has been enabled" : "&cExampleMod has been disabled");
                        break;
                    case "update":
                        if (ExampleMod.INSTANCE.getChecker().isUpdateAvailable()) {
                            Multithreading.runAsync(() -> {
                                if (ExampleMod.INSTANCE.getUpdateManager().updateMod()) {
                                    SimpleSender.send("&aSuccessfully updated the mod! Restart your game to see changes.");
                                } else {
                                    SimpleSender.send("&cFailed to update mod! To avoid any issues, delete the mod jar and install it manually again.");
                                }
                            });
                        } else {
                            SimpleSender.send("&cNo updates found. You're up to date!");
                        }
                        break;
                    case "check":
                        Settings.SEND_UPDATES.set(!Settings.SEND_UPDATES.get());
                        SimpleSender.send(Settings.SEND_UPDATES.get() ? "&aYou will be notified on updates" : "&cYou will no longer be notified on updates");
                        break;
                    default:
                        SimpleSender.send("&cIncorrect command usage. Try " + getCommandUsage(sender));
                        break;
                }
                break;
        }
    }

    /**
     * Returns true if the given command sender is allowed to use this command.
     *
     * @param sender The command sender that executed the command
     */
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return Arrays.asList("toggle", "check", "update");
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     *
     * @param args  The arguments that were passed
     * @param index Argument index to check
     */
    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }

}
