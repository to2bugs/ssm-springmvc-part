package com.otto.validator.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


import java.util.Date;

/*
    数据的校验
    1. name 不为null，且不是空字符串
       字符串不为空 @NotBlank
       集合不为空 @NotEmpty
       包装对象不为空 @NotNull
    2. password 长度大于6
    3. age 必须>= 1
    4. email 必须是邮箱格式
    5. birthday 必须是过去的时间

 */

@Data
public class User {
    @NotBlank
    private String name;

    @Length(min = 6)
    private String password;

    @Min(1)
    private Integer age;

    @Email
    private String email;

    @Past
    private Date birthday;
}
