package org.apache.zeppelin.conf;

import org.apache.commons.configuration.tree.ConfigurationNode;

import java.net.URL;
import java.util.List;

/**
 * Created by Bulat on 17.04.2017.
 */
public interface ConfigStrategy {
  double getDouble(String name, double alternative);

  int getInt(String name, int alternative);

  long getLong(String name, long alternative);

  float getFloat(String name, float alternative);

  boolean getBoolean(String name, boolean alternative);

  String getString(String name, String alternative);
}

