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
 * This interface extends the read-only interface with the setter method to change the informations from another class.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public interface IProgressModel
    extends IProgressModelRO
{

    /**
     * Set the minimum value of the progress range.
     * 
     * @param min <br>
     *            this integer data type must be a positive number.
     */
    void setMinimum( int min );

    /**
     * Set the maximum value of the progress range.
     * 
     * @param max <br>
     *            this integer data type must be a positive number.
     */
    void setMaximum( int max );

    /**
     * Set the minimum and maximum value of the progress range. This method solve the problem with the dependency
     * between {@link #setMaximum(int)} and {@link #setMinimum(int)}. The <code>min</code> param must be less than the
     * <code>max</code> param of this method.
     * 
     * @param min <br>
     *            this integer data type must be a positive number.
     * @param max <br>
     *            this integer data type must be a positive number.
     */
    void setMinAndMax( int min, int max );

    /**
     * Set the current value of the process. This value should be locate between the <code>min</code> and
     * <code>max</code> value.
     * 
     * @param value <br>
     *            this integer data type must be a positive number between the <code>min</code> and <code>max</code>
     *            value.
     */
    void setValue( int value );

    /**
     * Set the message of the current process.
     * 
     * @param message <br>
     *            the message param is a {@link String}
     */
    void setMessage( String message );

}