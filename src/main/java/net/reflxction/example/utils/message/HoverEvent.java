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
package net.reflxction.example.utils.message;

/**
 * Represents a hover-able event for the chat
 */
@SuppressWarnings("all")
public class HoverEvent {

    // Represents the event value
    private String value;

    /**
     * Represents the event action
     *
     * @see Action
     */
    private Action action;

    /**
     * Creates a hover event with the given values
     *
     * @param value  The event value
     * @param action The event action
     */
    public HoverEvent(String value, Action action) {
        this.value = value;
        this.action = action;
    }

    /**
     * The text value
     *
     * @return The text value of the event
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the event value
     *
     * @param value Value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * The event action
     *
     * @return The wrapped even action
     */
    public Action getAction() {
        return action;
    }

    /**
     * Represents all available actions for hovering
     */
    public enum Action {

        // Show text when hovering over the text
        SHOW_TEXT(net.minecraft.event.HoverEvent.Action.SHOW_TEXT),

        // Show an achievement when hovering over the text
        SHOW_ACHIEVEMENT(net.minecraft.event.HoverEvent.Action.SHOW_ACHIEVEMENT),

        // Show an item information (name, lore, enchantments, etc.) when hovering over the text
        SHOW_ITEM(net.minecraft.event.HoverEvent.Action.SHOW_ITEM),

        // Shows entity information (name, UUID, etc.) when hovering over the text
        SHOW_ENTITY(net.minecraft.event.HoverEvent.Action.SHOW_ENTITY);

        // The Minecraft action
        private net.minecraft.event.HoverEvent.Action action;

        /**
         * Creates a wrapping instance for the hover event
         *
         * @param action The Minecraft action
         */
        Action(net.minecraft.event.HoverEvent.Action action) {
            this.action = action;
        }

        /**
         * The action
         *
         * @return The non-wrapped Minecraft action
         */
        public net.minecraft.event.HoverEvent.Action getAction() {
            return action;
        }
    }

}
