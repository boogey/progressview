/**
 * Copyright 2012 Karsten Schulz
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
package com.github.boogey.progressview.swing;

/**
 * This enum contains all properties which generatet from the model classes. In future, it can be change for dynamicly
 * content.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public enum ProgressProperties
{
    /**
     * Minimum property
     */
    MINIMUM_PROPERTY,

    /**
     * Maximum property
     */
    MAXIMUM_PROPERTY,

    /**
     * Current value property
     */
    VALUE_PROPERTY,

    /**
     * Indeterminate property
     */
    INDETERMINATE_PROPERTY,

    /**
     * Message property
     */
    MESSAGE_PROPERTY,

    /**
     * Cancel property
     */
    CANCEL_PROPERTY,

    /**
     * Model has changed proptery
     */
    MODEL_PROPERTY;
}
