package org.apache.zeppelin.ruby;

import org.apache.commons.exec.DefaultExecutor;
import org.apache.zeppelin.interpreter.Interpreter;
import org.apache.zeppelin.interpreter.InterpreterContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

public class RubyInterpreter extends Interpreter{
    private static final Logger LOGGER = LoggerFactory.getLogger(RubyInterpreter.class);
    private static final String TIMEOUT_PROPERTY = "shell.command.timeout.millisecs";

    ConcurrentHashMap<String, DefaultExecutor> executors;
    @Override
    public void close() {}
    @Override
    public void cancel(InterpreterContext context) {
        DefaultExecutor executor = executors.remove(context.getParagraphId());
        if (executor != null) {
            executor.getWatchdog().destroyProcess();
        }
    }
}
