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

/**
 * This class is a concrete {@link IProgressModel} to observe and get the information.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public class DefaultProgressModel
    extends AbstractProgressModel
{

    private static final long serialVersionUID = -1453524023603051763L;

    /**
     * Default constructor and calls the base class constructor.
     * 
     * @see AbstractProgressModel#AbstractProgressModel()
     */
    public DefaultProgressModel()
    {
        super();
    }

    /**
     * This constructor calls the base class constructor.
     * 
     * @see AbstractProgressModel#AbstractProgressModel(int, int, int)
     */
    public DefaultProgressModel( final int min, final int max, final int startValue, final String startMessage )
    {
        super( min, max, startValue, startMessage );
    }

    /**
     * This constructor calls the base class constructor.
     * 
     * @see AbstractProgressModel#AbstractProgressModel(int, int, int, String)
     */
    public DefaultProgressModel( final int min, final int max, final int startValue )
    {
        super( min, max, startValue );
    }

}
