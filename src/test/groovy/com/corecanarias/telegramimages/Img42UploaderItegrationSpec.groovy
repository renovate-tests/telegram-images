package com.corecanarias.telegramimages;

import spock.lang.Specification;

import static org.junit.Assert.*;

/**
 * TODO: Include javadoc
 */
public class Img42UploaderItegrationSpec extends Specification {

    void "Test upload local image"() {
        given:
        Img42Uploader uploader = new Img42Uploader()

        when:
        String url = uploader.uploadImage("src/test/fixtures/sample.jpg")

        then:
        url
    }

    void "Test download image"() {
        given:
        Img42Uploader uploader = new Img42Uploader()

        when:
        File file = uploader.downloadImage("https://api.telegram.org/file/bot261215121:AAEZPdCKPMKx-UBBqNPaXtJZjKSSKsfBe_Q/photo/file_10.jpg")

        then:
        file
    }
}