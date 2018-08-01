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
package net.reflxction.example.settings;

import net.reflxction.example.ExampleMod;

/**
 * Class which contains and manages all the mod settings (while saving it to config etc)
 */
public class Settings {

    // Whether the mod is enabled or not
    private boolean enabled;

    // Whether the mod should send a notification to the player if an update is available
    private boolean sendUpdateNotifications;

    // Assign all variables
    public Settings() {
        enabled = ExampleMod.getConfig().get("Enabled", "Enabled", true).getBoolean();
        sendUpdateNotifications = ExampleMod.getConfig().get("Settings", "SendUpdate", true).getBoolean();
    }

    /**
     * Whether the mod is enabled or not
     *
     * @return True if the mod is enabled, false if not
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets whether the mod is enabled or not
     *
     * @param enabled Boolean to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        ExampleMod.getConfig().get("Enabled", "Enabled", true).set(enabled);
        ExampleMod.getConfig().save();
    }

    /**
     * Whether the mod should send notifications if an update is available
     *
     * @return ^
     */
    public boolean sendNotification() {
        return sendUpdateNotifications;
    }

    /**
     * Sets whether the mod should notifications if an update is available
     *
     * @param flag Boolean to set
     */
    public void setSendNotification(boolean flag) {
        this.sendUpdateNotifications = flag;
        ExampleMod.getConfig().get("Settings", "SendUpdates", true).set(flag);
        ExampleMod.getConfig().save();
    }
}
