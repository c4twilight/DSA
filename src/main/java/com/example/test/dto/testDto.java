package com.example.test.dto;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"page",
"per_page",
"total"
})
public class testDto {

@JsonProperty("page")
private Integer page;
@JsonProperty("per_page")
private String per_page;
@JsonProperty("total")
private String total;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
*
* @return
* The id
*/
@JsonProperty("page")
public Integer getPage() {
return page;
}

/**
*
* @param id
* The id
*/
@JsonProperty("id")
public void setPage(Integer page) {
this.page = page;
}

/**
*
* @return
* The firstName
*/
@JsonProperty("per_page")
public String getPer_page() {
return per_page;
}


@JsonProperty("per_page")
public void setPer_page(String per_page) {
this.per_page = per_page;
}

/**
*
* @return
* The lastName
*/
@JsonProperty("total")
public String getTotal() {
return total;
}


@JsonProperty("total")
public void setTotal(String total) {
this.total = total;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
