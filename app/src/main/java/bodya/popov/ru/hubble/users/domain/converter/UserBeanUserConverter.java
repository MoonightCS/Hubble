package bodya.popov.ru.hubble.users.domain.converter;

import java.util.ArrayList;
import java.util.List;

import bodya.popov.ru.hubble.users.data.bean.response.UserBean;
import bodya.popov.ru.hubble.users.domain.model.User;

/**
 * @author Popov Bogdan
 */

public class UserBeanUserConverter {

    public User convert(UserBean userBean) {
        User user = new User();
        user.setLogin(userBean.getLogin());
        user.setId(userBean.getId());
        user.setAvatarUrl(userBean.getAvatarUrl());
        user.setGravatarId(userBean.getGravatarId());
        user.setUrl(userBean.getUrl());
        user.setHtmlUrl(userBean.getHtmlUrl());
        user.setFollowersUrl(userBean.getFollowersUrl());
        user.setFollowingUrl(userBean.getFollowingUrl());
        user.setGistsUrl(userBean.getGistsUrl());
        user.setStarredUrl(userBean.getStarredUrl());
        user.setSubscriptionsUrl(userBean.getSubscriptionsUrl());
        user.setOrganizationsUrl(userBean.getOrganizationsUrl());
        user.setReposUrl(userBean.getReposUrl());
        user.setEventsUrl(userBean.getEventsUrl());
        user.setReceivedEventsUrl(userBean.getReceivedEventsUrl());
        user.setType(userBean.getType());
        user.setSiteAdmin(userBean.getSiteAdmin());
        user.setScore(userBean.getScore());
        return user;
    }

    public List<User> convertList(List<UserBean> userBeanList) {
        if (userBeanList == null) {
            return new ArrayList<>();
        }
        List<User> userList = new ArrayList<>(userBeanList.size());
        for (UserBean userBean : userBeanList) {
            userList.add(convert(userBean));
        }
        return userList;
    }


}
