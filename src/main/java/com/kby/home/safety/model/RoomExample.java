package com.kby.home.safety.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
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

        public Criteria andRoomTypeIsNull() {
            addCriterion("room_type is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNotNull() {
            addCriterion("room_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeEqualTo(Boolean value) {
            addCriterion("room_type =", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotEqualTo(Boolean value) {
            addCriterion("room_type <>", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThan(Boolean value) {
            addCriterion("room_type >", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("room_type >=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThan(Boolean value) {
            addCriterion("room_type <", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("room_type <=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIn(List<Boolean> values) {
            addCriterion("room_type in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotIn(List<Boolean> values) {
            addCriterion("room_type not in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("room_type between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("room_type not between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdIsNull() {
            addCriterion("temperature_threshold is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdIsNotNull() {
            addCriterion("temperature_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdEqualTo(Double value) {
            addCriterion("temperature_threshold =", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdNotEqualTo(Double value) {
            addCriterion("temperature_threshold <>", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdGreaterThan(Double value) {
            addCriterion("temperature_threshold >", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdGreaterThanOrEqualTo(Double value) {
            addCriterion("temperature_threshold >=", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdLessThan(Double value) {
            addCriterion("temperature_threshold <", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdLessThanOrEqualTo(Double value) {
            addCriterion("temperature_threshold <=", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdIn(List<Double> values) {
            addCriterion("temperature_threshold in", values, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdNotIn(List<Double> values) {
            addCriterion("temperature_threshold not in", values, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdBetween(Double value1, Double value2) {
            addCriterion("temperature_threshold between", value1, value2, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdNotBetween(Double value1, Double value2) {
            addCriterion("temperature_threshold not between", value1, value2, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdIsNull() {
            addCriterion("humidity_threshold is null");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdIsNotNull() {
            addCriterion("humidity_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdEqualTo(Double value) {
            addCriterion("humidity_threshold =", value, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdNotEqualTo(Double value) {
            addCriterion("humidity_threshold <>", value, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdGreaterThan(Double value) {
            addCriterion("humidity_threshold >", value, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdGreaterThanOrEqualTo(Double value) {
            addCriterion("humidity_threshold >=", value, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdLessThan(Double value) {
            addCriterion("humidity_threshold <", value, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdLessThanOrEqualTo(Double value) {
            addCriterion("humidity_threshold <=", value, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdIn(List<Double> values) {
            addCriterion("humidity_threshold in", values, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdNotIn(List<Double> values) {
            addCriterion("humidity_threshold not in", values, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdBetween(Double value1, Double value2) {
            addCriterion("humidity_threshold between", value1, value2, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andHumidityThresholdNotBetween(Double value1, Double value2) {
            addCriterion("humidity_threshold not between", value1, value2, "humidityThreshold");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationIsNull() {
            addCriterion("smoke_concentration is null");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationIsNotNull() {
            addCriterion("smoke_concentration is not null");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationEqualTo(Double value) {
            addCriterion("smoke_concentration =", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationNotEqualTo(Double value) {
            addCriterion("smoke_concentration <>", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationGreaterThan(Double value) {
            addCriterion("smoke_concentration >", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationGreaterThanOrEqualTo(Double value) {
            addCriterion("smoke_concentration >=", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationLessThan(Double value) {
            addCriterion("smoke_concentration <", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationLessThanOrEqualTo(Double value) {
            addCriterion("smoke_concentration <=", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationIn(List<Double> values) {
            addCriterion("smoke_concentration in", values, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationNotIn(List<Double> values) {
            addCriterion("smoke_concentration not in", values, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationBetween(Double value1, Double value2) {
            addCriterion("smoke_concentration between", value1, value2, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationNotBetween(Double value1, Double value2) {
            addCriterion("smoke_concentration not between", value1, value2, "smokeConcentration");
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