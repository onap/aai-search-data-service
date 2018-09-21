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
package org.onap.aai.sa.searchdbabstraction.searchapi;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;

public class FilterTest {

  @Test
  public void test() throws JsonParseException, JsonMappingException, IOException {


    String json = "{ \"any\": [ "
        + "{\"match\": {\"field\": \"searchTags\", \"value\": \"a\"}},"
        + "{\"match\": {\"field\": \"searchTags\", \"value\": \"b\"}}"
        + "],"
        + "\"all\": ["
        + "{\"parsed-query\": {\"field\": \"fieldname\", \"query-string\": \"string\"}}"
        + "]"
        + "}";

    ObjectMapper mapper = new ObjectMapper();
    Filter filter = mapper.readValue(json, Filter.class);
    System.out.println("GDF: filter = " + filter);
  }
}
