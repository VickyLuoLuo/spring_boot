package com.quark.data.rapid.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RunTimeEnvExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    private static final long serialVersionUID = 1L;

    public RunTimeEnvExample() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeIsNull() {
            addCriterion("runtime_type is null");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeIsNotNull() {
            addCriterion("runtime_type is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeEqualTo(String value) {
            addCriterion("runtime_type =", value, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeNotEqualTo(String value) {
            addCriterion("runtime_type <>", value, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeGreaterThan(String value) {
            addCriterion("runtime_type >", value, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("runtime_type >=", value, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeLessThan(String value) {
            addCriterion("runtime_type <", value, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeLessThanOrEqualTo(String value) {
            addCriterion("runtime_type <=", value, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeLike(String value) {
            addCriterion("runtime_type like", value, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeNotLike(String value) {
            addCriterion("runtime_type not like", value, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeIn(List<String> values) {
            addCriterion("runtime_type in", values, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeNotIn(List<String> values) {
            addCriterion("runtime_type not in", values, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeBetween(String value1, String value2) {
            addCriterion("runtime_type between", value1, value2, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeTypeNotBetween(String value1, String value2) {
            addCriterion("runtime_type not between", value1, value2, "runtimeType");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameIsNull() {
            addCriterion("runtime_name is null");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameIsNotNull() {
            addCriterion("runtime_name is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameEqualTo(String value) {
            addCriterion("runtime_name =", value, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameNotEqualTo(String value) {
            addCriterion("runtime_name <>", value, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameGreaterThan(String value) {
            addCriterion("runtime_name >", value, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameGreaterThanOrEqualTo(String value) {
            addCriterion("runtime_name >=", value, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameLessThan(String value) {
            addCriterion("runtime_name <", value, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameLessThanOrEqualTo(String value) {
            addCriterion("runtime_name <=", value, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameLike(String value) {
            addCriterion("runtime_name like", value, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameNotLike(String value) {
            addCriterion("runtime_name not like", value, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameIn(List<String> values) {
            addCriterion("runtime_name in", values, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameNotIn(List<String> values) {
            addCriterion("runtime_name not in", values, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameBetween(String value1, String value2) {
            addCriterion("runtime_name between", value1, value2, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeNameNotBetween(String value1, String value2) {
            addCriterion("runtime_name not between", value1, value2, "runtimeName");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpIsNull() {
            addCriterion("runtime_ip is null");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpIsNotNull() {
            addCriterion("runtime_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpEqualTo(String value) {
            addCriterion("runtime_ip =", value, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpNotEqualTo(String value) {
            addCriterion("runtime_ip <>", value, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpGreaterThan(String value) {
            addCriterion("runtime_ip >", value, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpGreaterThanOrEqualTo(String value) {
            addCriterion("runtime_ip >=", value, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpLessThan(String value) {
            addCriterion("runtime_ip <", value, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpLessThanOrEqualTo(String value) {
            addCriterion("runtime_ip <=", value, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpLike(String value) {
            addCriterion("runtime_ip like", value, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpNotLike(String value) {
            addCriterion("runtime_ip not like", value, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpIn(List<String> values) {
            addCriterion("runtime_ip in", values, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpNotIn(List<String> values) {
            addCriterion("runtime_ip not in", values, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpBetween(String value1, String value2) {
            addCriterion("runtime_ip between", value1, value2, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimeIpNotBetween(String value1, String value2) {
            addCriterion("runtime_ip not between", value1, value2, "runtimeIp");
            return (Criteria) this;
        }

        public Criteria andRuntimePortIsNull() {
            addCriterion("runtime_port is null");
            return (Criteria) this;
        }

        public Criteria andRuntimePortIsNotNull() {
            addCriterion("runtime_port is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimePortEqualTo(Integer value) {
            addCriterion("runtime_port =", value, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimePortNotEqualTo(Integer value) {
            addCriterion("runtime_port <>", value, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimePortGreaterThan(Integer value) {
            addCriterion("runtime_port >", value, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimePortGreaterThanOrEqualTo(Integer value) {
            addCriterion("runtime_port >=", value, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimePortLessThan(Integer value) {
            addCriterion("runtime_port <", value, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimePortLessThanOrEqualTo(Integer value) {
            addCriterion("runtime_port <=", value, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimePortIn(List<Integer> values) {
            addCriterion("runtime_port in", values, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimePortNotIn(List<Integer> values) {
            addCriterion("runtime_port not in", values, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimePortBetween(Integer value1, Integer value2) {
            addCriterion("runtime_port between", value1, value2, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimePortNotBetween(Integer value1, Integer value2) {
            addCriterion("runtime_port not between", value1, value2, "runtimePort");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameIsNull() {
            addCriterion("runtime_username is null");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameIsNotNull() {
            addCriterion("runtime_username is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameEqualTo(String value) {
            addCriterion("runtime_username =", value, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameNotEqualTo(String value) {
            addCriterion("runtime_username <>", value, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameGreaterThan(String value) {
            addCriterion("runtime_username >", value, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("runtime_username >=", value, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameLessThan(String value) {
            addCriterion("runtime_username <", value, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameLessThanOrEqualTo(String value) {
            addCriterion("runtime_username <=", value, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameLike(String value) {
            addCriterion("runtime_username like", value, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameNotLike(String value) {
            addCriterion("runtime_username not like", value, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameIn(List<String> values) {
            addCriterion("runtime_username in", values, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameNotIn(List<String> values) {
            addCriterion("runtime_username not in", values, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameBetween(String value1, String value2) {
            addCriterion("runtime_username between", value1, value2, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimeUsernameNotBetween(String value1, String value2) {
            addCriterion("runtime_username not between", value1, value2, "runtimeUsername");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordIsNull() {
            addCriterion("runtime_password is null");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordIsNotNull() {
            addCriterion("runtime_password is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordEqualTo(String value) {
            addCriterion("runtime_password =", value, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordNotEqualTo(String value) {
            addCriterion("runtime_password <>", value, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordGreaterThan(String value) {
            addCriterion("runtime_password >", value, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("runtime_password >=", value, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordLessThan(String value) {
            addCriterion("runtime_password <", value, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordLessThanOrEqualTo(String value) {
            addCriterion("runtime_password <=", value, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordLike(String value) {
            addCriterion("runtime_password like", value, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordNotLike(String value) {
            addCriterion("runtime_password not like", value, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordIn(List<String> values) {
            addCriterion("runtime_password in", values, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordNotIn(List<String> values) {
            addCriterion("runtime_password not in", values, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordBetween(String value1, String value2) {
            addCriterion("runtime_password between", value1, value2, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andRuntimePasswordNotBetween(String value1, String value2) {
            addCriterion("runtime_password not between", value1, value2, "runtimePassword");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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