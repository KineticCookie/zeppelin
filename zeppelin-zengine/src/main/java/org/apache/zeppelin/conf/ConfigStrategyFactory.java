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
