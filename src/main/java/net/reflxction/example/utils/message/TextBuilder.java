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

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.reflxction.example.utils.ChatColor;

/**
 * Class which helps creating hover and click messages, also helps coloring text and managing it
 * This uses the builder style, mainly using chaining methods
 */
public class TextBuilder {

    // The original text
    private String originalText;

    private ChatStyle style;

    /**
     * Creates a builder which is ready to add events to the text
     *
     * @param originalText Text to modify on
     */
    public TextBuilder(String originalText) {
        this.originalText = ChatColor.format(originalText);
        this.style = new ChatStyle();
    }

    /**
     * The text without modifications
     *
     * @return The original text without being modified, however chat-formatted (colors)
     */
    public String getOriginalText() {
        return originalText;
    }

    /**
     * Adds a hover event to the message
     *
     * @param event Event object to add
     */
    public TextBuilder setHover(HoverEvent event) {
        style.setChatHoverEvent(new net.minecraft.event.HoverEvent(event.getAction().getAction(), new ChatComponentText(event.getValue())));
        return this;
    }

    /**
     * Adds a click event to the message
     *
     * @param event Event object to add
     */
    public TextBuilder setClick(ClickEvent event) {
        style.setChatClickEvent(new net.minecraft.event.ClickEvent(event.getAction().getAction(), event.getValue()));
        return this;
    }

    /**
     * Appends specific text to the message
     *
     * @param text Text to append
     */
    public TextBuilder append(String text) {
        originalText = originalText.concat(text);
        return this;
    }

    /**
     * Sends the formatted message to the client
     */
    public void send() {
        IChatComponent componentText = new ChatComponentText(originalText)
                .setChatStyle(style);
        if(Minecraft.getMinecraft().thePlayer == null) return; // For safety
        Minecraft.getMinecraft().thePlayer.addChatMessage(componentText);
    }

}
