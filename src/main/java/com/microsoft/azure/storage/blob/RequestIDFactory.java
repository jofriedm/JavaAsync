/**
 * Copyright Microsoft Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.pipeline.RequestPolicyNode;
import com.microsoft.rest.v2.http.HttpRequest;
import com.microsoft.rest.v2.http.HttpResponse;
import com.microsoft.rest.v2.policy.RequestPolicy;
import rx.Single;

import java.util.UUID;

/**
 * Factory to create a unique request ID and set the x-ms-client-request-id header.
 */
public final class RequestIDFactory implements RequestPolicy.Factory {

    private final class RequestIDPolicy implements RequestPolicy {
        final RequestPolicy requestPolicy;

        final RequestPolicy.Options options;

        public RequestIDPolicy(RequestPolicy requestPolicy, RequestPolicy.Options options) {
            this.requestPolicy = requestPolicy;
            this.options = options;
        }

        /**
         * Add the unique client request ID to the request
         * @param request
         *      the request to populate with the client request ID
         * @return
         *      A {@link Single} representing the HTTP response that will arrive asynchronously.
         */
        public Single<HttpResponse> sendAsync(HttpRequest request) {
            request.headers().set(Constants.HeaderConstants.CLIENT_REQUEST_ID_HEADER, UUID.randomUUID().toString());
            return requestPolicy.sendAsync(request);
        }
    }

    @Override
    public RequestPolicy create(RequestPolicy next, RequestPolicy.Options options) {
        return new RequestIDPolicy(next, options);
    }
}
