package com.hmlr.model

import net.corda.core.crypto.SecureHash
import net.corda.core.identity.Party
import net.corda.core.serialization.CordaSerializable
import java.security.PublicKey

@CordaSerializable
data class LandTitleProperties(val address: Address,
                               val ownerConveyancer: Party?,
                               val owner: CustomParty?,
                               val buyer: CustomParty?,
                               val buyerConveyancer: Party?)

@CordaSerializable
data class Address( val houseNumber:String,
                    val streetName: String,
                    val county: String,
                    val city: String,
                    val country: String,
                    val postalCode: String)

@CordaSerializable
data class CustomParty(val forename: String,
                       val surname: String,
                       val NIN: String,
                       val address: Address,
                       val userType: UserType,
                       val email: String,
                       val phone: String,
                       val confirmationOfIdentity: Boolean,
                       val signature: ByteArray?,
                       val publicKey: PublicKey?)


@CordaSerializable
data class Attachments(var hash: SecureHash,
                       var typeOfAttachment: String,
                       var attachmentName: String)


@CordaSerializable
enum class TitleType {
    PARTIAL,
    WHOLE
}

@CordaSerializable
enum class UserType {
    INDIVIDUAL,
    COMPANY,
    OVERSEAS_COMPANY,
    NGO
}
@CordaSerializable
enum class Status {
    ISSUED,
    PENDING_BUYER_APPROVAL,
    TRANSFERRED
}

@CordaSerializable
enum class RequestIssuanceStatus {
    PENDING,
    APPROVED,
    TITLE_ALREADY_ISSUED,
    FAILED
}

