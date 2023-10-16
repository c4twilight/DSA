package com.example.test.dto;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "BasePrice")
public class BasePrice {
    private String currency;
    private String content;
    @XmlAttribute(name ="Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    @XmlValue
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BasePrice(String currency, String content) {
        this.currency = currency;
        this.content = content;
    }
}
