package com.aisino.domain.shiro;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMenuIdIsNull() {
            addCriterion("MENU_ID is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("MENU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(String value) {
            addCriterion("MENU_ID =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(String value) {
            addCriterion("MENU_ID <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(String value) {
            addCriterion("MENU_ID >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_ID >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(String value) {
            addCriterion("MENU_ID <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(String value) {
            addCriterion("MENU_ID <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLike(String value) {
            addCriterion("MENU_ID like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLike(String value) {
            addCriterion("MENU_ID not like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<String> values) {
            addCriterion("MENU_ID in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<String> values) {
            addCriterion("MENU_ID not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(String value1, String value2) {
            addCriterion("MENU_ID between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(String value1, String value2) {
            addCriterion("MENU_ID not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuUpidIsNull() {
            addCriterion("MENU_UPID is null");
            return (Criteria) this;
        }

        public Criteria andMenuUpidIsNotNull() {
            addCriterion("MENU_UPID is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUpidEqualTo(String value) {
            addCriterion("MENU_UPID =", value, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidNotEqualTo(String value) {
            addCriterion("MENU_UPID <>", value, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidGreaterThan(String value) {
            addCriterion("MENU_UPID >", value, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_UPID >=", value, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidLessThan(String value) {
            addCriterion("MENU_UPID <", value, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidLessThanOrEqualTo(String value) {
            addCriterion("MENU_UPID <=", value, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidLike(String value) {
            addCriterion("MENU_UPID like", value, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidNotLike(String value) {
            addCriterion("MENU_UPID not like", value, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidIn(List<String> values) {
            addCriterion("MENU_UPID in", values, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidNotIn(List<String> values) {
            addCriterion("MENU_UPID not in", values, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidBetween(String value1, String value2) {
            addCriterion("MENU_UPID between", value1, value2, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andMenuUpidNotBetween(String value1, String value2) {
            addCriterion("MENU_UPID not between", value1, value2, "menuUpid");
            return (Criteria) this;
        }

        public Criteria andIconClassIsNull() {
            addCriterion("ICON_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andIconClassIsNotNull() {
            addCriterion("ICON_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andIconClassEqualTo(String value) {
            addCriterion("ICON_CLASS =", value, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassNotEqualTo(String value) {
            addCriterion("ICON_CLASS <>", value, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassGreaterThan(String value) {
            addCriterion("ICON_CLASS >", value, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassGreaterThanOrEqualTo(String value) {
            addCriterion("ICON_CLASS >=", value, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassLessThan(String value) {
            addCriterion("ICON_CLASS <", value, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassLessThanOrEqualTo(String value) {
            addCriterion("ICON_CLASS <=", value, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassLike(String value) {
            addCriterion("ICON_CLASS like", value, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassNotLike(String value) {
            addCriterion("ICON_CLASS not like", value, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassIn(List<String> values) {
            addCriterion("ICON_CLASS in", values, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassNotIn(List<String> values) {
            addCriterion("ICON_CLASS not in", values, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassBetween(String value1, String value2) {
            addCriterion("ICON_CLASS between", value1, value2, "iconClass");
            return (Criteria) this;
        }

        public Criteria andIconClassNotBetween(String value1, String value2) {
            addCriterion("ICON_CLASS not between", value1, value2, "iconClass");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andHaschildIsNull() {
            addCriterion("HASCHILD is null");
            return (Criteria) this;
        }

        public Criteria andHaschildIsNotNull() {
            addCriterion("HASCHILD is not null");
            return (Criteria) this;
        }

        public Criteria andHaschildEqualTo(String value) {
            addCriterion("HASCHILD =", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildNotEqualTo(String value) {
            addCriterion("HASCHILD <>", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildGreaterThan(String value) {
            addCriterion("HASCHILD >", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildGreaterThanOrEqualTo(String value) {
            addCriterion("HASCHILD >=", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildLessThan(String value) {
            addCriterion("HASCHILD <", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildLessThanOrEqualTo(String value) {
            addCriterion("HASCHILD <=", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildLike(String value) {
            addCriterion("HASCHILD like", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildNotLike(String value) {
            addCriterion("HASCHILD not like", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildIn(List<String> values) {
            addCriterion("HASCHILD in", values, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildNotIn(List<String> values) {
            addCriterion("HASCHILD not in", values, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildBetween(String value1, String value2) {
            addCriterion("HASCHILD between", value1, value2, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildNotBetween(String value1, String value2) {
            addCriterion("HASCHILD not between", value1, value2, "haschild");
            return (Criteria) this;
        }

        public Criteria andHrefIsNull() {
            addCriterion("HREF is null");
            return (Criteria) this;
        }

        public Criteria andHrefIsNotNull() {
            addCriterion("HREF is not null");
            return (Criteria) this;
        }

        public Criteria andHrefEqualTo(String value) {
            addCriterion("HREF =", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotEqualTo(String value) {
            addCriterion("HREF <>", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThan(String value) {
            addCriterion("HREF >", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThanOrEqualTo(String value) {
            addCriterion("HREF >=", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLessThan(String value) {
            addCriterion("HREF <", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLessThanOrEqualTo(String value) {
            addCriterion("HREF <=", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLike(String value) {
            addCriterion("HREF like", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotLike(String value) {
            addCriterion("HREF not like", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefIn(List<String> values) {
            addCriterion("HREF in", values, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotIn(List<String> values) {
            addCriterion("HREF not in", values, "href");
            return (Criteria) this;
        }

        public Criteria andHrefBetween(String value1, String value2) {
            addCriterion("HREF between", value1, value2, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotBetween(String value1, String value2) {
            addCriterion("HREF not between", value1, value2, "href");
            return (Criteria) this;
        }

        public Criteria andRoleNeededIsNull() {
            addCriterion("ROLE_NEEDED is null");
            return (Criteria) this;
        }

        public Criteria andRoleNeededIsNotNull() {
            addCriterion("ROLE_NEEDED is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNeededEqualTo(String value) {
            addCriterion("ROLE_NEEDED =", value, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededNotEqualTo(String value) {
            addCriterion("ROLE_NEEDED <>", value, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededGreaterThan(String value) {
            addCriterion("ROLE_NEEDED >", value, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_NEEDED >=", value, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededLessThan(String value) {
            addCriterion("ROLE_NEEDED <", value, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededLessThanOrEqualTo(String value) {
            addCriterion("ROLE_NEEDED <=", value, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededLike(String value) {
            addCriterion("ROLE_NEEDED like", value, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededNotLike(String value) {
            addCriterion("ROLE_NEEDED not like", value, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededIn(List<String> values) {
            addCriterion("ROLE_NEEDED in", values, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededNotIn(List<String> values) {
            addCriterion("ROLE_NEEDED not in", values, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededBetween(String value1, String value2) {
            addCriterion("ROLE_NEEDED between", value1, value2, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andRoleNeededNotBetween(String value1, String value2) {
            addCriterion("ROLE_NEEDED not between", value1, value2, "roleNeeded");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}