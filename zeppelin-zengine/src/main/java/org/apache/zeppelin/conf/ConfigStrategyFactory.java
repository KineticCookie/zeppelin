package org.apache.zeppelin.conf;

import org.apache.commons.configuration.ConfigurationException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bulat on 17.04.2017.
 */
public class ConfigStrategyFactory {
  private static final String ZEPPELIN_SITE_XML = "zeppelin-site.xml";
  private static final String ZEPPELIN_SITE_JSON = "zeppelin-site.json";

  static DefaultStrategy defaultStrategy() {
    try {
      return new DefaultStrategy();
    } catch (ConfigurationException | MalformedURLException e) {
      e.printStackTrace();
      return null;
    }
  }

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
