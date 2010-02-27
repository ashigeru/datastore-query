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
 * プロパティ参照を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class PropertyTerm extends Term {

    /**
     * プロパティを保持する変数。
     */
    public final SimpleName variable;

    /**
     * プロパティの名称。
     */
    public final SimpleName name;

    /**
     * このクラスのインスタンスを生成する。
     * @param variable プロパティを保持する変数
     * @param name プロパティの名称
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public PropertyTerm(
            SimpleName variable,
            SimpleName name
            ) {
        if (variable == null) {
            throw new IllegalArgumentException("variable");
        }
        if (name == null) {
            throw new IllegalArgumentException("name");
        }
        this.variable = variable;
        this.name = name;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitPropertyTerm(PropertyTerm,Object) visitPropertyTerm(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitPropertyTerm(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "PropertyTerm'{'variable:{0}, name:{1}'}'",
            variable,
            name
            );
    }
}
