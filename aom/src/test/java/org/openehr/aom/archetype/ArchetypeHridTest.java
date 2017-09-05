package org.openehr.aom.archetype;

import org.junit.Before;
import org.junit.Test;
import org.openehr.basetypes.definitions.VersionStatus;

import static org.junit.Assert.*;

/**
 * Created by cnanjo on 6/2/16.
 */
public class ArchetypeHridTest {

    //TODO Add sad paths

    public static final String GOOD_STRING1 = "uk.gov.nhs::CIMI-CORE-ACTOR.actor.v1.0.0-rc.22";
    public static final String GOOD_STRING2 = "CIMI-CORE-ACTOR.actor.v1.0.0";
    public static final String GOOD_STRING3 = "CIMI-CORE-ACTOR.actor.v1";
    public static final String BAD_STRING1 = "CORE-ACTOR.actor.v1";

    private ArchetypeHrid releaseCandidate;
    private ArchetypeHrid semanticId;
    private ArchetypeHrid physicalId;

    @Before
    public void setup() {
        releaseCandidate = ArchetypeHrid.fromString(GOOD_STRING1);
        semanticId = ArchetypeHrid.fromString(GOOD_STRING3);
        physicalId = ArchetypeHrid.fromString(GOOD_STRING2);
    }

    @Test
    public void getNamespace() throws Exception {
        assertEquals("uk.gov.nhs", releaseCandidate.getNamespace());
        assertNull(semanticId.getNamespace());
        assertNull(physicalId.getNamespace());
    }

    @Test
    public void getRmPublisher() throws Exception {
        assertEquals("CIMI", releaseCandidate.getRmPublisher());
        assertEquals("CIMI", semanticId.getRmPublisher());
        assertEquals("CIMI", physicalId.getRmPublisher());
    }

    @Test
    public void getRmPackage() throws Exception {
        assertEquals("CORE", releaseCandidate.getRmPackage());
        assertEquals("CORE", semanticId.getRmPackage());
        assertEquals("CORE", physicalId.getRmPackage());
    }

    @Test
    public void getRmClass() throws Exception {
        assertEquals("ACTOR", releaseCandidate.getRmClass());
        assertEquals("ACTOR", semanticId.getRmClass());
        assertEquals("ACTOR", physicalId.getRmClass());
    }

    @Test
    public void getConceptId() throws Exception {
        assertEquals("actor", releaseCandidate.getConceptId());
        assertEquals("actor", semanticId.getConceptId());
        assertEquals("actor", physicalId.getConceptId());
    }

    @Test
    public void getReleaseVersion() throws Exception {
        assertEquals("1.0.0", releaseCandidate.getReleaseVersion());
        assertEquals("1", semanticId.getReleaseVersion());
        assertEquals("1.0.0", physicalId.getReleaseVersion());
    }

    @Test
    public void getVersionStatus() throws Exception {
        assertEquals(VersionStatus.RELEASE_CANDIDATE, releaseCandidate.getVersionStatus());
        assertNull(semanticId.getVersionStatus());
        assertNull(physicalId.getVersionStatus());
    }

    @Test
    public void getBuildCount() throws Exception {
        assertEquals("22", releaseCandidate.getBuildCount());
        assertNull(semanticId.getBuildCount());
        assertNull(physicalId.getBuildCount());
    }

    @Test
    public void getSemanticId() throws Exception {
        assertEquals("uk.gov.nhs::CIMI-CORE-ACTOR.actor.v1", releaseCandidate.getSemanticId());
        assertEquals("CIMI-CORE-ACTOR.actor.v1", semanticId.getSemanticId());
        assertEquals("CIMI-CORE-ACTOR.actor.v1", physicalId.getSemanticId());
    }

    @Test
    public void getPhysicalId() throws Exception {
        assertEquals("uk.gov.nhs::CIMI-CORE-ACTOR.actor.v1.0.0", releaseCandidate.getPhysicalId());
        assertEquals("CIMI-CORE-ACTOR.actor.v1", semanticId.getPhysicalId());
        assertEquals("CIMI-CORE-ACTOR.actor.v1.0.0", physicalId.getPhysicalId());
    }

    @Test
    public void getVersionId() throws Exception {

    }

    @Test
    public void getMajorVersion() throws Exception {
        assertEquals("1", releaseCandidate.getMajorVersion());
        assertEquals("1", semanticId.getMajorVersion());
        assertEquals("1", physicalId.getMajorVersion());
    }

    @Test
    public void getMinorVersion() throws Exception {
        assertEquals("0", releaseCandidate.getMinorVersion());
        assertNull(semanticId.getMinorVersion());
        assertEquals("0", physicalId.getMinorVersion());
    }

    @Test
    public void getPatchVersion() throws Exception {
        assertEquals("0", releaseCandidate.getPatchVersion());
        assertNull(semanticId.getPatchVersion());
        assertEquals("0", physicalId.getPatchVersion());
    }

    @Test
    public void validate() throws Exception {
        assertTrue(releaseCandidate.validate().isValid());
        assertTrue(semanticId.validate().isValid());
        assertTrue(physicalId.validate().isValid());
    }

    @Test
    public void fromString() throws Exception {
        try {
            ArchetypeHrid badArchetypeHrid1 = ArchetypeHrid.fromString(BAD_STRING1);
            fail();
        } catch(Exception e) {

        }
    }

}