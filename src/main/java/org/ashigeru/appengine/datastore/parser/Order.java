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
 * Order By句を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class Order extends Node {

    /**
     * 整列基準の一覧。
     */
    public final java.util.List<? extends OrderCriterion> criteria;

    /**
     * このクラスのインスタンスを生成する。
     * @param criteria 整列基準の一覧
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Order(
            java.util.List<? extends OrderCriterion> criteria
            ) {
        if (criteria == null) {
            throw new IllegalArgumentException("criteria");
        }
        this.criteria = java.util.Collections.unmodifiableList(criteria);
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitOrder(Order,Object) visitOrder(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitOrder(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "Order'{'criteria:{0}'}'",
            criteria
            );
    }
}
