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
 * From句を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class Source extends Node {

    /**
     * 元となるエンティティの種類。
     */
    public final Type type;

    /**
     * 個々のエンティティを束縛するシンボルの名称。
     */
    public final SimpleName paremeter;

    /**
     * このクラスのインスタンスを生成する。
     * @param type 元となるエンティティの種類
     * @param paremeter 個々のエンティティを束縛するシンボルの名称
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Source(
            Type type,
            SimpleName paremeter
            ) {
        if (type == null) {
            throw new IllegalArgumentException("type");
        }
        if (paremeter == null) {
            throw new IllegalArgumentException("paremeter");
        }
        this.type = type;
        this.paremeter = paremeter;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitSource(Source,Object) visitSource(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitSource(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "Source'{'type:{0}, paremeter:{1}'}'",
            type,
            paremeter
            );
    }
}
