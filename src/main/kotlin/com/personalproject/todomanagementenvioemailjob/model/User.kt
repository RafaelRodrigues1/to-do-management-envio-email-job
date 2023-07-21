package com.personalproject.todomanagementenvioemailjob.model

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data
import java.util.*

@Data
class User (
    @JsonProperty("id") var id: UUID,
    @JsonProperty("name") val name: String,
    @JsonProperty("registration") val registration: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("registerDate") val registerDate: Date,
    @JsonProperty("status") val status: UserStatus,
)

enum class UserStatus {
    ATIVO, INATIVO, PENDENTE, PROCESSANDO;
}
