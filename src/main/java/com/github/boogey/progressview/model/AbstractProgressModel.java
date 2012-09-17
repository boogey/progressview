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

import java.beans.PropertyChangeListener;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.github.boogey.progressview.swing.ProgressProperties;
import com.jgoodies.binding.beans.Model;

/**
 * This abstract class extends from {@link Model} and implements the mutable interface {@link IProgressModel}. This
 * class is the basic implementation for the swing listener model. The inheritance from the {@link Model} class allowed
 * to add and remove {@link PropertyChangeListener} and protected fire-method to notify the observers.
 * 
 * @author Karsten Schulz <a href="mailto:lennylinux.ks@googlmail.com">(lennylinux.ks@googlmail.com)</a>
 */
public abstract class AbstractProgressModel
    extends Model
    implements IProgressModel
{

    private static final long serialVersionUID = -8052266737621492877L;

    private int min;

    private int max;

    private int value;

    private String message;

    /**
     * Default constructor with basic initializations. The range between minimum and maximum is 100 and starts from zero
     * and the default message is blank.
     */
    public AbstractProgressModel()
    {
        this( 0, 100, 0, "" );
    }

    /**
     * This constructor allowed to specify the <code>min</code>, <code>max</code> and <code>startValue</code>.
     * 
     * @param min <br>
     *            the non negative integer data type.
     * @param max <br>
     *            the non negative integer data type.
     * @param startValue <br>
     *            the non negative integer data type between <code>min</code> and <code>max</code> as start value.
     */
    public AbstractProgressModel( final int min, final int max, final int startValue )
    {
        this( min, max, startValue, "" );
    }

    /**
     * This constructor extends the default constructor with <code>min</code>, <code>max</code>, <code>startValue</code>
     * and a <code>startMessage</code>.
     * 
     * @param min <br>
     *            the non negative integer data type.*
     * @param max <br>
     *            the non negative integer data type.
     * @param startValue <br>
     *            the non negative integer data type between <code>min</code> and <code>max</code> as start value.
     * @param startMessage <br>
     *            a {@link String} to set the start message (for example "init")
     */
    public AbstractProgressModel( final int min, final int max, final int startValue, final String startMessage )
    {
        setMinAndMax( min, max );
        setValue( startValue );
        setMessage( startMessage );
    }

    /**
     * Set the minimum value of the progress range. This minimum must be less than the current maximum value. This
     * method fire a notification for the observers.
     * 
     * @param min <br>
     *            this integer data type must be a positive number.
     */
    @Override
    public void setMinimum( final int min )
    {
        checkNumberRange( ProgressProperties.MINIMUM_PROPERTY, min );

        if ( this.min != min )
        {
            int oldMin = this.min;
            this.min = min;
            firePropertyChange( String.valueOf( ProgressProperties.MINIMUM_PROPERTY ), oldMin, min );
        }
    }

    /**
     * Set the maximum value of the progress range. This maximum must be greater than the current minimum value. This
     * method fire a notification for the observers.
     * 
     * @param max <br>
     *            this integer data type must be a positive number.
     */
    @Override
    public void setMaximum( final int max )
    {
        checkNumberRange( ProgressProperties.MAXIMUM_PROPERTY, max );

        if ( this.max != max )
        {
            int oldMax = this.max;
            this.max = max;
            firePropertyChange( String.valueOf( ProgressProperties.MAXIMUM_PROPERTY ), oldMax, max );
        }
    }

    /*
     * (non-Javadoc)
     * @see com.github.boogey.someutils.swing.IProgressModel#getMinimum()
     */
    @Override
    public int getMinimum()
    {
        return min;
    }

    /*
     * (non-Javadoc)
     * @see com.github.boogey.someutils.swing.IProgressModel#getMaximum()
     */
    @Override
    public int getMaximum()
    {
        return max;
    }

    /**
     * Set the minimum and maximum value of the progress range. This method solve the problem with the dependency
     * between {@link #setMaximum(int)} and {@link #setMinimum(int)}. This method checks only if the new maximum value
     * greater than the new minimum value. The <code>min</code> param must be less than the <code>max</code> param of
     * this method.
     * 
     * @param min <br>
     *            this integer data type must be a positive number.
     * @param max <br>
     *            this integer data type must be a positive number.
     */
    @Override
    public void setMinAndMax( final int min, final int max )
    {
        if ( min > max )
        {
            throw new IllegalArgumentException( String.format( "the max (%d) value must be greater than the min (%d) "
                + "value", Integer.valueOf( max ), Integer.valueOf( min ) ) );
        }

        if ( max > Integer.MAX_VALUE )
        {
            throw new IllegalArgumentException( String.format( "the max (%d) value must be equal less than the "
                + "maximum integer value", Integer.valueOf( max ), Integer.valueOf( min ) ) );
        }

        boolean indeterminate = checkIndeterminate( this.min, this.max );
        boolean newIndeterminate = checkIndeterminate( min, max );

        if ( indeterminate && newIndeterminate )
        {
            // nothing to do;
            return;
        }

        this.min = min;
        this.max = max;

        if ( indeterminate != newIndeterminate )
        {
            firePropertyChange( String.valueOf( ProgressProperties.INDETERMINATE_PROPERTY ), indeterminate,
                                newIndeterminate );
        }
    }

    /*
     * (non-Javadoc)
     * @see com.github.boogey.someutils.swing.IProgressModel#setValue(int)
     */
    @Override
    public void setValue( final int value )
    {
        checkNumberRange( ProgressProperties.VALUE_PROPERTY, value );

        if ( this.value != value )
        {
            int oldValue = this.value;
            this.value = value;
            firePropertyChange( String.valueOf( ProgressProperties.VALUE_PROPERTY ), oldValue, value );
        }
    }

    /*
     * (non-Javadoc)
     * @see com.github.boogey.someutils.swing.IProgressModel#getValue()
     */
    @Override
    public int getValue()
    {
        return value;
    }

    /**
     * Set the message of the current process. If the message is <code>null</code> than the message is blank. This
     * method fire a notification for the observers.
     * 
     * @param message <br>
     *            the message param is a {@link String}
     */
    @Override
    public void setMessage( String message )
    {
        if ( !StringUtils.equals( this.message, message ) )
        {
            String oldMessage = this.message;
            this.message = ObjectUtils.defaultIfNull( message, "" );
            firePropertyChange( String.valueOf( ProgressProperties.MESSAGE_PROPERTY ), oldMessage, message );
        }
    }

    /*
     * (non-Javadoc)
     * @see com.github.boogey.someutils.swing.IProgressModel#getMessage()
     */
    @Override
    public String getMessage()
    {
        return message;
    }

    /*
     * (non-Javadoc)
     * @see com.github.boogey.someutils.swing.IProgressModel#getIndeterminate()
     */
    @Override
    public boolean isIndeterminate()
    {
        return checkIndeterminate( min, max );
    }

    private static boolean checkIndeterminate( final int minValue, final int maxValue )
    {
        return minValue == maxValue;
    }

    private void checkNumberRange( final ProgressProperties property, final int numberValue )
    {
        boolean checkVariable;
        String throwMessage;
        switch ( property )
        {
            case MINIMUM_PROPERTY:
                checkVariable = max <= numberValue && numberValue >= 0;
                throwMessage =
                    String.format( "value (%d) is greater than the current max value (%d) or less than zero",
                                   Integer.valueOf( numberValue ), Integer.valueOf( max ) );
                break;
            case MAXIMUM_PROPERTY:
                checkVariable = min <= numberValue && numberValue >= 0;
                throwMessage =
                    String.format( "value (%d) is less than the current min value (%d) or less than zero",
                                   Integer.valueOf( numberValue ), Integer.valueOf( min ) );
                break;
            case VALUE_PROPERTY:
                checkVariable = min <= numberValue && numberValue <= max;
                throwMessage =
                    String.format( "value (%d) is less than the current min value (%d) or greater than the current max value (%d)",
                                   Integer.valueOf( numberValue ), Integer.valueOf( min ), Integer.valueOf( max ) );
                break;
            default:
                checkVariable = false;
                throwMessage = String.format( "property (%s) is not an integer datatype", property );
                break;
        }

        if ( !checkVariable )
        {
            throw new IllegalArgumentException( throwMessage );
        }
    }
}
