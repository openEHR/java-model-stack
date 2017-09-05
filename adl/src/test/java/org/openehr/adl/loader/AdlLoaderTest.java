package org.openehr.adl.loader;

import org.openehr.adl.antlr.AdlVisitorImpl;
import org.openehr.adl.antlr.adlVisitor;
import org.junit.Test;

/**
 * Created by cnanjo on 5/18/16.
 */
public class AdlLoaderTest {
    @Test
    public void loadAdlFile() throws Exception {
        AdlLoader loader = new AdlLoader();
        AdlVisitorImpl visitor = loader.loadAdlFile(AdlLoaderTest.class.getResourceAsStream("/CIMI-CORE-ACTOR.actor.v1.0.0.adls"));
        visitor.getAstRootNode();
//        assertEquals("Stack should consist of a single item", 1, visitor.getStack().size());
//        CompositeOdinObject root = visitor.getAstRootNode();
//        validateRootLevelAttributes(root);
    }

    @Test
    public void loadAdlFile1() throws Exception {

    }

}