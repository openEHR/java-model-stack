package org.openehr.basetypes.definitions;

/*
 * #%L
 * OpenEHR - Java Model Stack
 * %%
 * Copyright (C) 2016 - 2017 Cognitive Medical Systems
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

/**
 * Definitions relating to the internal code system of archetypes.
 *
 * Created by cnanjo on 5/18/16.
 */
public class AdlCodeDefinitions {

    /**
     * String leader of ‘identifier’ codes, i.e. codes used to identify archetype nodes.
     */
    public static final String ID_CODE_LEADER = "id";

    /**
     * String leader of ‘value’ codes, i.e. codes used to identify codes values, including value set members.
     */
    public static final String VALUE_CODE_LEADER = "at";

    /**
     * String leader of ‘value set’ codes, i.e. codes used to identify value sets.
     */
    public static final String VALUE_SET_CODE_LEADER = "ac";

    /**
     * Character used to separate numeric parts of codes belonging to different specialisation levels.
     */
    public static final Character SPECIALIZATION_SEPARATOR = '.';

    /**
     * Regex used to define the legal numeric part of any archetype code. Corresponds to the simple pattern of dotted numbers, as used in typical multi-level numbering schemes.
     */
    public static final String CODE_REGEX_PATTERN = "(0|[1-9][0-9]*)(\\.(0|[1-9][0-9]*))*";

    /**
     * Regex pattern of the root id code of any archetype. Corresponds to codes of the form id1, id1.1, id1.1.1 etc..
     */
    public static final String ROOT_CODE_REGEX_PATTERN = "^id1(\\.1)*$";

    /**
     * Code id used for C_PRIMITIVE_OBJECT nodes on creation.
     */
    public static final String PRIMITIVE_NODE_ID = "id9999";
}
