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

import javax.swing.JProgressBar;

import com.github.boogey.progressview.model.IProgressModelRO;

/**
 * This class contains the logic elements of the notification mechanism of the {@link JProgressBar}. Its the middleware
 * between the model and the view. (MVC)
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public class ProgressPropertyListener
    implements PropertyChangeListener
{

    private final IProgressModelRO model;

    private final JProgressBar observedBar;

    /**
     * This constructor instance an object of {@link ProgressPropertyListener} with the {@link JProgressBar} and the
     * {@link IProgressModelRO}.
     * 
     * @param progressBar <br>
     *            the {@link JProgressBar} that will be updated.
     * @param model <br>
     *            the model as {@link IProgressModelRO}.
     */
    public ProgressPropertyListener( final JProgressBar progressBar, final IProgressModelRO model )
    {
        this.model = model;
        observedBar = progressBar;
    }

    /*
     * (non-Javadoc)
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    @Override
    public void propertyChange( final PropertyChangeEvent evt )
    {
        ProgressProperties property = ProgressProperties.valueOf( evt.getPropertyName() );

        switch ( property )
        {
            case MAXIMUM_PROPERTY:
                observedBar.setMaximum( model.getMaximum() );
                break;
            case MINIMUM_PROPERTY:
                observedBar.setMinimum( model.getMinimum() );
                break;
            case VALUE_PROPERTY:
                observedBar.setValue( model.getValue() );
                break;
            case INDETERMINATE_PROPERTY:
                observedBar.setIndeterminate( model.isIndeterminate() );
                break;
            default:
                break;
        }
    }
}
