package cn.woyeshi.server.domain;

import java.util.ArrayList;
import java.util.List;

public class SplitInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SplitInfoExample() {
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

        public Criteria andSplitIdIsNull() {
            addCriterion("split_id is null");
            return (Criteria) this;
        }

        public Criteria andSplitIdIsNotNull() {
            addCriterion("split_id is not null");
            return (Criteria) this;
        }

        public Criteria andSplitIdEqualTo(Integer value) {
            addCriterion("split_id =", value, "splitId");
            return (Criteria) this;
        }

        public Criteria andSplitIdNotEqualTo(Integer value) {
            addCriterion("split_id <>", value, "splitId");
            return (Criteria) this;
        }

        public Criteria andSplitIdGreaterThan(Integer value) {
            addCriterion("split_id >", value, "splitId");
            return (Criteria) this;
        }

        public Criteria andSplitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("split_id >=", value, "splitId");
            return (Criteria) this;
        }

        public Criteria andSplitIdLessThan(Integer value) {
            addCriterion("split_id <", value, "splitId");
            return (Criteria) this;
        }

        public Criteria andSplitIdLessThanOrEqualTo(Integer value) {
            addCriterion("split_id <=", value, "splitId");
            return (Criteria) this;
        }

        public Criteria andSplitIdIn(List<Integer> values) {
            addCriterion("split_id in", values, "splitId");
            return (Criteria) this;
        }

        public Criteria andSplitIdNotIn(List<Integer> values) {
            addCriterion("split_id not in", values, "splitId");
            return (Criteria) this;
        }

        public Criteria andSplitIdBetween(Integer value1, Integer value2) {
            addCriterion("split_id between", value1, value2, "splitId");
            return (Criteria) this;
        }

        public Criteria andSplitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("split_id not between", value1, value2, "splitId");
            return (Criteria) this;
        }

        public Criteria andAppVersionIsNull() {
            addCriterion("app_version is null");
            return (Criteria) this;
        }

        public Criteria andAppVersionIsNotNull() {
            addCriterion("app_version is not null");
            return (Criteria) this;
        }

        public Criteria andAppVersionEqualTo(String value) {
            addCriterion("app_version =", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotEqualTo(String value) {
            addCriterion("app_version <>", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThan(String value) {
            addCriterion("app_version >", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThanOrEqualTo(String value) {
            addCriterion("app_version >=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThan(String value) {
            addCriterion("app_version <", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThanOrEqualTo(String value) {
            addCriterion("app_version <=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLike(String value) {
            addCriterion("app_version like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotLike(String value) {
            addCriterion("app_version not like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionIn(List<String> values) {
            addCriterion("app_version in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotIn(List<String> values) {
            addCriterion("app_version not in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionBetween(String value1, String value2) {
            addCriterion("app_version between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotBetween(String value1, String value2) {
            addCriterion("app_version not between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionIsNull() {
            addCriterion("split_version is null");
            return (Criteria) this;
        }

        public Criteria andSplitVersionIsNotNull() {
            addCriterion("split_version is not null");
            return (Criteria) this;
        }

        public Criteria andSplitVersionEqualTo(String value) {
            addCriterion("split_version =", value, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionNotEqualTo(String value) {
            addCriterion("split_version <>", value, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionGreaterThan(String value) {
            addCriterion("split_version >", value, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionGreaterThanOrEqualTo(String value) {
            addCriterion("split_version >=", value, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionLessThan(String value) {
            addCriterion("split_version <", value, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionLessThanOrEqualTo(String value) {
            addCriterion("split_version <=", value, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionLike(String value) {
            addCriterion("split_version like", value, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionNotLike(String value) {
            addCriterion("split_version not like", value, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionIn(List<String> values) {
            addCriterion("split_version in", values, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionNotIn(List<String> values) {
            addCriterion("split_version not in", values, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionBetween(String value1, String value2) {
            addCriterion("split_version between", value1, value2, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitVersionNotBetween(String value1, String value2) {
            addCriterion("split_version not between", value1, value2, "splitVersion");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlIsNull() {
            addCriterion("split_config_url is null");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlIsNotNull() {
            addCriterion("split_config_url is not null");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlEqualTo(String value) {
            addCriterion("split_config_url =", value, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlNotEqualTo(String value) {
            addCriterion("split_config_url <>", value, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlGreaterThan(String value) {
            addCriterion("split_config_url >", value, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlGreaterThanOrEqualTo(String value) {
            addCriterion("split_config_url >=", value, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlLessThan(String value) {
            addCriterion("split_config_url <", value, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlLessThanOrEqualTo(String value) {
            addCriterion("split_config_url <=", value, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlLike(String value) {
            addCriterion("split_config_url like", value, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlNotLike(String value) {
            addCriterion("split_config_url not like", value, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlIn(List<String> values) {
            addCriterion("split_config_url in", values, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlNotIn(List<String> values) {
            addCriterion("split_config_url not in", values, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlBetween(String value1, String value2) {
            addCriterion("split_config_url between", value1, value2, "splitConfigUrl");
            return (Criteria) this;
        }

        public Criteria andSplitConfigUrlNotBetween(String value1, String value2) {
            addCriterion("split_config_url not between", value1, value2, "splitConfigUrl");
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