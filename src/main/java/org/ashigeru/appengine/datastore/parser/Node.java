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
 * すべての中小構文木の基底となるクラス。
 * @author ashigeru
 */
public abstract class Node {

    /**
     * 指定のビジタを受け入れ、{@link Visitor}の対応するメソッドに処理を委譲する。
     * @param <R> ビジタの実行結果
     * @param <C> ビジタに渡す引数の型
     * @param <E> ビジタの例外型
     * @param visitor 対象のビジタ
     * @param context ビジタに渡す引数(省略可)
     * @return ビジタの実行結果
     * @throws E ビジタ内で例外が発生した場合
     * @throws IllegalArgumentException {@code visitor}に{@code null}が指定された場合
     */
    public abstract <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E;
}
