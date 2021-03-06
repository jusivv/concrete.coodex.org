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

package org.coodex.concrete.core.intercept;


/**
 * Created by davidoff shen on 2016-09-01.
 */
public class InterceptOrders {

    /**
     * 审计切片
     */
    public static final int SYSTEM_AUDIT = 100;

    /**
     * 系统服务时间
     */
    public static final int SERVICE_TIMING = 200;

    /**
     * Bean有效性验证切片
     */
    public static final int BEAN_VALIDATION = 1000;

    /**
     * RBAC切片
     */
    public static final int RBAC = 9000;


    public static final int OTHER = 9001;
}
