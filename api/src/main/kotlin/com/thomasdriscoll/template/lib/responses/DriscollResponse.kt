package com.thomasdriscoll.template.lib.responses

class DriscollResponse <T> (
        val status: Int,
        val data: T?
)