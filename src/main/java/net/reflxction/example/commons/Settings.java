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
package net.reflxction.example.commons;

import net.reflxction.simplejson.configuration.select.SelectKey;
import net.reflxction.simplejson.configuration.select.SelectionHolder;

/**
 * A class with all commons as constants
 */
public class Settings {

    /**
     * Whether the mod is enabled or not
     */
    @SelectKey("enabled")
    public static final SelectionHolder<Boolean> ENABLED = new SelectionHolder<>(true);

    /**
     * Whether the mod should send updates or check for them
     */
    @SelectKey("sendUpdates")
    public static final SelectionHolder<Boolean> SEND_UPDATES = new SelectionHolder<>(true);

}
