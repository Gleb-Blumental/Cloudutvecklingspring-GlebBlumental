package org.glebindustries.veterinary_application.configurations;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.util.ArrayList;
import java.util.List;

public class Cognito {
    private static CognitoIdentityProviderClient getClient() {
        return CognitoIdentityProviderClient.builder()
                .region(Region.EU_NORTH_1)
                .build();
    }

    public static void deleteUser(String userId) {
        try {
            AdminDeleteUserRequest deleteUserRequest = AdminDeleteUserRequest.builder()
                    .userPoolId("eu-north-1_UMdR6Rc8A")
                    .username(userId)
                    .build();

            CognitoIdentityProviderClient cognitoClient = getClient();
            cognitoClient.adminDeleteUser(deleteUserRequest);

            System.out.println("Successfully deleted user from Cognito.");
        } catch (CognitoIdentityProviderException e) {
            System.err.println("Error deleting user from Cognito: " + e.awsErrorDetails().errorMessage());
        }
    }

    public static boolean isUserInGroup(String username, String userPoolId, String groupName) {
        try {
            AdminListGroupsForUserRequest request = AdminListGroupsForUserRequest.builder()
                    .username(username)
                    .userPoolId(userPoolId)
                    .build();

            CognitoIdentityProviderClient cognitoClient = getClient();
            AdminListGroupsForUserResponse response = cognitoClient.adminListGroupsForUser(request);

            return response.groups().stream()
                    .anyMatch(group -> group.groupName().equals(groupName));
        } catch (CognitoIdentityProviderException e) {
            System.err.println("Error checking user group: " + e.awsErrorDetails().errorMessage());
            return false;
        }

    }
}