package com.tsmc.eda.connector.client

import com.t1m0.soap.GreetingRequest
import com.t1m0.soap.GreetingResponse
import com.t1m0.soap.SimpleSoapService
import javax.jws.WebService

@WebService(
    endpointInterface = "com.t1m0.soap.SimpleSoapService",
    name = "SimpleSoapService",
    targetNamespace = "urn:com:t1m0:soap"
)
class SimpleSoapController : SimpleSoapService {

    override fun greeting(greetingRequest: GreetingRequest): GreetingResponse {
        val greeting = GreetingResponse()
        greeting.message = "Hello " + greetingRequest.name
        return greeting
    }

}