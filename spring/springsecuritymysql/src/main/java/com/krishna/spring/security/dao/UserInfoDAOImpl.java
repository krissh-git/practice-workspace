package com.krishna.spring.security.dao;

import com.krishna.spring.security.entity.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserInfoDAOImpl implements IUserInfoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserInfo getActiveUser(String userName) {
        UserInfo userInfo = null;
        System.out.println(userName);
        final String query = "SELECT u FROM UserInfo u WHERE userName = ? AND enabled = ?";
        List<UserInfo> resultList = entityManager.createQuery(query)
                .setParameter(1, userName)
                .setParameter(2, (short)1)
                .getResultList();

        if (!CollectionUtils.isEmpty(resultList)) {
            userInfo = resultList.get(0);
        }

        return userInfo;
    }
}
