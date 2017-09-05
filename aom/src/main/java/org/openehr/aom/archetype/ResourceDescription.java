package org.openehr.aom.archetype;

import org.openehr.basetypes.terminology.TerminologyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Defines the descriptive meta-data of a resource.
 *
 * Created by cnanjo on 5/18/16.
 */
public class ResourceDescription {

    public ResourceDescription() {
        originalAuthor = new HashMap<String, String>();
        this.otherContributors = new ArrayList<String>();
        this.ipAcknowledgements = new HashMap<String, String>();
        this.references = new HashMap<String, String>();
        this.conversionDetails = new HashMap<String, String>();
        this.otherDetails = new HashMap<String, String>();
        this.details = new HashMap<String, ResourceDescriptionItem>();
    }

    /**
     * Original author of this resource, with all relevant details, including organisation.
     */
    private Map<String, String> originalAuthor;
    /**
     * Namespace of original author’s organisation, in reverse internet form, if applicable.
     */
    private String originalNamespace;
    /**
     * Plain text name of organisation that originally published this artefact, if any.
     */
    private String originalPublisher;
    /**
     * Other contributors to the resource, each listed in "name <email>" form.
     */
    private List<String> otherContributors;
    /**
     * Lifecycle state of the resource, typically including states such as: initial, in_development, in_review, published, superseded, obsolete.
     */
    private TerminologyCode lifecycleState;
    /**
     * Namespace in reverse internet id form, of current custodian organisation.
     */
    private String custodianNamespace;
    /**
     * Plain text name of current custodian organisation.
     */
    private String custodianOrganization;
    /**
     * Optional copyright statement for the resource as a knowledge resource.
     */
    private String copyright;
    /**
     * Licence of current artefact, in format "short licence name <URL of licence>", e.g. "Apache 2.0 License <http://www.apache.org/licenses/LICENSE-2.0.html>"
     */
    private String licence;
    /**
     * List of acknowledgements of other IP directly referenced in this archetype, typically terminology codes, ontology ids etc. Recommended keys are the widely known name or namespace for the IP source, as shown in the following example:
     *
     * ip_acknowledgements = < ["loinc"] = <"This content from LOINC® is copyright © 1995 Regenstrief Institute, Inc. and the LOINC Committee, and available at no cost under the license at http://loinc.org/terms-of-use">; ["snomedct"] = <"Content from SNOMED CT® is copyright © 2007 IHTSDO <ihtsdo.org>"> >
     */
    private Map<String, String> ipAcknowledgements;
    /**
     * List of references of material on which this artefact is based, as a keyed list of strings. The keys should be in a standard citation format.
     */
    private Map<String,String> references;
    /**
     * URI of package to which this resource belongs.
     */
    private String resourcePackageUri;
    /**
     * Details related to conversion process that generated this model from an original, if relevant, as a list of name/value pairs. Typical example with recommended tags: conversion_details = < ["source_model"] = <"CEM model xyz http://location.in.clinicalelementmodels.com>" ["tool"] = <"cem2adl v6.3.0"> ["time"] = <"2014-11-03T09:05:00"> >
     */
    private Map<String, String> conversionDetails;
    /**
     * Additional non language-senstive resource meta-data, as a list of name/value pairs.
     */
    private Map<String, String> otherDetails;
    /**
     * Details of all parts of resource description that are natural language-dependent, keyed by language code.
     */
    private Map<String, ResourceDescriptionItem> details;
    /**
     * Reference to owning resource.
     */
    private AuthoredResource parentResource;

    /**
     * Method returns original author attributes.
     *
     * @return
     */
    public Map<String, String> getOriginalAuthor() {
        return originalAuthor;
    }

    /**
     * Method sets original author attributes.
     *
     * @param originalAuthor
     */
    public void setOriginalAuthor(Map<String, String> originalAuthor) {
        this.originalAuthor = originalAuthor;
    }

    /**
     * Use to set an original author name-value-pair attribute such as:
     * <pre>
     * name='Sam Heard'
     * organization='Ocean Informatics'
     * email='sam.heard@oceaninformatics.com'
     * date='2006-03-22'
     * </pre>
     *
     * @param name
     * @param value
     */
    public void addOriginalAuthorAttribute(String name, String value) {
        this.originalAuthor.put(name, value);
    }

    /**
     * Returns the original namespace for this archetype.
     *
     * @return
     */
    public String getOriginalNamespace() {
        return originalNamespace;
    }

    /**
     * Sets the original namespace for this archetype.
     *
     * @param originalNamespace
     */
    public void setOriginalNamespace(String originalNamespace) {
        this.originalNamespace = originalNamespace;
    }

    /**
     * Returns the original publisher.
     *
     * @return
     */
    public String getOriginalPublisher() {
        return originalPublisher;
    }

    /**
     * Sets the original publisher.
     *
     * @param originalPublisher
     */
    public void setOriginalPublisher(String originalPublisher) {
        this.originalPublisher = originalPublisher;
    }

    /**
     * Returns the list of other contributors.
     *
     * @return
     */
    public List<String> getOtherContributors() {
        return otherContributors;
    }

    /**
     * Sets the list of other contributors.
     *
     * @param otherContributors
     */
    public void setOtherContributors(List<String> otherContributors) {
        this.otherContributors = otherContributors;
    }

    /**
     * Adds another contributor for this artefact.
     *
     * @param otherContributor
     */
    public void addOtherContributor(String otherContributor) {
        this.otherContributors.add(otherContributor);
    }

    /**
     * Returns the lifecycle state for this artefact.
     *
     * @return
     */
    public TerminologyCode getLifecycleState() {
        return lifecycleState;
    }

    /**
     * Sets the lifecycle state for this artefact.
     *
     * @param lifecycleState
     */
    public void setLifecycleState(TerminologyCode lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    /**
     * Returns the custodian namespace for this artefact.
     *
     * @return
     */
    public String getCustodianNamespace() {
        return custodianNamespace;
    }

    /**
     * Sets the custodian namespace for this artefact.
     *
     * @param custodianNamespace
     */
    public void setCustodianNamespace(String custodianNamespace) {
        this.custodianNamespace = custodianNamespace;
    }

    /**
     * Returns the custodian organization for this artefact.
     *
     * @return
     */
    public String getCustodianOrganization() {
        return custodianOrganization;
    }

    /**
     * Sets the custodian organization for this artefact.
     *
     * @param custodianOrganization
     */
    public void setCustodianOrganization(String custodianOrganization) {
        this.custodianOrganization = custodianOrganization;
    }

    /**
     * Returns the copyright information for this artefact.
     *
     * @return
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Sets the copyright information for this artefact.
     *
     * @param copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * Returns the license information for this artefact.
     *
     * @return
     */
    public String getLicence() {
        return licence;
    }

    /**
     * Sets the license information for this artefact.
     *
     * @param licence
     */
    public void setLicence(String licence) {
        this.licence = licence;
    }

    /**
     * Returns the list of IP Acknowledgements for this artefact.
     *
     * @return
     */
    public Map<String, String> getIpAcknowledgements() {
        return ipAcknowledgements;
    }

    /**
     * Sets the list of IP Acknowledgements for this artefact.
     *
     * @param ipAcknowledgements
     */
    public void setIpAcknowledgements(Map<String, String> ipAcknowledgements) {
        this.ipAcknowledgements = ipAcknowledgements;
    }

    /**
     * Adds an IP Acknowledgement
     *
     * @param entity
     * @param ipAcknowledgementText
     */
    public void addIpAcknowledgement(String entity, String ipAcknowledgementText) {
        this.ipAcknowledgements.put(entity, ipAcknowledgementText);
    }

    /**
     * Returns references associated with this archetype.
     *
     * @return
     */
    public Map<String, String> getReferences() {
        return references;
    }

    /**
     * Sets references associated with this archetype.
     *
     * @param references
     */
    public void setReferences(Map<String, String> references) {
        this.references = references;
    }

    /**
     * Method adds a reference to the set of references for this archetype.
     *
     * @param citation
     * @param reference
     */
    public void addReference(String citation, String reference) {
        this.references.put(citation, reference);
    }

    /**
     * Returns the resource package URI.
     *
     * @return
     */
    public String getResourcePackageUri() {
        return resourcePackageUri;
    }

    /**
     * Sets the resource package URI.
     *
     * @param resourcePackageUri
     */
    public void setResourcePackageUri(String resourcePackageUri) {
        this.resourcePackageUri = resourcePackageUri;
    }

    /**
     * Returns the conversion details for this archetype.
     *
     * @return
     */
    public Map<String, String> getConversionDetails() {
        return conversionDetails;
    }

    /**
     * Sets the conversion details for this archetype.
     *
     * @param conversionDetails
     */
    public void setConversionDetails(Map<String, String> conversionDetails) {
        this.conversionDetails = conversionDetails;
    }

    public void addConversionDetails(String key, String value) {
        this.conversionDetails.put(key, value);
    }

    /**
     * Returns other details for this archetype.
     *
     * @return
     */
    public Map<String, String> getOtherDetails() {
        return otherDetails;
    }

    /**
     * Sets other details for this archetype.
     *
     * @param otherDetails
     */
    public void setOtherDetails(Map<String, String> otherDetails) {
        this.otherDetails = otherDetails;
    }

    /**
     * Adds another detail as a key=value pair.
     *
     * @param key
     * @param value
     */
    public void addOtherDetails(String key, String value) {
        this.otherDetails.put(key, value);
    }

    /**
     * Returns the details for this archetype.
     *
     * @return
     */
    public Map<String, ResourceDescriptionItem> getDetails() {
        return details;
    }

    /**
     * Sets the details for this archetype.
     *
     * @param details
     */
    public void setDetails(Map<String, ResourceDescriptionItem> details) {
        this.details = details;
    }

    /**
     * Adds language-dependent details for this archetype.
     *
     * @param language
     * @param details
     */
    public void addDetail(String language, ResourceDescriptionItem details) {
        this.details.put(language, details);
    }

    /**
     * Returns the parent resource for this archetype.
     *
     * @return
     */
    public AuthoredResource getParentResource() {
        return parentResource;
    }

    /**
     * Sets the parent resource for this archetype.
     *
     * @param parentResource
     */
    public void setParentResource(AuthoredResource parentResource) {
        this.parentResource = parentResource;
    }
}
