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
 * Apply文を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class ApplyStatement extends Statement {

    /**
     * 結果に対して適用する手続き。
     */
    public final Procedure procedure;

    /**
     * 元となるエンティティの一覧。
     */
    public final Source source;

    /**
     * フィルタ(省略可)。
     */
    public final Filter filter;

    /**
     * 整列順序(省略可)。
     */
    public final Order order;

    /**
     * このクラスのインスタンスを生成する。
     * @param procedure 結果に対して適用する手続き
     * @param source 元となるエンティティの一覧
     * @param filter フィルタ(省略可)
     * @param order 整列順序(省略可)
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public ApplyStatement(
            Procedure procedure,
            Source source,
            Filter filter,
            Order order
            ) {
        if (procedure == null) {
            throw new IllegalArgumentException("procedure");
        }
        if (source == null) {
            throw new IllegalArgumentException("source");
        }
        this.procedure = procedure;
        this.source = source;
        this.filter = filter;
        this.order = order;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitApplyStatement(ApplyStatement,Object) visitApplyStatement(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitApplyStatement(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "ApplyStatement'{'procedure:{0}, source:{1}, filter:{2}, order:{3}'}'",
            procedure,
            source,
            filter,
            order
            );
    }
}
