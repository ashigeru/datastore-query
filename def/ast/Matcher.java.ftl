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

import java.util.Collection;
import java.util.List;

/**
 * 2つの{@link Node}の構造を比較する。
 * @author ashigeru
 */
class Matcher extends Visitor<Boolean, Node, RuntimeException> {
<#list beans as bean><#if bean.hasAttribute("Abstract") = false>

    @Override
    public Boolean visit${bean.typeSpec.name}(
            ${bean.typeSpec.name} elem,
            Node context) {
        if ((context instanceof ${bean.typeSpec.name}) == false) {
            return Boolean.FALSE;
        }
        ${bean.typeSpec.name} other = (${bean.typeSpec.name}) context;
<#list bean.propertyList as prop>
        if (eq(elem.${prop.name}, other.${prop.name}) == false) {
            return Boolean.FALSE;
        }
</#list>
        return Boolean.TRUE;
    }
</#if></#list>

    private boolean eq(Enum<?> a, Enum<?> b) {
        return a == b;
    }

    private boolean eq(String a, String b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        return a.equals(b);
    }

    private boolean eq(Node a, Node b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        return a.accept(this, b);
    }

    private boolean eq(List<? extends Node> a, List<? extends Node> b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        int size = a.size();
        if (size != b.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (eq(a.get(i), b.get(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
