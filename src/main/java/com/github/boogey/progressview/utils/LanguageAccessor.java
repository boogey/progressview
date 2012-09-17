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
package com.github.boogey.progressview.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Internationalise the graphical user interface for different languages.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public class LanguageAccessor
{
    private static final String BUNDLE_NAME = "cfg/progressview"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle( LanguageAccessor.BUNDLE_NAME );

    /**
     * Default constructor.
     */
    private LanguageAccessor()
    {
    }

    /**
     * Return the value of the key.
     * 
     * @param key <br>
     *            the language key
     * @return the value or if not exist "!key!".
     */
    public static String getString( String key )
    {
        try
        {
            return LanguageAccessor.RESOURCE_BUNDLE.getString( key );
        }
        catch ( MissingResourceException e )
        {
            return '!' + key + '!';
        }
    }
}
