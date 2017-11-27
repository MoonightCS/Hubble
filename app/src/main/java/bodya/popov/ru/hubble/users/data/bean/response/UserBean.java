package bodya.popov.ru.hubble.users.data.bean.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Popov Bogdan
 */

public class UserBean {
    @JsonProperty("login")
    private String mLogin;
    @JsonProperty("id")
    private Integer mId;
    @JsonProperty("avatar_url")
    private String mAvatarUrl;
    @JsonProperty("gravatar_id")
    private String mGravatarId;
    @JsonProperty("url")
    private String mUrl;
    @JsonProperty("html_url")
    private String mHtmlUrl;
    @JsonProperty("followers_url")
    private String mFollowersUrl;
    @JsonProperty("following_url")
    private String mFollowingUrl;
    @JsonProperty("gists_url")
    private String mGistsUrl;
    @JsonProperty("starred_url")
    private String mStarredUrl;
    @JsonProperty("subscriptions_url")
    private String mSubscriptionsUrl;
    @JsonProperty("organizations_url")
    private String mOrganizationsUrl;
    @JsonProperty("repos_url")
    private String mReposUrl;
    @JsonProperty("events_url")
    private String mEventsUrl;
    @JsonProperty("received_events_url")
    private String mReceivedEventsUrl;
    @JsonProperty("type")
    private String mType;
    @JsonProperty("site_admin")
    private Boolean mSiteAdmin;
    @JsonProperty("score")
    private Double mScore;

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public void setGravatarId(String gravatarId) {
        mGravatarId = gravatarId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return mFollowersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        mFollowersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        mFollowingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return mGistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        mGistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return mStarredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        mStarredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return mSubscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        mSubscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return mOrganizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        mOrganizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public void setReposUrl(String reposUrl) {
        mReposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        mEventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return mReceivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        mReceivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Boolean getSiteAdmin() {
        return mSiteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        mSiteAdmin = siteAdmin;
    }

    public Double getScore() {
        return mScore;
    }

    public void setScore(Double score) {
        mScore = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserBean userBean = (UserBean) o;

        if (mLogin != null ? !mLogin.equals(userBean.mLogin) : userBean.mLogin != null) {
            return false;
        }
        if (mId != null ? !mId.equals(userBean.mId) : userBean.mId != null) {
            return false;
        }
        if (mAvatarUrl != null ? !mAvatarUrl.equals(userBean.mAvatarUrl) : userBean.mAvatarUrl != null) {
            return false;
        }
        if (mGravatarId != null ? !mGravatarId.equals(userBean.mGravatarId) : userBean.mGravatarId != null) {
            return false;
        }
        if (mUrl != null ? !mUrl.equals(userBean.mUrl) : userBean.mUrl != null) {
            return false;
        }
        if (mHtmlUrl != null ? !mHtmlUrl.equals(userBean.mHtmlUrl) : userBean.mHtmlUrl != null) {
            return false;
        }
        if (mFollowersUrl != null ? !mFollowersUrl.equals(userBean.mFollowersUrl) : userBean.mFollowersUrl != null) {
            return false;
        }
        if (mFollowingUrl != null ? !mFollowingUrl.equals(userBean.mFollowingUrl) : userBean.mFollowingUrl != null) {
            return false;
        }
        if (mGistsUrl != null ? !mGistsUrl.equals(userBean.mGistsUrl) : userBean.mGistsUrl != null) {
            return false;
        }
        if (mStarredUrl != null ? !mStarredUrl.equals(userBean.mStarredUrl) : userBean.mStarredUrl != null) {
            return false;
        }
        if (mSubscriptionsUrl != null ? !mSubscriptionsUrl.equals(userBean.mSubscriptionsUrl) : userBean.mSubscriptionsUrl != null) {
            return false;
        }
        if (mOrganizationsUrl != null ? !mOrganizationsUrl.equals(userBean.mOrganizationsUrl) : userBean.mOrganizationsUrl != null) {
            return false;
        }
        if (mReposUrl != null ? !mReposUrl.equals(userBean.mReposUrl) : userBean.mReposUrl != null) {
            return false;
        }
        if (mEventsUrl != null ? !mEventsUrl.equals(userBean.mEventsUrl) : userBean.mEventsUrl != null) {
            return false;
        }
        if (mReceivedEventsUrl != null ? !mReceivedEventsUrl.equals(userBean.mReceivedEventsUrl) : userBean.mReceivedEventsUrl != null) {
            return false;
        }
        if (mType != null ? !mType.equals(userBean.mType) : userBean.mType != null) {
            return false;
        }
        if (mSiteAdmin != null ? !mSiteAdmin.equals(userBean.mSiteAdmin) : userBean.mSiteAdmin != null) {
            return false;
        }
        return mScore != null ? mScore.equals(userBean.mScore) : userBean.mScore == null;
    }

    @Override
    public int hashCode() {
        int result = mLogin != null ? mLogin.hashCode() : 0;
        result = 31 * result + (mId != null ? mId.hashCode() : 0);
        result = 31 * result + (mAvatarUrl != null ? mAvatarUrl.hashCode() : 0);
        result = 31 * result + (mGravatarId != null ? mGravatarId.hashCode() : 0);
        result = 31 * result + (mUrl != null ? mUrl.hashCode() : 0);
        result = 31 * result + (mHtmlUrl != null ? mHtmlUrl.hashCode() : 0);
        result = 31 * result + (mFollowersUrl != null ? mFollowersUrl.hashCode() : 0);
        result = 31 * result + (mFollowingUrl != null ? mFollowingUrl.hashCode() : 0);
        result = 31 * result + (mGistsUrl != null ? mGistsUrl.hashCode() : 0);
        result = 31 * result + (mStarredUrl != null ? mStarredUrl.hashCode() : 0);
        result = 31 * result + (mSubscriptionsUrl != null ? mSubscriptionsUrl.hashCode() : 0);
        result = 31 * result + (mOrganizationsUrl != null ? mOrganizationsUrl.hashCode() : 0);
        result = 31 * result + (mReposUrl != null ? mReposUrl.hashCode() : 0);
        result = 31 * result + (mEventsUrl != null ? mEventsUrl.hashCode() : 0);
        result = 31 * result + (mReceivedEventsUrl != null ? mReceivedEventsUrl.hashCode() : 0);
        result = 31 * result + (mType != null ? mType.hashCode() : 0);
        result = 31 * result + (mSiteAdmin != null ? mSiteAdmin.hashCode() : 0);
        result = 31 * result + (mScore != null ? mScore.hashCode() : 0);
        return result;
    }
}
