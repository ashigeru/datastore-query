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

import org.ashigeru.appengine.datastore.common.LiteralKind;

/**
 * リテラルを表すクラス。
 * @author Suguru ARAKAWA
 */
public final class Literal extends Term {

    /**
     * リテラルの種類。
     */
    public final LiteralKind kind;

    /**
     * リテラルを構成するトークン。
     */
    public final String token;

    /**
     * このクラスのインスタンスを生成する。
     * @param kind リテラルの種類
     * @param token リテラルを構成するトークン
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Literal(
            LiteralKind kind,
            String token
            ) {
        if (kind == null) {
            throw new IllegalArgumentException("kind");
        }
        if (token == null) {
            throw new IllegalArgumentException("token");
        }
        this.kind = kind;
        this.token = token;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitLiteral(Literal,Object) visitLiteral(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitLiteral(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "Literal'{'kind:{0}, token:{1}'}'",
            kind,
            token
            );
    }
}
