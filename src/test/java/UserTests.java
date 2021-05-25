import models.User;
import models.UserData;
import models.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTests extends TestBase{
    @Test
    @DisplayName("User with id=2 has email=janet.weaver@reqres.in")
    void userEmailTest() {
        User user = apiSteps.getUserById(2);
        assertThat(user.getUserData().getEmail()).isEqualTo("janet.weaver@reqres.in");
    }

    @Test
    @DisplayName("All users have id and it same in user data when we get it by id")
    void allUsersHaveIdTest() {
        Users usersList;
        int pageCounter = 0;
        boolean hasMorePages = true;
        while (hasMorePages) {
            pageCounter++;
            usersList = apiSteps.getUsersFromPage(pageCounter);
            for (UserData userData : usersList.getUserData()) {
                assertThat(apiSteps.getUserById(userData.getId()).getUserData().getId()).isEqualTo(userData.getId());
            }
            hasMorePages = (usersList.getPage() < usersList.getTotalPages());
        }
    }

    @Test
    @DisplayName("User with email domain reqres.in exist on first users page")
    void usersHaveUserWithEmailDomainTest() {
        apiSteps.userWithEmailDomainExist("reqres.in");
    }
}
