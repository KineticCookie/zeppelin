package org.apache.zeppelin.conf;

import java.net.URL;

/**
 * Created by Bulat on 17.04.2017.
 */
public class JSONStrategy implements ConfigStrategy {
  public JSONStrategy(URL url) {

  }

  @Override
  public int getInt(String name, int alternative) {
    return 0;
  }

  @Override
  public long getLong(String name, long alternative) {
    return 0;
  }

  @Override
  public float getFloat(String name, float alternative) {
    return 0;
  }

  @Override
  public boolean getBoolean(String name, boolean alternative) {
    return false;
  }

  @Override
  public String getString(String name, String alternative) {
    return null;
  }
}
