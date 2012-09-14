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
package com.github.boogey.progressview.model;

import com.jgoodies.common.bean.ObservableBean2;

/**
 * This interface contains read-only method to get the information for the graphical user interface.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public interface IProgressModelRO
    extends ObservableBean2
{
    /**
     * Returns the indeterminate state of the minimum and maximum value.
     * 
     * @return <code>true</code> if the range have a indeterminate state.
     */
    boolean isIndeterminate();

    /**
     * Returns the minimum value.
     * 
     * @return an integer data type with the minimum value.
     */
    int getMinimum();

    /**
     * Returns the maximum value.
     * 
     * @return an integer data type with the maximum value.
     */
    int getMaximum();

    /**
     * Returns the current process value between the minimum and the maximum value.
     * 
     * @return an integer data type with the current value.
     * @see #getMinimum()
     * @see #getMaximum()
     */
    int getValue();

    /**
     * Returns the message from the process to show in the graphical user interface.
     * 
     * @return a {@link String} with the message.
     */
    String getMessage();

}