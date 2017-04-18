/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zeppelin.conf;

import org.apache.commons.configuration.ConfigurationException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bulat on 18.04.2017.
 */
public class DefaultStrategy implements ConfigStrategy {
  private XMLStrategy strategy;
  public DefaultStrategy() {
    strategy = new XMLStrategy();
    for (ZeppelinConfiguration.ConfVars v : ZeppelinConfiguration.ConfVars.values()) {
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
}
