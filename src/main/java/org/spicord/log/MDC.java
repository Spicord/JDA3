package org.spicord.log;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class MDC {

    public static class MDCCloseable implements AutoCloseable {
        private String key;

        MDCCloseable(String key) {
            this.key = key;
        }

        @Override
        public void close() {
            contextMap.get().remove(key);
        }
    }

    private static final ThreadLocal<Map<String, String>> contextMap = new ThreadLocal<Map<String, String>>() {
        @Override
        protected Map<String,String> initialValue() {
            return new HashMap<>();
        }
    };

    public static void put(String key, String val) {
        MDC.contextMap.get().put(key, val);
    }

    public static void setContextMap(ConcurrentMap<String, String> contextMap) {
        MDC.contextMap.set(contextMap);
    }

    public static Map<String, String> getCopyOfContextMap() {
        return new HashMap<>(MDC.contextMap.get());
    }

    public static MDCCloseable putCloseable(String key, String val) {
        MDC.contextMap.get().put(key, val);
        return new MDCCloseable(key);
    }
}
