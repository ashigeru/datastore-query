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
 * リストを表すクラス。
 * @author Suguru ARAKAWA
 */
public final class ListTerm extends Term {

    /**
     * 要素の一覧。
     */
    public final java.util.List<? extends Term> elements;

    /**
     * このクラスのインスタンスを生成する。
     * @param elements 要素の一覧
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public ListTerm(
            java.util.List<? extends Term> elements
            ) {
        if (elements == null) {
            throw new IllegalArgumentException("elements");
        }
        this.elements = java.util.Collections.unmodifiableList(elements);
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitListTerm(ListTerm,Object) visitListTerm(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitListTerm(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "ListTerm'{'elements:{0}'}'",
            elements
            );
    }
}
