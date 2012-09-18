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
import java.util.List;

import javax.swing.JDialog;
import javax.swing.SwingWorker;

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

    private final List<SwingWorker<?, ?>> interruptSwingWorkers;

    /**
     * This constructor need the {@link JDialog} to dispose and the {@link ThreadGroup} to interrupt.
     * 
     * @param closingDialog <br>
     *            the to disposing {@link JDialog}.
     * @param interruptThreadGroup <br>
     *            the to interrupt {@link ThreadGroup}.
     */
    public WindowPropertyListener( final JDialog closingDialog, final List<SwingWorker<?, ?>> interruptThreadGroup )
    {
        closingWindow = closingDialog;
        interruptSwingWorkers = interruptThreadGroup;
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
            if ( null != interruptSwingWorkers )
            {
                for ( SwingWorker<?, ?> worker : interruptSwingWorkers )
                {
                    worker.cancel( true );
                }
            }

            closingWindow.dispose();
        }
    }
}
