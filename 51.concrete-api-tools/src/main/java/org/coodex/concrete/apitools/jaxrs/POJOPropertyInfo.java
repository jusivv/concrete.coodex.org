/*
 * Copyright (c) 2017 coodex.org (jujus.shen@126.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.coodex.concrete.apitools.jaxrs;

import org.coodex.concrete.api.Description;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.coodex.concrete.jaxrs.JaxRSHelper.lowerFirstChar;

/**
 * Created by davidoff shen on 2016-12-04.
 */
public class POJOPropertyInfo {

    public POJOPropertyInfo(Class<?> contextType, Method method) {
        String methodName = method.getName();
        int startIndex = methodName.startsWith("is") && method.getReturnType() == boolean.class ? 2 : 3;
        name = lowerFirstChar(method.getName().substring(startIndex));
        pojoTypeInfo = new POJOTypeInfo(contextType, method.getGenericReturnType());
        description = method.getAnnotation(Description.class);
//        type = method.getGenericReturnType();
    }

    public POJOPropertyInfo(Class<?> contextType, Field field) {
        name = field.getName();
        description = field.getAnnotation(Description.class);
        pojoTypeInfo = new POJOTypeInfo(contextType, field.getGenericType());
//        type = field.getGenericType();
    }

    private final String name;
    private final Description description;
    private POJOTypeInfo pojoTypeInfo;

//    private final Type type;

    public String getName() {
        return name;
    }

    public POJOTypeInfo getType() {
        return pojoTypeInfo;
    }

    public String getLabel() {
        return description == null ? "" : description.name();
//        return Common.isBlank(s) ? "　" : s;
    }

    public String getDescription() {
        return description == null ? "" : description.description();
//        return Common.isBlank(s) ? "　" : s;
    }

//    public String getTypeString(){
//
//    }
}
