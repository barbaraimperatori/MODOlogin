package com.example.modologin.data.model

data class LoginResponse(
    val accessToken: String,
    val idToken: String,
    val refreshToken: String,
    val expiresIn: Long,
    val tokenType: String,
    val identityValidation: Boolean,
    val softtokenInvalid: Boolean,
    val onboardingVersion: String,
    val additionalData: Boolean,
    val identityDocumentInfo: Boolean,
    val lastLogin: String
)
