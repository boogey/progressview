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

import java.util.List;

import javax.swing.SwingWorker;

/**
 * This default class of the {@link AbstractCancelableProgress} contains a {@link ThreadGroup} which can be handle. For
 * example it can be interrupt or so.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public class CancelableSwingWorkers
    extends AbstractCancelableProgress
{

    private static final long serialVersionUID = -2430853713227256185L;

    private final List<SwingWorker<?, ?>> runableThreadGroup;

    /**
     * This constructor is the only one to instance an object of this class. Its need a reference of an object from
     * class {@link ThreadGroup}.
     * 
     * @param threadGroup <br>
     *            an object reference of an {@link ThreadGroup}.
     */
    public CancelableSwingWorkers( List<SwingWorker<?, ?>> threadGroup )
    {
        runableThreadGroup = threadGroup;
    }

    /**
     * Returns the object reference of a {@link ThreadGroup}.
     * 
     * @return the {@link ThreadGroup}
     */
    public List<SwingWorker<?, ?>> getRunableThreadGroup()
    {
        return runableThreadGroup;
    }

}
