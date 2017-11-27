package bodya.popov.ru.hubble.users.domain.model;

/**
 * @author Popov Bogdan
 */

public class User {

    private String mLogin;
    private Integer mId;
    private String mAvatarUrl;
    private String mGravatarId;
    private String mUrl;
    private String mHtmlUrl;
    private String mFollowersUrl;
    private String mFollowingUrl;
    private String mGistsUrl;
    private String mStarredUrl;
    private String mSubscriptionsUrl;
    private String mOrganizationsUrl;
    private String mReposUrl;
    private String mEventsUrl;
    private String mReceivedEventsUrl;
    private String mType;
    private Boolean mSiteAdmin;
    private Double mScore;

    public String getLogin() {
        return mLogin;
    }

    public Integer getId() {
        return mId;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public String getFollowersUrl() {
        return mFollowersUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public String getGistsUrl() {
        return mGistsUrl;
    }

    public String getStarredUrl() {
        return mStarredUrl;
    }

    public String getSubscriptionsUrl() {
        return mSubscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return mOrganizationsUrl;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public String getReceivedEventsUrl() {
        return mReceivedEventsUrl;
    }

    public String getType() {
        return mType;
    }

    public Boolean getSiteAdmin() {
        return mSiteAdmin;
    }

    public Double getScore() {
        return mScore;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public void setGravatarId(String gravatarId) {
        mGravatarId = gravatarId;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        mFollowersUrl = followersUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        mFollowingUrl = followingUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        mGistsUrl = gistsUrl;
    }

    public void setStarredUrl(String starredUrl) {
        mStarredUrl = starredUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        mSubscriptionsUrl = subscriptionsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        mOrganizationsUrl = organizationsUrl;
    }

    public void setReposUrl(String reposUrl) {
        mReposUrl = reposUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        mEventsUrl = eventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        mReceivedEventsUrl = receivedEventsUrl;
    }

    public void setType(String type) {
        mType = type;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        mSiteAdmin = siteAdmin;
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

        User user = (User) o;

        if (mLogin != null ? !mLogin.equals(user.mLogin) : user.mLogin != null) {
            return false;
        }
        if (mId != null ? !mId.equals(user.mId) : user.mId != null) {
            return false;
        }
        if (mAvatarUrl != null ? !mAvatarUrl.equals(user.mAvatarUrl) : user.mAvatarUrl != null) {
            return false;
        }
        if (mGravatarId != null ? !mGravatarId.equals(user.mGravatarId) : user.mGravatarId != null) {
            return false;
        }
        if (mUrl != null ? !mUrl.equals(user.mUrl) : user.mUrl != null) {
            return false;
        }
        if (mHtmlUrl != null ? !mHtmlUrl.equals(user.mHtmlUrl) : user.mHtmlUrl != null) {
            return false;
        }
        if (mFollowersUrl != null ? !mFollowersUrl.equals(user.mFollowersUrl) : user.mFollowersUrl != null) {
            return false;
        }
        if (mFollowingUrl != null ? !mFollowingUrl.equals(user.mFollowingUrl) : user.mFollowingUrl != null) {
            return false;
        }
        if (mGistsUrl != null ? !mGistsUrl.equals(user.mGistsUrl) : user.mGistsUrl != null) {
            return false;
        }
        if (mStarredUrl != null ? !mStarredUrl.equals(user.mStarredUrl) : user.mStarredUrl != null) {
            return false;
        }
        if (mSubscriptionsUrl != null ? !mSubscriptionsUrl.equals(user.mSubscriptionsUrl) : user.mSubscriptionsUrl != null) {
            return false;
        }
        if (mOrganizationsUrl != null ? !mOrganizationsUrl.equals(user.mOrganizationsUrl) : user.mOrganizationsUrl != null) {
            return false;
        }
        if (mReposUrl != null ? !mReposUrl.equals(user.mReposUrl) : user.mReposUrl != null) {
            return false;
        }
        if (mEventsUrl != null ? !mEventsUrl.equals(user.mEventsUrl) : user.mEventsUrl != null) {
            return false;
        }
        if (mReceivedEventsUrl != null ? !mReceivedEventsUrl.equals(user.mReceivedEventsUrl) : user.mReceivedEventsUrl != null) {
            return false;
        }
        if (mType != null ? !mType.equals(user.mType) : user.mType != null) {
            return false;
        }
        if (mSiteAdmin != null ? !mSiteAdmin.equals(user.mSiteAdmin) : user.mSiteAdmin != null) {
            return false;
        }
        return mScore != null ? mScore.equals(user.mScore) : user.mScore == null;
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
