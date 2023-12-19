//
// Copyright Aliaksei Levin (levlam@telegram.org), Arseny Smirnov (arseny30@gmail.com) 2014-2023
//
// Distributed under the Boost Software License, Version 1.0. (See accompanying
// file LICENSE_1_0.txt or copy at http://www.boost.org/LICENSE_1_0.txt)
//
package org.drinkless.tdlib;

import java.io.IOError;
import java.io.IOException;

import org.amuradon.tralon.sigpron.telegram.handlers.DefaultLogMessageHandler;

/**
 * Main class for interaction with the TDLib.
 */
public final class Client {
    static {
        try {
            System.loadLibrary("tdjni");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    /**
     * Interface for handler of messages that are added to the internal TDLib log.
     */
    public interface LogMessageHandler {
        /**
         * Callback called on messages that are added to the internal TDLib log.
         *
         * @param verbosityLevel Log verbosity level with which the message was added from -1 up to 1024.
         *                       If 0, then TDLib will crash as soon as the callback returns.
         *                       None of the TDLib methods can be called from the callback.
         * @param message        The message added to the internal TDLib log.
         */
        void onLogMessage(int verbosityLevel, String message);
    }

    /**
     * Exception class thrown when TDLib error occurred while performing {@link #execute(TdApi.Function)}.
     */
    public static class ExecutionException extends Exception {
        /**
         * Original TDLib error occurred when performing one of the synchronous functions.
         */
        public final TdApi.Error error;

        /**
         * @param error TDLib error occurred while performing {@link #execute(TdApi.Function)}.
         */
        ExecutionException (TdApi.Error error) {
            super(error.code + ": " + error.message);
            this.error = error;
        }
    }

    public static void configureTdlibLogging() {
    	 // set log message handler to handle only fatal errors (0) and plain log messages (-1)
    	nativeClientSetLogMessageHandler(0, new DefaultLogMessageHandler());

        // disable TDLib log and redirect fatal errors and plain log messages to a file
        try {
        	execute(new TdApi.SetLogVerbosityLevel(0));
        	execute(new TdApi.SetLogStream(new TdApi.LogStreamFile("tdlib.log", 1 << 27, false)));
        } catch (ExecutionException error) {
            throw new IOError(new IOException("Write access to the current directory is required"));
        }
    }
    
    /**
     * Synchronously executes a TDLib request. Only a few marked accordingly requests can be executed synchronously.
     *
     * @param query Object representing a query to the TDLib.
     * @param <T> Automatically deduced return type of the query.
     * @return request result.
     * @throws ExecutionException if query execution fails.
     */
    private static <T extends TdApi.Object> T execute(TdApi.Function<T> query) throws ExecutionException {
        TdApi.Object object = nativeClientExecute(query);
        if (object instanceof TdApi.Error) {
            throw new ExecutionException((TdApi.Error) object);
        }
        //noinspection unchecked
        return (T) object;
    }

    public static native int createNativeClient();

    public static native void nativeClientSend(int nativeClientId, long eventId, TdApi.Function function);

    public static native int nativeClientReceive(int[] clientIds, long[] eventIds, TdApi.Object[] events, double timeout);

    public static native TdApi.Object nativeClientExecute(TdApi.Function function);

    public static native void nativeClientSetLogMessageHandler(int maxVerbosityLevel, LogMessageHandler logMessageHandler);
}
