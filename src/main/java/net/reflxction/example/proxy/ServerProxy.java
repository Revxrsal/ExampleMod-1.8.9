/*
 * * Copyright 2019 github.com/ReflxctionDev
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
package net.reflxction.example.proxy;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.reflxction.example.commands.ExampleCommand;

public class ServerProxy implements IProxy {

    /**
     * Fml life cycle event for Pre-Initialization. Historically (before registry events)
     * this was where blocks, items, etc. were registered. There are still things
     * like entities and networking which should still be registered here.
     *
     * @param event the event
     */
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new ExampleCommand());
    }

    /**
     * Fml life cycle event for Initialization. This phase is good for registering event listeners, for registering things that depend on things in pre-init from other mods (like
     * recipes, advancements and such.)
     *
     * @param event the event
     */
    @Override
    public void init(FMLInitializationEvent event) {

    }

    /**
     * Fml life cycle event Post Initialization. This phase is useful For doing inter-mod stuff like checking which mods are loaded or if you want a complete view of things across
     * mods like having a list of all registered items to aid random item generation.
     *
     * @param event the event
     */
    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    /**
     * Fml life cycle event. Server commands should be registered here.
     *
     * @param event the event
     */
    @Override
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new ExampleCommand());
    }

}