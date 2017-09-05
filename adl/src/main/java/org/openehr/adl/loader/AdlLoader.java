package org.openehr.adl.loader;

import org.openehr.adl.antlr.AdlVisitorImpl;
import org.openehr.adl.antlr.adlLexer;
import org.openehr.adl.antlr.adlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by cnanjo on 4/17/16.
 */
public class AdlLoader {

    private static Logger log = LogManager.getLogger(AdlLoader.class.getName());

    public AdlVisitorImpl loadAdlFile(String adlFilePath) {
        File file = new File(adlFilePath);
        AdlVisitorImpl visitor = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            visitor = loadAdlFile(fis);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            log.error("Error loading ADL archetype", ioe);
            throw new RuntimeException("Error loading ADL archetype", ioe);
        }
        return visitor;
    }

    public AdlVisitorImpl loadAdlFile(InputStream inputStream) {
        AdlVisitorImpl visitor = new AdlVisitorImpl();
        try {
            ANTLRInputStream input = new ANTLRInputStream(inputStream);
            adlLexer lexer = new adlLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            adlParser parser = new adlParser(tokens);
            ParseTree tree = parser.adl();
            visitor.visit(tree);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            log.error("Error loading ADL archetype", ioe);
            throw new RuntimeException("Error loading ADL archetype", ioe);
        }
        return visitor;
    }
}

