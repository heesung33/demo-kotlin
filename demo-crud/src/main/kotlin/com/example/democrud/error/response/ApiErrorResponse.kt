package com.example.democrud.error.response



data class ApiErrorResponse (
    val status: Int,
    val divisionCode: String,
    val resultMsg: String,
    val errors: List<FieldError>,
    val reason: String
) {
    data class FieldError(
        val field: String,
        val value: String,
        val reason: String
    ) {
        companion object {
            fun of(field: String, value: String, reason: String): List<FieldError> {
                return listOf(FieldError(field, value, reason))
            }

            fun of(bindingResult: org.springframework.validation.BindingResult): List<FieldError> {
                return bindingResult.fieldErrors.map { error ->
                    FieldError(
                        field = error.field,
                        value = error.rejectedValue?.toString() ?: "",
                        reason = error.defaultMessage ?: ""
                    )
                }
            }
        }
    }
}
