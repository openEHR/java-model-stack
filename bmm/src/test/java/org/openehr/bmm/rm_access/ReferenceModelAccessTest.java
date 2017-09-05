package org.openehr.bmm.rm_access;

/*
 * #%L
 * OpenEHR - Java Model Stack
 * %%
 * Copyright (C) 2016 - 2017  Cognitive Medical Systems, Inc (http://www.cognitivemedicine.com).
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 * Author: Claude Nanjo
 */

import org.junit.Before;
import org.junit.Test;
import org.openehr.bmm.persistence.deserializer.BmmSchemaDeserializer;
import org.openehr.bmm.persistence.deserializer.BmmSchemaDeserializerTest;
import org.openehr.odin.CompositeOdinObject;
import org.openehr.odin.antlr.OdinVisitorImpl;
import org.openehr.odin.loader.OdinLoaderImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReferenceModelAccessTest {

    private List<String> schemaDirectories;

    @Before
    public void setup() {
        schemaDirectories = new ArrayList<>();
        String path = ReferenceModelAccessTest.class.getResource("/cimi/CIMI-RM-3.0.5.bmm").getFile();
        path = path.substring(0, path.lastIndexOf('/'));
        schemaDirectories.add(path);
    }
    @Test
    public void getSchemaDirectories() throws Exception {

    }

    @Test
    public void setSchemaDirectories() throws Exception {

    }

    @Test
    public void getAllSchemas() throws Exception {

    }

    @Test
    public void setAllSchemas() throws Exception {

    }

    @Test
    public void getValidModels() throws Exception {
        ReferenceModelAccess access = new ReferenceModelAccess();
        access.setSchemaDirectories(schemaDirectories);
        access.initializeAll();
        System.out.println("DONE");
    }

    @Test
    public void setValidModels() throws Exception {

    }

    @Test
    public void initializeWithLoadList() throws Exception {

    }

    @Test
    public void initializeAll() throws Exception {

    }

    @Test
    public void clearCache() throws Exception {

    }

    @Test
    public void reloadSchemas() throws Exception {

    }

}