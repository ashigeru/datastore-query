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
 * 限定名を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class QualifiedName extends Name {

    /**
     * 限定子。
     */
    public final Name name;

    /**
     * 単純名。
     */
    public final SimpleName simpleName;

    /**
     * このクラスのインスタンスを生成する。
     * @param name 限定子
     * @param simpleName 単純名
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public QualifiedName(
            Name name,
            SimpleName simpleName
            ) {
        if (name == null) {
            throw new IllegalArgumentException("name");
        }
        if (simpleName == null) {
            throw new IllegalArgumentException("simpleName");
        }
        this.name = name;
        this.simpleName = simpleName;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitQualifiedName(QualifiedName,Object) visitQualifiedName(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitQualifiedName(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "QualifiedName'{'name:{0}, simpleName:{1}'}'",
            name,
            simpleName
            );
    }
}
