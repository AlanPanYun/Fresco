package alanpan.gbi.com.frescodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by alan.pan on 2016/10/24.
 */

@Entity
public class UserTwo {

    @Id
    private int id;
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Generated(hash = 1703653820)
    public UserTwo(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1156005031)
    public UserTwo() {
    }

}
