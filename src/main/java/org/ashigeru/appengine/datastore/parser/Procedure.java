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
 * 適用する手続きを表すクラス。
 * @author Suguru ARAKAWA
 */
public final class Procedure extends Node {

    /**
     * 手続きの名前。
     */
    public final SimpleName name;

    /**
     * 手続きに渡す引数の一覧。
     */
    public final java.util.List<? extends Term> arguments;

    /**
     * 手続きに複数の要素を渡す場合の、1回分の最大数(省略可)。
     */
    public final Term every;

    /**
     * このクラスのインスタンスを生成する。
     * @param name 手続きの名前
     * @param arguments 手続きに渡す引数の一覧
     * @param every 手続きに複数の要素を渡す場合の、1回分の最大数(省略可)
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Procedure(
            SimpleName name,
            java.util.List<? extends Term> arguments,
            Term every
            ) {
        if (name == null) {
            throw new IllegalArgumentException("name");
        }
        if (arguments == null) {
            throw new IllegalArgumentException("arguments");
        }
        this.name = name;
        this.arguments = java.util.Collections.unmodifiableList(arguments);
        this.every = every;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitProcedure(Procedure,Object) visitProcedure(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitProcedure(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "Procedure'{'name:{0}, arguments:{1}, every:{2}'}'",
            name,
            arguments,
            every
            );
    }
}
