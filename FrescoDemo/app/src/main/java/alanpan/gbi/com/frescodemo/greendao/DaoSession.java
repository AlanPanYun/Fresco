package alanpan.gbi.com.frescodemo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import alanpan.gbi.com.frescodemo.greendao.User;
import alanpan.gbi.com.frescodemo.UserTwo;

import alanpan.gbi.com.frescodemo.greendao.UserDao;
import alanpan.gbi.com.frescodemo.greendao.UserTwoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig userTwoDaoConfig;

    private final UserDao userDao;
    private final UserTwoDao userTwoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        userTwoDaoConfig = daoConfigMap.get(UserTwoDao.class).clone();
        userTwoDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        userTwoDao = new UserTwoDao(userTwoDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(UserTwo.class, userTwoDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        userTwoDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public UserTwoDao getUserTwoDao() {
        return userTwoDao;
    }

}
