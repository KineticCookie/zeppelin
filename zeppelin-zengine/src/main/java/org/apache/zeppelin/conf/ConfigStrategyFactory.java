package org.apache.zeppelin.conf;

import org.apache.commons.configuration.ConfigurationException;

import java.net.URL;

/**
 * Created by Bulat on 17.04.2017.
 */
public class ConfigStrategyFactory {
    static ConfigStrategy init(URL url) throws ConfigurationException {
        if (url.getFile().endsWith("xml")) {
            return new XMLStrategy(url);
        } else if (url.getFile().endsWith("json")) {
            return new JSONStrategy(url);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
