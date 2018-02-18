package patterns.builder;

import java.util.Date;

public class User {
    public static void main(String[] args) {
        Account account = Account.newBuilder()
                .setAge(12)
                .setName("Some")
                .setEmail("email")
                .setPass("pass")
                .setBirsday(new Date())
                .build();
    }
}

class Account {
    private String name;
    private String email;
    private int age;
    private String password;
    private Date birsday;

    private Account() {

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirsday() {
        return birsday;
    }

    public static Builder newBuilder() {
        return new Account().new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", age=").append(age);
        sb.append(", password='").append(password).append('\'');
        sb.append(", birsday=").append(birsday);
        sb.append('}');
        return sb.toString();
    }

    class Builder {

        Builder() {
        }

        public Builder setName(String name) {
            Account.this.name = name;
            return this;
        }


        public Builder setEmail(String email) {
            Account.this.email = email;
            return this;
        }

        public Builder setAge(int age) {
            Account.this.age = age;
            return this;
        }

        public Builder setPass(String password) {
            Account.this.password = password;
            return this;
        }

        public Builder setBirsday(Date date) {
            Account.this.birsday = date;
            return this;
        }

        public Account build() {
            //this return always same object
            //is need new object then new Account create
            return Account.this;
        }
    }
}


