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
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.ConfigurationNode;

import java.net.URL;
import java.util.List;

/**
 * Created by Bulat on 17.04.2017.
 */
public class XMLStrategy extends XMLConfiguration implements ConfigStrategy {
  @Override
  public String getString(String name, String d) {
    List<ConfigurationNode> properties = getRootNode().getChildren();
    if (properties == null || properties.isEmpty()) {
      return d;
    }
    for (ConfigurationNode p : properties) {
      if (p.getChildren("name") != null && !p.getChildren("name").isEmpty()
        && name.equals(p.getChildren("name").get(0).getValue())) {
        return (String) p.getChildren("value").get(0).getValue();
      }
    }
    return d;
  }

  @Override
  public int getInt(String name, int d) {
    List<ConfigurationNode> properties = getRootNode().getChildren();
    if (properties == null || properties.isEmpty()) {
      return d;
    }
    for (ConfigurationNode p : properties) {
      if (p.getChildren("name") != null && !p.getChildren("name").isEmpty()
        && name.equals(p.getChildren("name").get(0).getValue())) {
        return Integer.parseInt((String) p.getChildren("value").get(0).getValue());
      }
    }
    return d;
  }

  @Override
  public long getLong(String name, long d) {
    List<ConfigurationNode> properties = getRootNode().getChildren();
    if (properties == null || properties.isEmpty()) {
      return d;
    }
    for (ConfigurationNode p : properties) {
      if (p.getChildren("name") != null && !p.getChildren("name").isEmpty()
        && name.equals(p.getChildren("name").get(0).getValue())) {
        return Long.parseLong((String) p.getChildren("value").get(0).getValue());
      }
    }
    return d;
  }

  @Override
  public float getFloat(String name, float d) {
    List<ConfigurationNode> properties = getRootNode().getChildren();
    if (properties == null || properties.isEmpty()) {
      return d;
    }
    for (ConfigurationNode p : properties) {
      if (p.getChildren("name") != null && !p.getChildren("name").isEmpty()
        && name.equals(p.getChildren("name").get(0).getValue())) {
        return Float.parseFloat((String) p.getChildren("value").get(0).getValue());
      }
    }
    return d;
  }

  @Override
  public boolean getBoolean(String name, boolean d) {
    List<ConfigurationNode> properties = getRootNode().getChildren();
    if (properties == null || properties.isEmpty()) {
      return d;
    }
    for (ConfigurationNode p : properties) {
      if (p.getChildren("name") != null && !p.getChildren("name").isEmpty()
        && name.equals(p.getChildren("name").get(0).getValue())) {
        return Boolean.parseBoolean((String) p.getChildren("value").get(0).getValue());
      }
    }
    return d;
  }

  public XMLStrategy(URL url) {
    setDelimiterParsingDisabled(true);
    try {
      load(url);
    } catch (ConfigurationException e) {
      e.printStackTrace();
    }
  }

}
