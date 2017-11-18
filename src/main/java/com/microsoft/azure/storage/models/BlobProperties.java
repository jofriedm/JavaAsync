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

import com.microsoft.rest.v2.DateTimeRfc1123;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Properties of a blob.
 */
public class BlobProperties {
    /**
     * The lastModified property.
     */
    @JsonProperty(value = "Last-Modified")
    private DateTimeRfc1123 lastModified;

    /**
     * The etag property.
     */
    @JsonProperty(value = "Etag")
    private String etag;

    /**
     * Size in bytes.
     */
    @JsonProperty(value = "Content-Length")
    private Integer contentLength;

    /**
     * The contentType property.
     */
    @JsonProperty(value = "Content-Type")
    private String contentType;

    /**
     * The contentEncoding property.
     */
    @JsonProperty(value = "Content-Encoding")
    private String contentEncoding;

    /**
     * The contentLanguage property.
     */
    @JsonProperty(value = "Content-Language")
    private String contentLanguage;

    /**
     * The contentMD5 property.
     */
    @JsonProperty(value = "Content-MD5")
    private String contentMD5;

    /**
     * The contentDisposition property.
     */
    @JsonProperty(value = "Content-Disposition")
    private String contentDisposition;

    /**
     * The cacheControl property.
     */
    @JsonProperty(value = "Cache-Control")
    private String cacheControl;

    /**
     * The xMsBlobSequenceNumber property.
     */
    @JsonProperty(value = "x-ms-blob-sequence-number")
    private String xMsBlobSequenceNumber;

    /**
     * The blobType property.
     */
    @JsonProperty(value = "BlobType")
    private String blobType;

    /**
     * Possible values include: 'locked', 'unlocked'.
     */
    @JsonProperty(value = "LeaseStatus")
    private LeaseStatusType leaseStatus;

    /**
     * Possible values include: 'available', 'leased', 'expired', 'breaking',
     * 'broken'.
     */
    @JsonProperty(value = "LeaseState")
    private LeaseStateType leaseState;

    /**
     * Possible values include: 'infinite', 'fixed'.
     */
    @JsonProperty(value = "LeaseDuration")
    private LeaseDurationType leaseDuration;

    /**
     * The copyId property.
     */
    @JsonProperty(value = "CopyId")
    private String copyId;

    /**
     * Possible values include: 'pending', 'success', 'aborted', 'failed'.
     */
    @JsonProperty(value = "CopyStatus")
    private CopyStatusType copyStatus;

    /**
     * The copySource property.
     */
    @JsonProperty(value = "CopySource")
    private String copySource;

    /**
     * The copyProgress property.
     */
    @JsonProperty(value = "CopyProgress")
    private String copyProgress;

    /**
     * The copyCompletionTime property.
     */
    @JsonProperty(value = "CopyCompletionTime")
    private DateTimeRfc1123 copyCompletionTime;

    /**
     * The copyStatusDescription property.
     */
    @JsonProperty(value = "CopyStatusDescription")
    private String copyStatusDescription;

    /**
     * The serverEncrypted property.
     */
    @JsonProperty(value = "ServerEncrypted")
    private Boolean serverEncrypted;

    /**
     * The incrementalCopy property.
     */
    @JsonProperty(value = "IncrementalCopy")
    private Boolean incrementalCopy;

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
     * @return the BlobProperties object itself.
     */
    public BlobProperties withLastModified(DateTime lastModified) {
        if (lastModified == null) {
            this.lastModified = null;
        } else {
            this.lastModified = new DateTimeRfc1123(lastModified);
        }
        return this;
    }

    /**
     * Get the etag value.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set the etag value.
     *
     * @param etag the etag value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get the contentLength value.
     *
     * @return the contentLength value
     */
    public Integer contentLength() {
        return this.contentLength;
    }

    /**
     * Set the contentLength value.
     *
     * @param contentLength the contentLength value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withContentLength(Integer contentLength) {
        this.contentLength = contentLength;
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
     * @return the BlobProperties object itself.
     */
    public BlobProperties withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Get the contentEncoding value.
     *
     * @return the contentEncoding value
     */
    public String contentEncoding() {
        return this.contentEncoding;
    }

    /**
     * Set the contentEncoding value.
     *
     * @param contentEncoding the contentEncoding value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
        return this;
    }

    /**
     * Get the contentLanguage value.
     *
     * @return the contentLanguage value
     */
    public String contentLanguage() {
        return this.contentLanguage;
    }

    /**
     * Set the contentLanguage value.
     *
     * @param contentLanguage the contentLanguage value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
        return this;
    }

    /**
     * Get the contentMD5 value.
     *
     * @return the contentMD5 value
     */
    public String contentMD5() {
        return this.contentMD5;
    }

    /**
     * Set the contentMD5 value.
     *
     * @param contentMD5 the contentMD5 value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withContentMD5(String contentMD5) {
        this.contentMD5 = contentMD5;
        return this;
    }

    /**
     * Get the contentDisposition value.
     *
     * @return the contentDisposition value
     */
    public String contentDisposition() {
        return this.contentDisposition;
    }

    /**
     * Set the contentDisposition value.
     *
     * @param contentDisposition the contentDisposition value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
        return this;
    }

    /**
     * Get the cacheControl value.
     *
     * @return the cacheControl value
     */
    public String cacheControl() {
        return this.cacheControl;
    }

    /**
     * Set the cacheControl value.
     *
     * @param cacheControl the cacheControl value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
        return this;
    }

    /**
     * Get the xMsBlobSequenceNumber value.
     *
     * @return the xMsBlobSequenceNumber value
     */
    public String xMsBlobSequenceNumber() {
        return this.xMsBlobSequenceNumber;
    }

    /**
     * Set the xMsBlobSequenceNumber value.
     *
     * @param xMsBlobSequenceNumber the xMsBlobSequenceNumber value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withXMsBlobSequenceNumber(String xMsBlobSequenceNumber) {
        this.xMsBlobSequenceNumber = xMsBlobSequenceNumber;
        return this;
    }

    /**
     * Get the blobType value.
     *
     * @return the blobType value
     */
    public String blobType() {
        return this.blobType;
    }

    /**
     * Set the blobType value.
     *
     * @param blobType the blobType value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withBlobType(String blobType) {
        this.blobType = blobType;
        return this;
    }

    /**
     * Get the leaseStatus value.
     *
     * @return the leaseStatus value
     */
    public LeaseStatusType leaseStatus() {
        return this.leaseStatus;
    }

    /**
     * Set the leaseStatus value.
     *
     * @param leaseStatus the leaseStatus value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withLeaseStatus(LeaseStatusType leaseStatus) {
        this.leaseStatus = leaseStatus;
        return this;
    }

    /**
     * Get the leaseState value.
     *
     * @return the leaseState value
     */
    public LeaseStateType leaseState() {
        return this.leaseState;
    }

    /**
     * Set the leaseState value.
     *
     * @param leaseState the leaseState value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withLeaseState(LeaseStateType leaseState) {
        this.leaseState = leaseState;
        return this;
    }

    /**
     * Get the leaseDuration value.
     *
     * @return the leaseDuration value
     */
    public LeaseDurationType leaseDuration() {
        return this.leaseDuration;
    }

    /**
     * Set the leaseDuration value.
     *
     * @param leaseDuration the leaseDuration value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withLeaseDuration(LeaseDurationType leaseDuration) {
        this.leaseDuration = leaseDuration;
        return this;
    }

    /**
     * Get the copyId value.
     *
     * @return the copyId value
     */
    public String copyId() {
        return this.copyId;
    }

    /**
     * Set the copyId value.
     *
     * @param copyId the copyId value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withCopyId(String copyId) {
        this.copyId = copyId;
        return this;
    }

    /**
     * Get the copyStatus value.
     *
     * @return the copyStatus value
     */
    public CopyStatusType copyStatus() {
        return this.copyStatus;
    }

    /**
     * Set the copyStatus value.
     *
     * @param copyStatus the copyStatus value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withCopyStatus(CopyStatusType copyStatus) {
        this.copyStatus = copyStatus;
        return this;
    }

    /**
     * Get the copySource value.
     *
     * @return the copySource value
     */
    public String copySource() {
        return this.copySource;
    }

    /**
     * Set the copySource value.
     *
     * @param copySource the copySource value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withCopySource(String copySource) {
        this.copySource = copySource;
        return this;
    }

    /**
     * Get the copyProgress value.
     *
     * @return the copyProgress value
     */
    public String copyProgress() {
        return this.copyProgress;
    }

    /**
     * Set the copyProgress value.
     *
     * @param copyProgress the copyProgress value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withCopyProgress(String copyProgress) {
        this.copyProgress = copyProgress;
        return this;
    }

    /**
     * Get the copyCompletionTime value.
     *
     * @return the copyCompletionTime value
     */
    public DateTime copyCompletionTime() {
        if (this.copyCompletionTime == null) {
            return null;
        }
        return this.copyCompletionTime.dateTime();
    }

    /**
     * Set the copyCompletionTime value.
     *
     * @param copyCompletionTime the copyCompletionTime value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withCopyCompletionTime(DateTime copyCompletionTime) {
        if (copyCompletionTime == null) {
            this.copyCompletionTime = null;
        } else {
            this.copyCompletionTime = new DateTimeRfc1123(copyCompletionTime);
        }
        return this;
    }

    /**
     * Get the copyStatusDescription value.
     *
     * @return the copyStatusDescription value
     */
    public String copyStatusDescription() {
        return this.copyStatusDescription;
    }

    /**
     * Set the copyStatusDescription value.
     *
     * @param copyStatusDescription the copyStatusDescription value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withCopyStatusDescription(String copyStatusDescription) {
        this.copyStatusDescription = copyStatusDescription;
        return this;
    }

    /**
     * Get the serverEncrypted value.
     *
     * @return the serverEncrypted value
     */
    public Boolean serverEncrypted() {
        return this.serverEncrypted;
    }

    /**
     * Set the serverEncrypted value.
     *
     * @param serverEncrypted the serverEncrypted value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withServerEncrypted(Boolean serverEncrypted) {
        this.serverEncrypted = serverEncrypted;
        return this;
    }

    /**
     * Get the incrementalCopy value.
     *
     * @return the incrementalCopy value
     */
    public Boolean incrementalCopy() {
        return this.incrementalCopy;
    }

    /**
     * Set the incrementalCopy value.
     *
     * @param incrementalCopy the incrementalCopy value to set
     * @return the BlobProperties object itself.
     */
    public BlobProperties withIncrementalCopy(Boolean incrementalCopy) {
        this.incrementalCopy = incrementalCopy;
        return this;
    }

}