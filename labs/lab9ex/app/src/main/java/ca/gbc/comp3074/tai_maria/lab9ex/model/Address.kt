package ca.gbc.comp3074.tai_maria.lab9ex.model

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)
