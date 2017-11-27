package bodya.popov.ru.hubble.users.data.bean.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Popov Bogdan
 */

public class UsersResponseBean {

    @JsonProperty("total_count")
    private Integer mTotalCount;
    @JsonProperty("incomplete_results")
    private Boolean mIncompleteResults;
    @JsonProperty("items")
    private List<UserBean> mUserBeanList;

    public Integer getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        mTotalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return mIncompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        mIncompleteResults = incompleteResults;
    }

    public List<UserBean> getUserBeanList() {
        return mUserBeanList;
    }

    public void setUserBeanList(List<UserBean> userBeanList) {
        mUserBeanList = userBeanList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsersResponseBean that = (UsersResponseBean) o;

        if (mTotalCount != null ? !mTotalCount.equals(that.mTotalCount) : that.mTotalCount != null) {
            return false;
        }
        if (mIncompleteResults != null ? !mIncompleteResults.equals(that.mIncompleteResults) : that.mIncompleteResults != null) {
            return false;
        }
        return mUserBeanList != null ? mUserBeanList.equals(that.mUserBeanList) : that.mUserBeanList == null;
    }

    @Override
    public int hashCode() {
        int result = mTotalCount != null ? mTotalCount.hashCode() : 0;
        result = 31 * result + (mIncompleteResults != null ? mIncompleteResults.hashCode() : 0);
        result = 31 * result + (mUserBeanList != null ? mUserBeanList.hashCode() : 0);
        return result;
    }
}
