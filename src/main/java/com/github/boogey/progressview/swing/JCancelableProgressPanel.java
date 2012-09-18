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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.boogey.progressview.model.CancelableSwingWorkers;
import com.github.boogey.progressview.model.ICancelableProgressRO;
import com.github.boogey.progressview.model.IProgressModelRO;
import com.github.boogey.progressview.util.LanguageAccessor;

/**
 * This class represented an cancelable progress panel and contains a {@link JProgressPanel}.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public class JCancelableProgressPanel
    extends JPanel
{

    private static final long serialVersionUID = 7316733741780252690L;

    private JButton cancelButton;

    private JProgressPanel progessPanel;

    private ICancelableProgressRO model;

    /**
     * The default constructor.
     */
    public JCancelableProgressPanel()
    {
        super();
        initObjects();
    }

    /**
     * The constructor to specify an model as {@link ICancelableProgressRO}.
     * 
     * @param model <br>
     *            the cancelable progress model as {@link ICancelableProgressRO}.
     */
    public JCancelableProgressPanel( final ICancelableProgressRO model )
    {
        this();
        setModel( model );
    }

    protected void initObjects()
    {
        setLayout( new GridBagLayout() );
        cancelButton = new JButton( LanguageAccessor.getString("ProgressView.cancelbutton") ); //$NON-NLS-1$
        model = new CancelableSwingWorkers( null );
        progessPanel = new JProgressPanel();
        positionElements();
    }

    protected void positionElements()
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets( 5, 5, 5, 5 );
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 3;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        constraints.gridx = 0;
        constraints.gridy = 0;
        add( progessPanel, constraints );

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridwidth = 1;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        positionCancelButton( constraints );
    }

    protected void positionCancelButton( final GridBagConstraints constraints )
    {
        add( cancelButton, constraints );
    }

    /**
     * Set the {@link IProgressModelRO} for the {@link JProgressPanel} and delegate this method to the
     * {@link JProgressPanel#setModel(IProgressModelRO)}.
     * 
     * @param model <br>
     *            the {@link IProgressModelRO} model to view in the panel.
     */
    public void setProgressModel( final IProgressModelRO model )
    {
        progessPanel.setModel( model );
    }

    /**
     * Set the {@link ICancelableProgressRO} for the {@link JCancelableProgressPanel} and fire a
     * {@link PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)}.
     * 
     * @param model <br>
     *            the {@link ICancelableProgressRO} model to cancel.
     */
    public void setModel( final ICancelableProgressRO model )
    {
        if ( null != model )
        {
            ICancelableProgressRO oldModel = this.model;
            this.model = model;
            firePropertyChange( String.valueOf( ProgressProperties.MODEL_PROPERTY ), oldModel, model );
        }
    }

    /**
     * Returns the {@link ICancelableProgressRO}.
     * 
     * @return an object reference as {@link ICancelableProgressRO}.
     */
    public ICancelableProgressRO getModel()
    {
        return model;
    }

    /**
     * Return the {@link IProgressModelRO} from the {@link JProgressPanel}.
     * 
     * @return an object reference as {@link IProgressModelRO} from {@link JProgressPanel}.
     */
    public IProgressModelRO getProgressModel()
    {
        return progessPanel.getModel();
    }

    /**
     * Add an {@link ActionListener} to the {@link JButton} for the cancel option
     * 
     * @param al <br>
     *            an object reference of an {@link ActionListener}.
     */
    public void addCancelButtonListener( ActionListener al )
    {
        cancelButton.addActionListener( al );
    }

    /**
     * Remove an existing {@link ActionListener} from the {@link JButton} for the cancel option
     * 
     * @param al <br>
     *            an existing object reference to an {@link ActionListener}.
     */
    public void removeCancelButtonListener( ActionListener al )
    {
        cancelButton.removeActionListener( al );
    }
}
