package cn.woyeshi.server.domain;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andIsAlertIsNull() {
            addCriterion("is_alert is null");
            return (Criteria) this;
        }

        public Criteria andIsAlertIsNotNull() {
            addCriterion("is_alert is not null");
            return (Criteria) this;
        }

        public Criteria andIsAlertEqualTo(String value) {
            addCriterion("is_alert =", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotEqualTo(String value) {
            addCriterion("is_alert <>", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertGreaterThan(String value) {
            addCriterion("is_alert >", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertGreaterThanOrEqualTo(String value) {
            addCriterion("is_alert >=", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertLessThan(String value) {
            addCriterion("is_alert <", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertLessThanOrEqualTo(String value) {
            addCriterion("is_alert <=", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertLike(String value) {
            addCriterion("is_alert like", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotLike(String value) {
            addCriterion("is_alert not like", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertIn(List<String> values) {
            addCriterion("is_alert in", values, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotIn(List<String> values) {
            addCriterion("is_alert not in", values, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertBetween(String value1, String value2) {
            addCriterion("is_alert between", value1, value2, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotBetween(String value1, String value2) {
            addCriterion("is_alert not between", value1, value2, "isAlert");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andChangeLogIsNull() {
            addCriterion("change_log is null");
            return (Criteria) this;
        }

        public Criteria andChangeLogIsNotNull() {
            addCriterion("change_log is not null");
            return (Criteria) this;
        }

        public Criteria andChangeLogEqualTo(String value) {
            addCriterion("change_log =", value, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogNotEqualTo(String value) {
            addCriterion("change_log <>", value, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogGreaterThan(String value) {
            addCriterion("change_log >", value, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogGreaterThanOrEqualTo(String value) {
            addCriterion("change_log >=", value, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogLessThan(String value) {
            addCriterion("change_log <", value, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogLessThanOrEqualTo(String value) {
            addCriterion("change_log <=", value, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogLike(String value) {
            addCriterion("change_log like", value, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogNotLike(String value) {
            addCriterion("change_log not like", value, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogIn(List<String> values) {
            addCriterion("change_log in", values, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogNotIn(List<String> values) {
            addCriterion("change_log not in", values, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogBetween(String value1, String value2) {
            addCriterion("change_log between", value1, value2, "changeLog");
            return (Criteria) this;
        }

        public Criteria andChangeLogNotBetween(String value1, String value2) {
            addCriterion("change_log not between", value1, value2, "changeLog");
            return (Criteria) this;
        }

        public Criteria andIsDebugIsNull() {
            addCriterion("is_debug is null");
            return (Criteria) this;
        }

        public Criteria andIsDebugIsNotNull() {
            addCriterion("is_debug is not null");
            return (Criteria) this;
        }

        public Criteria andIsDebugEqualTo(String value) {
            addCriterion("is_debug =", value, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugNotEqualTo(String value) {
            addCriterion("is_debug <>", value, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugGreaterThan(String value) {
            addCriterion("is_debug >", value, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugGreaterThanOrEqualTo(String value) {
            addCriterion("is_debug >=", value, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugLessThan(String value) {
            addCriterion("is_debug <", value, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugLessThanOrEqualTo(String value) {
            addCriterion("is_debug <=", value, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugLike(String value) {
            addCriterion("is_debug like", value, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugNotLike(String value) {
            addCriterion("is_debug not like", value, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugIn(List<String> values) {
            addCriterion("is_debug in", values, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugNotIn(List<String> values) {
            addCriterion("is_debug not in", values, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugBetween(String value1, String value2) {
            addCriterion("is_debug between", value1, value2, "isDebug");
            return (Criteria) this;
        }

        public Criteria andIsDebugNotBetween(String value1, String value2) {
            addCriterion("is_debug not between", value1, value2, "isDebug");
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