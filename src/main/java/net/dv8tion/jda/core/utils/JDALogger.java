/*
 *     Copyright 2015-2018 Austin Keener & Michael Ritter & Florian Spieß
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

package net.dv8tion.jda.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.spicord.log.Logger;
import org.spicord.log.LoggerFactory;

/**
 * This class serves as a LoggerFactory for JDA's internals.
 * <p>
 * It also has the utility method {@link #getLazyString(LazyEvaluation)} which is used to lazily construct Strings for Logging.
 */
public class JDALogger
{

    private JDALogger() {}

    /**
     * Will get the {@link org.spicord.log.Logger} with the given log-name.
     *
     * @param  name
     *         The name of the Logger
     *
     * @return Logger with given log name
     */
    public static Logger getLog(String name)
    {
        return LoggerFactory.getLogger(name);
    }

    /**
     * Will get the {@link org.spicord.log.Logger} for the given Class.
     *
     * @param  clazz
     *         The class used for the Logger name
     *
     * @return Logger for given Class
     */
    public static Logger getLog(Class<?> clazz)
    {
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * Utility function to enable logging of complex statements more efficiently (lazy).
     *
     * @param  lazyLambda
     *         The Supplier used when evaluating the expression
     *
     * @return An Object that can be passed to SLF4J's logging methods as lazy parameter
     */
    public static Object getLazyString(LazyEvaluation lazyLambda)
    {
        return new Object()
        {
            @Override
            public String toString()
            {
                try
                {
                    return lazyLambda.getString();
                }
                catch (Exception ex)
                {
                    StringWriter sw = new StringWriter();
                    ex.printStackTrace(new PrintWriter(sw));
                    return "Error while evaluating lazy String... " + sw.toString();
                }
            }
        };
    }

    /**
     * Functional interface used for {@link #getLazyString(LazyEvaluation)} to lazily construct a String.
     */
    @FunctionalInterface
    public interface LazyEvaluation
    {
        /**
         * This method is used by {@link #getLazyString(LazyEvaluation)}
         * when SLF4J requests String construction.
         * <br>The String returned by this is used to construct the log message.
         *
         * @throws Exception
         *         To allow lazy evaluation of methods that might throw exceptions
         *
         * @return The String for log message
         */
        String getString() throws Exception;
    }
}

