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

import java.beans.PropertyChangeEvent;

import com.github.boogey.progressview.swing.ProgressProperties;
import com.jgoodies.binding.beans.Model;

/**
 * This abstract class contains the basis logic for an {@link ICancelableProgress}.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public abstract class AbstractCancelableProgress
    extends Model
    implements ICancelableProgress
{

    private static final long serialVersionUID = 2247535955027947743L;

    private boolean cancel;

    /**
     * This is the only one constructor to instance an object of {@link AbstractCancelableProgress}.
     */
    public AbstractCancelableProgress()
    {
        cancel = false;
    }

    /**
     * This method set a boolean value to true and fires a {@link PropertyChangeEvent}.
     */
    @Override
    public void setCancel()
    {
        cancel = true;
        firePropertyChange( String.valueOf( ProgressProperties.CANCEL_PROPERTY ), false, true );
    }

    @Override
    public boolean isCancel()
    {
        return cancel;
    }
}
