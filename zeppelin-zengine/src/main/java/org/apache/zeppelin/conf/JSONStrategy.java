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

import java.net.URL;
import org.json.*;
/**
 * Created by Bulat on 17.04.2017.
 */
public class JSONStrategy implements ConfigStrategy {
  JSONObject obj;

  public JSONStrategy(URL url) {
    obj = new JSONObject(url);
  }

  @Override
  public int getInt(String name, int alternative) {
    JSONArray properties = obj.getJSONObject("configuration").getJSONArray("property");
    if (properties == null) {
      return alternative;
    }
    String propertyName;
    for (int i = 0; i < properties.length(); i++) {
      propertyName = properties.getJSONObject(i).getString("name");
      if (propertyName != null && name.equals(propertyName)) {
        return Integer.parseInt((String) properties.getJSONObject(i).getString("value"));
      }
    }
    return alternative;
  }

  @Override
  public long getLong(String name, long alternative) {
    JSONArray properties = obj.getJSONObject("configuration").getJSONArray("property");
    if (properties == null) {
      return alternative;
    }
    String propertyName;
    for (int i = 0; i < properties.length(); i++) {
      propertyName = properties.getJSONObject(i).getString("name");
      if (propertyName != null && name.equals(propertyName)) {
        return Long.parseLong((String) properties.getJSONObject(i).getString("value"));
      }
    }
    return alternative;
  }

  @Override
  public float getFloat(String name, float alternative) {
    JSONArray properties = obj.getJSONObject("configuration").getJSONArray("property");
    if (properties == null) {
      return alternative;
    }
    String propertyName;
    for (int i = 0; i < properties.length(); i++) {
      propertyName = properties.getJSONObject(i).getString("name");
      if (propertyName != null && name.equals(propertyName)) {
        return Float.parseFloat((String) properties.getJSONObject(i).getString("value"));
      }
    }
    return alternative;
  }

  @Override
  public boolean getBoolean(String name, boolean alternative) {
    JSONArray properties = obj.getJSONObject("configuration").getJSONArray("property");
    if (properties == null) {
      return alternative;
    }
    String propertyName;
    for (int i = 0; i < properties.length(); i++) {
      propertyName = properties.getJSONObject(i).getString("name");
      if (propertyName != null && name.equals(propertyName)) {
        return Boolean.parseBoolean((String) properties.getJSONObject(i).getString("value"));
      }
    }
    return alternative;
  }

  @Override
  public String getString(String name, String alternative) {
    JSONArray properties = obj.getJSONObject("configuration").getJSONArray("property");
    if (properties == null) {
      return alternative;
    }
    String propertyName;
    for (int i = 0; i < properties.length(); i++) {
      propertyName = properties.getJSONObject(i).getString("name");
      if (propertyName != null && name.equals(propertyName)) {
        return properties.getJSONObject(i).getString("value");
      }
    }
    return alternative;
  }
}
