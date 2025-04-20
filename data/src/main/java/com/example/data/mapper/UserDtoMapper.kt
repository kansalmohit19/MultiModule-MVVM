package com.example.data.mapper

import com.example.data.model.UserDto
import com.example.domain.model.User

fun UserDto?.toDomain(): User = User(
    name = this?.name.orEmpty(),
    email = this?.email.orEmpty(),
    countryCode = this?.countryCode.orEmpty(),
    phoneNo = this?.phoneNo.orEmpty()
)