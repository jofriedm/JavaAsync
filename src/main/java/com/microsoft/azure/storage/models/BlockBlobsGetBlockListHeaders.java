/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.storage.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.v2.DateTimeRfc1123;
import org.joda.time.DateTime;

/**
 * Defines headers for GetBlockList operation.
 */
public class BlockBlobsGetBlockListHeaders {
    /**
     * Returns the date and time the container was last modified. Any operation
     * that modifies the blob, including an update of the blob's metadata or
     * properties, changes the last-modified time of the blob.
     */
    @JsonProperty(value = "Last-Modified")
    private DateTimeRfc1123 lastModified;

    /**
     * The ETag contains a value that you can use to perform operations
     * conditionally. If the request version is 2011-08-18 or newer, the ETag
     * value will be in quotes.
     */
    @JsonProperty(value = "ETag")
    private String eTag;

    /**
     * The content type specified for the blob. The default content type is
     * 'application/octet-stream'.
     */
    @JsonProperty(value = "Content-Type")
    private String contentType;

    /**
     * The size of the blob in bytes.
     */
    @JsonProperty(value = "x-ms-blob-content-length")
    private Long blobContentLength;

    /**
     * This header uniquely identifies the request that was made and can be
     * used for troubleshooting the request.
     */
    @JsonProperty(value = "x-ms-request-id")
    private String requestId;

    /**
     * Indicates the version of the Blob service used to execute the request.
     * This header is returned for requests made against version 2009-09-19 and
     * above.
     */
    @JsonProperty(value = "x-ms-version")
    private String version;

    /**
     * UTC date/time value generated by the service that indicates the time at
     * which the response was initiated.
     */
    @JsonProperty(value = "Date")
    private DateTimeRfc1123 dateProperty;

    /**
     * Get the lastModified value.
     *
     * @return the lastModified value
     */
    public DateTime lastModified() {
        if (this.lastModified == null) {
            return null;
        }
        return this.lastModified.dateTime();
    }

    /**
     * Set the lastModified value.
     *
     * @param lastModified the lastModified value to set
     * @return the BlockBlobsGetBlockListHeaders object itself.
     */
    public BlockBlobsGetBlockListHeaders withLastModified(DateTime lastModified) {
        if (lastModified == null) {
            this.lastModified = null;
        } else {
            this.lastModified = new DateTimeRfc1123(lastModified);
        }
        return this;
    }

    /**
     * Get the eTag value.
     *
     * @return the eTag value
     */
    public String eTag() {
        return this.eTag;
    }

    /**
     * Set the eTag value.
     *
     * @param eTag the eTag value to set
     * @return the BlockBlobsGetBlockListHeaders object itself.
     */
    public BlockBlobsGetBlockListHeaders withETag(String eTag) {
        this.eTag = eTag;
        return this;
    }

    /**
     * Get the contentType value.
     *
     * @return the contentType value
     */
    public String contentType() {
        return this.contentType;
    }

    /**
     * Set the contentType value.
     *
     * @param contentType the contentType value to set
     * @return the BlockBlobsGetBlockListHeaders object itself.
     */
    public BlockBlobsGetBlockListHeaders withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Get the blobContentLength value.
     *
     * @return the blobContentLength value
     */
    public Long blobContentLength() {
        return this.blobContentLength;
    }

    /**
     * Set the blobContentLength value.
     *
     * @param blobContentLength the blobContentLength value to set
     * @return the BlockBlobsGetBlockListHeaders object itself.
     */
    public BlockBlobsGetBlockListHeaders withBlobContentLength(Long blobContentLength) {
        this.blobContentLength = blobContentLength;
        return this;
    }

    /**
     * Get the requestId value.
     *
     * @return the requestId value
     */
    public String requestId() {
        return this.requestId;
    }

    /**
     * Set the requestId value.
     *
     * @param requestId the requestId value to set
     * @return the BlockBlobsGetBlockListHeaders object itself.
     */
    public BlockBlobsGetBlockListHeaders withRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Get the version value.
     *
     * @return the version value
     */
    public String version() {
        return this.version;
    }

    /**
     * Set the version value.
     *
     * @param version the version value to set
     * @return the BlockBlobsGetBlockListHeaders object itself.
     */
    public BlockBlobsGetBlockListHeaders withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * Get the dateProperty value.
     *
     * @return the dateProperty value
     */
    public DateTime dateProperty() {
        if (this.dateProperty == null) {
            return null;
        }
        return this.dateProperty.dateTime();
    }

    /**
     * Set the dateProperty value.
     *
     * @param dateProperty the dateProperty value to set
     * @return the BlockBlobsGetBlockListHeaders object itself.
     */
    public BlockBlobsGetBlockListHeaders withDateProperty(DateTime dateProperty) {
        if (dateProperty == null) {
            this.dateProperty = null;
        } else {
            this.dateProperty = new DateTimeRfc1123(dateProperty);
        }
        return this;
    }

}
