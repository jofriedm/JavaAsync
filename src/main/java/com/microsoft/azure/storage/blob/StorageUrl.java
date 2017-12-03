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

import com.microsoft.azure.storage.implementation.AzureBlobStorageImpl;
import com.microsoft.azure.storage.pipeline.Pipeline;
import com.microsoft.rest.v2.http.HttpPipeline;

public abstract class StorageUrl {

    protected final String url;

    protected final AzureBlobStorageImpl storageClient;

    protected StorageUrl(String url, HttpPipeline pipeline) {
        if (url == null) {
            throw new IllegalArgumentException("url cannot be null.");
        }
        if (pipeline == null) {
            throw new IllegalArgumentException("pipeline cannot be null.");
        }

        this.url = url;
        this.storageClient = new AzureBlobStorageImpl(pipeline);
    }

    @Override
    public String toString() {
        return this.url;
    }
}
