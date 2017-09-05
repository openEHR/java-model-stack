package org.openehr.basetypes;

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

import org.openehr.basetypes.primitivetypes.OrderedNumeric;

import java.util.HashMap;
import java.util.Map;

public class OpenEhrTypeMapper {

    private Map<Class<? extends Any>, Class<?>> map;

    public OpenEhrTypeMapper() {
        map = new HashMap<>();
        map.put(Any.class, Object.class);
        map.put(OrderedNumeric.class, Number.class);
        map.put(org.openehr.basetypes.primitivetypes.Boolean.class, java.lang.Boolean.class);
        map.put(org.openehr.basetypes.primitivetypes.Integer.class, java.lang.Integer.class);
        map.put(org.openehr.basetypes.primitivetypes.Integer64.class, java.lang.Long.class);
        map.put(org.openehr.basetypes.primitivetypes.Real.class, java.lang.Float.class);
        map.put(org.openehr.basetypes.primitivetypes.Integer64.class, java.lang.Long.class);
        map.put(org.openehr.basetypes.primitivetypes.Double.class, java.lang.Double.class);
        map.put(org.openehr.basetypes.primitivetypes.String.class, java.lang.String.class);
        map.put(org.openehr.basetypes.primitivetypes.String.class, java.lang.String.class);
        map.put(org.openehr.basetypes.structures.List.class, java.util.List.class);
        map.put(org.openehr.basetypes.structures.Set.class, java.util.Set.class);
        map.put(org.openehr.basetypes.structures.Hash.class, java.util.Map.class);

    }

    public Class<?> getEquivalentJavaType(Class<? extends Any> openEhrType) {
        return map.get(openEhrType);
    }
}
