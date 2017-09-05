package org.openehr.aom.archetype;

import org.openehr.basetypes.definitions.VersionStatus;
import org.openehr.validation.InvalidArgumentException;
import org.openehr.validation.ValidationResult;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Human_readable structured identifier (HRID) for an archetype or template.
 *
 * Created by cnanjo on 5/19/16.
 */
public class ArchetypeHrid {

    public static final String HRID_PATTERN = "((?<namespace>([a-zA-Z][a-zA-Z0-9-]*)(\\.([a-zA-Z][a-zA-Z0-9-]*))*)::)?(?<publisher>[a-zA-Z][a-zA-Z0-9_]*)-(?<package>[a-zA-Z][a-zA-Z0-9_]*)-(?<class>[a-zA-Z][a-zA-Z0-9_]*)\\.(?<conceptid>[a-zA-Z][a-zA-Z0-9-]*)\\.v(?<major>\\d+)(\\.(?<minor>\\d+)\\.(?<patch>\\d+)((?<status>-rc|-alpha)((\\.)(?<count>\\d+))?)?)?";
    public static final Pattern HRID_COMPILED_PATTERN;

    static {
        HRID_COMPILED_PATTERN = Pattern.compile(HRID_PATTERN);
    }
    /**
     * Reverse domain name namespace identifier.
     */
    private String namespace;
    /**
     * Name of the Reference Model publisher.
     */
    private String rmPublisher;
    /**
     * Name of the package in whose reachability graph the rm_class class is found (there can be more than one possibility in many reference models).
     */
    private String rmPackage;
    /**
     * Name of the root class of this archetype.
     */
    private String rmClass;
    /**
     * The short concept name of the archetype as used in the multi-axial archetype_hrid.
     */
    private String conceptId;
    /**
     * The major version component of the release version
     */
    private String majorVersion;
    /**
     * The minor component of the release version
     */
    private String minorVersion;
    /**
     * The parch version component of the release version
     */
    private String patchVersion;
    /**
     * The status of the version, i.e. released, release_candidate etc.
     */
    private VersionStatus versionStatus;
    /**
     *
     The build count since last increment of any version part.
     */
    private String buildCount;
    /**
     * The unparsed, original Id
     */
    private String originalId;

    /**
     * Methods returns the namespace for the archetype.
     *
     * @return
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Method sets the namespace for this archetype.
     *
     * @param namespace
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Method returns the RM Publisher for this archetype.
     *
     * @return
     */
    public String getRmPublisher() {
        return rmPublisher;
    }

    /**
     * Method sets the RM Publisher for this archetype.
     *
     * @param rmPublisher
     */
    public void setRmPublisher(String rmPublisher) {
        this.rmPublisher = rmPublisher;
    }

    /**
     * Method returns the RM Package for this archetype.
     *
     * @return
     */
    public String getRmPackage() {
        return rmPackage;
    }

    /**
     * Method sets the RM package for this archetype.
     *
     * @param rmPackage
     */
    public void setRmPackage(String rmPackage) {
        this.rmPackage = rmPackage;
    }

    /**
     * Method returns the RM class for this archetype.
     *
     * @return
     */
    public String getRmClass() {
        return rmClass;
    }

    /**
     * Method sets the RM class for this archetype.
     *
     * @param rmClass
     */
    public void setRmClass(String rmClass) {
        this.rmClass = rmClass;
    }

    /**
     * Method returns the concept ID associated with this archetype.
     *
     * @return
     */
    public String getConceptId() {
        return conceptId;
    }

    /**
     * Method sets the concept ID associated with this archetype.
     *
     * @param conceptId
     */
    public void setConceptId(String conceptId) {
        this.conceptId = conceptId;
    }

    /**
     * Method returns the full numeric version of this archetype consisting of 3 parts, e.g. 1.8.2. The archetype_hrid feature includes only the major version.
     *
     * @return
     */
    public String getReleaseVersion() {
        StringBuilder builder = new StringBuilder();
        if(majorVersion != null) {
            builder.append(majorVersion);
            if(minorVersion != null) {
                builder.append(".").append(minorVersion);
                if(patchVersion != null) {
                    builder.append(".").append(patchVersion);
                }
            }
        } else {
            return null;
        }
        return builder.toString();
    }

    /**
     * Method requires a valid release version in the form of major.minor.patch,
     * where major, minor and patch are integer values. E.g., 1.8.2
     *
     * @param releaseVersion
     */
    public void setReleaseVersion(String releaseVersion) {
        if(StringUtils.isEmpty(releaseVersion)) {
            throw new InvalidArgumentException("Release version cannot be empty");
        }
        String[] components = releaseVersion.split("\\.");
        if(components.length != 3) {
            throw new InvalidArgumentException("Invalid release version format " + releaseVersion);
        } else {
            this.majorVersion = components[0];
            this.minorVersion = components[1];
            this.patchVersion = components[2];
        }
    }

    /**
     * Returns the version status for this archetype (e.g., rc2)
     * @return
     */
    public VersionStatus getVersionStatus() {
        return versionStatus;
    }

    /**
     * Method sets the version status of this archetype.
     *
     * @param versionStatus
     */
    public void setVersionStatus(VersionStatus versionStatus) {
        this.versionStatus = versionStatus;
    }

    /**
     * Method returns the build count for this archetype.
     *
     * @return
     */
    public String getBuildCount() {
        return buildCount;
    }

    /**
     * Method sets the build count for this archetype.
     *
     * @param buildCount
     */
    public void setBuildCount(String buildCount) {
        this.buildCount = buildCount;
    }

    /**
     * Method returns the semantic id (the 'interface' form) of the HRID, down it its major version
     *
     * @return
     */
    public String getSemanticId() {
        StringBuilder builder = new StringBuilder();
        if(namespace != null) {
            builder.append(namespace).append("::");
        }
        builder.append(rmPublisher).append("-").append(rmPackage).append("-").append(rmClass).append(".").append(conceptId).append(".v").append(majorVersion);
        return builder.toString();
    }

    /**
     * Method returns the 'physical' form of the HRID, including the complete version information
     *
     * @return
     */
    public String getPhysicalId() {
        StringBuilder builder = new StringBuilder(getSemanticId());
        if(minorVersion != null) {
            builder.append(".").append(minorVersion);
        }
        if(patchVersion != null) {
            builder.append(".").append(patchVersion);
        }
        return builder.toString();
    }

    /**
     * Method returns the full version identifier string, based on release_version and lifecycle. E.g. 1.8.2-rc.4
     *
     * @return
     */
    public String getVersionId() {
        return getPhysicalId() + "-" + versionStatus + "." + buildCount;
    }

    /**
     * Method returns the major version for this archetype
     *
     * @return
     */
    public String getMajorVersion() {
        return majorVersion;
    }

    /**
     * Method sets the major version for this archetype HRID
     *
     * @param majorVersion
     */
    public void setMajorVersion(String majorVersion) {
        this.majorVersion = majorVersion;
    }

    /**
     * Method returns the minor version for this archetype
     *
     * @return
     */
    public String getMinorVersion() {
        return minorVersion;
    }

    /**
     * Method sets the minor version for this archetype HRID
     *
     * @param minorVersion
     */
    public void setMinorVersion(String minorVersion) {
        this.minorVersion = minorVersion;
    }

    /**
     * Method returns the patch version for this archetype
     *
     * @return
     */
    public String getPatchVersion() {
        return patchVersion;
    }

    /**
     * Method sets the patch version for this HRID
     *
     * @param patchVersion
     */
    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }

    /**
     * Method returns the original HRID if one was provided
     *
     * @return
     */
    public String getOriginalId() {
        return originalId;
    }

    /**
     * Method sets the original HRID
     *
     * @param originalId
     */
    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    /**
     * Validates the Archetype HRID
     *
     * @return
     */
    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();
        result.setValid(false);
        if(StringUtils.isEmpty(rmPublisher)) {
            result.addValidationErrorMessage("Inv_rm_publisher_validity", "RM Publisher cannot be empty");
        } else if(StringUtils.isEmpty(rmPackage)) {
            result.addValidationErrorMessage("Inv_rm_package_validity", "RM Package cannot be empty");
        } else if(StringUtils.isEmpty(rmClass)) {
            result.addValidationErrorMessage("Inv_class_name_validity", "RM Class cannot be empty");
        } else if(StringUtils.isEmpty(conceptId)) {
            result.addValidationErrorMessage("Inv_concept_id_validity", "Concept ID cannot be empty");
        } else  if(StringUtils.isEmpty(getReleaseVersion())) {
            result.addValidationErrorMessage("Inv_release_version_validity", "Release version cannot be empty");
        } else {
            result.setValid(true);
        }
        return result;
    }

    public static ArchetypeHrid fromString(String hrid) {
        Matcher matcher = HRID_COMPILED_PATTERN.matcher(hrid);
        ArchetypeHrid archetypeHrid = new ArchetypeHrid();
        archetypeHrid.setOriginalId(hrid);
        if (matcher.find( )) {
            String namespace =  matcher.group("namespace");
            archetypeHrid.setNamespace(namespace);
            String rmPublisher = matcher.group("publisher");
            archetypeHrid.setRmPublisher(rmPublisher);
            String rmPackage = matcher.group("package");
            archetypeHrid.setRmPackage(rmPackage);
            String rmClass = matcher.group("class");
            archetypeHrid.setRmClass(rmClass);
            String conceptId = matcher.group("conceptid");
            archetypeHrid.setConceptId(conceptId);
            String majorVersion = matcher.group("major");
            archetypeHrid.setMajorVersion(majorVersion);
            String minorVersion = matcher.group("minor");
            archetypeHrid.setMinorVersion(minorVersion);
            String patchVersion = matcher.group("patch");
            archetypeHrid.setPatchVersion(patchVersion);
            String versionStatus = matcher.group("status");
            if(versionStatus != null && versionStatus.equalsIgnoreCase("-rc")) {
                archetypeHrid.setVersionStatus(VersionStatus.RELEASE_CANDIDATE);
            } else if(versionStatus != null && versionStatus.equalsIgnoreCase("-alpha")) {
                archetypeHrid.setVersionStatus(VersionStatus.ALPHA);
            }
            String buildCount = matcher.group("count");
            archetypeHrid.setBuildCount(buildCount);
        } else {
            throw new RuntimeException(hrid + " has an invalid format");
        }
        return archetypeHrid;
    }
}
