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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.apache.commons.lang3.ObjectUtils;

import com.github.boogey.progressview.model.IProgressModelRO;

/**
 * This {@link JPanel} contains a simple progress view with an {@link JLabel} for the process message and an
 * {@link JProgressBar} for the progress of the process.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
@SuppressWarnings( "serial" )
public class JProgressPanel
    extends JPanel
{

    private JProgressBar progressBar;

    private JLabel messageLabel;

    private IProgressModelRO model;

    private ProgressPropertyListener progressListener;

    /**
     * Default constructor to instance an object of {@link JProgressPanel}.
     */
    public JProgressPanel()
    {
        initObjects();
    }

    /**
     * This constructor set in addition an {@link IProgressModelRO}.
     * 
     * @param model <br>
     *            the model that will be showed of the {@link JPanel}.
     */
    public JProgressPanel( final IProgressModelRO model )
    {
        this();
        setModel( model );
    }

    /**
     * Initialize the attributes of this classes. This method will be called in the constructor of this class.
     */
    protected void initObjects()
    {
        setLayout( new GridBagLayout() );
        progressBar = new JProgressBar();
        messageLabel = new JLabel();
        positionElements();
    }

    /**
     * Set or change manually the {@link IProgressModelRO}.
     * 
     * @param model <br>
     *            the model that will be showed of the {@link JPanel}.
     */
    public void setModel( final IProgressModelRO model )
    {
        if ( null != model && ObjectUtils.notEqual( this.model, model ) )
        {
            if ( null != this.model )
            {
                this.model.removePropertyChangeListener( progressListener );
            }
            progressListener = new ProgressPropertyListener( progressBar, model );

            this.model = model;
            this.model.addPropertyChangeListener( progressListener );
            progressBar.setMinimum( model.getMinimum() );
            progressBar.setMaximum( model.getMaximum() );
            progressBar.setIndeterminate( model.isIndeterminate() );
            messageLabel.setText( model.getMessage() );
        }
    }

    /**
     * Returns the model of the {@link JPanel}.
     * 
     * @return the {@link IProgressModelRO} that showing in the {@link JPanel}.
     */
    public IProgressModelRO getModel()
    {
        return model;
    }

    /**
     * This protected method set the location of the components ({@link JLabel} and {@link JProgressBar}) on the
     * {@link JPanel}. The layout is set in the {@link #initObjects()}-method. This {@link JPanel} will use an
     * {@link GridBagLayout}.
     */
    protected void positionElements()
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets( 5, 5, 5, 5 );
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        constraints.weighty = 0.0;

        constraints.gridx = 0;
        constraints.gridy = 0;
        positionMessage( constraints );

        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.gridy = 1;
        positionProgressBar( constraints );
    }

    /**
     * This protected method set the location of the message label under a specify {@link GridBagConstraints}.
     * 
     * @param constraints <br>
     *            the constraint to specify the position of the {@link JLabel}.
     */
    protected void positionMessage( final GridBagConstraints constraints )
    {
        add( messageLabel, constraints );
    }

    /**
     * This protected method set the location of the progress bar under a specify {@link GridBagConstraints}.
     * 
     * @param constraints <br>
     *            the constraint to specify the position of the {@link JProgressBar}.
     */
    protected void positionProgressBar( final GridBagConstraints constraints )
    {
        add( progressBar, constraints );
    }
}
