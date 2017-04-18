package org.apache.zeppelin.conf;

import org.apache.commons.configuration.ConfigurationException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bulat on 18.04.2017.
 */
public class DefaultStrategy extends XMLStrategy implements ConfigStrategy {
  public DefaultStrategy() throws ConfigurationException, MalformedURLException {
    super(new URL(""));
  }

  @Override
  public double getDouble(String name, double alternative) {
    return 0;
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

  void setDefaults(ZeppelinConfiguration.ConfVars[] values) {
    for (ZeppelinConfiguration.ConfVars v : values) {
      if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.BOOLEAN) {
        this.setProperty(v.getVarName(), v.getBooleanValue());
      } else if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.LONG) {
        this.setProperty(v.getVarName(), v.getLongValue());
      } else if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.INT) {
        this.setProperty(v.getVarName(), v.getIntValue());
      } else if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.FLOAT) {
        this.setProperty(v.getVarName(), v.getFloatValue());
      } else if (v.getType() == ZeppelinConfiguration.ConfVars.VarType.STRING) {
        this.setProperty(v.getVarName(), v.getStringValue());
      } else {
        throw new RuntimeException("Unsupported VarType");
      }
    }
  }
}
