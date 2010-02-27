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

import org.ashigeru.appengine.datastore.common.OrderDirection;

/**
 * 整列基準句を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class OrderCriterion extends Node {

    /**
     * 整列する順序の方向。
     */
    public final OrderDirection direction;

    /**
     * 整列基準の項。
     */
    public final Term target;

    /**
     * このクラスのインスタンスを生成する。
     * @param direction 整列する順序の方向
     * @param target 整列基準の項
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public OrderCriterion(
            OrderDirection direction,
            Term target
            ) {
        if (direction == null) {
            throw new IllegalArgumentException("direction");
        }
        if (target == null) {
            throw new IllegalArgumentException("target");
        }
        this.direction = direction;
        this.target = target;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitOrderCriterion(OrderCriterion,Object) visitOrderCriterion(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitOrderCriterion(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "OrderCriterion'{'direction:{0}, target:{1}'}'",
            direction,
            target
            );
    }
}
