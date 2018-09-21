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
package org.onap.aai.sa.searchdbabstraction.elasticsearch.exception;

public class DocumentStoreOperationException extends Exception {

    private static final long serialVersionUID = -7689309913743200670L;

    public enum ErrorMessage {
        NO_RESPONSE_CODE(
                "Failed to get the response code from the connection."
        ),
        SET_REQUEST_METHOD_FAILED(
                "Failed to set HTTP request method to %s."
        );
        private String message;

        ErrorMessage(String msg) {
            this.message = msg;
        }
    }

    public DocumentStoreOperationException(ErrorMessage error, Exception ex, Object... args) {
        super(String.format(error.message, args), ex);
    }

    public DocumentStoreOperationException(String message, Exception ex) {
        super(message, ex);
    }

    public DocumentStoreOperationException(String message) {
        super(message);
    }

}
