package bean;

import javax.validation.constraints.*;

public class User {

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 0, max = 4, message = "name should be between {min} - {max}")
    private String name;

    @Min(value = 0, message = "age should not be smaller than {value}")
    @Max(value = 120, message = "age should not be larger than {value}")
    private int age;

    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "invalid phone number")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
