/**
 * ============LICENSE_START=======================================================
 * Search Data Service
 * ================================================================================
 * Copyright © 2017 AT&T Intellectual Property.
 * Copyright © 2017 Amdocs
 * All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License ati
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 *
 * ECOMP and OpenECOMP are trademarks
 * and service marks of AT&T Intellectual Property.
 */
package org.openecomp.sa.searchdbabstraction.service;

import org.openecomp.cl.api.Logger;
import org.openecomp.cl.eelf.LoggerFactory;
import org.openecomp.sa.searchdbabstraction.elasticsearch.config.ElasticSearchConfig;
import org.openecomp.sa.searchdbabstraction.elasticsearch.dao.ElasticSearchHttpController;
import org.openecomp.sa.searchdbabstraction.logging.SearchDbMsgs;
import org.openecomp.sa.searchdbabstraction.util.SearchDbConstants;

import java.io.FileInputStream;
import java.util.Properties;


public class SearchService {
  private ElasticSearchHttpController esController = null;

  static Logger logger = LoggerFactory.getInstance().getLogger(SearchService.class.getName());

  public SearchService() {
    try {
      start();
    } catch (Exception e) {
      logger.error(SearchDbMsgs.STARTUP_EXCEPTION, e.getLocalizedMessage());
    }
  }

  protected void start() throws Exception {
    Properties configProperties = new Properties();
    configProperties.load(new FileInputStream(SearchDbConstants.ES_CONFIG_FILE));
    ElasticSearchConfig esConfig = new ElasticSearchConfig(configProperties);

    esController = new ElasticSearchHttpController(esConfig);
    logger.info(SearchDbMsgs.SERVICE_STARTED);
  }
}
