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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.boogey.progressview.model.ICancelableProgress;

/**
 * This {@link ActionListener} handles the cancel button in the progress view.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public class CancelActionListener
    implements ActionListener
{

    private final ICancelableProgress model;

    /**
     * The only one constructor to instance an object of {@link CancelActionListener}. Its need an
     * {@link ICancelableProgress} object.
     * 
     * @param model <br>
     *            the {@link ICancelableProgress} model to set the cancel-flag.
     */
    public CancelActionListener( final ICancelableProgress model )
    {
        this.model = model;
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed( final ActionEvent e )
    {
        model.setCancel();
    }

}
