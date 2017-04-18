package org.apache.zeppelin.conf;

import org.apache.commons.configuration.ConfigurationException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bulat on 18.04.2017.
 */
public class DefaultStrategy implements ConfigStrategy {
  private XMLStrategy strategy;
  public DefaultStrategy() throws MalformedURLException, ConfigurationException {
    strategy = new XMLStrategy(new URL(""));
  }

  @Override
  public int getInt(String name, int alternative) {
    return strategy.getInt(name, alternative);
  }

  @Override
  public long getLong(String name, long alternative) {
    return strategy.getLong(name, alternative);
  }

  @Override
  public float getFloat(String name, float alternative) {
    return strategy.getFloat(name, alternative);
  }

  @Override
  public boolean getBoolean(String name, boolean alternative) {
    return strategy.getBoolean(name, alternative);
  }

  @Override
  public String getString(String name, String alternative) {
    return strategy.getString(name, alternative);
  }

  void setDefaults(ZeppelinConfiguration.ConfVars[] values) {
    for (ZeppelinConfiguration.ConfVars v : values) {
      if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.BOOLEAN) {
        strategy.setProperty(v.getVarName(), v.getBooleanValue());
      } else if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.LONG) {
        strategy.setProperty(v.getVarName(), v.getLongValue());
      } else if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.INT) {
        strategy.setProperty(v.getVarName(), v.getIntValue());
      } else if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.FLOAT) {
        strategy.setProperty(v.getVarName(), v.getFloatValue());
      } else if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.STRING) {
        strategy.setProperty(v.getVarName(), v.getStringValue());
      } else {
        throw new RuntimeException("Unsupported VarType");
      }
    }
  }
}
