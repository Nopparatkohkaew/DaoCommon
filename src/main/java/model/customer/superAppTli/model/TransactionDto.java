package main.java.model.customer.superAppTli.model;

import java.util.Date;

public class TransactionDto {
  private Long id;
  private Long transactionId;
  private String customerId;
  private String referenceId;
  private String requestJson;
  private String responseJson;
  private Date createDatetime;
  private String createBy;
  private String transactionType;

  public TransactionDto() {}

  public TransactionDto(
      Long id,
      Long transactionId,
      String customerId,
      String referenceId,
      String requestJson,
      String responseJson,
      Date createDatetime,
      String createBy,
      String transactionType) {
    this.id = id;
    this.transactionId = transactionId;
    this.customerId = customerId;
    this.referenceId = referenceId;
    this.requestJson = requestJson;
    this.responseJson = responseJson;
    this.createDatetime = createDatetime;
    this.createBy = createBy;
    this.transactionType = transactionType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public String getRequestJson() {
    return requestJson;
  }

  public void setRequestJson(String requestJson) {
    this.requestJson = requestJson;
  }

  public String getResponseJson() {
    return responseJson;
  }

  public void setResponseJson(String responseJson) {
    this.responseJson = responseJson;
  }

  public Date getCreateDatetime() {
    return createDatetime;
  }

  public void setCreateDatetime(Date createDatetime) {
    this.createDatetime = createDatetime;
  }

  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  @Override
  public String toString() {
    return "TransactionRequest{"
        + "id="
        + id
        + ", transactionId="
        + transactionId
        + ", customerId='"
        + customerId
        + '\''
        + ", referenceId='"
        + referenceId
        + '\''
        + ", requestJson='"
        + requestJson
        + '\''
        + ", responseJson='"
        + responseJson
        + '\''
        + ", createDatetime="
        + createDatetime
        + ", createBy='"
        + createBy
        + '\''
        + ", transactionType='"
        + transactionType
        + '\''
        + '}';
  }
}
