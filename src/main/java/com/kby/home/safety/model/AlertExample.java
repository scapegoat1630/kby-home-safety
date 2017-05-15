package com.kby.home.safety.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlertExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andAlertTypeIsNull() {
            addCriterion("alert_type is null");
            return (Criteria) this;
        }

        public Criteria andAlertTypeIsNotNull() {
            addCriterion("alert_type is not null");
            return (Criteria) this;
        }

        public Criteria andAlertTypeEqualTo(Integer value) {
            addCriterion("alert_type =", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeNotEqualTo(Integer value) {
            addCriterion("alert_type <>", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeGreaterThan(Integer value) {
            addCriterion("alert_type >", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("alert_type >=", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeLessThan(Integer value) {
            addCriterion("alert_type <", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeLessThanOrEqualTo(Integer value) {
            addCriterion("alert_type <=", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeIn(List<Integer> values) {
            addCriterion("alert_type in", values, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeNotIn(List<Integer> values) {
            addCriterion("alert_type not in", values, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeBetween(Integer value1, Integer value2) {
            addCriterion("alert_type between", value1, value2, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("alert_type not between", value1, value2, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertValueIsNull() {
            addCriterion("alert_value is null");
            return (Criteria) this;
        }

        public Criteria andAlertValueIsNotNull() {
            addCriterion("alert_value is not null");
            return (Criteria) this;
        }

        public Criteria andAlertValueEqualTo(Double value) {
            addCriterion("alert_value =", value, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertValueNotEqualTo(Double value) {
            addCriterion("alert_value <>", value, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertValueGreaterThan(Double value) {
            addCriterion("alert_value >", value, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertValueGreaterThanOrEqualTo(Double value) {
            addCriterion("alert_value >=", value, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertValueLessThan(Double value) {
            addCriterion("alert_value <", value, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertValueLessThanOrEqualTo(Double value) {
            addCriterion("alert_value <=", value, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertValueIn(List<Double> values) {
            addCriterion("alert_value in", values, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertValueNotIn(List<Double> values) {
            addCriterion("alert_value not in", values, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertValueBetween(Double value1, Double value2) {
            addCriterion("alert_value between", value1, value2, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertValueNotBetween(Double value1, Double value2) {
            addCriterion("alert_value not between", value1, value2, "alertValue");
            return (Criteria) this;
        }

        public Criteria andAlertTimeIsNull() {
            addCriterion("alert_time is null");
            return (Criteria) this;
        }

        public Criteria andAlertTimeIsNotNull() {
            addCriterion("alert_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlertTimeEqualTo(Date value) {
            addCriterion("alert_time =", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeNotEqualTo(Date value) {
            addCriterion("alert_time <>", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeGreaterThan(Date value) {
            addCriterion("alert_time >", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("alert_time >=", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeLessThan(Date value) {
            addCriterion("alert_time <", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeLessThanOrEqualTo(Date value) {
            addCriterion("alert_time <=", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeIn(List<Date> values) {
            addCriterion("alert_time in", values, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeNotIn(List<Date> values) {
            addCriterion("alert_time not in", values, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeBetween(Date value1, Date value2) {
            addCriterion("alert_time between", value1, value2, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeNotBetween(Date value1, Date value2) {
            addCriterion("alert_time not between", value1, value2, "alertTime");
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

        public Criteria andUdpateTimeIsNull() {
            addCriterion("udpate_time is null");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeIsNotNull() {
            addCriterion("udpate_time is not null");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeEqualTo(Date value) {
            addCriterion("udpate_time =", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeNotEqualTo(Date value) {
            addCriterion("udpate_time <>", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeGreaterThan(Date value) {
            addCriterion("udpate_time >", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("udpate_time >=", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeLessThan(Date value) {
            addCriterion("udpate_time <", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeLessThanOrEqualTo(Date value) {
            addCriterion("udpate_time <=", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeIn(List<Date> values) {
            addCriterion("udpate_time in", values, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeNotIn(List<Date> values) {
            addCriterion("udpate_time not in", values, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeBetween(Date value1, Date value2) {
            addCriterion("udpate_time between", value1, value2, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeNotBetween(Date value1, Date value2) {
            addCriterion("udpate_time not between", value1, value2, "udpateTime");
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