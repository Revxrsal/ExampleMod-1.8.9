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
package net.reflxction.example;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.reflxction.example.commons.Settings;
import net.reflxction.example.proxy.IProxy;
import net.reflxction.example.updater.UpdateManager;
import net.reflxction.example.updater.VersionChecker;
import net.reflxction.example.utils.Reference;
import net.reflxction.simplejson.configuration.select.SelectableConfiguration;
import net.reflxction.simplejson.json.JsonFile;

import java.io.File;

/**
 * ExampleMod: The mod template used by all of my mods
 */
@Mod(
        modid = Reference.MOD_ID,
        name = Reference.NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS
)
public class ExampleMod {

    public static final ExampleMod INSTANCE = new ExampleMod();
    // Config for saving data
    private static final SelectableConfiguration CONFIGURATION = SelectableConfiguration.of(
            JsonFile.of(Minecraft.getMinecraft().mcDataDir + File.separator + "config" + File.separator + "example-mod.cfg"));

    // Assign proxies of the mod
    @SidedProxy(

            // Client side proxy
            clientSide = Reference.CLIENT_PROXY,

            // Server side proxy
            serverSide = Reference.SERVER_PROXY
    )
    private static IProxy PROXY;

    // The update manager
    private UpdateManager updateManager = new UpdateManager(true);

    // The version checker
    private VersionChecker checker = new VersionChecker();

    /**
     * Called before the mod is fully initialized
     * <p>
     * Registries: Initiate variables and client command registries
     *
     * @param event Forge's pre-init event
     */
    @EventHandler
    public void onFMLPreInitialization(FMLPreInitializationEvent event) {
        CONFIGURATION.register(Settings.class);
        CONFIGURATION.associate();
        PROXY.preInit(event);
    }

    /**
     * Called when the mod has been fully initialized
     * <p>
     * Registries: Events and client-server command registries
     *
     * @param event Forge's init event
     */
    @EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        PROXY.init(event);
    }

    /**
     * Called after the mod has been successfully initialized
     * <p>
     * Registries: Nothing
     *
     * @param event Forge's post init event
     */
    @EventHandler
    public void onFMLPostInitialization(FMLPostInitializationEvent event) {
        PROXY.postInit(event);
    }

    /**
     * Called after {@link FMLServerAboutToStartEvent} and before {@link FMLServerStartedEvent}.
     *
     * @param event Forge's server-starting lifecycle event
     */
    @EventHandler
    public void onFMLServerStarting(FMLServerStartingEvent event) {
        PROXY.serverStarting(event);
    }

    /**
     * The mod update manager
     *
     * @return An instance of the mod update manager
     */
    public UpdateManager getUpdateManager() {
        return updateManager;
    }

    /**
     * Returns the mod version checker
     * @return The mod's version checker
     */
    public VersionChecker getChecker() {
        return checker;
    }

}
