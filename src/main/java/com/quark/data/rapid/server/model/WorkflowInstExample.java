package com.quark.data.rapid.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkflowInstExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    private static final long serialVersionUID = 1L;

    public WorkflowInstExample() {
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

        public Criteria andDataStreamWorkflowIdIsNull() {
            addCriterion("data_stream_workflow_id is null");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdIsNotNull() {
            addCriterion("data_stream_workflow_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdEqualTo(Long value) {
            addCriterion("data_stream_workflow_id =", value, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdNotEqualTo(Long value) {
            addCriterion("data_stream_workflow_id <>", value, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdGreaterThan(Long value) {
            addCriterion("data_stream_workflow_id >", value, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdGreaterThanOrEqualTo(Long value) {
            addCriterion("data_stream_workflow_id >=", value, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdLessThan(Long value) {
            addCriterion("data_stream_workflow_id <", value, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdLessThanOrEqualTo(Long value) {
            addCriterion("data_stream_workflow_id <=", value, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdIn(List<Long> values) {
            addCriterion("data_stream_workflow_id in", values, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdNotIn(List<Long> values) {
            addCriterion("data_stream_workflow_id not in", values, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdBetween(Long value1, Long value2) {
            addCriterion("data_stream_workflow_id between", value1, value2, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andDataStreamWorkflowIdNotBetween(Long value1, Long value2) {
            addCriterion("data_stream_workflow_id not between", value1, value2, "dataStreamWorkflowId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdIsNull() {
            addCriterion("runtime_env_id is null");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdIsNotNull() {
            addCriterion("runtime_env_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdEqualTo(Long value) {
            addCriterion("runtime_env_id =", value, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdNotEqualTo(Long value) {
            addCriterion("runtime_env_id <>", value, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdGreaterThan(Long value) {
            addCriterion("runtime_env_id >", value, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdGreaterThanOrEqualTo(Long value) {
            addCriterion("runtime_env_id >=", value, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdLessThan(Long value) {
            addCriterion("runtime_env_id <", value, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdLessThanOrEqualTo(Long value) {
            addCriterion("runtime_env_id <=", value, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdIn(List<Long> values) {
            addCriterion("runtime_env_id in", values, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdNotIn(List<Long> values) {
            addCriterion("runtime_env_id not in", values, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdBetween(Long value1, Long value2) {
            addCriterion("runtime_env_id between", value1, value2, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andRuntimeEnvIdNotBetween(Long value1, Long value2) {
            addCriterion("runtime_env_id not between", value1, value2, "runtimeEnvId");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameIsNull() {
            addCriterion("workflow_inst_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameIsNotNull() {
            addCriterion("workflow_inst_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameEqualTo(String value) {
            addCriterion("workflow_inst_name =", value, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameNotEqualTo(String value) {
            addCriterion("workflow_inst_name <>", value, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameGreaterThan(String value) {
            addCriterion("workflow_inst_name >", value, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_inst_name >=", value, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameLessThan(String value) {
            addCriterion("workflow_inst_name <", value, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameLessThanOrEqualTo(String value) {
            addCriterion("workflow_inst_name <=", value, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameLike(String value) {
            addCriterion("workflow_inst_name like", value, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameNotLike(String value) {
            addCriterion("workflow_inst_name not like", value, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameIn(List<String> values) {
            addCriterion("workflow_inst_name in", values, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameNotIn(List<String> values) {
            addCriterion("workflow_inst_name not in", values, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameBetween(String value1, String value2) {
            addCriterion("workflow_inst_name between", value1, value2, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andWorkflowInstNameNotBetween(String value1, String value2) {
            addCriterion("workflow_inst_name not between", value1, value2, "workflowInstName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdIsNull() {
            addCriterion("runtime_job_id is null");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdIsNotNull() {
            addCriterion("runtime_job_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdEqualTo(String value) {
            addCriterion("runtime_job_id =", value, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdNotEqualTo(String value) {
            addCriterion("runtime_job_id <>", value, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdGreaterThan(String value) {
            addCriterion("runtime_job_id >", value, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdGreaterThanOrEqualTo(String value) {
            addCriterion("runtime_job_id >=", value, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdLessThan(String value) {
            addCriterion("runtime_job_id <", value, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdLessThanOrEqualTo(String value) {
            addCriterion("runtime_job_id <=", value, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdLike(String value) {
            addCriterion("runtime_job_id like", value, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdNotLike(String value) {
            addCriterion("runtime_job_id not like", value, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdIn(List<String> values) {
            addCriterion("runtime_job_id in", values, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdNotIn(List<String> values) {
            addCriterion("runtime_job_id not in", values, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdBetween(String value1, String value2) {
            addCriterion("runtime_job_id between", value1, value2, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andRuntimeJobIdNotBetween(String value1, String value2) {
            addCriterion("runtime_job_id not between", value1, value2, "runtimeJobId");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Integer value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Integer value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Integer value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Integer value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Integer value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Integer> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Integer> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Integer value1, Integer value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Integer value1, Integer value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andScheduledIsNull() {
            addCriterion("scheduled is null");
            return (Criteria) this;
        }

        public Criteria andScheduledIsNotNull() {
            addCriterion("scheduled is not null");
            return (Criteria) this;
        }

        public Criteria andScheduledEqualTo(Integer value) {
            addCriterion("scheduled =", value, "scheduled");
            return (Criteria) this;
        }

        public Criteria andScheduledNotEqualTo(Integer value) {
            addCriterion("scheduled <>", value, "scheduled");
            return (Criteria) this;
        }

        public Criteria andScheduledGreaterThan(Integer value) {
            addCriterion("scheduled >", value, "scheduled");
            return (Criteria) this;
        }

        public Criteria andScheduledGreaterThanOrEqualTo(Integer value) {
            addCriterion("scheduled >=", value, "scheduled");
            return (Criteria) this;
        }

        public Criteria andScheduledLessThan(Integer value) {
            addCriterion("scheduled <", value, "scheduled");
            return (Criteria) this;
        }

        public Criteria andScheduledLessThanOrEqualTo(Integer value) {
            addCriterion("scheduled <=", value, "scheduled");
            return (Criteria) this;
        }

        public Criteria andScheduledIn(List<Integer> values) {
            addCriterion("scheduled in", values, "scheduled");
            return (Criteria) this;
        }

        public Criteria andScheduledNotIn(List<Integer> values) {
            addCriterion("scheduled not in", values, "scheduled");
            return (Criteria) this;
        }

        public Criteria andScheduledBetween(Integer value1, Integer value2) {
            addCriterion("scheduled between", value1, value2, "scheduled");
            return (Criteria) this;
        }

        public Criteria andScheduledNotBetween(Integer value1, Integer value2) {
            addCriterion("scheduled not between", value1, value2, "scheduled");
            return (Criteria) this;
        }

        public Criteria andDeployingIsNull() {
            addCriterion("deploying is null");
            return (Criteria) this;
        }

        public Criteria andDeployingIsNotNull() {
            addCriterion("deploying is not null");
            return (Criteria) this;
        }

        public Criteria andDeployingEqualTo(Integer value) {
            addCriterion("deploying =", value, "deploying");
            return (Criteria) this;
        }

        public Criteria andDeployingNotEqualTo(Integer value) {
            addCriterion("deploying <>", value, "deploying");
            return (Criteria) this;
        }

        public Criteria andDeployingGreaterThan(Integer value) {
            addCriterion("deploying >", value, "deploying");
            return (Criteria) this;
        }

        public Criteria andDeployingGreaterThanOrEqualTo(Integer value) {
            addCriterion("deploying >=", value, "deploying");
            return (Criteria) this;
        }

        public Criteria andDeployingLessThan(Integer value) {
            addCriterion("deploying <", value, "deploying");
            return (Criteria) this;
        }

        public Criteria andDeployingLessThanOrEqualTo(Integer value) {
            addCriterion("deploying <=", value, "deploying");
            return (Criteria) this;
        }

        public Criteria andDeployingIn(List<Integer> values) {
            addCriterion("deploying in", values, "deploying");
            return (Criteria) this;
        }

        public Criteria andDeployingNotIn(List<Integer> values) {
            addCriterion("deploying not in", values, "deploying");
            return (Criteria) this;
        }

        public Criteria andDeployingBetween(Integer value1, Integer value2) {
            addCriterion("deploying between", value1, value2, "deploying");
            return (Criteria) this;
        }

        public Criteria andDeployingNotBetween(Integer value1, Integer value2) {
            addCriterion("deploying not between", value1, value2, "deploying");
            return (Criteria) this;
        }

        public Criteria andRunningIsNull() {
            addCriterion("running is null");
            return (Criteria) this;
        }

        public Criteria andRunningIsNotNull() {
            addCriterion("running is not null");
            return (Criteria) this;
        }

        public Criteria andRunningEqualTo(Integer value) {
            addCriterion("running =", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningNotEqualTo(Integer value) {
            addCriterion("running <>", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningGreaterThan(Integer value) {
            addCriterion("running >", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningGreaterThanOrEqualTo(Integer value) {
            addCriterion("running >=", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningLessThan(Integer value) {
            addCriterion("running <", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningLessThanOrEqualTo(Integer value) {
            addCriterion("running <=", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningIn(List<Integer> values) {
            addCriterion("running in", values, "running");
            return (Criteria) this;
        }

        public Criteria andRunningNotIn(List<Integer> values) {
            addCriterion("running not in", values, "running");
            return (Criteria) this;
        }

        public Criteria andRunningBetween(Integer value1, Integer value2) {
            addCriterion("running between", value1, value2, "running");
            return (Criteria) this;
        }

        public Criteria andRunningNotBetween(Integer value1, Integer value2) {
            addCriterion("running not between", value1, value2, "running");
            return (Criteria) this;
        }

        public Criteria andFinishedIsNull() {
            addCriterion("finished is null");
            return (Criteria) this;
        }

        public Criteria andFinishedIsNotNull() {
            addCriterion("finished is not null");
            return (Criteria) this;
        }

        public Criteria andFinishedEqualTo(Integer value) {
            addCriterion("finished =", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedNotEqualTo(Integer value) {
            addCriterion("finished <>", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedGreaterThan(Integer value) {
            addCriterion("finished >", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedGreaterThanOrEqualTo(Integer value) {
            addCriterion("finished >=", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedLessThan(Integer value) {
            addCriterion("finished <", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedLessThanOrEqualTo(Integer value) {
            addCriterion("finished <=", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedIn(List<Integer> values) {
            addCriterion("finished in", values, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedNotIn(List<Integer> values) {
            addCriterion("finished not in", values, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedBetween(Integer value1, Integer value2) {
            addCriterion("finished between", value1, value2, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedNotBetween(Integer value1, Integer value2) {
            addCriterion("finished not between", value1, value2, "finished");
            return (Criteria) this;
        }

        public Criteria andCancelingIsNull() {
            addCriterion("canceling is null");
            return (Criteria) this;
        }

        public Criteria andCancelingIsNotNull() {
            addCriterion("canceling is not null");
            return (Criteria) this;
        }

        public Criteria andCancelingEqualTo(Integer value) {
            addCriterion("canceling =", value, "canceling");
            return (Criteria) this;
        }

        public Criteria andCancelingNotEqualTo(Integer value) {
            addCriterion("canceling <>", value, "canceling");
            return (Criteria) this;
        }

        public Criteria andCancelingGreaterThan(Integer value) {
            addCriterion("canceling >", value, "canceling");
            return (Criteria) this;
        }

        public Criteria andCancelingGreaterThanOrEqualTo(Integer value) {
            addCriterion("canceling >=", value, "canceling");
            return (Criteria) this;
        }

        public Criteria andCancelingLessThan(Integer value) {
            addCriterion("canceling <", value, "canceling");
            return (Criteria) this;
        }

        public Criteria andCancelingLessThanOrEqualTo(Integer value) {
            addCriterion("canceling <=", value, "canceling");
            return (Criteria) this;
        }

        public Criteria andCancelingIn(List<Integer> values) {
            addCriterion("canceling in", values, "canceling");
            return (Criteria) this;
        }

        public Criteria andCancelingNotIn(List<Integer> values) {
            addCriterion("canceling not in", values, "canceling");
            return (Criteria) this;
        }

        public Criteria andCancelingBetween(Integer value1, Integer value2) {
            addCriterion("canceling between", value1, value2, "canceling");
            return (Criteria) this;
        }

        public Criteria andCancelingNotBetween(Integer value1, Integer value2) {
            addCriterion("canceling not between", value1, value2, "canceling");
            return (Criteria) this;
        }

        public Criteria andCanceledIsNull() {
            addCriterion("canceled is null");
            return (Criteria) this;
        }

        public Criteria andCanceledIsNotNull() {
            addCriterion("canceled is not null");
            return (Criteria) this;
        }

        public Criteria andCanceledEqualTo(Integer value) {
            addCriterion("canceled =", value, "canceled");
            return (Criteria) this;
        }

        public Criteria andCanceledNotEqualTo(Integer value) {
            addCriterion("canceled <>", value, "canceled");
            return (Criteria) this;
        }

        public Criteria andCanceledGreaterThan(Integer value) {
            addCriterion("canceled >", value, "canceled");
            return (Criteria) this;
        }

        public Criteria andCanceledGreaterThanOrEqualTo(Integer value) {
            addCriterion("canceled >=", value, "canceled");
            return (Criteria) this;
        }

        public Criteria andCanceledLessThan(Integer value) {
            addCriterion("canceled <", value, "canceled");
            return (Criteria) this;
        }

        public Criteria andCanceledLessThanOrEqualTo(Integer value) {
            addCriterion("canceled <=", value, "canceled");
            return (Criteria) this;
        }

        public Criteria andCanceledIn(List<Integer> values) {
            addCriterion("canceled in", values, "canceled");
            return (Criteria) this;
        }

        public Criteria andCanceledNotIn(List<Integer> values) {
            addCriterion("canceled not in", values, "canceled");
            return (Criteria) this;
        }

        public Criteria andCanceledBetween(Integer value1, Integer value2) {
            addCriterion("canceled between", value1, value2, "canceled");
            return (Criteria) this;
        }

        public Criteria andCanceledNotBetween(Integer value1, Integer value2) {
            addCriterion("canceled not between", value1, value2, "canceled");
            return (Criteria) this;
        }

        public Criteria andFailedIsNull() {
            addCriterion("failed is null");
            return (Criteria) this;
        }

        public Criteria andFailedIsNotNull() {
            addCriterion("failed is not null");
            return (Criteria) this;
        }

        public Criteria andFailedEqualTo(Integer value) {
            addCriterion("failed =", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedNotEqualTo(Integer value) {
            addCriterion("failed <>", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedGreaterThan(Integer value) {
            addCriterion("failed >", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedGreaterThanOrEqualTo(Integer value) {
            addCriterion("failed >=", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedLessThan(Integer value) {
            addCriterion("failed <", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedLessThanOrEqualTo(Integer value) {
            addCriterion("failed <=", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedIn(List<Integer> values) {
            addCriterion("failed in", values, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedNotIn(List<Integer> values) {
            addCriterion("failed not in", values, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedBetween(Integer value1, Integer value2) {
            addCriterion("failed between", value1, value2, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedNotBetween(Integer value1, Integer value2) {
            addCriterion("failed not between", value1, value2, "failed");
            return (Criteria) this;
        }

        public Criteria andReconcilingIsNull() {
            addCriterion("reconciling is null");
            return (Criteria) this;
        }

        public Criteria andReconcilingIsNotNull() {
            addCriterion("reconciling is not null");
            return (Criteria) this;
        }

        public Criteria andReconcilingEqualTo(Integer value) {
            addCriterion("reconciling =", value, "reconciling");
            return (Criteria) this;
        }

        public Criteria andReconcilingNotEqualTo(Integer value) {
            addCriterion("reconciling <>", value, "reconciling");
            return (Criteria) this;
        }

        public Criteria andReconcilingGreaterThan(Integer value) {
            addCriterion("reconciling >", value, "reconciling");
            return (Criteria) this;
        }

        public Criteria andReconcilingGreaterThanOrEqualTo(Integer value) {
            addCriterion("reconciling >=", value, "reconciling");
            return (Criteria) this;
        }

        public Criteria andReconcilingLessThan(Integer value) {
            addCriterion("reconciling <", value, "reconciling");
            return (Criteria) this;
        }

        public Criteria andReconcilingLessThanOrEqualTo(Integer value) {
            addCriterion("reconciling <=", value, "reconciling");
            return (Criteria) this;
        }

        public Criteria andReconcilingIn(List<Integer> values) {
            addCriterion("reconciling in", values, "reconciling");
            return (Criteria) this;
        }

        public Criteria andReconcilingNotIn(List<Integer> values) {
            addCriterion("reconciling not in", values, "reconciling");
            return (Criteria) this;
        }

        public Criteria andReconcilingBetween(Integer value1, Integer value2) {
            addCriterion("reconciling between", value1, value2, "reconciling");
            return (Criteria) this;
        }

        public Criteria andReconcilingNotBetween(Integer value1, Integer value2) {
            addCriterion("reconciling not between", value1, value2, "reconciling");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Long value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Long value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Long value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Long value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Long value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Long> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Long> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Long value1, Long value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Long value1, Long value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(String value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(String value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(String value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(String value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(String value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(String value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLike(String value) {
            addCriterion("is_del like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotLike(String value) {
            addCriterion("is_del not like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<String> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<String> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(String value1, String value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(String value1, String value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
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