package com.personalproject.todomanagementenvioemailjob.model

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data

@Data
class Email (
    @JsonProperty("title") val title: String,
    @JsonProperty("text") val text: String,
    @JsonProperty("receiver") val receiver: User? = null
)
