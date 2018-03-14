package com.json;

import com.db.DBManager;
import org.json.simple.JSONObject;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Json {
    private JSONObject obj=new JSONObject();
    String logSql;

    public String PersonalInfoEncode(String account){
        DBManager sql = DBManager.createInstance();
        sql.connectDB();
        logSql="select * from users where account='"+account+"'";

        // 操作DB对象
        try {
            ResultSet rs = sql.executeQuery(logSql);
            if (rs.next()) {
                String tempAccount,tempPassword,tempPhone,tempIntro,tempID,tempGender,tempBirth,tempNickname;
                tempAccount=rs.getString("account");
                tempPassword=rs.getString("password");
                tempPhone=rs.getString("phonenum");
                tempIntro=rs.getString("introduction");
                tempID=rs.getString("ID");
                tempGender=rs.getString("gender");
                tempBirth=rs.getString("birth");
                tempNickname=rs.getString("nickname");
                obj.put("account",tempAccount);
                obj.put("password",tempPassword);
                obj.put("phonenum",tempPhone);
                obj.put("introduction",tempIntro);
                obj.put("ID",tempID);
                obj.put("gender",tempGender);
                obj.put("birth",tempBirth);
                obj.put("nickname",tempNickname);
                return obj.toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();
        return null;
    }

    public boolean PersonalInfoWrite(JSONObject jsonObject){
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        // 操作DB对象
            String tempAccount,tempPhone,tempIntro,tempGender,tempBirth,tempNickname;
            tempAccount=(String)jsonObject.get("account");
            tempPhone=(String)jsonObject.get("phonenum");
            tempIntro=(String)jsonObject.get("introduction");
            tempGender=(String)jsonObject.get("gender");
            tempBirth=(String)jsonObject.get("birth");
            tempNickname=(String)jsonObject.get("nickname");
            logSql="update users set "+
                    "phonenum='"+tempPhone+
                    "',introduction='"+tempIntro+
                    "',gender='"+tempGender+
                    "',birth='"+tempBirth+
                    "',nickname='"+tempNickname+
                    "' where account='"+tempAccount+"'";
            int updateResult=sql.executeUpdate(logSql);
            sql.closeDB();
            return updateResult!=0;

    }
}
