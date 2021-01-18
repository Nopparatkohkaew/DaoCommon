package main.java.model.customer.contact.model;

public class EmailContactDto {
  public String emailId;
  public String addrLine;
  public String createUserCode;
  public String createTime;
  public String updateUserCode;
  public String lastUpdate;
  public String systemId;
  public String systemKey;

  public EmailContactDto() {
  }

  public EmailContactDto(String emailId, String addrLine, String createUserCode, String createTime, String updateUserCode, String lastUpdate, String systemId, String systemKey) {
    this.emailId = emailId;
    this.addrLine = addrLine;
    this.createUserCode = createUserCode;
    this.createTime = createTime;
    this.updateUserCode = updateUserCode;
    this.lastUpdate = lastUpdate;
    this.systemId = systemId;
    this.systemKey = systemKey;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getAddrLine() {
    return addrLine;
  }

  public void setAddrLine(String addrLine) {
    this.addrLine = addrLine;
  }

  public String getCreateUserCode() {
    return createUserCode;
  }

  public void setCreateUserCode(String createUserCode) {
    this.createUserCode = createUserCode;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getUpdateUserCode() {
    return updateUserCode;
  }

  public void setUpdateUserCode(String updateUserCode) {
    this.updateUserCode = updateUserCode;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getSystemId() {
    return systemId;
  }

  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

  public String getSystemKey() {
    return systemKey;
  }

  public void setSystemKey(String systemKey) {
    this.systemKey = systemKey;
  }
}
