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
 * Represents a clickable event for the chat
 */
@SuppressWarnings("all")
public class ClickEvent {

    // Represents the string value of the event
    private String value;

    /**
     * The wrapped event action
     *
     * @see Action
     */
    private Action action;

    /**
     * Creates a click event with the given arguments
     *
     * @param value  String value of the event
     * @param action Action of the event
     */
    public ClickEvent(String value, Action action) {
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
     * Sets the event action
     *
     * @param action Action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * Represents all available actions for the click event
     */
    public enum Action {

        // Opens a URL on click
        OPEN_URL(net.minecraft.event.ClickEvent.Action.OPEN_URL),

        // Opens a file on click
        OPEN_FILE(net.minecraft.event.ClickEvent.Action.OPEN_FILE),

        // Runs a specific command on click
        RUN_COMMAND(net.minecraft.event.ClickEvent.Action.RUN_COMMAND),

        // Inserts text into the player's chat box
        SUGGEST_COMMAND(net.minecraft.event.ClickEvent.Action.SUGGEST_COMMAND);

        // Represents the Minecraft action
        private net.minecraft.event.ClickEvent.Action action;

        /**
         * Creates a wrapping instance for the hover event
         *
         * @param action The Minecraft action
         */
        Action(net.minecraft.event.ClickEvent.Action action) {
            this.action = action;
        }

        /**
         * The action
         *
         * @return The non-wrapped Minecraft action
         */
        public net.minecraft.event.ClickEvent.Action getAction() {
            return action;
        }
    }

}
