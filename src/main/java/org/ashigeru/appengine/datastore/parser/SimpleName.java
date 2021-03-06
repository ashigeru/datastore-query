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
 * 単純名を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class SimpleName extends Name {

    /**
     * 識別子。
     */
    public final String identifier;

    /**
     * このクラスのインスタンスを生成する。
     * @param identifier 識別子
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public SimpleName(
            String identifier
            ) {
        if (identifier == null) {
            throw new IllegalArgumentException("identifier");
        }
        this.identifier = identifier;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitSimpleName(SimpleName,Object) visitSimpleName(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitSimpleName(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "SimpleName'{'identifier:{0}'}'",
            identifier
            );
    }
}
