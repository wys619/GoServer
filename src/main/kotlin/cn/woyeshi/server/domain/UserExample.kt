package cn.woyeshi.server.domain

class UserExample {

    var orderByClause: String? = null
    var distinct: Boolean = false

    var oredCriteria: MutableList<Criteria>? = null

    constructor() {
        this.oredCriteria = ArrayList<Criteria>()
    }

    fun or(criteria: Criteria) {
        oredCriteria?.add(criteria)
    }

    fun isDistinct(): Boolean {
        return distinct
    }

    fun or(): Criteria {
        val criteria = createCriteriaInternal()
        oredCriteria?.add(criteria)
        return criteria
    }

    fun createCriteria(): Criteria {
        val criteria = createCriteriaInternal()
        if (oredCriteria?.size == 0) {
            oredCriteria?.add(criteria)
        }
        return criteria
    }

    protected fun createCriteriaInternal(): Criteria {
        return Criteria()
    }

    fun clear() {
        oredCriteria?.clear()
        orderByClause = null
        distinct = false
    }


    companion object {

        abstract class GeneratedCriteria {
            var criteria: MutableList<Criterion>? = null

            constructor() : super() {
                criteria = ArrayList<Criterion>()
            }

            fun isValid(): Boolean {
                if (criteria?.size == null) {
                    return false
                } else {
                    return criteria?.size!! > 0
                }
            }

            fun getAllCriteria(): MutableList<Criterion>? {
                return criteria
            }

            fun addCriterion(condition: String) {
                if (condition == null) {
                    throw RuntimeException("Value for condition cannot be null")
                }
                criteria?.add(Criterion(condition))
            }

            protected fun addCriterion(condition: String, value: Any?, property: String) {
                if (value == null) {
                    throw RuntimeException("Value for $property cannot be null")
                }
                criteria?.add(Criterion(condition, value))
            }

            protected fun addCriterion(condition: String, value1: Any?, value2: Any?, property: String) {
                if (value1 == null || value2 == null) {
                    throw RuntimeException("Between values for $property cannot be null")
                }
                criteria?.add(Criterion(condition, value1, value2))
            }

            fun andUserIdIsNull(): Criteria {
                addCriterion("user_id is null")
                return this as Criteria
            }

            fun andUserIdIsNotNull(): Criteria {
                addCriterion("user_id is not null")
                return this as Criteria
            }

            fun andUserIdEqualTo(value: String): Criteria {
                addCriterion("user_id =", value, "userId")
                return this as Criteria
            }

            fun andUserIdNotEqualTo(value: String): Criteria {
                addCriterion("user_id <>", value, "userId")
                return this as Criteria
            }

            fun andUserIdGreaterThan(value: String): Criteria {
                addCriterion("user_id >", value, "userId")
                return this as Criteria
            }

            fun andUserIdGreaterThanOrEqualTo(value: String): Criteria {
                addCriterion("user_id >=", value, "userId")
                return this as Criteria
            }

            fun andUserIdLessThan(value: String): Criteria {
                addCriterion("user_id <", value, "userId")
                return this as Criteria
            }

            fun andUserIdLessThanOrEqualTo(value: String): Criteria {
                addCriterion("user_id <=", value, "userId")
                return this as Criteria
            }

            fun andUserIdLike(value: String): Criteria {
                addCriterion("user_id like", value, "userId")
                return this as Criteria
            }

            fun andUserIdNotLike(value: String): Criteria {
                addCriterion("user_id not like", value, "userId")
                return this as Criteria
            }

            fun andUserIdIn(values: List<String>): Criteria {
                addCriterion("user_id in", values, "userId")
                return this as Criteria
            }

            fun andUserIdNotIn(values: List<String>): Criteria {
                addCriterion("user_id not in", values, "userId")
                return this as Criteria
            }

            fun andUserIdBetween(value1: String, value2: String): Criteria {
                addCriterion("user_id between", value1, value2, "userId")
                return this as Criteria
            }

            fun andUserIdNotBetween(value1: String, value2: String): Criteria {
                addCriterion("user_id not between", value1, value2, "userId")
                return this as Criteria
            }

            fun andUserNameIsNull(): Criteria {
                addCriterion("user_name is null")
                return this as Criteria
            }

            fun andUserNameIsNotNull(): Criteria {
                addCriterion("user_name is not null")
                return this as Criteria
            }

            fun andUserNameEqualTo(value: String): Criteria {
                addCriterion("user_name =", value, "userName")
                return this as Criteria
            }

            fun andUserNameNotEqualTo(value: String): Criteria {
                addCriterion("user_name <>", value, "userName")
                return this as Criteria
            }

            fun andUserNameGreaterThan(value: String): Criteria {
                addCriterion("user_name >", value, "userName")
                return this as Criteria
            }

            fun andUserNameGreaterThanOrEqualTo(value: String): Criteria {
                addCriterion("user_name >=", value, "userName")
                return this as Criteria
            }

            fun andUserNameLessThan(value: String): Criteria {
                addCriterion("user_name <", value, "userName")
                return this as Criteria
            }

            fun andUserNameLessThanOrEqualTo(value: String): Criteria {
                addCriterion("user_name <=", value, "userName")
                return this as Criteria
            }

            fun andUserNameLike(value: String): Criteria {
                addCriterion("user_name like", value, "userName")
                return this as Criteria
            }

            fun andUserNameNotLike(value: String): Criteria {
                addCriterion("user_name not like", value, "userName")
                return this as Criteria
            }

            fun andUserNameIn(values: List<String>): Criteria {
                addCriterion("user_name in", values, "userName")
                return this as Criteria
            }

            fun andUserNameNotIn(values: List<String>): Criteria {
                addCriterion("user_name not in", values, "userName")
                return this as Criteria
            }

            fun andUserNameBetween(value1: String, value2: String): Criteria {
                addCriterion("user_name between", value1, value2, "userName")
                return this as Criteria
            }

            fun andUserNameNotBetween(value1: String, value2: String): Criteria {
                addCriterion("user_name not between", value1, value2, "userName")
                return this as Criteria
            }

            fun andPasswordIsNull(): Criteria {
                addCriterion("password is null")
                return this as Criteria
            }

            fun andPasswordIsNotNull(): Criteria {
                addCriterion("password is not null")
                return this as Criteria
            }

            fun andPasswordEqualTo(value: String): Criteria {
                addCriterion("password =", value, "password")
                return this as Criteria
            }

            fun andPasswordNotEqualTo(value: String): Criteria {
                addCriterion("password <>", value, "password")
                return this as Criteria
            }

            fun andPasswordGreaterThan(value: String): Criteria {
                addCriterion("password >", value, "password")
                return this as Criteria
            }

            fun andPasswordGreaterThanOrEqualTo(value: String): Criteria {
                addCriterion("password >=", value, "password")
                return this as Criteria
            }

            fun andPasswordLessThan(value: String): Criteria {
                addCriterion("password <", value, "password")
                return this as Criteria
            }

            fun andPasswordLessThanOrEqualTo(value: String): Criteria {
                addCriterion("password <=", value, "password")
                return this as Criteria
            }

            fun andPasswordLike(value: String): Criteria {
                addCriterion("password like", value, "password")
                return this as Criteria
            }

            fun andPasswordNotLike(value: String): Criteria {
                addCriterion("password not like", value, "password")
                return this as Criteria
            }

            fun andPasswordIn(values: List<String>): Criteria {
                addCriterion("password in", values, "password")
                return this as Criteria
            }

            fun andPasswordNotIn(values: List<String>): Criteria {
                addCriterion("password not in", values, "password")
                return this as Criteria
            }

            fun andPasswordBetween(value1: String, value2: String): Criteria {
                addCriterion("password between", value1, value2, "password")
                return this as Criteria
            }

            fun andPasswordNotBetween(value1: String, value2: String): Criteria {
                addCriterion("password not between", value1, value2, "password")
                return this as Criteria
            }

        }

        class Criteria constructor() : GeneratedCriteria()


        class Criterion {
            var condition: String? = null

            var value: Any? = null

            var secondValue: Any? = null

            var noValue: Boolean = false

            var singleValue: Boolean = false

            var betweenValue: Boolean = false

            var listValue: Boolean = false

            var typeHandler: String? = null

            constructor()

            constructor(condition: String?) : super() {
                this.condition = condition
                this.typeHandler = null
                this.noValue = true
            }

            constructor(condition: String?, value: Any?, typeHandler: String?) : super() {
                this.condition = condition
                this.value = value
                this.typeHandler = typeHandler
                if (value is List<*>) {
                    this.listValue = true
                } else {
                    this.singleValue = true
                }
            }

            constructor(condition: String?, value: Any?) : this(condition, value, null)

            constructor(condition: String?, value: Any?, secondValue: Any?, typeHandler: String?) : super() {
                this.condition = condition
                this.value = value
                this.secondValue = secondValue
                this.typeHandler = typeHandler
                this.betweenValue = true
            }

            constructor(condition: String?, value: Any?, secondValue: Any?) : this(condition, value, secondValue, null)


        }
    }


}