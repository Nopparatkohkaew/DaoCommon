package main.java.model.customer.contact.mapping;

import main.java.model.customer.contact.entity.EmailContactEntity;
import main.java.model.customer.contact.model.EmailContactDto;

import java.sql.ResultSet;

public class ContactMapping {
    public static EmailContactDto EmailMapping(ResultSet rs) throws Exception{
        if (rs == null) return null;
        try{
            EmailContactDto dao = new EmailContactDto();
            dao.setEmailId(rs.getString(EmailContactEntity.EMAIL_ID));
            dao.setAddrLine(rs.getString(EmailContactEntity.ADDR_LINE));
            dao.setUpdateUserCode(rs.getString(EmailContactEntity.UPDATE_USER_CODE));
            dao.setSystemKey(rs.getString(EmailContactEntity.SYSTEM_KEY));
            dao.setSystemId(rs.getString(EmailContactEntity.SYSTEM_ID));
            dao.setLastUpdate(rs.getString(EmailContactEntity.LAST_UPDATE));
            dao.setCreateUserCode(rs.getString(EmailContactEntity.CREATE_USER_CODE));
            dao.setCreateTime(rs.getString(EmailContactEntity.CREATE_TIME));

            return dao;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
