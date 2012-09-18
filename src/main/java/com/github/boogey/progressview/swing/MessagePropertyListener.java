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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;

/**
 * This {@link PropertyChangeListener} contains the logic to update the message label.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public class MessagePropertyListener
    implements PropertyChangeListener
{

    private final JLabel label;

    /**
     * Default constructor to instance an {@link JLabel}
     * 
     * @param label <br>
     *            the gui component to update as {@link JLabel}
     */
    public MessagePropertyListener( JLabel label )
    {
        this.label = label;
    }

    /*
     * (non-Javadoc)
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    @Override
    public void propertyChange( PropertyChangeEvent evt )
    {
        ProgressProperties property = ProgressProperties.valueOf( evt.getPropertyName() );

        switch ( property )
        {
            case MESSAGE_PROPERTY:
                label.setText( String.valueOf( evt.getNewValue() ) );
                break;
            default:
                break;
        }
    }

}
