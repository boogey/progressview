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

import javax.swing.JDialog;

import org.joda.time.DateTime;
import org.joda.time.Interval;

/**
 * This {@link PropertyChangeListener} is the execute element to interrupt a {@link ThreadGroup} and dispose the
 * {@link JDialog}.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public class WindowPropertyListener
    implements PropertyChangeListener
{
    private final JDialog closingWindow;

    private final ThreadGroup interruptThreadGroup;

    /**
     * This constructor need the {@link JDialog} to dispose and the {@link ThreadGroup} to interrupt.
     * 
     * @param closingDialog <br>
     *            the to disposing {@link JDialog}.
     * @param interruptThreadGroup <br>
     *            the to interrupt {@link ThreadGroup}.
     */
    public WindowPropertyListener( final JDialog closingDialog, final ThreadGroup interruptThreadGroup )
    {
        closingWindow = closingDialog;
        this.interruptThreadGroup = interruptThreadGroup;
    }

    /*
     * (non-Javadoc)
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    @Override
    public void propertyChange( final PropertyChangeEvent evt )
    {
        if ( String.valueOf( ProgressProperties.CANCEL_PROPERTY ).equals( evt.getPropertyName() ) )
        {
            DateTime startWaiting = new DateTime();
            DateTime currentTime = new DateTime();
            Interval waitInterval = new Interval( startWaiting, startWaiting.plusSeconds( 1 ) );

            if ( null != interruptThreadGroup )
            {
                while ( 0 == interruptThreadGroup.activeCount() || waitInterval.isAfter( currentTime ) )
                {
                    interruptThreadGroup.interrupt();
                    currentTime = new DateTime();
                }
            }

            closingWindow.dispose();
        }
        else if ( "state".equals( evt.getPropertyName() ) )
        {
            if ( 0 == interruptThreadGroup.activeCount() )
            {
                closingWindow.dispose();
            }
        }
    }
}
