package com.thomasdriscoll.template.lib.exceptions

class DriscollException(
    val code: Int,
    message: String
) : Exception(message)