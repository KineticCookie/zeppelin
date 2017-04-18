package org.apache.zeppelin.conf;


/**
 * Created by Bulat on 17.04.2017.
 */
public interface ConfigStrategy {
  int getInt(String name, int alternative);

  long getLong(String name, long alternative);

  float getFloat(String name, float alternative);

  boolean getBoolean(String name, boolean alternative);

  String getString(String name, String alternative);
}

