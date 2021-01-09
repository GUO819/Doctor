package com.fz.lbl_admin.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Guo
 * @date: 2021/1/9
 * @describe:
 */
public class LoginBean implements Serializable {


    /**
     * success : true
     * message : 操作成功
     * code : 200
     * result : {"multi_depart":1,"userInfo":{"id":"1300330035736059906","username":"8ca5cb744da041af9ac54a06da3ef9b9","realname":"狸狸猪猪111","avatar":"http://tp.mengya-app.com/1336238925266178048.jpg","birthday":null,"sex":2,"email":"17538321629@163.com","phone":"18749178175","orgCode":"A03","status":1,"delFlag":0,"workNo":null,"post":null,"telephone":"11112","createBy":null,"createTime":"2020-08-31 15:10:14","updateBy":"8ca5cb744da041af9ac54a06da3ef9b9","updateTime":"2020-12-23 18:25:10","activitiSync":0,"userIdentity":null,"departIds":null,"thirdId":null,"thirdType":null,"age":55,"address":"苏州市222","mixRangeIds":"","userType":1},"departs":[{"id":"aser3ds1234235gs12324sadf31sadf","parentId":null,"departName":"医生","departNameEn":null,"departNameAbbr":null,"departOrder":0,"description":null,"orgCategory":"1","orgType":"1","orgCode":"A03","mobile":null,"fax":null,"address":null,"memo":"医生","status":null,"delFlag":"0","createBy":"admin","createTime":"2020-07-16 14:20:31","updateBy":"","updateTime":null}],"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTE0OTI5MjQsInV1aWQiOiIxMzQ3ODg5NzExNjIwNDQ0MTYwIiwidXNlcm5hbWUiOiI4Y2E1Y2I3NDRkYTA0MWFmOWFjNTRhMDZkYTNlZjliOSJ9.51IQxzsRCnZr2f5ds7MQGohSrhYnh76yhwmgSl7KYws"}
     * timestamp : 1610196924536
     */

     public boolean success;
     public String message;
     public int code;
     public ResultBean result;
     public long timestamp;

    public static class ResultBean {
        /**
         * multi_depart : 1
         * userInfo : {"id":"1300330035736059906","username":"8ca5cb744da041af9ac54a06da3ef9b9","realname":"狸狸猪猪111","avatar":"http://tp.mengya-app.com/1336238925266178048.jpg","birthday":null,"sex":2,"email":"17538321629@163.com","phone":"18749178175","orgCode":"A03","status":1,"delFlag":0,"workNo":null,"post":null,"telephone":"11112","createBy":null,"createTime":"2020-08-31 15:10:14","updateBy":"8ca5cb744da041af9ac54a06da3ef9b9","updateTime":"2020-12-23 18:25:10","activitiSync":0,"userIdentity":null,"departIds":null,"thirdId":null,"thirdType":null,"age":55,"address":"苏州市222","mixRangeIds":"","userType":1}
         * departs : [{"id":"aser3ds1234235gs12324sadf31sadf","parentId":null,"departName":"医生","departNameEn":null,"departNameAbbr":null,"departOrder":0,"description":null,"orgCategory":"1","orgType":"1","orgCode":"A03","mobile":null,"fax":null,"address":null,"memo":"医生","status":null,"delFlag":"0","createBy":"admin","createTime":"2020-07-16 14:20:31","updateBy":"","updateTime":null}]
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTE0OTI5MjQsInV1aWQiOiIxMzQ3ODg5NzExNjIwNDQ0MTYwIiwidXNlcm5hbWUiOiI4Y2E1Y2I3NDRkYTA0MWFmOWFjNTRhMDZkYTNlZjliOSJ9.51IQxzsRCnZr2f5ds7MQGohSrhYnh76yhwmgSl7KYws
         */

         public int multi_depart;
         public UserInfoBean userInfo;
         public String token;
         public List<DepartsBean> departs;

         public static class UserInfoBean {
            /**
             * id : 1300330035736059906
             * username : 8ca5cb744da041af9ac54a06da3ef9b9
             * realname : 狸狸猪猪111
             * avatar : http://tp.mengya-app.com/1336238925266178048.jpg
             * birthday : null
             * sex : 2
             * email : 17538321629@163.com
             * phone : 18749178175
             * orgCode : A03
             * status : 1
             * delFlag : 0
             * workNo : null
             * post : null
             * telephone : 11112
             * createBy : null
             * createTime : 2020-08-31 15:10:14
             * updateBy : 8ca5cb744da041af9ac54a06da3ef9b9
             * updateTime : 2020-12-23 18:25:10
             * activitiSync : 0
             * userIdentity : null
             * departIds : null
             * thirdId : null
             * thirdType : null
             * age : 55
             * address : 苏州市222
             * mixRangeIds : 
             * userType : 1
             */

             public String id;
             public String username;
             public String realname;
             public String avatar;
             public Object birthday;
             public int sex;
             public String email;
             public String phone;
             public String orgCode;
             public int status;
             public int delFlag;
             public Object workNo;
             public Object post;
             public String telephone;
             public Object createBy;
             public String createTime;
             public String updateBy;
             public String updateTime;
             public int activitiSync;
             public Object userIdentity;
             public Object departIds;
             public Object thirdId;
             public Object thirdType;
             public int age;
             public String address;
             public String mixRangeIds;
             public int userType;
        }

        public static class DepartsBean {
            /**
             * id : aser3ds1234235gs12324sadf31sadf
             * parentId : null
             * departName : 医生
             * departNameEn : null
             * departNameAbbr : null
             * departOrder : 0
             * description : null
             * orgCategory : 1
             * orgType : 1
             * orgCode : A03
             * mobile : null
             * fax : null
             * address : null
             * memo : 医生
             * status : null
             * delFlag : 0
             * createBy : admin
             * createTime : 2020-07-16 14:20:31
             * updateBy : 
             * updateTime : null
             */

             public String id;
             public Object parentId;
             public String departName;
             public Object departNameEn;
             public Object departNameAbbr;
             public int departOrder;
             public Object description;
             public String orgCategory;
             public String orgType;
             public String orgCode;
             public Object mobile;
             public Object fax;
             public Object address;
             public String memo;
             public Object status;
             public String delFlag;
             public String createBy;
             public String createTime;
             public String updateBy;
             public Object updateTime;
        }
    }
}
