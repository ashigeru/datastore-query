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

import java.util.List;

/**
 * 2つの{@link Node}の構造を比較する。
 * @author ashigeru
 */
class Matcher extends Visitor<Boolean, Node, RuntimeException> {

    @Override
    public Boolean visitSelectStatement(
            SelectStatement elem,
            Node context) {
        if ((context instanceof SelectStatement) == false) {
            return Boolean.FALSE;
        }
        SelectStatement other = (SelectStatement) context;
        if (eq(elem.values, other.values) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.source, other.source) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.filter, other.filter) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.order, other.order) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitApplyStatement(
            ApplyStatement elem,
            Node context) {
        if ((context instanceof ApplyStatement) == false) {
            return Boolean.FALSE;
        }
        ApplyStatement other = (ApplyStatement) context;
        if (eq(elem.procedure, other.procedure) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.source, other.source) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.filter, other.filter) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.order, other.order) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitProcedure(
            Procedure elem,
            Node context) {
        if ((context instanceof Procedure) == false) {
            return Boolean.FALSE;
        }
        Procedure other = (Procedure) context;
        if (eq(elem.name, other.name) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.arguments, other.arguments) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.every, other.every) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSource(
            Source elem,
            Node context) {
        if ((context instanceof Source) == false) {
            return Boolean.FALSE;
        }
        Source other = (Source) context;
        if (eq(elem.type, other.type) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.paremeter, other.paremeter) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitFilter(
            Filter elem,
            Node context) {
        if ((context instanceof Filter) == false) {
            return Boolean.FALSE;
        }
        Filter other = (Filter) context;
        if (eq(elem.constraint, other.constraint) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitOrder(
            Order elem,
            Node context) {
        if ((context instanceof Order) == false) {
            return Boolean.FALSE;
        }
        Order other = (Order) context;
        if (eq(elem.criteria, other.criteria) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitOrderCriterion(
            OrderCriterion elem,
            Node context) {
        if ((context instanceof OrderCriterion) == false) {
            return Boolean.FALSE;
        }
        OrderCriterion other = (OrderCriterion) context;
        if (eq(elem.direction, other.direction) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.target, other.target) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitOrConstraint(
            OrConstraint elem,
            Node context) {
        if ((context instanceof OrConstraint) == false) {
            return Boolean.FALSE;
        }
        OrConstraint other = (OrConstraint) context;
        if (eq(elem.left, other.left) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.right, other.right) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitAndConstraint(
            AndConstraint elem,
            Node context) {
        if ((context instanceof AndConstraint) == false) {
            return Boolean.FALSE;
        }
        AndConstraint other = (AndConstraint) context;
        if (eq(elem.left, other.left) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.right, other.right) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitNotConstraint(
            NotConstraint elem,
            Node context) {
        if ((context instanceof NotConstraint) == false) {
            return Boolean.FALSE;
        }
        NotConstraint other = (NotConstraint) context;
        if (eq(elem.operand, other.operand) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitRelational(
            Relational elem,
            Node context) {
        if ((context instanceof Relational) == false) {
            return Boolean.FALSE;
        }
        Relational other = (Relational) context;
        if (eq(elem.operator, other.operator) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.left, other.left) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.right, other.right) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitBlock(
            Block elem,
            Node context) {
        if ((context instanceof Block) == false) {
            return Boolean.FALSE;
        }
        Block other = (Block) context;
        if (eq(elem.constraint, other.constraint) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitQuantification(
            Quantification elem,
            Node context) {
        if ((context instanceof Quantification) == false) {
            return Boolean.FALSE;
        }
        Quantification other = (Quantification) context;
        if (eq(elem.parameter, other.parameter) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.target, other.target) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.constraint, other.constraint) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitBinaryTerm(
            BinaryTerm elem,
            Node context) {
        if ((context instanceof BinaryTerm) == false) {
            return Boolean.FALSE;
        }
        BinaryTerm other = (BinaryTerm) context;
        if (eq(elem.operator, other.operator) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.left, other.left) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.right, other.right) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitUnaryTerm(
            UnaryTerm elem,
            Node context) {
        if ((context instanceof UnaryTerm) == false) {
            return Boolean.FALSE;
        }
        UnaryTerm other = (UnaryTerm) context;
        if (eq(elem.operator, other.operator) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.operand, other.operand) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitParenthesizedTerm(
            ParenthesizedTerm elem,
            Node context) {
        if ((context instanceof ParenthesizedTerm) == false) {
            return Boolean.FALSE;
        }
        ParenthesizedTerm other = (ParenthesizedTerm) context;
        if (eq(elem.term, other.term) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitListTerm(
            ListTerm elem,
            Node context) {
        if ((context instanceof ListTerm) == false) {
            return Boolean.FALSE;
        }
        ListTerm other = (ListTerm) context;
        if (eq(elem.elements, other.elements) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitPropertyTerm(
            PropertyTerm elem,
            Node context) {
        if ((context instanceof PropertyTerm) == false) {
            return Boolean.FALSE;
        }
        PropertyTerm other = (PropertyTerm) context;
        if (eq(elem.variable, other.variable) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.name, other.name) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitConstructTerm(
            ConstructTerm elem,
            Node context) {
        if ((context instanceof ConstructTerm) == false) {
            return Boolean.FALSE;
        }
        ConstructTerm other = (ConstructTerm) context;
        if (eq(elem.name, other.name) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.arguments, other.arguments) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitLiteral(
            Literal elem,
            Node context) {
        if ((context instanceof Literal) == false) {
            return Boolean.FALSE;
        }
        Literal other = (Literal) context;
        if (eq(elem.kind, other.kind) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.token, other.token) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitType(
            Type elem,
            Node context) {
        if ((context instanceof Type) == false) {
            return Boolean.FALSE;
        }
        Type other = (Type) context;
        if (eq(elem.name, other.name) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSimpleName(
            SimpleName elem,
            Node context) {
        if ((context instanceof SimpleName) == false) {
            return Boolean.FALSE;
        }
        SimpleName other = (SimpleName) context;
        if (eq(elem.identifier, other.identifier) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitQualifiedName(
            QualifiedName elem,
            Node context) {
        if ((context instanceof QualifiedName) == false) {
            return Boolean.FALSE;
        }
        QualifiedName other = (QualifiedName) context;
        if (eq(elem.name, other.name) == false) {
            return Boolean.FALSE;
        }
        if (eq(elem.simpleName, other.simpleName) == false) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean eq(Enum<?> a, Enum<?> b) {
        return a == b;
    }

    private boolean eq(String a, String b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        return a.equals(b);
    }

    private boolean eq(Node a, Node b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        return a.accept(this, b);
    }

    private boolean eq(List<? extends Node> a, List<? extends Node> b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        int size = a.size();
        if (size != b.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (eq(a.get(i), b.get(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
