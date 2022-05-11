import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.jboss.logging.Logger
import org.junit.jupiter.api.Test

@QuarkusTest
class SimpleSoapControllerTest {

    companion object {
        private val LOG: Logger = Logger.getLogger(SimpleSoapControllerTest::class.java)
    }

    @Test
    fun `test hello soap`() {
        Given {
            body(
                """<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:urn="urn:com:t1m0:soap">
    <soapenv:Body>
        <urn:greetingRequest>
            <name>Test</name>
        </urn:greetingRequest>
    </soapenv:Body>
</soapenv:Envelope>"""
            )
            contentType("text/xml")
        } When {
            post("/simple")
        } Then {
            statusCode(200)
            body(
                "message", Matchers.hasItem("Hello Test")
            )
        }
    }
}