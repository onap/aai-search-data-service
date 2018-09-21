/**
 * ============LICENSE_START=======================================================
 * org.onap.aai
 * ================================================================================
 * Copyright © 2017-2018 AT&T Intellectual Property. All rights reserved.
 * Copyright © 2017-2018 Amdocs
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */
package org.onap.aai.sa.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ApiUtilsTest {

  @Test
  public void testHTTPStatusConversion() {
      String statusString;
      statusString = ApiUtils.getHttpStatusString(201);
      assertEquals(0, statusString.compareToIgnoreCase("Created"));

      statusString = ApiUtils.getHttpStatusString(207);
      assertEquals(0, statusString.compareToIgnoreCase("Multi-Status"));

      statusString = ApiUtils.getHttpStatusString(9999);
      assertEquals(0, statusString.compareToIgnoreCase("Unknown"));
  }
}
