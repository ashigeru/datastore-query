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
 * {@link Node}を渡り歩くビジタ。
 * <p>
 * この実装では、すべてのメソッドが何も行わずに{@code null}を返す。
 * </p>
 * @param <R> 戻り値の型
 * @param <C> コンテキストオブジェクトの型
 * @param <E> 例外の型
 * @author Suguru ARAKAWA
 */
public abstract class Visitor<R, C, E extends Throwable> {
<#list beans as bean><#if bean.hasAttribute("Abstract") = false>

    /**
     * {@link ${bean.typeSpec.name}#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link ${bean.typeSpec.name}#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visit${bean.typeSpec.name}(
            ${bean.typeSpec.name} elem,
            C context) throws E {
        return null;
    }
</#if></#list>
}
