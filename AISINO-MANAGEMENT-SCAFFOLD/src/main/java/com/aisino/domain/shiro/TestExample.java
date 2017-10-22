package com.aisino.domain.shiro;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNoIsNull() {
            addCriterion("NO is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("NO is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(String value) {
            addCriterion("NO =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(String value) {
            addCriterion("NO <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(String value) {
            addCriterion("NO >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(String value) {
            addCriterion("NO >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(String value) {
            addCriterion("NO <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(String value) {
            addCriterion("NO <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLike(String value) {
            addCriterion("NO like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotLike(String value) {
            addCriterion("NO not like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<String> values) {
            addCriterion("NO in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<String> values) {
            addCriterion("NO not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(String value1, String value2) {
            addCriterion("NO between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(String value1, String value2) {
            addCriterion("NO not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("EXTEND is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("EXTEND is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("EXTEND =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("EXTEND <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("EXTEND >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("EXTEND >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("EXTEND <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("EXTEND <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("EXTEND like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("EXTEND not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("EXTEND in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("EXTEND not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("EXTEND between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("EXTEND not between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andBillnumberIsNull() {
            addCriterion("BILLNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andBillnumberIsNotNull() {
            addCriterion("BILLNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andBillnumberEqualTo(String value) {
            addCriterion("BILLNUMBER =", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotEqualTo(String value) {
            addCriterion("BILLNUMBER <>", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberGreaterThan(String value) {
            addCriterion("BILLNUMBER >", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberGreaterThanOrEqualTo(String value) {
            addCriterion("BILLNUMBER >=", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLessThan(String value) {
            addCriterion("BILLNUMBER <", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLessThanOrEqualTo(String value) {
            addCriterion("BILLNUMBER <=", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLike(String value) {
            addCriterion("BILLNUMBER like", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotLike(String value) {
            addCriterion("BILLNUMBER not like", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberIn(List<String> values) {
            addCriterion("BILLNUMBER in", values, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotIn(List<String> values) {
            addCriterion("BILLNUMBER not in", values, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberBetween(String value1, String value2) {
            addCriterion("BILLNUMBER between", value1, value2, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotBetween(String value1, String value2) {
            addCriterion("BILLNUMBER not between", value1, value2, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBuyernameIsNull() {
            addCriterion("BUYERNAME is null");
            return (Criteria) this;
        }

        public Criteria andBuyernameIsNotNull() {
            addCriterion("BUYERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andBuyernameEqualTo(String value) {
            addCriterion("BUYERNAME =", value, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameNotEqualTo(String value) {
            addCriterion("BUYERNAME <>", value, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameGreaterThan(String value) {
            addCriterion("BUYERNAME >", value, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameGreaterThanOrEqualTo(String value) {
            addCriterion("BUYERNAME >=", value, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameLessThan(String value) {
            addCriterion("BUYERNAME <", value, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameLessThanOrEqualTo(String value) {
            addCriterion("BUYERNAME <=", value, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameLike(String value) {
            addCriterion("BUYERNAME like", value, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameNotLike(String value) {
            addCriterion("BUYERNAME not like", value, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameIn(List<String> values) {
            addCriterion("BUYERNAME in", values, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameNotIn(List<String> values) {
            addCriterion("BUYERNAME not in", values, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameBetween(String value1, String value2) {
            addCriterion("BUYERNAME between", value1, value2, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyernameNotBetween(String value1, String value2) {
            addCriterion("BUYERNAME not between", value1, value2, "buyername");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeIsNull() {
            addCriterion("BUYERTAXCODE is null");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeIsNotNull() {
            addCriterion("BUYERTAXCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeEqualTo(String value) {
            addCriterion("BUYERTAXCODE =", value, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeNotEqualTo(String value) {
            addCriterion("BUYERTAXCODE <>", value, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeGreaterThan(String value) {
            addCriterion("BUYERTAXCODE >", value, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUYERTAXCODE >=", value, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeLessThan(String value) {
            addCriterion("BUYERTAXCODE <", value, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeLessThanOrEqualTo(String value) {
            addCriterion("BUYERTAXCODE <=", value, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeLike(String value) {
            addCriterion("BUYERTAXCODE like", value, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeNotLike(String value) {
            addCriterion("BUYERTAXCODE not like", value, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeIn(List<String> values) {
            addCriterion("BUYERTAXCODE in", values, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeNotIn(List<String> values) {
            addCriterion("BUYERTAXCODE not in", values, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeBetween(String value1, String value2) {
            addCriterion("BUYERTAXCODE between", value1, value2, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyertaxcodeNotBetween(String value1, String value2) {
            addCriterion("BUYERTAXCODE not between", value1, value2, "buyertaxcode");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneIsNull() {
            addCriterion("BUYERADDRESSPHONE is null");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneIsNotNull() {
            addCriterion("BUYERADDRESSPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneEqualTo(String value) {
            addCriterion("BUYERADDRESSPHONE =", value, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneNotEqualTo(String value) {
            addCriterion("BUYERADDRESSPHONE <>", value, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneGreaterThan(String value) {
            addCriterion("BUYERADDRESSPHONE >", value, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneGreaterThanOrEqualTo(String value) {
            addCriterion("BUYERADDRESSPHONE >=", value, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneLessThan(String value) {
            addCriterion("BUYERADDRESSPHONE <", value, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneLessThanOrEqualTo(String value) {
            addCriterion("BUYERADDRESSPHONE <=", value, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneLike(String value) {
            addCriterion("BUYERADDRESSPHONE like", value, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneNotLike(String value) {
            addCriterion("BUYERADDRESSPHONE not like", value, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneIn(List<String> values) {
            addCriterion("BUYERADDRESSPHONE in", values, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneNotIn(List<String> values) {
            addCriterion("BUYERADDRESSPHONE not in", values, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneBetween(String value1, String value2) {
            addCriterion("BUYERADDRESSPHONE between", value1, value2, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyeraddressphoneNotBetween(String value1, String value2) {
            addCriterion("BUYERADDRESSPHONE not between", value1, value2, "buyeraddressphone");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountIsNull() {
            addCriterion("BUYERBANKACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountIsNotNull() {
            addCriterion("BUYERBANKACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountEqualTo(String value) {
            addCriterion("BUYERBANKACCOUNT =", value, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountNotEqualTo(String value) {
            addCriterion("BUYERBANKACCOUNT <>", value, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountGreaterThan(String value) {
            addCriterion("BUYERBANKACCOUNT >", value, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountGreaterThanOrEqualTo(String value) {
            addCriterion("BUYERBANKACCOUNT >=", value, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountLessThan(String value) {
            addCriterion("BUYERBANKACCOUNT <", value, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountLessThanOrEqualTo(String value) {
            addCriterion("BUYERBANKACCOUNT <=", value, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountLike(String value) {
            addCriterion("BUYERBANKACCOUNT like", value, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountNotLike(String value) {
            addCriterion("BUYERBANKACCOUNT not like", value, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountIn(List<String> values) {
            addCriterion("BUYERBANKACCOUNT in", values, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountNotIn(List<String> values) {
            addCriterion("BUYERBANKACCOUNT not in", values, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountBetween(String value1, String value2) {
            addCriterion("BUYERBANKACCOUNT between", value1, value2, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andBuyerbankaccountNotBetween(String value1, String value2) {
            addCriterion("BUYERBANKACCOUNT not between", value1, value2, "buyerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellernameIsNull() {
            addCriterion("SELLERNAME is null");
            return (Criteria) this;
        }

        public Criteria andSellernameIsNotNull() {
            addCriterion("SELLERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSellernameEqualTo(String value) {
            addCriterion("SELLERNAME =", value, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameNotEqualTo(String value) {
            addCriterion("SELLERNAME <>", value, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameGreaterThan(String value) {
            addCriterion("SELLERNAME >", value, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameGreaterThanOrEqualTo(String value) {
            addCriterion("SELLERNAME >=", value, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameLessThan(String value) {
            addCriterion("SELLERNAME <", value, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameLessThanOrEqualTo(String value) {
            addCriterion("SELLERNAME <=", value, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameLike(String value) {
            addCriterion("SELLERNAME like", value, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameNotLike(String value) {
            addCriterion("SELLERNAME not like", value, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameIn(List<String> values) {
            addCriterion("SELLERNAME in", values, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameNotIn(List<String> values) {
            addCriterion("SELLERNAME not in", values, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameBetween(String value1, String value2) {
            addCriterion("SELLERNAME between", value1, value2, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellernameNotBetween(String value1, String value2) {
            addCriterion("SELLERNAME not between", value1, value2, "sellername");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeIsNull() {
            addCriterion("SELLERTAXCODE is null");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeIsNotNull() {
            addCriterion("SELLERTAXCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeEqualTo(String value) {
            addCriterion("SELLERTAXCODE =", value, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeNotEqualTo(String value) {
            addCriterion("SELLERTAXCODE <>", value, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeGreaterThan(String value) {
            addCriterion("SELLERTAXCODE >", value, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeGreaterThanOrEqualTo(String value) {
            addCriterion("SELLERTAXCODE >=", value, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeLessThan(String value) {
            addCriterion("SELLERTAXCODE <", value, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeLessThanOrEqualTo(String value) {
            addCriterion("SELLERTAXCODE <=", value, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeLike(String value) {
            addCriterion("SELLERTAXCODE like", value, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeNotLike(String value) {
            addCriterion("SELLERTAXCODE not like", value, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeIn(List<String> values) {
            addCriterion("SELLERTAXCODE in", values, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeNotIn(List<String> values) {
            addCriterion("SELLERTAXCODE not in", values, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeBetween(String value1, String value2) {
            addCriterion("SELLERTAXCODE between", value1, value2, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSellertaxcodeNotBetween(String value1, String value2) {
            addCriterion("SELLERTAXCODE not between", value1, value2, "sellertaxcode");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneIsNull() {
            addCriterion("SELLERADDRESSPHONE is null");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneIsNotNull() {
            addCriterion("SELLERADDRESSPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneEqualTo(String value) {
            addCriterion("SELLERADDRESSPHONE =", value, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneNotEqualTo(String value) {
            addCriterion("SELLERADDRESSPHONE <>", value, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneGreaterThan(String value) {
            addCriterion("SELLERADDRESSPHONE >", value, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneGreaterThanOrEqualTo(String value) {
            addCriterion("SELLERADDRESSPHONE >=", value, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneLessThan(String value) {
            addCriterion("SELLERADDRESSPHONE <", value, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneLessThanOrEqualTo(String value) {
            addCriterion("SELLERADDRESSPHONE <=", value, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneLike(String value) {
            addCriterion("SELLERADDRESSPHONE like", value, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneNotLike(String value) {
            addCriterion("SELLERADDRESSPHONE not like", value, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneIn(List<String> values) {
            addCriterion("SELLERADDRESSPHONE in", values, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneNotIn(List<String> values) {
            addCriterion("SELLERADDRESSPHONE not in", values, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneBetween(String value1, String value2) {
            addCriterion("SELLERADDRESSPHONE between", value1, value2, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSelleraddressphoneNotBetween(String value1, String value2) {
            addCriterion("SELLERADDRESSPHONE not between", value1, value2, "selleraddressphone");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountIsNull() {
            addCriterion("SELLERBANKACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountIsNotNull() {
            addCriterion("SELLERBANKACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountEqualTo(String value) {
            addCriterion("SELLERBANKACCOUNT =", value, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountNotEqualTo(String value) {
            addCriterion("SELLERBANKACCOUNT <>", value, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountGreaterThan(String value) {
            addCriterion("SELLERBANKACCOUNT >", value, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountGreaterThanOrEqualTo(String value) {
            addCriterion("SELLERBANKACCOUNT >=", value, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountLessThan(String value) {
            addCriterion("SELLERBANKACCOUNT <", value, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountLessThanOrEqualTo(String value) {
            addCriterion("SELLERBANKACCOUNT <=", value, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountLike(String value) {
            addCriterion("SELLERBANKACCOUNT like", value, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountNotLike(String value) {
            addCriterion("SELLERBANKACCOUNT not like", value, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountIn(List<String> values) {
            addCriterion("SELLERBANKACCOUNT in", values, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountNotIn(List<String> values) {
            addCriterion("SELLERBANKACCOUNT not in", values, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountBetween(String value1, String value2) {
            addCriterion("SELLERBANKACCOUNT between", value1, value2, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andSellerbankaccountNotBetween(String value1, String value2) {
            addCriterion("SELLERBANKACCOUNT not between", value1, value2, "sellerbankaccount");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CREATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CREATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(String value) {
            addCriterion("CREATEDATE =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(String value) {
            addCriterion("CREATEDATE <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(String value) {
            addCriterion("CREATEDATE >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEDATE >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(String value) {
            addCriterion("CREATEDATE <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(String value) {
            addCriterion("CREATEDATE <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLike(String value) {
            addCriterion("CREATEDATE like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotLike(String value) {
            addCriterion("CREATEDATE not like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<String> values) {
            addCriterion("CREATEDATE in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<String> values) {
            addCriterion("CREATEDATE not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(String value1, String value2) {
            addCriterion("CREATEDATE between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(String value1, String value2) {
            addCriterion("CREATEDATE not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("MONTH is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(String value) {
            addCriterion("MONTH =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(String value) {
            addCriterion("MONTH <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(String value) {
            addCriterion("MONTH >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(String value) {
            addCriterion("MONTH >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(String value) {
            addCriterion("MONTH <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(String value) {
            addCriterion("MONTH <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLike(String value) {
            addCriterion("MONTH like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotLike(String value) {
            addCriterion("MONTH not like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<String> values) {
            addCriterion("MONTH in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<String> values) {
            addCriterion("MONTH not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(String value1, String value2) {
            addCriterion("MONTH between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(String value1, String value2) {
            addCriterion("MONTH not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andTaxrateIsNull() {
            addCriterion("TAXRATE is null");
            return (Criteria) this;
        }

        public Criteria andTaxrateIsNotNull() {
            addCriterion("TAXRATE is not null");
            return (Criteria) this;
        }

        public Criteria andTaxrateEqualTo(BigDecimal value) {
            addCriterion("TAXRATE =", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateNotEqualTo(BigDecimal value) {
            addCriterion("TAXRATE <>", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateGreaterThan(BigDecimal value) {
            addCriterion("TAXRATE >", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TAXRATE >=", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateLessThan(BigDecimal value) {
            addCriterion("TAXRATE <", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TAXRATE <=", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateIn(List<BigDecimal> values) {
            addCriterion("TAXRATE in", values, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateNotIn(List<BigDecimal> values) {
            addCriterion("TAXRATE not in", values, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAXRATE between", value1, value2, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAXRATE not between", value1, value2, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxIsNull() {
            addCriterion("TAX is null");
            return (Criteria) this;
        }

        public Criteria andTaxIsNotNull() {
            addCriterion("TAX is not null");
            return (Criteria) this;
        }

        public Criteria andTaxEqualTo(BigDecimal value) {
            addCriterion("TAX =", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotEqualTo(BigDecimal value) {
            addCriterion("TAX <>", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThan(BigDecimal value) {
            addCriterion("TAX >", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TAX >=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThan(BigDecimal value) {
            addCriterion("TAX <", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TAX <=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxIn(List<BigDecimal> values) {
            addCriterion("TAX in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotIn(List<BigDecimal> values) {
            addCriterion("TAX not in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAX between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAX not between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameIsNull() {
            addCriterion("MAINDETAILNAME is null");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameIsNotNull() {
            addCriterion("MAINDETAILNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameEqualTo(String value) {
            addCriterion("MAINDETAILNAME =", value, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameNotEqualTo(String value) {
            addCriterion("MAINDETAILNAME <>", value, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameGreaterThan(String value) {
            addCriterion("MAINDETAILNAME >", value, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameGreaterThanOrEqualTo(String value) {
            addCriterion("MAINDETAILNAME >=", value, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameLessThan(String value) {
            addCriterion("MAINDETAILNAME <", value, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameLessThanOrEqualTo(String value) {
            addCriterion("MAINDETAILNAME <=", value, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameLike(String value) {
            addCriterion("MAINDETAILNAME like", value, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameNotLike(String value) {
            addCriterion("MAINDETAILNAME not like", value, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameIn(List<String> values) {
            addCriterion("MAINDETAILNAME in", values, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameNotIn(List<String> values) {
            addCriterion("MAINDETAILNAME not in", values, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameBetween(String value1, String value2) {
            addCriterion("MAINDETAILNAME between", value1, value2, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMaindetailnameNotBetween(String value1, String value2) {
            addCriterion("MAINDETAILNAME not between", value1, value2, "maindetailname");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andInvoicerIsNull() {
            addCriterion("INVOICER is null");
            return (Criteria) this;
        }

        public Criteria andInvoicerIsNotNull() {
            addCriterion("INVOICER is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicerEqualTo(String value) {
            addCriterion("INVOICER =", value, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerNotEqualTo(String value) {
            addCriterion("INVOICER <>", value, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerGreaterThan(String value) {
            addCriterion("INVOICER >", value, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICER >=", value, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerLessThan(String value) {
            addCriterion("INVOICER <", value, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerLessThanOrEqualTo(String value) {
            addCriterion("INVOICER <=", value, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerLike(String value) {
            addCriterion("INVOICER like", value, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerNotLike(String value) {
            addCriterion("INVOICER not like", value, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerIn(List<String> values) {
            addCriterion("INVOICER in", values, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerNotIn(List<String> values) {
            addCriterion("INVOICER not in", values, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerBetween(String value1, String value2) {
            addCriterion("INVOICER between", value1, value2, "invoicer");
            return (Criteria) this;
        }

        public Criteria andInvoicerNotBetween(String value1, String value2) {
            addCriterion("INVOICER not between", value1, value2, "invoicer");
            return (Criteria) this;
        }

        public Criteria andCashierIsNull() {
            addCriterion("CASHIER is null");
            return (Criteria) this;
        }

        public Criteria andCashierIsNotNull() {
            addCriterion("CASHIER is not null");
            return (Criteria) this;
        }

        public Criteria andCashierEqualTo(String value) {
            addCriterion("CASHIER =", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotEqualTo(String value) {
            addCriterion("CASHIER <>", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierGreaterThan(String value) {
            addCriterion("CASHIER >", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierGreaterThanOrEqualTo(String value) {
            addCriterion("CASHIER >=", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierLessThan(String value) {
            addCriterion("CASHIER <", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierLessThanOrEqualTo(String value) {
            addCriterion("CASHIER <=", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierLike(String value) {
            addCriterion("CASHIER like", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotLike(String value) {
            addCriterion("CASHIER not like", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierIn(List<String> values) {
            addCriterion("CASHIER in", values, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotIn(List<String> values) {
            addCriterion("CASHIER not in", values, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierBetween(String value1, String value2) {
            addCriterion("CASHIER between", value1, value2, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotBetween(String value1, String value2) {
            addCriterion("CASHIER not between", value1, value2, "cashier");
            return (Criteria) this;
        }

        public Criteria andCheckerIsNull() {
            addCriterion("CHECKER is null");
            return (Criteria) this;
        }

        public Criteria andCheckerIsNotNull() {
            addCriterion("CHECKER is not null");
            return (Criteria) this;
        }

        public Criteria andCheckerEqualTo(String value) {
            addCriterion("CHECKER =", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotEqualTo(String value) {
            addCriterion("CHECKER <>", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerGreaterThan(String value) {
            addCriterion("CHECKER >", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKER >=", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLessThan(String value) {
            addCriterion("CHECKER <", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLessThanOrEqualTo(String value) {
            addCriterion("CHECKER <=", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLike(String value) {
            addCriterion("CHECKER like", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotLike(String value) {
            addCriterion("CHECKER not like", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerIn(List<String> values) {
            addCriterion("CHECKER in", values, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotIn(List<String> values) {
            addCriterion("CHECKER not in", values, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerBetween(String value1, String value2) {
            addCriterion("CHECKER between", value1, value2, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotBetween(String value1, String value2) {
            addCriterion("CHECKER not between", value1, value2, "checker");
            return (Criteria) this;
        }

        public Criteria andIsprintedIsNull() {
            addCriterion("ISPRINTED is null");
            return (Criteria) this;
        }

        public Criteria andIsprintedIsNotNull() {
            addCriterion("ISPRINTED is not null");
            return (Criteria) this;
        }

        public Criteria andIsprintedEqualTo(String value) {
            addCriterion("ISPRINTED =", value, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedNotEqualTo(String value) {
            addCriterion("ISPRINTED <>", value, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedGreaterThan(String value) {
            addCriterion("ISPRINTED >", value, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedGreaterThanOrEqualTo(String value) {
            addCriterion("ISPRINTED >=", value, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedLessThan(String value) {
            addCriterion("ISPRINTED <", value, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedLessThanOrEqualTo(String value) {
            addCriterion("ISPRINTED <=", value, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedLike(String value) {
            addCriterion("ISPRINTED like", value, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedNotLike(String value) {
            addCriterion("ISPRINTED not like", value, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedIn(List<String> values) {
            addCriterion("ISPRINTED in", values, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedNotIn(List<String> values) {
            addCriterion("ISPRINTED not in", values, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedBetween(String value1, String value2) {
            addCriterion("ISPRINTED between", value1, value2, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIsprintedNotBetween(String value1, String value2) {
            addCriterion("ISPRINTED not between", value1, value2, "isprinted");
            return (Criteria) this;
        }

        public Criteria andIslistedIsNull() {
            addCriterion("ISLISTED is null");
            return (Criteria) this;
        }

        public Criteria andIslistedIsNotNull() {
            addCriterion("ISLISTED is not null");
            return (Criteria) this;
        }

        public Criteria andIslistedEqualTo(String value) {
            addCriterion("ISLISTED =", value, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedNotEqualTo(String value) {
            addCriterion("ISLISTED <>", value, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedGreaterThan(String value) {
            addCriterion("ISLISTED >", value, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedGreaterThanOrEqualTo(String value) {
            addCriterion("ISLISTED >=", value, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedLessThan(String value) {
            addCriterion("ISLISTED <", value, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedLessThanOrEqualTo(String value) {
            addCriterion("ISLISTED <=", value, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedLike(String value) {
            addCriterion("ISLISTED like", value, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedNotLike(String value) {
            addCriterion("ISLISTED not like", value, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedIn(List<String> values) {
            addCriterion("ISLISTED in", values, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedNotIn(List<String> values) {
            addCriterion("ISLISTED not in", values, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedBetween(String value1, String value2) {
            addCriterion("ISLISTED between", value1, value2, "islisted");
            return (Criteria) this;
        }

        public Criteria andIslistedNotBetween(String value1, String value2) {
            addCriterion("ISLISTED not between", value1, value2, "islisted");
            return (Criteria) this;
        }

        public Criteria andIscanceledIsNull() {
            addCriterion("ISCANCELED is null");
            return (Criteria) this;
        }

        public Criteria andIscanceledIsNotNull() {
            addCriterion("ISCANCELED is not null");
            return (Criteria) this;
        }

        public Criteria andIscanceledEqualTo(String value) {
            addCriterion("ISCANCELED =", value, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledNotEqualTo(String value) {
            addCriterion("ISCANCELED <>", value, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledGreaterThan(String value) {
            addCriterion("ISCANCELED >", value, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledGreaterThanOrEqualTo(String value) {
            addCriterion("ISCANCELED >=", value, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledLessThan(String value) {
            addCriterion("ISCANCELED <", value, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledLessThanOrEqualTo(String value) {
            addCriterion("ISCANCELED <=", value, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledLike(String value) {
            addCriterion("ISCANCELED like", value, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledNotLike(String value) {
            addCriterion("ISCANCELED not like", value, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledIn(List<String> values) {
            addCriterion("ISCANCELED in", values, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledNotIn(List<String> values) {
            addCriterion("ISCANCELED not in", values, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledBetween(String value1, String value2) {
            addCriterion("ISCANCELED between", value1, value2, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andIscanceledNotBetween(String value1, String value2) {
            addCriterion("ISCANCELED not between", value1, value2, "iscanceled");
            return (Criteria) this;
        }

        public Criteria andAuthcodeIsNull() {
            addCriterion("AUTHCODE is null");
            return (Criteria) this;
        }

        public Criteria andAuthcodeIsNotNull() {
            addCriterion("AUTHCODE is not null");
            return (Criteria) this;
        }

        public Criteria andAuthcodeEqualTo(String value) {
            addCriterion("AUTHCODE =", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeNotEqualTo(String value) {
            addCriterion("AUTHCODE <>", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeGreaterThan(String value) {
            addCriterion("AUTHCODE >", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHCODE >=", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeLessThan(String value) {
            addCriterion("AUTHCODE <", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeLessThanOrEqualTo(String value) {
            addCriterion("AUTHCODE <=", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeLike(String value) {
            addCriterion("AUTHCODE like", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeNotLike(String value) {
            addCriterion("AUTHCODE not like", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeIn(List<String> values) {
            addCriterion("AUTHCODE in", values, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeNotIn(List<String> values) {
            addCriterion("AUTHCODE not in", values, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeBetween(String value1, String value2) {
            addCriterion("AUTHCODE between", value1, value2, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeNotBetween(String value1, String value2) {
            addCriterion("AUTHCODE not between", value1, value2, "authcode");
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