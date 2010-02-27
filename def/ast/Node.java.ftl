/*
 * Copyright 2010 @ashigeru.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.ashigeru.appengine.datastore.parser;

import org.ashigeru.appengine.datastore.common.*;

<#if bean.hasAttribute("Abstract")>
    <#assign inheritivity = "abstract">
<#else>
    <#assign inheritivity = "final">
</#if>
/**
 * ${bean.getAttribute("Doc")}を表すクラス。
 * @author Suguru ARAKAWA
 */
public ${inheritivity} class ${bean.typeSpec.name}<#if bean.extendsList?size != 0> extends <#list bean.extendsList as t><#if t_index != 0>, </#if>${type(t)}</#list></#if> {
<#list bean.propertyList as prop>

    /**
     * ${prop.getAttribute("Doc")}。
     */
    public final ${type(prop.type)} ${prop.name};
</#list>
<#if bean.propertyList?size != 0>

    /**
     * このクラスのインスタンスを生成する。
<#list bean.propertyList as prop>
     * @param ${prop.name} ${prop.getAttribute("Doc")}
</#list>
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public ${bean.typeSpec.name}(
<#list bean.propertyList as prop>
            ${type(prop.type)} ${prop.name}<#if prop_has_next>,</#if>
</#list>
            ) {
<#list bean.propertyList as prop>
<#if prop.hasAttribute("Optional") == false>
        if (${prop.name} == null) {
            throw new IllegalArgumentException("${prop.name}");
        }
</#if>
</#list>
<#list bean.propertyList as prop>
<#if prop.type.dimensions != 0>
        this.${prop.name} = java.util.Collections.unmodifiableList(${prop.name});
<#else>
        this.${prop.name} = ${prop.name};
</#if>
</#list>
    }
</#if>
<#if bean.hasAttribute("Abstract") = false>

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visit${bean.typeSpec.name}(${bean.typeSpec.name},Object) visit${bean.typeSpec.name}(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visit${bean.typeSpec.name}(this, context);
    }

    @Override
    public String toString() {
<#if bean.propertyList?size = 0>
        return "${bean.typeSpec.name}";
<#else>
        return java.text.MessageFormat.format(
            "${bean.typeSpec.name}'{'<#list bean.propertyList as prop>${prop.name}:{${prop_index}}<#if prop_has_next>, </#if></#list>'}'",
<#list bean.propertyList as prop>
            ${prop.name}<#if prop_has_next>,</#if>
</#list>
            );
</#if>
    }
<#elseif bean.propertyList?size = 0>
    // no members
</#if>
}
