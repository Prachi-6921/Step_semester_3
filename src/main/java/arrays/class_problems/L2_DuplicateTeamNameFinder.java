package arrays.class_problems;

public class L2_DuplicateTeamNameFinder {

    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return teamNames[i];
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String[] teamNames = {"ByteForce", "CodeCrafters", "ByteForce"};

        String duplicate = findDuplicateTeam(teamNames);

        if (duplicate != null) {
            System.out.println("Duplicate Found: " + duplicate);
        } else {
            System.out.println("No Duplicates Found");
        }
    }
}
