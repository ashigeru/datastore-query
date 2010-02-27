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

/**
 * 未実装のものに対して例外をスローする{@link Visitor}の骨格実装。
 * <p>
 * この実装では、すべてのメソッドが何も行わずに{@link UnsupportedOperationException}をスローする。
 * </p>
 * @param <R> 戻り値の型
 * @param <C> コンテキストオブジェクトの型
 * @param <E> 例外の型
 * @author ashigeru
 */
public abstract class StrictVisitor<R, C, E extends Throwable>
        extends Visitor<R, C, E> {
<#list beans as bean><#if bean.hasAttribute("Abstract") = false>

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visit${bean.typeSpec.name}(
            ${bean.typeSpec.name} elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visit${bean.typeSpec.name} is not overridden (elem={0}, context={1})",
            elem, context));
    }
</#if></#list>
}
