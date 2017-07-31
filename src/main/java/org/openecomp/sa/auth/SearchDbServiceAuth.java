/**
 * ============LICENSE_START=======================================================
 * org.onap.aai
 * ================================================================================
 * Copyright © 2017 AT&T Intellectual Property. All rights reserved.
 * Copyright © 2017 Amdocs
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
 *
 * ECOMP is a trademark and service mark of AT&T Intellectual Property.
 */
package org.openecomp.sa.auth;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;

public class SearchDbServiceAuth {

  public SearchDbServiceAuth() {
  }

  public boolean authBasic(String username, String authFunction) {
    return SearchDbServiceAuthCore.authorize(username, authFunction);
  }

  public String authUser(HttpHeaders headers, String authUser, String authFunction) {


    SearchDbServiceAuth aaiAuth = new SearchDbServiceAuth();

    StringBuilder username = new StringBuilder();

    username.append(authUser);
    if (aaiAuth.authBasic(username.toString(), authFunction) == false) {
      return "AAI_9101";

    }
    return "OK";
  }

  public boolean authCookie(Cookie cookie, String authFunction, StringBuilder username) {

    // String result = "no value";
    if (cookie == null) {
      return false;
    }

    return SearchDbServiceAuthCore.authorize(username.toString(), authFunction);
  }
}
