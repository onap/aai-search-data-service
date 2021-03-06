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

/**
 * An example of a date_range aggregation:
 *
 * <p>
 * 
 * <pre>
 * {
 *    "aggs": {
 *        "my_group": {
 *            "term": {
 *                "field": "group"
 *            }
 *        }
 *    }
 * }
 * </pre>
 *
 * @author sye
 */
public class GroupByAggregation extends AbstractAggregation {

    @Override
    public String toElasticSearch() {
        StringBuilder sb = new StringBuilder();

        sb.append("\"terms\": {\"field\": \"");
        sb.append(field);
        sb.append("\"");
        if (size != null) {
            sb.append(", \"size\": ");
            sb.append(size);
        }

        if (minThreshold != null) {
            sb.append(", \"min_doc_count\": ").append(minThreshold);
        }

        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toString() {
        return "{group-by: {field: " + field + ", size: " + size + " minThreshold: " + minThreshold + "}}";
    }

}
